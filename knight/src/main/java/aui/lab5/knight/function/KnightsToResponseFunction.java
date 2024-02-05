package aui.lab5.knight.function;

import org.springframework.stereotype.Component;
import aui.lab5.knight.dto.GetKnightsResponse;
import aui.lab5.knight.entity.Knight;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List<Knight>} to {@link GetKnightsResponse}.
 */
@Component
public class KnightsToResponseFunction implements Function<List<Knight>, GetKnightsResponse> {
    @Override
    public GetKnightsResponse apply(List<Knight> entities) {
        return GetKnightsResponse.builder()
                .knights(entities.stream()
                        .map(knight -> GetKnightsResponse.Knight.builder()
                                .id(knight.getId())
                                .name(knight.getName())
                                .build())
                        .toList())
                .build();
    }
}