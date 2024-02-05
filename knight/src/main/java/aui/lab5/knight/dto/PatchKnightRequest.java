package aui.lab5.knight.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * PATCH knight request. Contains all fields that can be updated by the user. How knight is described is defined
 * in {@link GetKnightsResponse.Knight} class.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchKnightRequest {
    /**
     * Knight's name.
     */
    private String name;

    /**
     * Knight's age.
     */
    private int age;

    /**
     * Knight's health.
     */
    private double health;
}