package com.coca.controller;


import com.coca.model.ActualSalesInparameter;
import com.coca.model.BusinessPlanInparameter;
import com.coca.service.ActualSalesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AcutalSalesController {

    @Resource
    private ActualSalesService actualSalesService;


    @RequestMapping("uploadActualSalesData.do")
    @ResponseBody
    public Map<String,Object> uploadActualSalesData(@RequestBody ActualSalesInparameter actualSalesInparameter){
        Map<String,Object> result = new HashMap<>();
        try {
            actualSalesService.insertOrUpdateActualsData(actualSalesInparameter);
        }catch (Exception e){
            if(e.getMessage().length()>50){
                result.put("error","上传错误请重试或者联系管理员");
            }else {
                result.put("error",e.getMessage());
            }
            return result;
        }
        return result;
    }
}