package cn.edu.cqut.crmservice.entity;

import java.io.Serializable;

public class Report implements Serializable {
    private String item;
    private String value;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getValue() {
        return Long.valueOf(value);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
