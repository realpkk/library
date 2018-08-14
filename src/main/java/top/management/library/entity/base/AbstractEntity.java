package top.management.library.entity.base;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity extends IDEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createTime;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date updateTime;

    public AbstractEntity(){}

    @PrePersist
    public void preCreate(){
        Date currentTime = new Date();
        this.createTime = currentTime;
    }

    @PreUpdate
    public void preUpdate(){
        Date currentTime = new Date();
        if (this.createTime == null){
            this.createTime = currentTime;
        }
        this.updateTime = currentTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
