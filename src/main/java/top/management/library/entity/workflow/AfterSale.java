package top.management.library.entity.workflow;

import top.management.library.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aftersale")
public class AfterSale extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "type",nullable = false)
    @NotNull
    private Integer type;// 1 退款 2 退订

    @Column(name = "application_code",nullable = false,unique = true)
    @NotNull
    private String applicationCode;

    @Column(name = "application_launcher",nullable = false)
    @NotNull
    private String applicationLauncher;

    @Column(name = "application_description")
    private String applicationDescription;

    @Column(name = "approval_status",nullable = false)
    @NotNull
    private Integer approvalStatus;//1 审批中 2 已批准 3 已驳回

    @Column(name = "reply")
    private String reply;

    @Column(name = "order_code",nullable = false)
    @NotNull
    private String orderCode;

    @Column(name = "book_code",nullable = false)
    @NotNull
    private String bookCode;

    @Column(name = "book_name",nullable = false)
    @NotNull
    private String bookName;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public String getApplicationLauncher() {
        return applicationLauncher;
    }

    public void setApplicationLauncher(String applicationLauncher) {
        this.applicationLauncher = applicationLauncher;
    }

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
