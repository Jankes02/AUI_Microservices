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
 * PUT knight request. Contains only fields that can be set up byt the user while creating a new knight.How
 * knight is described is defined in {@link GetKnightsResponse.Knight} class.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutKnightRequest {
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
     * Knight's current health.
     */
    private double health;

    /**
     * Identifier of the knight's order.
     */
    private UUID order;
}