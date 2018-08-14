package top.management.library.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.management.library.common.utils.ExpireDateUtil;
import top.management.library.entity.book.Book;
import top.management.library.entity.order.Order;

import top.management.library.repository.BookRepository;
import top.management.library.repository.OrderRepository;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;


    @Transactional(rollbackFor = Exception.class)
    public Order createOrder(Order order) {

        orderRepository.save(order);
        return orderRepository.findOrderByOrderCode(order.getOrderCode());
    }

    public Page getOrdersByLoginName(String loginName, Pageable pageable) {

        return orderRepository.findOrderByOrderLoginName(loginName,pageable);
    }

    public Order findOrderByOrderCode(String orderCode) {

        return orderRepository.findOrderByOrderCode(orderCode);
    }

    public Page<Order> getOrders(Specification<Order> specification, Pageable pageable) {

        return orderRepository.findAll(specification,pageable);
    }

    @Transactional(rollbackFor = Exception.class)
    public void payForOrderByOrderCode(String orderCode) {

        Order order = orderRepository.findOrderByOrderCode(orderCode);
        if (order.getType()==2){
            orderRepository.updatePaymentStatus(orderCode,1);
        }else{
            orderRepository.updatePaymentStatus(orderCode,2);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelOrderByOrderCode(String orderCode) {

        orderRepository.deleteOrderByOrderCode(orderCode);
    }

    @Transactional(rollbackFor = Exception.class)
    public void extendOrderByOrderCode(String orderCode,Integer orderPeriod) {

        Order order = orderRepository.findOrderByOrderCode(orderCode);
        Date newExpireTime = ExpireDateUtil.dateCalculate(order.getExpireTime(),orderPeriod);
        order.setPaymentStatus(0);
        order.setExpireTime(newExpireTime);
        order.setOrderPeriod(orderPeriod);
        orderRepository.save(order);
    }

    @Transactional(rollbackFor = Exception.class)
    public void unsubscribeOrderByOrderCode(String orderCode) {

        orderRepository.updatePaymentStatus(orderCode,3);

    }

    @Transactional(rollbackFor = Exception.class)
    public void refundOrderByOrderCode(String orderCode) {

        orderRepository.updatePaymentStatus(orderCode,3);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelRenewal(String orderCode) {

        Order order = orderRepository.findOrderByOrderCode(orderCode);
        Date originalExpireTime = ExpireDateUtil.getOriginalExpireTime(order.getExpireTime(),order.getOrderPeriod());
        order.setExpireTime(originalExpireTime);
        order.setPaymentStatus(2);
        orderRepository.save(order);
    }

    @Transactional(rollbackFor = Exception.class)
    public void orderClean(){

        orderRepository.deleteOrderByPaymentStatus();
    }

    public boolean inventoryCheck(String bookCode, Integer orderAmount) {

        Book book = bookRepository.findBookByBookCode(bookCode);
        if (orderAmount>book.getBookRemain()){
            return false;
        }else {
            return true;
        }
    }
}
