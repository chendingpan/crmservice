
package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-13
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号，主键，自动递增
     */
    @TableId(value = "odr_id", type = IdType.AUTO)
    private Integer odrId;

    /**
     * 订单日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime odrTime;

    /**
     * 订单金额
     */
    private BigDecimal odrAmount;

    /**
     * 订单状态。1-未付款、2-已付款、3-已发货、4-已收货、5-已退货
     */
    private Integer odrStatus;

    /**
     * 客户编号
     */
    private Integer cusId;

    public Integer getOdrId() {
        return odrId;
    }

    public void setOdrId(Integer odrId) {
        this.odrId = odrId;
    }

    public LocalDateTime getOdrTime() {
        return odrTime;
    }

    public void setOdrTime(LocalDateTime odrTime) {
        this.odrTime = odrTime;
    }

    public BigDecimal getOdrAmount() {
        return odrAmount;
    }

    public void setOdrAmount(BigDecimal odrAmount) {
        this.odrAmount = odrAmount;
    }

    public Integer getOdrStatus() {
        return odrStatus;
    }

    public void setOdrStatus(Integer odrStatus) {
        this.odrStatus = odrStatus;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Orders{" +
        "odrId = " + odrId +
        ", odrTime = " + odrTime +
        ", odrAmount = " + odrAmount +
        ", odrStatus = " + odrStatus +
        ", cusId = " + cusId +
        "}";
    }
}
