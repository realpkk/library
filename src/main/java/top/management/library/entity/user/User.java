package top.management.library.entity.user;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import top.management.library.entity.base.AbstractEntity;
import top.management.library.entity.role.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "username",nullable = false)
    @NotNull
    private String username;

    @Column(name = "password",nullable = false)
    @NotNull
    private String password;

    @Column(name = "login_name",unique = true,nullable = false)
    @NotNull
    private String loginName;

    @Column(name = "user_status",nullable = false)
    @NotNull
    private Integer userStatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_rel_role",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<Role> roleList = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public boolean isAdmin(){

        return id != null && id == 1;
    }

    @Override
    public String toString() {
        return "User{"+"id="+id+",loginName="+loginName+",username="+username+",password="+password+",userStatus="+userStatus+"}";
    }
}
