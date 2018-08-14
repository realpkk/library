package top.management.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import top.management.library.entity.order.Order;
import top.management.library.repository.base.AbstractRepository;

@Repository
public interface OrderRepository extends AbstractRepository<Order,Long> {

    Order findOrderByOrderCode(String orderCode);

    Page findOrderByOrderLoginName(String loginName, Pageable pageable);

    @Modifying
    @Query("update Order o set o.paymentStatus =?2 where o.orderCode =?1")
    int updatePaymentStatus(String orderCode,Integer paymentStatus);

    @Modifying
    @Query("delete from Order o where o.orderCode=?1")
    int deleteOrderByOrderCode(String orderCode);

    @Modifying
    @Query("update Order o set o.orderPeriod=?2 where o.orderCode=?1")
    int updateOrderPeriod(String orderCode, Integer orderPeriod);

    @Modifying
    @Query("delete from Order o where o.paymentStatus = 3")
    int deleteOrderByPaymentStatus();
}
