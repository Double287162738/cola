package com.coca.model;

import com.coca.util.Page;

import java.io.Serializable;
import java.util.List;

public class ActualSalesInparameter implements Serializable{


    private List<ActualSales> actualSalesList;

    private String year;

    private String month;

    private List<String> category;

    private List<String> bpName;

    private List<String> brand;

    private List<String> ppName;

    private List<String> bg;

    private Page page;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<ActualSales> getActualSalesList() {
        return actualSalesList;
    }

    public void setActualSalesList(List<ActualSales> actualSalesList) {
        this.actualSalesList = actualSalesList;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<String> getBpName() {
        return bpName;
    }

    public void setBpName(List<String> bpName) {
        this.bpName = bpName;
    }

    public List<String> getBrand() {
        return brand;
    }

    public void setBrand(List<String> brand) {
        this.brand = brand;
    }

    public List<String> getPpName() {
        return ppName;
    }

    public void setPpName(List<String> ppName) {
        this.ppName = ppName;
    }

    public List<String> getBg() {
        return bg;
    }

    public void setBg(List<String> bg) {
        this.bg = bg;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}