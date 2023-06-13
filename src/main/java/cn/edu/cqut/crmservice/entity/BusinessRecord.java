package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@TableName("business_record")
public class BusinessRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate cusDate;

    /**
     * 地点
     */
    private String cusLocation;

    /**
     * 概要
     */
    private String cusSummary;

    /**
     * 详细信息
     */
    private String cusDetailInformation;

    /**
     * 客户编号
     */
    private Integer cusId;

    /**
     * 销售员
     */
    private Integer cusSalesperson;

    @TableId(value = "con_record_id", type = IdType.AUTO)
    private Integer conRecordId;

    public Integer getConRecordId() {
        return conRecordId;
    }

    public void setConRecordId(Integer conRecordId) {
        this.conRecordId = conRecordId;
    }

    public LocalDate getCusDate() {
        return cusDate;
    }

    public void setCusDate(LocalDate cusDate) {
        this.cusDate = cusDate;
    }

    public String getCusLocation() {
        return cusLocation;
    }

    public void setCusLocation(String cusLocation) {
        this.cusLocation = cusLocation;
    }

    public String getCusSummary() {
        return cusSummary;
    }

    public void setCusSummary(String cusSummary) {
        this.cusSummary = cusSummary;
    }

    public String getCusDetailInformation() {
        return cusDetailInformation;
    }

    public void setCusDetailInformation(String cusDetailInformation) {
        this.cusDetailInformation = cusDetailInformation;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getCusSalesperson() {
        return cusSalesperson;
    }

    public void setCusSalesperson(Integer cusSalesperson) {
        this.cusSalesperson = cusSalesperson;
    }

    @Override
    public String toString() {
        return "BusinessRecord{" +
        "cusDate = " + cusDate +
        ", cusLocation = " + cusLocation +
        ", cusSummary = " + cusSummary +
        ", cusDetailInformation = " + cusDetailInformation +
        ", cusId = " + cusId +
        ", cusSalesperson = " + cusSalesperson +
        "}";
    }
}
