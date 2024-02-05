package aui.lab5.knight.function;

import org.springframework.stereotype.Component;
import aui.lab5.knight.dto.PutKnightRequest;
import aui.lab5.knight.entity.Knight;
import aui.lab5.order.entity.Order;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link PutKnightRequest} to {@link Knight}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
@Component
public class RequestToKnightFunction implements BiFunction<UUID, PutKnightRequest, Knight> {

    @Override
    public Knight apply(UUID id, PutKnightRequest request) {
        return Knight.builder()
                .id(id)
                .name(request.getName())
                .age(request.getAge())
                .strength(request.getStrength())
                .health(request.getHealth())
                .order(Order.builder()
                        .id(request.getOrder())
                        .build())
                .build();
    }
}