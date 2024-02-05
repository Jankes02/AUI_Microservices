package aui.lab5.knight.entity;

import jakarta.persistence.*;
import lombok.*;
import aui.lab5.order.entity.Order;

import java.io.Serializable;
import java.util.UUID;

/**
 * Entity for game knight owned by the user. Represents knights basic stats as well as
 * order.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "knights")
public class Knight implements Serializable {
    /**
     * Unique id (primary key).
     */
    @Id
    private UUID id;

    /**
     * Knight's name.
     */
    private String name;

    /**
     * Knight's strength.
     */
    private int strength;

    /**
     * Knight's health.
     */
    private double health;

    /**
     * Knight's age.
     */
    private int age;

    /**
     * Knight's order (class).
     */
    @ManyToOne
    @JoinColumn(name = "\"order\"")
    private Order order;
}