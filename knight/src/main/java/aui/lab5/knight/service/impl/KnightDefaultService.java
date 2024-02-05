package aui.lab5.knight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aui.lab5.knight.entity.Knight;
import aui.lab5.knight.repository.api.KnightRepository;
import aui.lab5.knight.service.api.KnightService;
import aui.lab5.order.repository.api.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding knight entity.
 */
@Service
public class KnightDefaultService implements KnightService {

    /**
     * Repository for knight entity.
     */
    private final KnightRepository repository;

    /**
     * Repository for order entity.
     */
    private final OrderRepository orderRepository;

    /**
     * @param repository      repository for knight entity
     * @param orderRepository repository for order entity
     */
    @Autowired
    public KnightDefaultService(
            KnightRepository repository,
            OrderRepository orderRepository
    ) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Knight> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Knight> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Knight>> findAllByOrder(UUID orderId) {
        return orderRepository.findById(orderId)
                .map(repository::findAllByOrder);
    }

    @Override
    public void create(Knight knight) {
        repository.save(knight);
    }

    @Override
    public void update(Knight knight) {
        repository.save(knight);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}