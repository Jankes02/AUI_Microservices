package aui.lab5.order.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import aui.lab5.knight.entity.Knight;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Entity class for game knights' orders (classes). Describes name of the order.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    /**
     * Unique id (primary key).
     */
    @Id
    private UUID id;

    /**
     * List of order knights. By default, list of knights is not loaded from the database.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Knight> knights;
}