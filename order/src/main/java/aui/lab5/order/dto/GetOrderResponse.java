package aui.lab5.order.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import aui.lab5.order.entity.Order;

import java.util.UUID;

/**
 * GET order response. Described details about selected order. Can be used to present description while
 * character creation or on character's stat page. How order is described is defined in
 * {@link Order}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetOrderResponse {
    /**
     * Unique id identifying order.
     */
    private UUID id;

    /**
     * Name of the order.
     */
    private String name;
}