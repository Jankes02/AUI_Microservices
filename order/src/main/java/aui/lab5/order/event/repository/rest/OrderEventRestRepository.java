package aui.lab5.order.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import aui.lab5.order.event.repository.api.OrderEventRepository;

import java.util.UUID;

@Repository
public class OrderEventRestRepository implements OrderEventRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public OrderEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/orders/{id}", id);
    }

}
