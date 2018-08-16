package com.coca.model;

import java.util.ArrayList;
import java.util.List;

public class ActualSalesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActualSalesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andActualYearIsNull() {
            addCriterion("ACTUAL_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andActualYearIsNotNull() {
            addCriterion("ACTUAL_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andActualYearEqualTo(String value) {
            addCriterion("ACTUAL_YEAR =", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearNotEqualTo(String value) {
            addCriterion("ACTUAL_YEAR <>", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearGreaterThan(String value) {
            addCriterion("ACTUAL_YEAR >", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearGreaterThanOrEqualTo(String value) {
            addCriterion("ACTUAL_YEAR >=", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearLessThan(String value) {
            addCriterion("ACTUAL_YEAR <", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearLessThanOrEqualTo(String value) {
            addCriterion("ACTUAL_YEAR <=", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearLike(String value) {
            addCriterion("ACTUAL_YEAR like", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearNotLike(String value) {
            addCriterion("ACTUAL_YEAR not like", value, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearIn(List<String> values) {
            addCriterion("ACTUAL_YEAR in", values, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearNotIn(List<String> values) {
            addCriterion("ACTUAL_YEAR not in", values, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearBetween(String value1, String value2) {
            addCriterion("ACTUAL_YEAR between", value1, value2, "actualYear");
            return (Criteria) this;
        }

        public Criteria andActualYearNotBetween(String value1, String value2) {
            addCriterion("ACTUAL_YEAR not between", value1, value2, "actualYear");
            return (Criteria) this;
        }

        public Criteria andFullCodeIsNull() {
            addCriterion("FULL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFullCodeIsNotNull() {
            addCriterion("FULL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFullCodeEqualTo(String value) {
            addCriterion("FULL_CODE =", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeNotEqualTo(String value) {
            addCriterion("FULL_CODE <>", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeGreaterThan(String value) {
            addCriterion("FULL_CODE >", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FULL_CODE >=", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeLessThan(String value) {
            addCriterion("FULL_CODE <", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeLessThanOrEqualTo(String value) {
            addCriterion("FULL_CODE <=", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeLike(String value) {
            addCriterion("FULL_CODE like", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeNotLike(String value) {
            addCriterion("FULL_CODE not like", value, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeIn(List<String> values) {
            addCriterion("FULL_CODE in", values, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeNotIn(List<String> values) {
            addCriterion("FULL_CODE not in", values, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeBetween(String value1, String value2) {
            addCriterion("FULL_CODE between", value1, value2, "fullCode");
            return (Criteria) this;
        }

        public Criteria andFullCodeNotBetween(String value1, String value2) {
            addCriterion("FULL_CODE not between", value1, value2, "fullCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeIsNull() {
            addCriterion("BP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBpCodeIsNotNull() {
            addCriterion("BP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBpCodeEqualTo(String value) {
            addCriterion("BP_CODE =", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeNotEqualTo(String value) {
            addCriterion("BP_CODE <>", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeGreaterThan(String value) {
            addCriterion("BP_CODE >", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BP_CODE >=", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeLessThan(String value) {
            addCriterion("BP_CODE <", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeLessThanOrEqualTo(String value) {
            addCriterion("BP_CODE <=", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeLike(String value) {
            addCriterion("BP_CODE like", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeNotLike(String value) {
            addCriterion("BP_CODE not like", value, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeIn(List<String> values) {
            addCriterion("BP_CODE in", values, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeNotIn(List<String> values) {
            addCriterion("BP_CODE not in", values, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeBetween(String value1, String value2) {
            addCriterion("BP_CODE between", value1, value2, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpCodeNotBetween(String value1, String value2) {
            addCriterion("BP_CODE not between", value1, value2, "bpCode");
            return (Criteria) this;
        }

        public Criteria andBpNameIsNull() {
            addCriterion("BP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBpNameIsNotNull() {
            addCriterion("BP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBpNameEqualTo(String value) {
            addCriterion("BP_NAME =", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameNotEqualTo(String value) {
            addCriterion("BP_NAME <>", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameGreaterThan(String value) {
            addCriterion("BP_NAME >", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameGreaterThanOrEqualTo(String value) {
            addCriterion("BP_NAME >=", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameLessThan(String value) {
            addCriterion("BP_NAME <", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameLessThanOrEqualTo(String value) {
            addCriterion("BP_NAME <=", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameLike(String value) {
            addCriterion("BP_NAME like", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameNotLike(String value) {
            addCriterion("BP_NAME not like", value, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameIn(List<String> values) {
            addCriterion("BP_NAME in", values, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameNotIn(List<String> values) {
            addCriterion("BP_NAME not in", values, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameBetween(String value1, String value2) {
            addCriterion("BP_NAME between", value1, value2, "bpName");
            return (Criteria) this;
        }

        public Criteria andBpNameNotBetween(String value1, String value2) {
            addCriterion("BP_NAME not between", value1, value2, "bpName");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("CATEGORY =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("CATEGORY <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("CATEGORY >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("CATEGORY <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("CATEGORY like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("CATEGORY not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("CATEGORY in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("CATEGORY not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("CATEGORY between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("CATEGORY not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("BRAND is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("BRAND is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("BRAND =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("BRAND <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("BRAND >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("BRAND <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("BRAND <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("BRAND like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("BRAND not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("BRAND in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("BRAND not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("BRAND between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("BRAND not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andPpCodeIsNull() {
            addCriterion("PP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPpCodeIsNotNull() {
            addCriterion("PP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPpCodeEqualTo(String value) {
            addCriterion("PP_CODE =", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeNotEqualTo(String value) {
            addCriterion("PP_CODE <>", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeGreaterThan(String value) {
            addCriterion("PP_CODE >", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PP_CODE >=", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeLessThan(String value) {
            addCriterion("PP_CODE <", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeLessThanOrEqualTo(String value) {
            addCriterion("PP_CODE <=", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeLike(String value) {
            addCriterion("PP_CODE like", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeNotLike(String value) {
            addCriterion("PP_CODE not like", value, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeIn(List<String> values) {
            addCriterion("PP_CODE in", values, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeNotIn(List<String> values) {
            addCriterion("PP_CODE not in", values, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeBetween(String value1, String value2) {
            addCriterion("PP_CODE between", value1, value2, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpCodeNotBetween(String value1, String value2) {
            addCriterion("PP_CODE not between", value1, value2, "ppCode");
            return (Criteria) this;
        }

        public Criteria andPpNameIsNull() {
            addCriterion("PP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPpNameIsNotNull() {
            addCriterion("PP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPpNameEqualTo(String value) {
            addCriterion("PP_NAME =", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameNotEqualTo(String value) {
            addCriterion("PP_NAME <>", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameGreaterThan(String value) {
            addCriterion("PP_NAME >", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameGreaterThanOrEqualTo(String value) {
            addCriterion("PP_NAME >=", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameLessThan(String value) {
            addCriterion("PP_NAME <", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameLessThanOrEqualTo(String value) {
            addCriterion("PP_NAME <=", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameLike(String value) {
            addCriterion("PP_NAME like", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameNotLike(String value) {
            addCriterion("PP_NAME not like", value, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameIn(List<String> values) {
            addCriterion("PP_NAME in", values, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameNotIn(List<String> values) {
            addCriterion("PP_NAME not in", values, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameBetween(String value1, String value2) {
            addCriterion("PP_NAME between", value1, value2, "ppName");
            return (Criteria) this;
        }

        public Criteria andPpNameNotBetween(String value1, String value2) {
            addCriterion("PP_NAME not between", value1, value2, "ppName");
            return (Criteria) this;
        }

        public Criteria andBgIsNull() {
            addCriterion("BG is null");
            return (Criteria) this;
        }

        public Criteria andBgIsNotNull() {
            addCriterion("BG is not null");
            return (Criteria) this;
        }

        public Criteria andBgEqualTo(String value) {
            addCriterion("BG =", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgNotEqualTo(String value) {
            addCriterion("BG <>", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgGreaterThan(String value) {
            addCriterion("BG >", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgGreaterThanOrEqualTo(String value) {
            addCriterion("BG >=", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgLessThan(String value) {
            addCriterion("BG <", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgLessThanOrEqualTo(String value) {
            addCriterion("BG <=", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgLike(String value) {
            addCriterion("BG like", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgNotLike(String value) {
            addCriterion("BG not like", value, "bg");
            return (Criteria) this;
        }

        public Criteria andBgIn(List<String> values) {
            addCriterion("BG in", values, "bg");
            return (Criteria) this;
        }

        public Criteria andBgNotIn(List<String> values) {
            addCriterion("BG not in", values, "bg");
            return (Criteria) this;
        }

        public Criteria andBgBetween(String value1, String value2) {
            addCriterion("BG between", value1, value2, "bg");
            return (Criteria) this;
        }

        public Criteria andBgNotBetween(String value1, String value2) {
            addCriterion("BG not between", value1, value2, "bg");
            return (Criteria) this;
        }

        public Criteria andPcCodeIsNull() {
            addCriterion("PC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPcCodeIsNotNull() {
            addCriterion("PC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPcCodeEqualTo(String value) {
            addCriterion("PC_CODE =", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeNotEqualTo(String value) {
            addCriterion("PC_CODE <>", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeGreaterThan(String value) {
            addCriterion("PC_CODE >", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PC_CODE >=", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeLessThan(String value) {
            addCriterion("PC_CODE <", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeLessThanOrEqualTo(String value) {
            addCriterion("PC_CODE <=", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeLike(String value) {
            addCriterion("PC_CODE like", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeNotLike(String value) {
            addCriterion("PC_CODE not like", value, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeIn(List<String> values) {
            addCriterion("PC_CODE in", values, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeNotIn(List<String> values) {
            addCriterion("PC_CODE not in", values, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeBetween(String value1, String value2) {
            addCriterion("PC_CODE between", value1, value2, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcCodeNotBetween(String value1, String value2) {
            addCriterion("PC_CODE not between", value1, value2, "pcCode");
            return (Criteria) this;
        }

        public Criteria andPcNameIsNull() {
            addCriterion("PC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPcNameIsNotNull() {
            addCriterion("PC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPcNameEqualTo(String value) {
            addCriterion("PC_NAME =", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotEqualTo(String value) {
            addCriterion("PC_NAME <>", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameGreaterThan(String value) {
            addCriterion("PC_NAME >", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameGreaterThanOrEqualTo(String value) {
            addCriterion("PC_NAME >=", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLessThan(String value) {
            addCriterion("PC_NAME <", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLessThanOrEqualTo(String value) {
            addCriterion("PC_NAME <=", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLike(String value) {
            addCriterion("PC_NAME like", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotLike(String value) {
            addCriterion("PC_NAME not like", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameIn(List<String> values) {
            addCriterion("PC_NAME in", values, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotIn(List<String> values) {
            addCriterion("PC_NAME not in", values, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameBetween(String value1, String value2) {
            addCriterion("PC_NAME between", value1, value2, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotBetween(String value1, String value2) {
            addCriterion("PC_NAME not between", value1, value2, "pcName");
            return (Criteria) this;
        }

        public Criteria andJanIsNull() {
            addCriterion("JAN is null");
            return (Criteria) this;
        }

        public Criteria andJanIsNotNull() {
            addCriterion("JAN is not null");
            return (Criteria) this;
        }

        public Criteria andJanEqualTo(String value) {
            addCriterion("JAN =", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanNotEqualTo(String value) {
            addCriterion("JAN <>", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanGreaterThan(String value) {
            addCriterion("JAN >", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanGreaterThanOrEqualTo(String value) {
            addCriterion("JAN >=", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanLessThan(String value) {
            addCriterion("JAN <", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanLessThanOrEqualTo(String value) {
            addCriterion("JAN <=", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanLike(String value) {
            addCriterion("JAN like", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanNotLike(String value) {
            addCriterion("JAN not like", value, "jan");
            return (Criteria) this;
        }

        public Criteria andJanIn(List<String> values) {
            addCriterion("JAN in", values, "jan");
            return (Criteria) this;
        }

        public Criteria andJanNotIn(List<String> values) {
            addCriterion("JAN not in", values, "jan");
            return (Criteria) this;
        }

        public Criteria andJanBetween(String value1, String value2) {
            addCriterion("JAN between", value1, value2, "jan");
            return (Criteria) this;
        }

        public Criteria andJanNotBetween(String value1, String value2) {
            addCriterion("JAN not between", value1, value2, "jan");
            return (Criteria) this;
        }

        public Criteria andFebIsNull() {
            addCriterion("FEB is null");
            return (Criteria) this;
        }

        public Criteria andFebIsNotNull() {
            addCriterion("FEB is not null");
            return (Criteria) this;
        }

        public Criteria andFebEqualTo(String value) {
            addCriterion("FEB =", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebNotEqualTo(String value) {
            addCriterion("FEB <>", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebGreaterThan(String value) {
            addCriterion("FEB >", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebGreaterThanOrEqualTo(String value) {
            addCriterion("FEB >=", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebLessThan(String value) {
            addCriterion("FEB <", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebLessThanOrEqualTo(String value) {
            addCriterion("FEB <=", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebLike(String value) {
            addCriterion("FEB like", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebNotLike(String value) {
            addCriterion("FEB not like", value, "feb");
            return (Criteria) this;
        }

        public Criteria andFebIn(List<String> values) {
            addCriterion("FEB in", values, "feb");
            return (Criteria) this;
        }

        public Criteria andFebNotIn(List<String> values) {
            addCriterion("FEB not in", values, "feb");
            return (Criteria) this;
        }

        public Criteria andFebBetween(String value1, String value2) {
            addCriterion("FEB between", value1, value2, "feb");
            return (Criteria) this;
        }

        public Criteria andFebNotBetween(String value1, String value2) {
            addCriterion("FEB not between", value1, value2, "feb");
            return (Criteria) this;
        }

        public Criteria andMarIsNull() {
            addCriterion("MAR is null");
            return (Criteria) this;
        }

        public Criteria andMarIsNotNull() {
            addCriterion("MAR is not null");
            return (Criteria) this;
        }

        public Criteria andMarEqualTo(String value) {
            addCriterion("MAR =", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarNotEqualTo(String value) {
            addCriterion("MAR <>", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarGreaterThan(String value) {
            addCriterion("MAR >", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarGreaterThanOrEqualTo(String value) {
            addCriterion("MAR >=", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarLessThan(String value) {
            addCriterion("MAR <", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarLessThanOrEqualTo(String value) {
            addCriterion("MAR <=", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarLike(String value) {
            addCriterion("MAR like", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarNotLike(String value) {
            addCriterion("MAR not like", value, "mar");
            return (Criteria) this;
        }

        public Criteria andMarIn(List<String> values) {
            addCriterion("MAR in", values, "mar");
            return (Criteria) this;
        }

        public Criteria andMarNotIn(List<String> values) {
            addCriterion("MAR not in", values, "mar");
            return (Criteria) this;
        }

        public Criteria andMarBetween(String value1, String value2) {
            addCriterion("MAR between", value1, value2, "mar");
            return (Criteria) this;
        }

        public Criteria andMarNotBetween(String value1, String value2) {
            addCriterion("MAR not between", value1, value2, "mar");
            return (Criteria) this;
        }

        public Criteria andAprIsNull() {
            addCriterion("APR is null");
            return (Criteria) this;
        }

        public Criteria andAprIsNotNull() {
            addCriterion("APR is not null");
            return (Criteria) this;
        }

        public Criteria andAprEqualTo(String value) {
            addCriterion("APR =", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprNotEqualTo(String value) {
            addCriterion("APR <>", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprGreaterThan(String value) {
            addCriterion("APR >", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprGreaterThanOrEqualTo(String value) {
            addCriterion("APR >=", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprLessThan(String value) {
            addCriterion("APR <", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprLessThanOrEqualTo(String value) {
            addCriterion("APR <=", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprLike(String value) {
            addCriterion("APR like", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprNotLike(String value) {
            addCriterion("APR not like", value, "apr");
            return (Criteria) this;
        }

        public Criteria andAprIn(List<String> values) {
            addCriterion("APR in", values, "apr");
            return (Criteria) this;
        }

        public Criteria andAprNotIn(List<String> values) {
            addCriterion("APR not in", values, "apr");
            return (Criteria) this;
        }

        public Criteria andAprBetween(String value1, String value2) {
            addCriterion("APR between", value1, value2, "apr");
            return (Criteria) this;
        }

        public Criteria andAprNotBetween(String value1, String value2) {
            addCriterion("APR not between", value1, value2, "apr");
            return (Criteria) this;
        }

        public Criteria andMayIsNull() {
            addCriterion("MAY is null");
            return (Criteria) this;
        }

        public Criteria andMayIsNotNull() {
            addCriterion("MAY is not null");
            return (Criteria) this;
        }

        public Criteria andMayEqualTo(String value) {
            addCriterion("MAY =", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayNotEqualTo(String value) {
            addCriterion("MAY <>", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayGreaterThan(String value) {
            addCriterion("MAY >", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayGreaterThanOrEqualTo(String value) {
            addCriterion("MAY >=", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayLessThan(String value) {
            addCriterion("MAY <", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayLessThanOrEqualTo(String value) {
            addCriterion("MAY <=", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayLike(String value) {
            addCriterion("MAY like", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayNotLike(String value) {
            addCriterion("MAY not like", value, "may");
            return (Criteria) this;
        }

        public Criteria andMayIn(List<String> values) {
            addCriterion("MAY in", values, "may");
            return (Criteria) this;
        }

        public Criteria andMayNotIn(List<String> values) {
            addCriterion("MAY not in", values, "may");
            return (Criteria) this;
        }

        public Criteria andMayBetween(String value1, String value2) {
            addCriterion("MAY between", value1, value2, "may");
            return (Criteria) this;
        }

        public Criteria andMayNotBetween(String value1, String value2) {
            addCriterion("MAY not between", value1, value2, "may");
            return (Criteria) this;
        }

        public Criteria andJunIsNull() {
            addCriterion("JUN is null");
            return (Criteria) this;
        }

        public Criteria andJunIsNotNull() {
            addCriterion("JUN is not null");
            return (Criteria) this;
        }

        public Criteria andJunEqualTo(String value) {
            addCriterion("JUN =", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunNotEqualTo(String value) {
            addCriterion("JUN <>", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunGreaterThan(String value) {
            addCriterion("JUN >", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunGreaterThanOrEqualTo(String value) {
            addCriterion("JUN >=", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunLessThan(String value) {
            addCriterion("JUN <", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunLessThanOrEqualTo(String value) {
            addCriterion("JUN <=", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunLike(String value) {
            addCriterion("JUN like", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunNotLike(String value) {
            addCriterion("JUN not like", value, "jun");
            return (Criteria) this;
        }

        public Criteria andJunIn(List<String> values) {
            addCriterion("JUN in", values, "jun");
            return (Criteria) this;
        }

        public Criteria andJunNotIn(List<String> values) {
            addCriterion("JUN not in", values, "jun");
            return (Criteria) this;
        }

        public Criteria andJunBetween(String value1, String value2) {
            addCriterion("JUN between", value1, value2, "jun");
            return (Criteria) this;
        }

        public Criteria andJunNotBetween(String value1, String value2) {
            addCriterion("JUN not between", value1, value2, "jun");
            return (Criteria) this;
        }

        public Criteria andJulIsNull() {
            addCriterion("JUL is null");
            return (Criteria) this;
        }

        public Criteria andJulIsNotNull() {
            addCriterion("JUL is not null");
            return (Criteria) this;
        }

        public Criteria andJulEqualTo(String value) {
            addCriterion("JUL =", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulNotEqualTo(String value) {
            addCriterion("JUL <>", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulGreaterThan(String value) {
            addCriterion("JUL >", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulGreaterThanOrEqualTo(String value) {
            addCriterion("JUL >=", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulLessThan(String value) {
            addCriterion("JUL <", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulLessThanOrEqualTo(String value) {
            addCriterion("JUL <=", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulLike(String value) {
            addCriterion("JUL like", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulNotLike(String value) {
            addCriterion("JUL not like", value, "jul");
            return (Criteria) this;
        }

        public Criteria andJulIn(List<String> values) {
            addCriterion("JUL in", values, "jul");
            return (Criteria) this;
        }

        public Criteria andJulNotIn(List<String> values) {
            addCriterion("JUL not in", values, "jul");
            return (Criteria) this;
        }

        public Criteria andJulBetween(String value1, String value2) {
            addCriterion("JUL between", value1, value2, "jul");
            return (Criteria) this;
        }

        public Criteria andJulNotBetween(String value1, String value2) {
            addCriterion("JUL not between", value1, value2, "jul");
            return (Criteria) this;
        }

        public Criteria andAugIsNull() {
            addCriterion("AUG is null");
            return (Criteria) this;
        }

        public Criteria andAugIsNotNull() {
            addCriterion("AUG is not null");
            return (Criteria) this;
        }

        public Criteria andAugEqualTo(String value) {
            addCriterion("AUG =", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugNotEqualTo(String value) {
            addCriterion("AUG <>", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugGreaterThan(String value) {
            addCriterion("AUG >", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugGreaterThanOrEqualTo(String value) {
            addCriterion("AUG >=", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugLessThan(String value) {
            addCriterion("AUG <", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugLessThanOrEqualTo(String value) {
            addCriterion("AUG <=", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugLike(String value) {
            addCriterion("AUG like", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugNotLike(String value) {
            addCriterion("AUG not like", value, "aug");
            return (Criteria) this;
        }

        public Criteria andAugIn(List<String> values) {
            addCriterion("AUG in", values, "aug");
            return (Criteria) this;
        }

        public Criteria andAugNotIn(List<String> values) {
            addCriterion("AUG not in", values, "aug");
            return (Criteria) this;
        }

        public Criteria andAugBetween(String value1, String value2) {
            addCriterion("AUG between", value1, value2, "aug");
            return (Criteria) this;
        }

        public Criteria andAugNotBetween(String value1, String value2) {
            addCriterion("AUG not between", value1, value2, "aug");
            return (Criteria) this;
        }

        public Criteria andSepIsNull() {
            addCriterion("SEP is null");
            return (Criteria) this;
        }

        public Criteria andSepIsNotNull() {
            addCriterion("SEP is not null");
            return (Criteria) this;
        }

        public Criteria andSepEqualTo(String value) {
            addCriterion("SEP =", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepNotEqualTo(String value) {
            addCriterion("SEP <>", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepGreaterThan(String value) {
            addCriterion("SEP >", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepGreaterThanOrEqualTo(String value) {
            addCriterion("SEP >=", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepLessThan(String value) {
            addCriterion("SEP <", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepLessThanOrEqualTo(String value) {
            addCriterion("SEP <=", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepLike(String value) {
            addCriterion("SEP like", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepNotLike(String value) {
            addCriterion("SEP not like", value, "sep");
            return (Criteria) this;
        }

        public Criteria andSepIn(List<String> values) {
            addCriterion("SEP in", values, "sep");
            return (Criteria) this;
        }

        public Criteria andSepNotIn(List<String> values) {
            addCriterion("SEP not in", values, "sep");
            return (Criteria) this;
        }

        public Criteria andSepBetween(String value1, String value2) {
            addCriterion("SEP between", value1, value2, "sep");
            return (Criteria) this;
        }

        public Criteria andSepNotBetween(String value1, String value2) {
            addCriterion("SEP not between", value1, value2, "sep");
            return (Criteria) this;
        }

        public Criteria andOctIsNull() {
            addCriterion("OCT is null");
            return (Criteria) this;
        }

        public Criteria andOctIsNotNull() {
            addCriterion("OCT is not null");
            return (Criteria) this;
        }

        public Criteria andOctEqualTo(String value) {
            addCriterion("OCT =", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctNotEqualTo(String value) {
            addCriterion("OCT <>", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctGreaterThan(String value) {
            addCriterion("OCT >", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctGreaterThanOrEqualTo(String value) {
            addCriterion("OCT >=", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctLessThan(String value) {
            addCriterion("OCT <", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctLessThanOrEqualTo(String value) {
            addCriterion("OCT <=", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctLike(String value) {
            addCriterion("OCT like", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctNotLike(String value) {
            addCriterion("OCT not like", value, "oct");
            return (Criteria) this;
        }

        public Criteria andOctIn(List<String> values) {
            addCriterion("OCT in", values, "oct");
            return (Criteria) this;
        }

        public Criteria andOctNotIn(List<String> values) {
            addCriterion("OCT not in", values, "oct");
            return (Criteria) this;
        }

        public Criteria andOctBetween(String value1, String value2) {
            addCriterion("OCT between", value1, value2, "oct");
            return (Criteria) this;
        }

        public Criteria andOctNotBetween(String value1, String value2) {
            addCriterion("OCT not between", value1, value2, "oct");
            return (Criteria) this;
        }

        public Criteria andNovIsNull() {
            addCriterion("NOV is null");
            return (Criteria) this;
        }

        public Criteria andNovIsNotNull() {
            addCriterion("NOV is not null");
            return (Criteria) this;
        }

        public Criteria andNovEqualTo(String value) {
            addCriterion("NOV =", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovNotEqualTo(String value) {
            addCriterion("NOV <>", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovGreaterThan(String value) {
            addCriterion("NOV >", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovGreaterThanOrEqualTo(String value) {
            addCriterion("NOV >=", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovLessThan(String value) {
            addCriterion("NOV <", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovLessThanOrEqualTo(String value) {
            addCriterion("NOV <=", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovLike(String value) {
            addCriterion("NOV like", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovNotLike(String value) {
            addCriterion("NOV not like", value, "nov");
            return (Criteria) this;
        }

        public Criteria andNovIn(List<String> values) {
            addCriterion("NOV in", values, "nov");
            return (Criteria) this;
        }

        public Criteria andNovNotIn(List<String> values) {
            addCriterion("NOV not in", values, "nov");
            return (Criteria) this;
        }

        public Criteria andNovBetween(String value1, String value2) {
            addCriterion("NOV between", value1, value2, "nov");
            return (Criteria) this;
        }

        public Criteria andNovNotBetween(String value1, String value2) {
            addCriterion("NOV not between", value1, value2, "nov");
            return (Criteria) this;
        }

        public Criteria andDeceIsNull() {
            addCriterion("DECE is null");
            return (Criteria) this;
        }

        public Criteria andDeceIsNotNull() {
            addCriterion("DECE is not null");
            return (Criteria) this;
        }

        public Criteria andDeceEqualTo(String value) {
            addCriterion("DECE =", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceNotEqualTo(String value) {
            addCriterion("DECE <>", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceGreaterThan(String value) {
            addCriterion("DECE >", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceGreaterThanOrEqualTo(String value) {
            addCriterion("DECE >=", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceLessThan(String value) {
            addCriterion("DECE <", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceLessThanOrEqualTo(String value) {
            addCriterion("DECE <=", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceLike(String value) {
            addCriterion("DECE like", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceNotLike(String value) {
            addCriterion("DECE not like", value, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceIn(List<String> values) {
            addCriterion("DECE in", values, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceNotIn(List<String> values) {
            addCriterion("DECE not in", values, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceBetween(String value1, String value2) {
            addCriterion("DECE between", value1, value2, "dece");
            return (Criteria) this;
        }

        public Criteria andDeceNotBetween(String value1, String value2) {
            addCriterion("DECE not between", value1, value2, "dece");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("UPDATE_TIME like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("UPDATE_TIME not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}