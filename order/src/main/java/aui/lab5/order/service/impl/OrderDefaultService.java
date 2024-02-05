package aui.lab5.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aui.lab5.order.entity.Order;
import aui.lab5.order.event.repository.api.OrderEventRepository;
import aui.lab5.order.repository.api.OrderRepository;
import aui.lab5.order.service.api.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding character's order entity.
 */
@Service
public class OrderDefaultService implements OrderService {
    /**
     * Repository for order entity.
     */
    private final OrderRepository repository;

    /**
     * Repository for sending events about orders management.
     */
    private final OrderEventRepository eventRepository;

    /**
     * @param repository      repository for order entity
     * @param eventRepository repository for sending events about orders management
     */
    @Autowired
    public OrderDefaultService(OrderRepository repository, OrderEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    /**
     * @param id id of the order
     * @return container with order entity
     */
    @Override
    public Optional<Order> find(UUID id) {
        return repository.findById(id);
    }

    /**
     * Stores new order in the data store.
     *
     * @param order new order to be saved
     */
    @Override
    public void create(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}