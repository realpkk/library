package top.management.library.controller.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.management.library.common.utils.MD5Util;
import top.management.library.entity.menu.Menu;
import top.management.library.entity.user.User;
import top.management.library.service.menu.MenuService;
import top.management.library.service.user.UserService;

import java.util.List;

@Controller
public class LoginConrtroller {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/homepage")
    public String toHomepage(){
        return "homepage";
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    public String toLogin(@RequestParam(required = true,value = "loginName")String loginName,
                          @RequestParam(required = true,value = "password")String password, Model model){

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName,password);
        try {
            currentUser.login(usernamePasswordToken);
        } catch (DisabledAccountException e){
            model.addAttribute("message","用户已被禁用");
            return "login";
        } catch (AuthenticationException e){
            model.addAttribute("message","用户名或密码错误");
            return "login";
        }
        return "homepage";
    }

    @RequestMapping(value = "/register")
    public String register(@RequestParam(required = true,value = "loginName")String loginName,
                         @RequestParam(required = true,value = "username")String username,
                         @RequestParam(required = true,value = "password")String password,Model model){

        if (userService.duplicateCheck(loginName)){
            model.addAttribute("registerMessage","登录ID已被使用");
            return "register";
        }else {
            User registerUser = new User();
            registerUser.setLoginName(loginName);
            registerUser.setUsername(username);
            registerUser.setPassword(MD5Util.encode(password));
            registerUser.setUserStatus(1);

            userService.createUser(registerUser);
            return "login";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister(){

        return "register";
    }

    @RequestMapping("/logout")
    public String logout(){

        SecurityUtils .getSubject().logout();
        return "login";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestBody User registerUser){

        registerUser.setPassword(MD5Util.encode(registerUser.getPassword()));
        registerUser.setUserStatus(1);
        userService.createUser(registerUser);
        return "test";
    }


}
