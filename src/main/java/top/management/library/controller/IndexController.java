package top.management.library.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.management.library.entity.menu.Menu;
import top.management.library.entity.user.User;
import top.management.library.service.menu.MenuService;
import top.management.library.service.user.UserService;

import java.util.List;


@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("")
    public String toIndex(){

        return "index";
    }

    @RequestMapping("/test")
    public String test(){

        return "/test/Index";
    }

    @RequestMapping("/navbar")
    public String getNavbar(Model model){

        String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findUserByLoginName(currentUser);
        model.addAttribute("user",user);
        return "/index/navbar";
    }

    @RequestMapping("/sidebar")
    public String getSidebar(Model model){

        String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findUserByLoginName(currentUser);
        List<Menu> menuList = menuService.getCompleteMenuFromUser(user);
        model.addAttribute("menuList",menuList);
        return "/index/sidebar";
    }

}
