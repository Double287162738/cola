package com.coca.service;


import com.coca.mapper.ActualSalesCustomerMapper;
import com.coca.mapper.ActualSalesMapper;
import com.coca.model.*;
import com.coca.util.SnowflakeIdWorker;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            Double everyTimeNum = 100.0;
            Double totalNum = Double.valueOf(dataList.size());
            int frequency = (int) Math.ceil(totalNum/everyTimeNum);
            for(int i=1;i<=frequency;i++){
                List<ActualSales> list = new ArrayList<>();
                int startIndex = (i-1)*100;
                int endIndex = i*100-1;
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

}