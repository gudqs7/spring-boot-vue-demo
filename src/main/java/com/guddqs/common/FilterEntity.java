package com.guddqs.common;

/**
 * @author wq
 * @date 2018/5/8
 */
public class FilterEntity {
    private String type;
    private Object value;
    private String field;
    private String operator;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
}
