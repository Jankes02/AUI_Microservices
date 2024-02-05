package aui.lab5.knight.initialize;

import aui.lab5.knight.entity.Knight;
import aui.lab5.order.entity.Order;
import aui.lab5.knight.service.api.KnightService;
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
    private final KnightService knightService;
    private final OrderService orderService;

    @Autowired
    public InitializeData(KnightService knightService, OrderService orderService) {
        this.knightService = knightService;
        this.orderService = orderService;
    }

    @Override
    public void afterPropertiesSet() {
        if (knightService.findAll().isEmpty()) {
            Order orderOfThePhoenix = Order.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .build();
            Order orderOfGermany = Order.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .build();

            orderService.create(orderOfThePhoenix);
            orderService.create(orderOfGermany);

            knightService.create(Knight.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                    .name("Sir Camelot").age(70).strength(550).health(1).order(orderOfThePhoenix).build());
            knightService.create(Knight.builder()
                    .id(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
                    .name("Sir Lancelot").age(71).strength(560).health(1).order(orderOfThePhoenix).build());
            knightService.create(Knight.builder()
                    .id(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
                    .name("Sir Leonard").age(18).strength(100).health(1).order(orderOfThePhoenix).build());
            knightService.create(Knight.builder()
                    .id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16895d1e1"))
                    .name("Sir Adam").age(21).strength(95).health(0.9).order(orderOfThePhoenix).build());
            knightService.create(Knight.builder()
                    .id(UUID.randomUUID())
                    .name("Sir Charles").age(32).strength(110).health(0.75).order(orderOfThePhoenix).build());
            knightService.create(Knight.builder()
                    .id(UUID.randomUUID())
                    .name("Sir David").age(54).strength(120).health(1).order(orderOfThePhoenix).build());

            knightService.create(Knight.builder()
                    .id(UUID.randomUUID())
                    .name("Hans von Hohenzollern").age(70).strength(540).health(1).order(orderOfGermany).build());
            knightService.create(Knight.builder()
                    .id(UUID.randomUUID())
                    .name("Heinrich von Potsdam").age(81).strength(520).health(0.8).order(orderOfGermany).build());
            knightService.create(Knight.builder()
                    .id(UUID.randomUUID())
                    .name("Arnold von Rhein").age(34).strength(220).health(1).order(orderOfGermany).build());
        }
    }
}