package com.bjpowernode.crm.settings.entity;

public class DicValue {
    private String id;
    private String value;
    private String text;
    private String orderNo;
    private String typeCode;
    private String name;

    public DicValue(String id, String value, String text, String orderNo, String typeCode, String name) {
        this.id = id;
        this.value = value;
        this.text = text;
        this.orderNo = orderNo;
        this.typeCode = typeCode;
        this.name = name;
    }

    public DicValue() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DicValue{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", text='" + text + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
