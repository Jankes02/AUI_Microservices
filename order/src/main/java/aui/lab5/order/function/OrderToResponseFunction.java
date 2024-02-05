package aui.lab5.order.function;

import org.springframework.stereotype.Component;
import aui.lab5.order.dto.GetOrderResponse;
import aui.lab5.order.entity.Order;

import java.util.function.Function;

/**
 * Converts {@link Order} to {@link GetOrderResponse}.
 */
@Component
public class OrderToResponseFunction implements Function<Order, GetOrderResponse> {
    @Override
    public GetOrderResponse apply(Order entity) {
        return GetOrderResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}