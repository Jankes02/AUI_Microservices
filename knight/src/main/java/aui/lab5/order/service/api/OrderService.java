package aui.lab5.order.service.api;

import aui.lab5.order.entity.Order;

import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding knight's order entity.
 */
public interface OrderService {


    /**
     * @param id id of the order
     * @return container with order entity
     */
    Optional<Order> find(UUID id);

    /**
     * Stores new order in the data store.
     *
     * @param order new order to be saved
     */
    void create(Order order);

    /**
     * Deletes existing order.
     *
     * @param id existing order's id to be deleted
     */
    void delete(UUID id);

}
