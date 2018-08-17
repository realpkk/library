package top.management.library.controller.workflow;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.management.library.common.utils.CodeGenerateUtil;
import top.management.library.common.utils.MapConvertUtil;
import top.management.library.entity.order.Order;
import top.management.library.entity.user.User;
import top.management.library.entity.workflow.AdminMessage;
import top.management.library.entity.workflow.AfterSale;
import top.management.library.service.order.OrderService;
import top.management.library.service.user.UserService;
import top.management.library.service.workflow.AterSaleService;
import top.management.library.service.workflow.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/afterSale")
public class AfterSaleController {

    @Autowired
    private AterSaleService aterSaleService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    private final Integer DEFAULT_APPROVE_STATUS = 1;

    private final Pageable DEFAULT_PAGEABLE = new PageRequest(0,10);

    @RequestMapping("")
    public String showApplications(Model model){

        String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findUserByLoginName(currentUser);
        Page page;
        if (user.isAdmin()){
            page = aterSaleService.getAllApplications(DEFAULT_PAGEABLE);
        }else {
            page = aterSaleService.getApplicationsByLauncher(currentUser,DEFAULT_PAGEABLE);
        }
        model.addAttribute("page",page);
        return "aftersale";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String createApplication(@RequestBody AfterSale afterSale){

        String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
        Order order = orderService.findOrderByOrderCode(afterSale.getOrderCode());
        afterSale.setApplicationLauncher(currentUser);
        afterSale.setApprovalStatus(DEFAULT_APPROVE_STATUS);
        afterSale.setApplicationCode(CodeGenerateUtil.refundCodeGenerate(currentUser,afterSale.getType()));
        afterSale.setBookCode(order.getBookCode());
        afterSale.setBookName(order.getBookName());
        aterSaleService.createApplicationRecord(afterSale);
        AdminMessage message = new AdminMessage();
        message.setApplicationCode(afterSale.getApplicationCode());
        message.setType(afterSale.getType());
        message.setMessageStatus(0);
        message.setSender(currentUser);
        messageService.createMessage(message);
        return "申请已提交！ \n流水号："+ afterSale.getApplicationCode();
    }

    @RequestMapping("/search")
    public String getBooks(HttpServletResponse response, HttpServletRequest request, Model model){

        Map<String,String> paramMap = MapConvertUtil.getParameterMap(request);
        model.addAttribute("page",aterSaleService.getPage(paramMap,DEFAULT_PAGEABLE));
        return "aftersale";
    }

    @RequestMapping("/page")
    public String toPage(HttpServletRequest request,HttpServletResponse response,Model model){

        Pageable pageable = new PageRequest
                (Integer.parseInt(request.getParameter("@pageNumber")),Integer.parseInt(request.getParameter("@pageSize")));
        model.addAttribute("page",aterSaleService.getPage(MapConvertUtil.getParameterMap(request),pageable));
        return "aftersale";
    }

    @RequestMapping("/remind")
    @ResponseBody
    public String remindAdmin(@RequestBody AfterSale afterSale){

        afterSale = aterSaleService.getApplicationByAfterSaleCode(afterSale.getApplicationCode());
        AdminMessage message = new AdminMessage();
        message.setApplicationCode(afterSale.getApplicationCode());
        message.setType(3);
        message.setMessageStatus(0);
        message.setSender(afterSale.getApplicationLauncher());
        messageService.createMessage(message);
        return "提醒已发送！";
    }

    @RequestMapping("/cancel")
    @ResponseBody
    public String cancelApplication(@RequestBody AfterSale afterSale){

        aterSaleService.cancelApplication(afterSale.getApplicationCode());
        return "流水号："+afterSale.getApplicationCode()+"\n已取消";
    }

    @RequestMapping("/pass")
    @ResponseBody
    public String passApplication(@RequestBody AfterSale afterSale){

        aterSaleService.passApplication(afterSale.getApplicationCode());
        return "流水号："+afterSale.getApplicationCode()+"\n已通过";
    }

    @RequestMapping("/reject")
    @ResponseBody
    public String rejectApplication(@RequestBody AfterSale afterSale){

        aterSaleService.rejectApplication(afterSale.getApplicationCode(),afterSale.getReply());
        return "流水号："+afterSale.getApplicationCode()+"\n已驳回";
    }




}
