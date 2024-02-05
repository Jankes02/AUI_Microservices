package aui.lab5.order.initialize;

import aui.lab5.order.entity.Order;
import aui.lab5.order.service.api.OrderService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */

@Component
public class InitializeData implements InitializingBean {
    /**
     * Service for professions operations.
     */
    private final OrderService orderService;

    @Autowired
    public InitializeData(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void afterPropertiesSet() {
        if (orderService.findAll().isEmpty()) {
            Order orderOfThePhoenix = Order.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Order of the Phoenix")
                    .build();
            Order orderOfGermany = Order.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Order of Germany")
                    .build();

            orderService.create(orderOfThePhoenix);
            orderService.create(orderOfGermany);
        }
    }
}