package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 * @author CQUT
 * @since 2023-06-11
 */
@TableName("sale_chance")
public class SaleChance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售机会编号
     */
    @TableId(value = "sc_id", type = IdType.AUTO)
    private Integer scId;

    /**
     * 客户名称
     */
    private String scCusName;

    /**
     * 机会来源：1促销，2广告，3搜索引擎，4线上咨询，5电话咨询，6邮件咨询，7客户介绍
     */
    private Integer scChanceSource;

    /**
     * 联系人
     */
    private String scContact;

    /**
     * 联系电话
     */
    private String scPhone;

    /**
     * 成功几率
     */
    private Integer scProbability;

    /**
     * 概要
     */
    private String scSummary;

    /**
     * 机会描述
     */
    private String scDesc;

    /**
     * 创建人
     */
    private String scCreator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime scCreationTime;

    /**
     * 指派给
     */
    private String scAssignTo;

    /**
     * 指派时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime scAssignTime;

    /**
     * 销售机会的状态：1未分配，2已分配，3开发成功，4开发失败
     */
    private Integer scStatus;

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScCusName() {
        return scCusName;
    }

    public void setScCusName(String scCusName) {
        this.scCusName = scCusName;
    }

    public Integer getScChanceSource() {
        return scChanceSource;
    }

    public void setScChanceSource(Integer scChanceSource) {
        this.scChanceSource = scChanceSource;
    }

    public String getScContact() {
        return scContact;
    }

    public void setScContact(String scContact) {
        this.scContact = scContact;
    }

    public String getScPhone() {
        return scPhone;
    }

    public void setScPhone(String scPhone) {
        this.scPhone = scPhone;
    }

    public Integer getScProbability() {
        return scProbability;
    }

    public void setScProbability(Integer scProbability) {
        this.scProbability = scProbability;
    }

    public String getScSummary() {
        return scSummary;
    }

    public void setScSummary(String scSummary) {
        this.scSummary = scSummary;
    }

    public String getScDesc() {
        return scDesc;
    }

    public void setScDesc(String scDesc) {
        this.scDesc = scDesc;
    }

    public String getScCreator() {
        return scCreator;
    }

    public void setScCreator(String scCreator) {
        this.scCreator = scCreator;
    }

    public LocalDateTime getScCreationTime() {
        return scCreationTime;
    }

    public void setScCreationTime(LocalDateTime scCreationTime) {
        this.scCreationTime = scCreationTime;
    }

    public String getScAssignTo() {
        return scAssignTo;
    }

    public void setScAssignTo(String scAssignTo) {
        this.scAssignTo = scAssignTo;
    }

    public LocalDateTime getScAssignTime() {
        return scAssignTime;
    }

    public void setScAssignTime(LocalDateTime scAssignTime) {
        this.scAssignTime = scAssignTime;
    }

    public Integer getScStatus() {
        return scStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.scStatus = scStatus;
    }

    @Override
    public String toString() {
        return "SaleChance{" +
        "scId = " + scId +
        ", scCusName = " + scCusName +
        ", scChanceSource = " + scChanceSource +
        ", scContact = " + scContact +
        ", scPhone = " + scPhone +
        ", scProbability = " + scProbability +
        ", scSummary = " + scSummary +
        ", scDesc = " + scDesc +
        ", scCreator = " + scCreator +
        ", scCreationTime = " + scCreationTime +
        ", scAssignTo = " + scAssignTo +
        ", scAssignTime = " + scAssignTime +
        ", scStatus = " + scStatus +
        "}";
    }
}
