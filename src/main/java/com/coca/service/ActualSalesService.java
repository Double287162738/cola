package com.coca.service;


import com.coca.mapper.ActualSalesCustomerMapper;
import com.coca.mapper.ActualSalesMapper;
import com.coca.model.*;
import com.coca.util.ColaConstant;
import com.coca.util.Page;
import com.coca.util.SnowflakeIdWorker;
import com.coca.util.StringToListUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("actualSalesService")
public class ActualSalesService {

    @Resource
    private ActualSalesMapper actualSalesMapper;
    @Resource
    private ActualSalesCustomerMapper actualSalesCustomerMapper;

    public void insertOrUpdateActualsData(ActualSalesInparameter actualSalesInparameter){
        //当前年
        String year = actualSalesInparameter.getYear();
        //当前月
        String month = actualSalesInparameter.getMonth();
        //需要新增或者需要更新的数据
        List<ActualSales> dataList = actualSalesInparameter.getActualSalesList();
        if(StringUtils.isBlank(year)){
            throw new RuntimeException("Actual sales [YEAR] is null,Please check");
        }
        if(StringUtils.isBlank(month)){
            throw new RuntimeException("Actual sales [MONTH] is null,Please check");
        }
        if(dataList.size()<1){
            throw new RuntimeException("Actual sales [DATA] is null,Please check");
        }
        ActualSalesExample actualSalesExample = new ActualSalesExample();
        ActualSalesExample.Criteria criteria = actualSalesExample.createCriteria();
        criteria.andActualYearEqualTo(year);
        Integer count = actualSalesMapper.countByExample(actualSalesExample);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //如果当前年不存在数据，则新增
        if(count==0){
            SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
            String dateString = sdf.format(new Date());
            Double everyTimeNum = 70.0;
            Double totalNum = Double.valueOf(dataList.size());
            int frequency = (int) Math.ceil(totalNum/everyTimeNum);
            //分批次入库
            for(int i=1;i<=frequency;i++){
                List<ActualSales> list = new ArrayList<>();
                int startIndex = (i-1)*70;
                int endIndex = i*70-1;
                if(endIndex>dataList.size()){
                    endIndex=dataList.size()-1;
                }
                list = dataList.subList(startIndex,endIndex+1);
                //截取部分数据的部分字段赋值
                for(ActualSales actualSales : dataList){
                    actualSales.setId(Long.toString(snowflakeIdWorker.nextId()));
                    actualSales.setCreateTime(dateString);
                    actualSales.setActualYear(year);
                }
                try{
                    actualSalesCustomerMapper.batchInsertActualSalesData(list);
                }catch (Exception e){
                    e.getMessage();
                }
            }
        }else{//存在数据即表示需更新
            String dateString = sdf.format(new Date());
            Double everyTimeNum = 80.0;
            Double totalNum = Double.valueOf(dataList.size());
            int frequency = (int) Math.ceil(totalNum/everyTimeNum);
            for(int i=1;i<=frequency;i++){
                List<ActualSales> list = new ArrayList<>();
                int startIndex = (i-1)*80;
                int endIndex = i*80-1;
                if(endIndex>dataList.size()){
                    endIndex=dataList.size()-1;
                }
                list = dataList.subList(startIndex,endIndex+1);
                //截取部分数据的部分字段赋值
                for(ActualSales actualSales : dataList){
                    actualSales.setUpdateTime(dateString);
                }
                try{
                    actualSalesCustomerMapper.batchUpdateActualSalesData(list,Integer.valueOf(month));
                }catch (Exception e){
                    e.getMessage();
                }
            }
        }
    }


    /**
     * 下拉框初始化
     * @return
     */
    public Map<String,Object> distinctActualSalesSelect(){
        Map<String,Object> result = new HashMap<>();
        List<ActualSales> list = actualSalesCustomerMapper.distinctActualSalesSelect();
        List<String> category = new ArrayList<>();
        List<String> bpName = new ArrayList<>();
        List<String> brand = new ArrayList<>();
        List<String> ppName = new ArrayList<>();
        List<String> bg = new ArrayList<>();
        for(ActualSales actualSales : list){
            if(!bg.contains(actualSales.getBg())){
                bg.add(actualSales.getBg());
            }
            if(!category.contains(actualSales.getCategory())){
                category.add(actualSales.getCategory());
            }
            if(!bpName.contains(actualSales.getBpName())){
                bpName.add(actualSales.getBpName());
            }
            if(!brand.contains(actualSales.getBrand())){
                brand.add(actualSales.getBrand());
            }
            if(!ppName.contains(actualSales.getPpName())){
                ppName.add(actualSales.getPpName());
            }
        }
        result.put("category",category);
        result.put("bpName",bpName);
        result.put("brand",brand);
        result.put("ppName",ppName);
        result.put("bg",bg);
        return result;
    }

    /**
     * Actual Report 查询
     * @param page
     * @param actualSalesInparameter
     * @return
     */
    public Page selectActualSalesData(Page page, ActualSalesInparameter actualSalesInparameter){
        Page result = new Page();
        ActualSalesExample actualSalesExample = new ActualSalesExample();
        actualSalesExample.setPage(page);
        actualSalesExample.setOrderByClause("ID");
        ActualSalesExample.Criteria criteria = actualSalesExample.createCriteria();
        criteria.andActualYearEqualTo(actualSalesInparameter.getYear());
        //添加搜索条件
        if(actualSalesInparameter.getCategory()!=null && actualSalesInparameter.getCategory().size()>0){
            criteria.andCategoryIn(actualSalesInparameter.getCategory());
        }
        if(actualSalesInparameter.getBpName()!=null && actualSalesInparameter.getBpName().size()>0){
            criteria.andBpNameIn(actualSalesInparameter.getBpName());
        }
        if(actualSalesInparameter.getBrand()!=null && actualSalesInparameter.getBrand().size()>0){
            criteria.andBrandIn(actualSalesInparameter.getBrand());
        }
        if(actualSalesInparameter.getPpName()!=null && actualSalesInparameter.getPpName().size()>0){
            criteria.andPpNameIn(actualSalesInparameter.getPpName());
        }
        if(actualSalesInparameter.getBg()!=null && actualSalesInparameter.getBg().size()>0){
            criteria.andBgIn(actualSalesInparameter.getBg());
        }
        List<ActualSales> list = actualSalesMapper.selectByExamplePage(actualSalesExample);
        //当前月
        Integer month = Integer.valueOf(actualSalesInparameter.getMonth());
        this.blankSomeMonthsData(list,month);
        Integer count = actualSalesMapper.countByExample(actualSalesExample);
        result.setRecords(list);
        result.setTotalRecord(count);
        return result;
    }


    /**
     * Actual Sales Report 导出
     * @param request
     * @param response
     * @return
     */
    public Map<String,Object> actualSalesReportExport(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashMap<>();
        try {
            ActualSalesInparameter actualSalesInparameter = new ActualSalesInparameter();
            //get parameter
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String category = request.getParameter("category");
            String bpName = request.getParameter("bpName");
            String brand = request.getParameter("brand");
            String ppName = request.getParameter("ppName");
            String bg = request.getParameter("bg");
            //组装查询条件
            if(StringUtils.isNotBlank(year)){
                actualSalesInparameter.setYear(year);
            }
            if(StringUtils.isNotBlank(category)){
                actualSalesInparameter.setCategory(StringToListUtils.changeToList(category,","));
            }
            if(StringUtils.isNotBlank(bpName)){
                actualSalesInparameter.setBpName(StringToListUtils.changeToList(bpName,","));
            }
            if(StringUtils.isNotBlank(brand)){
                actualSalesInparameter.setBrand(StringToListUtils.changeToList(brand,","));
            }
            if(StringUtils.isNotBlank(ppName)){
                actualSalesInparameter.setPpName(StringToListUtils.changeToList(ppName,","));
            }
            if(StringUtils.isNotBlank(bg)){
                actualSalesInparameter.setBg(StringToListUtils.changeToList(bg,","));
            }
            //根据查询条件查询需要导出的数据
            ActualSalesExample actualSalesExample = new ActualSalesExample();
            ActualSalesExample.Criteria criteria = actualSalesExample.createCriteria();
            criteria.andActualYearEqualTo(actualSalesInparameter.getYear());
            if(actualSalesInparameter.getCategory()!=null && actualSalesInparameter.getCategory().size()>0){
                criteria.andCategoryIn(actualSalesInparameter.getCategory());
            }
            if(actualSalesInparameter.getBpName()!=null && actualSalesInparameter.getBpName().size()>0){
                criteria.andBpNameIn(actualSalesInparameter.getBpName());
            }
            if(actualSalesInparameter.getBrand()!=null && actualSalesInparameter.getBrand().size()>0){
                criteria.andBrandIn(actualSalesInparameter.getBrand());
            }
            if(actualSalesInparameter.getPpName()!=null && actualSalesInparameter.getPpName().size()>0){
                criteria.andPpNameIn(actualSalesInparameter.getPpName());
            }
            if(actualSalesInparameter.getBg()!=null && actualSalesInparameter.getBg().size()>0){
                criteria.andBgIn(actualSalesInparameter.getBg());
            }
            List<ActualSales> exportData = actualSalesMapper.selectByExample(actualSalesExample);
            //不需要导出的月份
            List<String> needExportMonth = this.noNeedMonthData(Integer.valueOf(month));
            // 创建一个excel
            XSSFWorkbook wb = new XSSFWorkbook();
            //创建sheet
            XSSFSheet sheet = wb.createSheet("Actual Sales Report");
            //自适应宽度
            sheet.autoSizeColumn(1, true);
            sheet.setColumnWidth(0,40*256);
            sheet.setDefaultColumnWidth(17);
            //表头字体
            XSSFFont titleFont = wb.createFont();
            titleFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
            titleFont.setFontName("宋体");
            titleFont.setFontHeight((short) 200);
            //表头样式
            XSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            titleStyle.setFont(titleFont);
            //数据样式
            XSSFCellStyle dataStyle = wb.createCellStyle();
            dataStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            // 创建第一行（表头）
            XSSFRow row = sheet.createRow(0);
            Field[] fields = ActualSales.class.getDeclaredFields();
            List<String> keys = new ArrayList<>();
            int colNum = 0;
            for(int i=0;i<fields.length;i++){
                Field field = fields[i];
                field.setAccessible(true);
                if(!needExportMonth.contains(field.getName().toUpperCase())){
                    XSSFCell firstCol = row.createCell(colNum);
                    firstCol.setCellStyle(titleStyle);
                    keys.add(field.getName());
                    firstCol.setCellValue(field.getName());
                    colNum++;
                }
            }
            //第二行开始进行数据导出
            for(int i=0;i<exportData.size();i++){
                row = sheet.createRow(i+1);
                for(int j=0;j<keys.size();j++){
                    XSSFCell col = row.createCell(j);
                    col.setCellStyle(dataStyle);
                    String newKey = keys.get(j).substring(0,1).toUpperCase()+keys.get(j).substring(1,keys.get(j).length());
                    String methodName = "get"+newKey;
                    Method method = exportData.get(i).getClass().getMethod(methodName,null);
                    col.setCellValue(method.invoke(exportData.get(i),null)==null? "":method.invoke(exportData.get(i),null).toString());
                }
            }
            request.setCharacterEncoding("UTF-8");
            String fileName = year+"-"+month+"-AS-Report.xlsx";
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download");
            OutputStream out = response.getOutputStream();
            wb.write(out);
            out.close();
        }catch (Exception e){
            e.getMessage();
            result.put("error","导出错误，请重试或联系管理员");
        }
        return result;
    }


    /**
     * 将不需要数据的月份置空
     * @param list
     * @param month
     */
    public void blankSomeMonthsData(List<ActualSales> list,Integer month){
        for(ActualSales actualSales : list){
            if(month<1){
                actualSales.setJan(null);
            }
            if(month<2){
                actualSales.setFeb(null);
            }
            if(month<3){
                actualSales.setMar(null);
            }
            if(month<4){
                actualSales.setApr(null);
            }
            if(month<5){
                actualSales.setMay(null);
            }
            if(month<6){
                actualSales.setJun(null);
            }
            if(month<7){
                actualSales.setJul(null);
            }
            if(month<8){
                actualSales.setAug(null);
            }
            if(month<9){
                actualSales.setSep(null);
            }
            if(month<10){
                actualSales.setOct(null);
            }
            if(month<11){
                actualSales.setNov(null);
            }
            if(month<12){
                actualSales.setDece(null);
            }
        }
    }


    /**
     * 不需要数据的月份
     * @param month
     * @return
     */
    private List<String> noNeedMonthData(Integer month){
        List<String> result = new ArrayList<>();
        for(int i=month;i<12;i++){
            result.add(ColaConstant.MONTH.get(i));
        }
        return result;
    }

}