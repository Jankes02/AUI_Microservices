package aui.lab5.knight.function;

import aui.lab5.knight.dto.PatchKnightRequest;
import aui.lab5.knight.entity.Knight;

import java.util.function.BiFunction;

/**
 * Returns new instance of {@link Knight} based on provided value and updated with values from
 * {@link PatchKnightRequest}.
 */
public class UpdateKnightWithRequestFunction implements BiFunction<Knight, PatchKnightRequest, Knight> {

    @Override
    public Knight apply(Knight entity, PatchKnightRequest request) {
        return Knight.builder()
                .id(entity.getId())
                .name(request.getName())
                .age(request.getAge())
                .strength(entity.getStrength())
                .health(entity.getHealth())
                .order(entity.getOrder())
                .build();
    }
}