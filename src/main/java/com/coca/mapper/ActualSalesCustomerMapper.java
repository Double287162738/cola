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
     * 批量insert计划数据
     * @param list
     */
    void batchInsertActualSalesData(@Param("list") List<ActualSales> list);


    /**
     * 批量update计划数据
     * @param list
     */
    void batchUpdateActualSalesData(@Param("list") List<ActualSales> list,@Param("bigMonth") int bigMonth );


    /**
     * 下拉框初始化查询
     * @return
     */
    List<ActualSales> distinctActualSalesSelect();
}