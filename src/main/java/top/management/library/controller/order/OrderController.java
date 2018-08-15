package top.management.library.controller.order;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.management.library.common.utils.ExpireDateUtil;
import top.management.library.common.utils.MapConvertUtil;
import top.management.library.common.utils.CodeGenerateUtil;
import top.management.library.entity.order.Order;
import top.management.library.entity.user.User;
import top.management.library.service.book.BookService;
import top.management.library.service.order.OrderService;
import top.management.library.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final Pageable DEFAULT_PAGEABLE = new PageRequest(0,10);

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String showOrders(Model model){

        String currentUserLoginName = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findUserByLoginName(currentUserLoginName);
        Page page;
        if (user.isAdmin()){
            page = orderService.getAllOrders(DEFAULT_PAGEABLE);
        }else {
            page = orderService.getOrdersByLoginName(currentUserLoginName,DEFAULT_PAGEABLE);
        }
        model.addAttribute("page",page);
        return "order";
    }

    @RequestMapping("/check")
    public String toOrderCheck(@RequestParam String orderCode,Model model){

        Order order = orderService.findOrderByOrderCode(orderCode);
        model.addAttribute("order",order);
        return "ordercheck";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Order saveOrder(@RequestBody Order order){

        String currentUserLoginName = (String) SecurityUtils.getSubject().getPrincipal();
        order.setOrderLoginName(currentUserLoginName);
        order.setOrderCode(CodeGenerateUtil.orderCodeGenerate(order.getBookCode(),order.getType(),currentUserLoginName));
        order.setOrderUsername(userService.getUsernameByUserLoginName(currentUserLoginName));
        order.setBookName(bookService.getBookNameByBookCode(order.getBookCode()));
        order.setPaymentStatus(0);
        if (order.getType()==1){
            order.setExpireTime(ExpireDateUtil.dateCalculate(new Date(),order.getOrderPeriod()));
        }
        Order savedOrder = orderService.createOrder(order);
        return savedOrder;
    }

    @RequestMapping("/search")
    public String getBooks(HttpServletResponse response, HttpServletRequest request, Model model){

        Map<String,String> paramMap = MapConvertUtil.getParameterMap(request);
        model.addAttribute("page",orderService.getPage(paramMap,DEFAULT_PAGEABLE));
        return "order";
    }

    @RequestMapping("/page")
    public String toPage(HttpServletRequest request,HttpServletResponse response,Model model){

        Pageable pageable = new PageRequest
                (Integer.parseInt(request.getParameter("@pageNumber")),Integer.parseInt(request.getParameter("@pageSize")));
        model.addAttribute("page",orderService.getPage(MapConvertUtil.getParameterMap(request),pageable));
        return "order";
    }

    @RequestMapping("/pay")
    @ResponseBody
    public String payOrder(@RequestBody Order order){

        if (orderService.inventoryCheck(order.getBookCode(),order.getOrderAmount())){
            orderService.payForOrderByOrderCode(order.getOrderCode());
            bookService.bookRemainUpdateByBookCode(order.getBookCode(),order.getOrderAmount());
            return "订单:\n"+order.getOrderCode()+"\n支付成功!";
        }else {
            orderService.cancelOrderByOrderCode(order.getOrderCode());
            return "库存不足!\n订单:\n"+order.getOrderCode()+"\n已取消!";
        }

    }

    @RequestMapping("/cancel")
    @ResponseBody
    public String cancelOrder(@RequestBody Order order){

        orderService.cancelOrderByOrderCode(order.getOrderCode());
        return "订单:\n"+order.getOrderCode()+"\n已取消!";
    }

    @RequestMapping("/extend")
    @ResponseBody
    public Order extendOrder(@RequestBody Order order){

        orderService.extendOrderByOrderCode(order.getOrderCode(),order.getOrderPeriod());
        Order newOrder = orderService.findOrderByOrderCode(order.getOrderCode());
        return newOrder;
    }

    @RequestMapping("/renewalCancel")
    @ResponseBody
    public String extendOrderCancel(@RequestBody Order order){

        orderService.cancelRenewal(order.getOrderCode());
        return "订单:\n"+order.getOrderCode()+"\n已取消!";
    }

    @RequestMapping("/unsubscribe")
    @ResponseBody
    public String unsubscribeOrder(@RequestBody Order order){

        orderService.unsubscribeOrderByOrderCode(order.getOrderCode());
        return "订单:\n"+order.getOrderCode()+"\n已退订!";
    }
}
