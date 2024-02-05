package aui.lab5.order.event.repository.api;

import java.util.UUID;

/**
 * Repository for sending events about orders.
 */
public interface OrderEventRepository {

    /**
     * Delete order.
     *
     * @param id order's id
     */
    void delete(UUID id);
}