package com.coca.mapper;

import com.coca.model.ActualSales;
import com.coca.model.ActualSalesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualSalesMapper {
    int countByExample(ActualSalesExample example);

    int deleteByExample(ActualSalesExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActualSales record);

    int insertSelective(ActualSales record);

    List<ActualSales> selectByExample(ActualSalesExample example);

    ActualSales selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActualSales record, @Param("example") ActualSalesExample example);

    int updateByExample(@Param("record") ActualSales record, @Param("example") ActualSalesExample example);

    int updateByPrimaryKeySelective(ActualSales record);

    int updateByPrimaryKey(ActualSales record);
}