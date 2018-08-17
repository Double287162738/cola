package com.coca.controller;


import com.coca.model.ActualSalesInparameter;
import com.coca.model.BusinessPlanInparameter;
import com.coca.service.ActualSalesService;
import com.coca.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AcutalSalesController {

    @Resource
    private ActualSalesService actualSalesService;


    /**
     * 上传
     * @param actualSalesInparameter
     * @return
     */
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



    /**
     * Actual Sales Report 下拉框初始化
     * @return
     */
    @RequestMapping("distinctActualSalesSelect.do")
    @ResponseBody
    public Map<String,Object> distinctActualSalesSelect(){
        Map<String,Object> result = new HashMap<>();
        try {
            result=actualSalesService.distinctActualSalesSelect();
        }catch (Exception e){
            result.put("error","上传错误请重试或者联系管理员");
            return result;
        }
        return result;
    }

    /**
     * Actual Report 搜索数据
     * @param actualSalesInparameter
     * @return
     */
    @RequestMapping("selectActualSalesReportData.do")
    @ResponseBody
    public Map<String,Object> selectBusinessPlanData(@RequestBody ActualSalesInparameter actualSalesInparameter){
        Page page = actualSalesInparameter.getPage();
        Map<String,Object> result = new HashMap<>();
        try {
            Page resultPage = actualSalesService.selectActualSalesData(page,actualSalesInparameter);
            result.put("result",resultPage);
        }catch (Exception e){
            e.getMessage();
            result.put("error","请重试或者联系管理员");
            return result;
        }
        return result;
    }

    /**
     * Business Report 导出
     * @return
     */
    @RequestMapping(value="/actualSalesReportExport.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> businessReportExport(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashMap<>();
        try {
            result=actualSalesService.actualSalesReportExport(request,response);
        }catch (Exception e){
            result.put("error","上传错误请重试或者联系管理员");
            return result;
        }
        return result;
    }


}