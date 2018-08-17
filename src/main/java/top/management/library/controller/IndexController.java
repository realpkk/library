package top.management.library.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.management.library.entity.menu.Menu;
import top.management.library.entity.user.User;
import top.management.library.entity.workflow.AdminMessage;
import top.management.library.service.menu.MenuService;
import top.management.library.service.user.UserService;
import top.management.library.service.workflow.MessageService;

import java.util.List;


@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MessageService messageService;

    private final Integer DEFAULT_PAGE = 0;
    private final Integer DEFAULT_PAGE_SIZE = 5;

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
        if (user.isAdmin()){
            Pageable pageable = new PageRequest(DEFAULT_PAGE,DEFAULT_PAGE_SIZE);
            Page<AdminMessage> page =  messageService.findUnReadedMessages(pageable);
            model.addAttribute("message",page);
            Integer count = messageService.countUnReadedMessages();
            model.addAttribute("count",count);
        }
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
