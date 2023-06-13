package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号
     */
    @TableId(value = "cus_id", type = IdType.AUTO)
    private Integer cusId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 客户地区：1.华南、2.华东、3.中南、4.西北、5.西南
     */
    private Integer cusRegion;

    /**
     * 客户行业：1.金融、2.房地产、3.商业服务、4.运输物流、5.生产、6.政府、7.文化传媒、8.其他
     */
    private Integer cusIndustry;

    /**
     * 客户等级：1.重点客户、2.普通客户、3.非优先客户
     */
    private Integer cusLevel;

    /**
     * 客户评分：1、2、3、4、5
     */
    private Integer cusRate;

    /**
     * 信用等级：1、2、3、4、5
     */
    private Integer cusCredit;

    /**
     * 客户地址
     */
    private String cusAddr;

    /**
     * 客户邮编
     */
    private String cusPostcode;

    /**
     * 客户电话
     */
    private String cusPhone;

    /**
     * 客户网址
     */
    private String cusUrl;

    /**
     * 客户传真
     */
    private String cusFax;

    /**
     * 销售员
     */
    private String cusSalesperson;

    /**
     * 状态：正常（1）、流失（2）
     */
    private Integer cusState;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Integer getCusRegion() {
        return cusRegion;
    }

    public void setCusRegion(Integer cusRegion) {
        this.cusRegion = cusRegion;
    }

    public Integer getCusIndustry() {
        return cusIndustry;
    }

    public void setCusIndustry(Integer cusIndustry) {
        this.cusIndustry = cusIndustry;
    }

    public Integer getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(Integer cusLevel) {
        this.cusLevel = cusLevel;
    }

    public Integer getCusRate() {
        return cusRate;
    }

    public void setCusRate(Integer cusRate) {
        this.cusRate = cusRate;
    }

    public Integer getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(Integer cusCredit) {
        this.cusCredit = cusCredit;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public String getCusPostcode() {
        return cusPostcode;
    }

    public void setCusPostcode(String cusPostcode) {
        this.cusPostcode = cusPostcode;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusUrl() {
        return cusUrl;
    }

    public void setCusUrl(String cusUrl) {
        this.cusUrl = cusUrl;
    }

    public String getCusFax() {
        return cusFax;
    }

    public void setCusFax(String cusFax) {
        this.cusFax = cusFax;
    }

    public String getCusSalesperson() {
        return cusSalesperson;
    }

    public void setCusSalesperson(String cusSalesperson) {
        this.cusSalesperson = cusSalesperson;
    }

    public Integer getCusState() {
        return cusState;
    }

    public void setCusState(Integer cusState) {
        this.cusState = cusState;
    }

    @Override
    public String toString() {
        return "Customer{" +
        "cusId = " + cusId +
        ", cusName = " + cusName +
        ", cusRegion = " + cusRegion +
        ", cusIndustry = " + cusIndustry +
        ", cusLevel = " + cusLevel +
        ", cusRate = " + cusRate +
        ", cusCredit = " + cusCredit +
        ", cusAddr = " + cusAddr +
        ", cusPostcode = " + cusPostcode +
        ", cusPhone = " + cusPhone +
        ", cusUrl = " + cusUrl +
        ", cusFax = " + cusFax +
        ", cusSalesperson = " + cusSalesperson +
        ", cusState = " + cusState +
        "}";
    }
}
