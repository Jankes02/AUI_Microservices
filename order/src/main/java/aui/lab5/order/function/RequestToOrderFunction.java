package aui.lab5.order.function;

import aui.lab5.order.dto.PutOrderRequest;
import aui.lab5.order.entity.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToOrderFunction implements BiFunction<UUID, PutOrderRequest, Order> {

    @Override
    public Order apply(UUID id, PutOrderRequest request) {
        return Order.builder()
                .id(id)
                .name(request.getName())
                .build();
    }
}