package top.management.library.entity.role;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import top.management.library.entity.user.User;
import top.management.library.entity.base.AbstractEntity;
import top.management.library.entity.menu.Menu;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "role_name",nullable = false)
    @NotNull
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_rel_menu",joinColumns = {@JoinColumn(name = "role_id")},inverseJoinColumns = {@JoinColumn(name = "menu_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<Menu> menuList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_rel_role",joinColumns = {@JoinColumn(name = "role_id")},inverseJoinColumns = {@JoinColumn(name = "user_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<User> userList = new ArrayList<>();

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString(){
        return "Role{"+"id="+id+",roleName="+roleName+"}";
    }
}
