package top.management.library.common.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.management.library.service.order.OrderService;

import java.util.Date;

@Component
public class ScheduledTask {

    @Autowired
    private OrderService orderService;

    @Scheduled
    public void test(){

        orderService.orderClean();
    }
}
