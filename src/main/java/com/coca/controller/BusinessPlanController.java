package com.coca.controller;


import com.coca.model.BusinessPlanInparameter;
import com.coca.service.BusinessPlanService;
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
public class BusinessPlanController {

    @Resource
    private BusinessPlanService businessPlanService;


    /**
     * Business Creating 上传
     * @param businessPlanInparameter
     * @return
     */
    @RequestMapping("uploadPlanData.do")
    @ResponseBody
    public Map<String,Object> uploadPlanData(@RequestBody BusinessPlanInparameter businessPlanInparameter){
        Map<String,Object> result = new HashMap<>();
        try {
            businessPlanService.insertBusinessPlanData(businessPlanInparameter);
        }catch (Exception e){
            result.put("error","上传错误请重试或者联系管理员");
            return result;
        }
        return result;
    }


    /**
     * Business Plan Report 搜索数据
     * @param businessPlanInparameter
     * @return
     */
    @RequestMapping("selectBusinessPlanData.do")
    @ResponseBody
    public Map<String,Object> selectBusinessPlanData(@RequestBody BusinessPlanInparameter businessPlanInparameter){
        Page page = businessPlanInparameter.getPage();
        Map<String,Object> result = new HashMap<>();
        try {
            Page resultPage = businessPlanService.selectBusinessPlanData(page,businessPlanInparameter);
            result.put("result",resultPage);
        }catch (Exception e){
            e.getMessage();
            result.put("error","请重试或者联系管理员");
            return result;
        }
        return result;
    }


    /**
     * Business Plan Report 下拉框初始化
     * @return
     */
    @RequestMapping("distinctSelect.do")
    @ResponseBody
    public Map<String,Object> distinctSelect(){
        Map<String,Object> result = new HashMap<>();
        try {
            result=businessPlanService.distinctSelect();
        }catch (Exception e){
            result.put("error","上传错误请重试或者联系管理员");
            return result;
        }
        return result;
    }


    /**
     * Business Report 导出
     * @return
     */
    @RequestMapping(value="/businessReportExport.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> businessReportExport(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashMap<>();
        try {
            result=businessPlanService.businessReportExport(request,response);
        }catch (Exception e){
            result.put("error","上传错误请重试或者联系管理员");
            return result;
        }
        return result;
    }

}