package top.management.library.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import top.management.library.entity.base.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;;
import java.util.Date;

@Entity
@Table(name = "record")
public class Order extends AbstractEntity implements Comparable<Order> {

    private static final long serialVersionUID = 1L;

    @Column(name =" orderCode",nullable = false,unique = true)
    @NotNull
    private String orderCode;

    @Column(name = "type",nullable = false)
    @NotNull
    private Integer type; //1 订阅 2 购买

    @Column(name = "book_name",nullable = false)
    @NotNull
    private String bookName;

    @Column(name = "book_code",nullable = false)
    @NotNull
    private String bookCode;

    @Column(name = "order_amount",nullable = false)
    @NotNull
    private Integer orderAmount;

    @Column(name = "order_username",nullable = false)
    @NotNull
    private String orderUsername;

    @Column(name = "order_login_name",nullable = false)
    @NotNull
    private String orderLoginName;

    @Column(name = "payment_status",nullable = false)
    @NotNull
    private Integer paymentStatus;//0 未支付 1 已支付 2 订阅中 3 已退订 4 已到期

    @Column(name = "order_period")
    private Integer orderPeriod;//1 一月 2 一季度 3 半年 4 一年

    @Column(name = "expire_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireTime;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderUsername() {
        return orderUsername;
    }

    public void setOrderUsername(String orderUsername) {
        this.orderUsername = orderUsername;
    }

    public String getOrderLoginName() {
        return orderLoginName;
    }

    public void setOrderLoginName(String orderLoginName) {
        this.orderLoginName = orderLoginName;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getOrderPeriod() {
        return orderPeriod;
    }

    public void setOrderPeriod(Integer orderPeriod) {
        this.orderPeriod = orderPeriod;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public int compareTo(Order o) {
        return this.bookCode.compareTo(getOrderCode());
    }


}
