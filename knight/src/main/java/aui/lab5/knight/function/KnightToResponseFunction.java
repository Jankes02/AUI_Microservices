package aui.lab5.knight.function;

import org.springframework.stereotype.Component;
import aui.lab5.knight.dto.GetKnightResponse;
import aui.lab5.knight.entity.Knight;

import java.util.function.Function;

/**
 * Converts {@link Knight} to {@link GetKnightResponse}.
 */
@Component
public class KnightToResponseFunction implements Function<Knight, GetKnightResponse> {

    @Override
    public GetKnightResponse apply(Knight entity) {
        return GetKnightResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .strength(entity.getStrength())
                .health(entity.getHealth())
                .order(GetKnightResponse.Order.builder()
                        .id(entity.getOrder().getId())
                        .build())
                .build();
    }

}
