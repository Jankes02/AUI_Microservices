package aui.lab5.knight.service.api;

import aui.lab5.knight.entity.Knight;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding knight entity.
 */

public interface KnightService {

    /**
     * Finds single knight.
     *
     * @param id knight's id
     * @return container with knight
     */
    Optional<Knight> find(UUID id);

    /**
     * @return all available knights
     */
    List<Knight> findAll();

    /**
     * Creates new knight.
     *
     * @param knight new knight
     */
    void create(Knight knight);

    /**
     * Updates existing knight.
     *
     * @param knight knight to be updated
     */
    void update(Knight knight);

    /**
     * Deletes existing knight.
     *
     * @param id existing knight's id to be deleted
     */
    void delete(UUID id);

    /**
     * @param orderId order id
     * @return list of knights if order exists
     */
    Optional<List<Knight>> findAllByOrder(UUID orderId);
}