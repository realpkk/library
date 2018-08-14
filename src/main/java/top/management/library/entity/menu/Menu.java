package top.management.library.entity.menu;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import top.management.library.entity.role.Role;
import top.management.library.entity.base.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends AbstractEntity implements Comparable<Menu>{

    private static final long serialVersionUID = 1L;

    @Column(name = "type")
    private Integer type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id",insertable = false,updatable = false)
    private Menu parent;

    @Column(name = "parent_id")
    private Long parentId;
    
    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_href")
    private String menuHref;

    @Column(name = "menu_icon")
    private String menuIcon;

    @Column(name = "menu_sort")
    private String menuSort;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "psermission")
    private String permission;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_rel_menu",joinColumns = {@JoinColumn(name = "menu_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<Role> roleList = new ArrayList<>();

    @Transient
    private List<Menu> menuList = new ArrayList<>();

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(String menuSort) {
        this.menuSort = menuSort;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int compareTo(Menu o) {
        return this.menuSort.compareTo(o.getMenuSort());
    }

    @Override
    public String toString() {
        return "Menu{"+"id="+id+",permission="+permission+",permissionName"+permissionName+",type="+type
                +",parent="+parent+",parentId="+parentId+",menuName='" +menuName+",menuHref="+menuHref
                +",menuIcon="+menuIcon +",menuSort="+menuSort+"}";
    }
}
