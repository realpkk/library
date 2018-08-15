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
import top.management.library.entity.order.Order;
import top.management.library.entity.user.User;
import top.management.library.entity.workflow.Refund;
import top.management.library.service.order.OrderService;
import top.management.library.service.user.UserService;
import top.management.library.service.workflow.RefundService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/refund")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    private final Integer DEFAULT_APPROVE_STATUS = 1;

    private final Pageable DEFAULT_PAGEABLE = new PageRequest(0,10);

    @RequestMapping("")
    public String showRefunds(Model model){

        String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findUserByLoginName(currentUser);
        Page page;
        if (user.isAdmin()){
            page = refundService.getAllRefunds(DEFAULT_PAGEABLE);
        }else {
            page = refundService.getRefundsByLauncher(currentUser,DEFAULT_PAGEABLE);
        }
        model.addAttribute("page",page);
        return "refund";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String refund(@RequestBody Refund refund){

        String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
        Order order = orderService.findOrderByOrderCode(refund.getRefundOrderCode());
        refund.setRefundLauncher(currentUser);
        refund.setApprovalStatus(DEFAULT_APPROVE_STATUS);
        refund.setRefundCode(CodeGenerateUtil.refundCodeGenerate(currentUser));
        refund.setRefundBookCode(order.getBookCode());
        refund.setRefundBookName(order.getBookName());
        refundService.createRefundRecord(refund);
        return "退款申请已提交 \n流水号："+refund.getRefundCode();
    }
}
