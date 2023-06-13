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
 * @since 2023-06-08
 */
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务编号
     */
    @TableId(value = "svs_id", type = IdType.AUTO)
    private Integer svsId;

    /**
     * 咨询、投诉、建议
     */
    private String svsType;

    /**
     * 描述问题的一句话
     */
    private String svsOverview;

    /**
     * 详细描述
     */
    private String svsRequirements;

    /**
     * 客户编号
     */
    private Integer cusId;

    /**
     * 创建人姓名（谁创建的这个服务）
     */
    private String svsFounder;

    /**
     * 创建时间
     */
    private String svsCreationtime;

    /**
     * 新创建、已分配、已处理、已归档
     */
    private String svsState;

    /**
     * 分配时间
     */
    private String svsAllocatetime;

    /**
     * 处理人
     */
    private String svsProcessingpeople;

    /**
     * 处理方法
     */
    private String svsProcessingmethod;

    /**
     * 处理时间
     */
    private String svsProcessingtime;

    /**
     * 客户反馈
     */
    private String svsCustomerfeedback;

    /**
     * 1、2、3、4、5
     */
    private Integer svsCustomersatisfaction;

    /**
     * 反馈时间
     */
    private String svsFeedbacktime;

    public Integer getSvsId() {
        return svsId;
    }

    public void setSvsId(Integer svsId) {
        this.svsId = svsId;
    }

    public String getSvsType() {
        return svsType;
    }

    public void setSvsType(String svsType) {
        this.svsType = svsType;
    }

    public String getSvsOverview() {
        return svsOverview;
    }

    public void setSvsOverview(String svsOverview) {
        this.svsOverview = svsOverview;
    }

    public String getSvsRequirements() {
        return svsRequirements;
    }

    public void setSvsRequirements(String svsRequirements) {
        this.svsRequirements = svsRequirements;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getSvsFounder() {
        return svsFounder;
    }

    public void setSvsFounder(String svsFounder) {
        this.svsFounder = svsFounder;
    }

    public String getSvsCreationtime() {
        return svsCreationtime;
    }

    public void setSvsCreationtime(String svsCreationtime) {
        this.svsCreationtime = svsCreationtime;
    }

    public String getSvsState() {
        return svsState;
    }

    public void setSvsState(String svsState) {
        this.svsState = svsState;
    }

    public String getSvsAllocatetime() {
        return svsAllocatetime;
    }

    public void setSvsAllocatetime(String svsAllocatetime) {
        this.svsAllocatetime = svsAllocatetime;
    }

    public String getSvsProcessingpeople() {
        return svsProcessingpeople;
    }

    public void setSvsProcessingpeople(String svsProcessingpeople) {
        this.svsProcessingpeople = svsProcessingpeople;
    }

    public String getSvsProcessingmethod() {
        return svsProcessingmethod;
    }

    public void setSvsProcessingmethod(String svsProcessingmethod) {
        this.svsProcessingmethod = svsProcessingmethod;
    }

    public String getSvsProcessingtime() {
        return svsProcessingtime;
    }

    public void setSvsProcessingtime(String svsProcessingtime) {
        this.svsProcessingtime = svsProcessingtime;
    }

    public String getSvsCustomerfeedback() {
        return svsCustomerfeedback;
    }

    public void setSvsCustomerfeedback(String svsCustomerfeedback) {
        this.svsCustomerfeedback = svsCustomerfeedback;
    }

    public Integer getSvsCustomersatisfaction() {
        return svsCustomersatisfaction;
    }

    public void setSvsCustomersatisfaction(Integer svsCustomersatisfaction) {
        this.svsCustomersatisfaction = svsCustomersatisfaction;
    }

    public String getSvsFeedbacktime() {
        return svsFeedbacktime;
    }

    public void setSvsFeedbacktime(String svsFeedbacktime) {
        this.svsFeedbacktime = svsFeedbacktime;
    }

    @Override
    public String toString() {
        return "Services{" +
        "svsId = " + svsId +
        ", svsType = " + svsType +
        ", svsOverview = " + svsOverview +
        ", svsRequirements = " + svsRequirements +
        ", cusId = " + cusId +
        ", svsFounder = " + svsFounder +
        ", svsCreationtime = " + svsCreationtime +
        ", svsState = " + svsState +
        ", svsAllocatetime = " + svsAllocatetime +
        ", svsProcessingpeople = " + svsProcessingpeople +
        ", svsProcessingmethod = " + svsProcessingmethod +
        ", svsProcessingtime = " + svsProcessingtime +
        ", svsCustomerfeedback = " + svsCustomerfeedback +
        ", svsCustomersatisfaction = " + svsCustomersatisfaction +
        ", svsFeedbacktime = " + svsFeedbacktime +
        "}";
    }
}
