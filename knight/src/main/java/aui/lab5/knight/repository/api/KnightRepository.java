package aui.lab5.knight.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aui.lab5.knight.entity.Knight;
import aui.lab5.order.entity.Order;

import java.util.List;
import java.util.UUID;

/**
 * Repository for knight entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface KnightRepository extends JpaRepository<Knight, UUID> {
    List<Knight> findAllByOrder(Order order);
}