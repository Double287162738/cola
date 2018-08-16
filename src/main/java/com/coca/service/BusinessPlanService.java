package com.coca.service;


import com.coca.mapper.BusinessPlanCustomerMapper;
import com.coca.mapper.BusinessPlanMapper;
import com.coca.model.BusinessPlan;
import com.coca.model.BusinessPlanExample;
import com.coca.model.BusinessPlanInparameter;
import com.coca.util.Page;
import com.coca.util.SnowflakeIdWorker;
import com.coca.util.StringToListUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("businessPlanService")
public class BusinessPlanService {

    @Resource
    private BusinessPlanCustomerMapper businessPlanCustomerMapper;
    @Resource
    private BusinessPlanMapper businessPlanMapper;

    public void insertBusinessPlanData(BusinessPlanInparameter businessPlanInparameter){
        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(new Date());
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        List<BusinessPlan> planDataList = businessPlanInparameter.getPlanDataList();
        //分批次插入数据库，一次insert 80条
        Double everyTimeNum = 80.0;
        Double totalNum = Double.valueOf(planDataList.size());
        int frequency = (int) Math.ceil(totalNum/everyTimeNum);
        for(int i=1;i<=frequency;i++){
            List<BusinessPlan> list = new ArrayList<>();
            int startIndex = (i-1)*80;
            int endIndex = i*80-1;
            if(endIndex>planDataList.size()){
                endIndex=planDataList.size()-1;
            }
            list = planDataList.subList(startIndex,endIndex+1);
            //截取部分数据的部分字段赋值
            for(BusinessPlan businessPlan : planDataList){
                businessPlan.setId(Long.toString(snowflakeIdWorker.nextId()));
                businessPlan.setCreateBy("admin");
                businessPlan.setCreateTime(dateString);
                businessPlan.setPlanYear(businessPlanInparameter.getYear());
            }
            try{
                businessPlanCustomerMapper.batchInsertBusinessPlanData(list);
            }catch (Exception e){
                e.getMessage();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime) + "ms");
    }


    /**
     * Business Report 查询
     * @param page
     * @param businessPlanInparameter
     * @return
     */
    public Page selectBusinessPlanData(Page page,BusinessPlanInparameter businessPlanInparameter){
        Page result = new Page();
        BusinessPlanExample businessPlanExample = new BusinessPlanExample();
        businessPlanExample.setPage(page);
        businessPlanExample.setOrderByClause("ID");
        BusinessPlanExample.Criteria criteria = businessPlanExample.createCriteria();
        criteria.andPlanYearEqualTo(businessPlanInparameter.getYear());
        //添加搜索条件
        if(businessPlanInparameter.getCategory()!=null && businessPlanInparameter.getCategory().size()>0){
            criteria.andCategoryIn(businessPlanInparameter.getCategory());
        }
        if(businessPlanInparameter.getBpName()!=null && businessPlanInparameter.getBpName().size()>0){
            criteria.andBpNameIn(businessPlanInparameter.getBpName());
        }
        if(businessPlanInparameter.getBrand()!=null && businessPlanInparameter.getBrand().size()>0){
            criteria.andBrandIn(businessPlanInparameter.getBrand());
        }
        if(businessPlanInparameter.getPpName()!=null && businessPlanInparameter.getPpName().size()>0){
            criteria.andPpNameIn(businessPlanInparameter.getPpName());
        }
        if(businessPlanInparameter.getBg()!=null && businessPlanInparameter.getBg().size()>0){
            criteria.andBgIn(businessPlanInparameter.getBg());
        }
        List<BusinessPlan> list = businessPlanMapper.selectByExamplePage(businessPlanExample);
        Integer count = businessPlanMapper.countByExample(businessPlanExample);
        result.setRecords(list);
        result.setTotalRecord(count);
        return result;
    }


    /**
     * Business Plan下拉框字典
     * @return
     */
    public Map<String,Object> distinctSelect(){
        Map<String,Object> result = new HashMap<>();
        List<BusinessPlan> list = businessPlanCustomerMapper.distinctSelect();
        List<String> category = new ArrayList<>();
        List<String> bpName = new ArrayList<>();
        List<String> brand = new ArrayList<>();
        List<String> ppName = new ArrayList<>();
        List<String> bg = new ArrayList<>();
        for(BusinessPlan businessPlan : list){
            if(!category.contains(businessPlan.getCategory())){
                category.add(businessPlan.getCategory());
            }
            if(!bpName.contains(businessPlan.getBpName())){
                bpName.add(businessPlan.getBpName());
            }
            if(!brand.contains(businessPlan.getBrand())){
                brand.add(businessPlan.getBrand());
            }
            if(!ppName.contains(businessPlan.getPpName())){
                ppName.add(businessPlan.getPpName());
            }
            if(!bg.contains(businessPlan.getBg())){
                bg.add(businessPlan.getBg());
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
     * Business Report 导出
     * @param request
     * @param response
     * @return
     */
    public Map<String,Object> businessReportExport(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashMap<>();
        try {
            BusinessPlanInparameter businessPlanInparameter = new BusinessPlanInparameter();
            //get parameter
            String year = request.getParameter("year");
            String category = request.getParameter("category");
            String bpName = request.getParameter("bpName");
            String brand = request.getParameter("brand");
            String ppName = request.getParameter("ppName");
            String bg = request.getParameter("bg");
            //组装查询条件
            if(StringUtils.isNotBlank(year)){
                businessPlanInparameter.setYear(year);
            }
            if(StringUtils.isNotBlank(category)){
                businessPlanInparameter.setCategory(StringToListUtils.changeToList(category,","));
            }
            if(StringUtils.isNotBlank(bpName)){
                businessPlanInparameter.setBpName(StringToListUtils.changeToList(bpName,","));
            }
            if(StringUtils.isNotBlank(brand)){
                businessPlanInparameter.setBrand(StringToListUtils.changeToList(brand,","));
            }
            if(StringUtils.isNotBlank(ppName)){
                businessPlanInparameter.setPpName(StringToListUtils.changeToList(ppName,","));
            }
            if(StringUtils.isNotBlank(bg)){
                businessPlanInparameter.setBg(StringToListUtils.changeToList(bg,","));
            }
            //根据查询条件查询需要导出的数据
            BusinessPlanExample businessPlanExample = new BusinessPlanExample();
            BusinessPlanExample.Criteria criteria = businessPlanExample.createCriteria();
            criteria.andPlanYearEqualTo(businessPlanInparameter.getYear());
            if(businessPlanInparameter.getCategory()!=null && businessPlanInparameter.getCategory().size()>0){
                criteria.andCategoryIn(businessPlanInparameter.getCategory());
            }
            if(businessPlanInparameter.getBpName()!=null && businessPlanInparameter.getBpName().size()>0){
                criteria.andBpNameIn(businessPlanInparameter.getBpName());
            }
            if(businessPlanInparameter.getBrand()!=null && businessPlanInparameter.getBrand().size()>0){
                criteria.andBrandIn(businessPlanInparameter.getBrand());
            }
            if(businessPlanInparameter.getPpName()!=null && businessPlanInparameter.getPpName().size()>0){
                criteria.andPpNameIn(businessPlanInparameter.getPpName());
            }
            if(businessPlanInparameter.getBg()!=null && businessPlanInparameter.getBg().size()>0){
                criteria.andBgIn(businessPlanInparameter.getBg());
            }
            List<BusinessPlan> exportData = businessPlanMapper.selectByExample(businessPlanExample);
            // 创建一个excel
            XSSFWorkbook wb = new XSSFWorkbook();
            //创建sheet
            XSSFSheet sheet = wb.createSheet("Business Plan");
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
            Field[] fields = BusinessPlan.class.getDeclaredFields();
            List<String> keys = new ArrayList<>();
            for(int i=0;i<fields.length;i++){
                Field field = fields[i];
                field.setAccessible(true);
                XSSFCell firstCol = row.createCell(i);
                firstCol.setCellStyle(titleStyle);
                keys.add(field.getName());
                firstCol.setCellValue(field.getName());
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
                    col.setCellValue(method.invoke(exportData.get(i),null).toString());
                }
            }
            request.setCharacterEncoding("UTF-8");
            String fileName = "消费记录.xlsx";
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

}