package top.management.library.entity.workflow;

import top.management.library.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "refund")
public class Refund extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "refund_code",nullable = false,unique = true)
    @NotNull
    private String refundCode;

    @Column(name = "refund_launcher",nullable = false)
    @NotNull
    private String refundLauncher;

    @Column(name = "refund_description")
    private String refundDescription;

    @Column(name = "approval_status",nullable = false)
    @NotNull
    private Integer approvalStatus;//1 审批中 2 已批准 3 已驳回

    @Column(name = "reply")
    private String reply;

    @Column(name = "refund_order_code",nullable = false)
    @NotNull
    private String refundOrderCode;

    @Column(name = "refund_book_code",nullable = false)
    @NotNull
    private String refundBookCode;

    @Column(name = "refund_book_name",nullable = false)
    @NotNull
    private String RefundBookName;

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public String getRefundLauncher() {
        return refundLauncher;
    }

    public void setRefundLauncher(String refundLauncher) {
        this.refundLauncher = refundLauncher;
    }

    public String getRefundDescription() {
        return refundDescription;
    }

    public void setRefundDescription(String refundDescription) {
        this.refundDescription = refundDescription;
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

    public String getRefundOrderCode() {
        return refundOrderCode;
    }

    public void setRefundOrderCode(String refundOrderCode) {
        this.refundOrderCode = refundOrderCode;
    }

    public String getRefundBookCode() {
        return refundBookCode;
    }

    public void setRefundBookCode(String refundBookCode) {
        this.refundBookCode = refundBookCode;
    }

    public String getRefundBookName() {
        return RefundBookName;
    }

    public void setRefundBookName(String refundBookName) {
        RefundBookName = refundBookName;
    }
}
