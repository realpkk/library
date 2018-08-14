package top.management.library.common.security;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import top.management.library.entity.menu.Menu;
import top.management.library.entity.user.User;
import top.management.library.service.menu.MenuService;
import top.management.library.service.user.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

public class CustomShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @PostConstruct
    public void initCredentialsMatcher(){

        setCredentialsMatcher(new CustomCredentialsMatcher());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userInfo = (String) principalCollection.getPrimaryPrincipal();
        User currentUser = userService.findUserByLoginName(userInfo);
        List<Menu> menuList = menuService.findMenuTreeFromUser(currentUser);
        for (Menu menu:menuList) {
            if (StringUtils.isNotEmpty(menu.getPermission())) {
                authorizationInfo.addStringPermission(menu.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String loginName = usernamePasswordToken.getUsername();
        User user = userService.findUserByLoginName(loginName);
        if (user !=null){
            if (user.getUserStatus()==0){
                throw new  DisabledAccountException();
            }
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getLoginName(),user.getPassword(),getName());
            return authenticationInfo;
        }else {
            return null;
        }
    }
}
