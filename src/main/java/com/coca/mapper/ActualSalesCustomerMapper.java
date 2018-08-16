package com.coca.mapper;

import com.coca.model.ActualSales;
import com.coca.model.ActualSalesExample;
import com.coca.model.BusinessPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActualSalesCustomerMapper {
    /**
     * 批量插入计划数据
     * @param list
     */
    void batchInsertActualSalesData(@Param("list") List<ActualSales> list);


    /**
     * 批量插入计划数据
     * @param list
     */
    void batchUpdateActualSalesData(@Param("list") List<ActualSales> list,@Param("bigMonth") int bigMonth );
}