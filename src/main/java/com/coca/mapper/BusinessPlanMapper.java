package com.coca.mapper;

import com.coca.model.BusinessPlan;
import com.coca.model.BusinessPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessPlanMapper {
    int countByExample(BusinessPlanExample example);

    int deleteByExample(BusinessPlanExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusinessPlan record);

    int insertSelective(BusinessPlan record);

    List<BusinessPlan> selectByExample(BusinessPlanExample example);

    List<BusinessPlan> selectByExamplePage(BusinessPlanExample example);

    BusinessPlan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusinessPlan record, @Param("example") BusinessPlanExample example);

    int updateByExample(@Param("record") BusinessPlan record, @Param("example") BusinessPlanExample example);

    int updateByPrimaryKeySelective(BusinessPlan record);

    int updateByPrimaryKey(BusinessPlan record);
}