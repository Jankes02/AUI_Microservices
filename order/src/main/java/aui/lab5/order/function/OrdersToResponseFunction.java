package aui.lab5.order.function;

import org.springframework.stereotype.Component;
import aui.lab5.order.dto.GetOrdersResponse;
import aui.lab5.order.entity.Order;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List<Order>} to {@link GetOrdersResponse}.
 */
@Component
public class OrdersToResponseFunction implements Function<List<Order>, GetOrdersResponse> {
    @Override
    public GetOrdersResponse apply(List<Order> entities) {
        return GetOrdersResponse.builder()
                .orders(entities.stream()
                        .map(order -> GetOrdersResponse.Order.builder()
                                .id(order.getId())
                                .name(order.getName())
                                .build())
                        .toList())
                .build();
    }
}