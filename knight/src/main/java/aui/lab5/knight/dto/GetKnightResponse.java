package aui.lab5.knight.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * GET knight response. It contains all field that can be presented (but not necessarily changed) to the used. How
 * knight is described is defined in {@link GetKnightsResponse.Knight} class.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetKnightResponse {
    /**
     * Represents single order.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Order {
        /**
         * Unique id identifying order.
         */
        private UUID id;

        /**
         * Name of the order.
         */
        private String name;
    }

    /**
     * Unique id identifying knight.
     */
    private UUID id;

    /**
     * Name of the knight.
     */
    private String name;

    /**
     * Knight's age.
     */
    private int age;

    /**
     * Knight's strength.
     */
    private int strength;

    /**
     * Knight's health.
     */
    private double health;

    /**
     * Knight's order.
     */
    private Order order;
}