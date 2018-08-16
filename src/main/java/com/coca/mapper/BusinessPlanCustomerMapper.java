package com.coca.mapper;

import com.coca.model.BusinessPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BusinessPlanCustomerMapper {

    /**
     * 批量插入计划数据
     * @param list
     */
    void batchInsertBusinessPlanData(@Param("list") List<BusinessPlan> list);


    /**
     * Business Plan 搜索下拉框字典
     * @return
     */
    List<BusinessPlan> distinctSelect();
}