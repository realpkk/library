package top.management.library.entity.workflow;

import top.management.library.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adminMassage")
public class AdminMessage extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "sender",nullable = false)
    @NotNull
    private String sender;

    @Column(name = "type",nullable = false)
    @NotNull
    private Integer type; //1 退款 2 退订 3 申请提醒

    @Column(name = "message_status",nullable = false)
    @NotNull
    private Integer messageStatus; //0 未读  1 已读

    @Column(name = "application_code",nullable = false)
    @NotNull
    private String applicationCode;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }
}
