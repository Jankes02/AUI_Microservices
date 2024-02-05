package aui.lab5.order.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import aui.lab5.order.controller.api.OrderController;
import aui.lab5.order.service.api.OrderService;

import java.util.UUID;

/**
 * Controller for order resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class OrderDefaultController implements OrderController {

    /**
     * Service for managing orders.
     */
    private final OrderService service;


    /**
     * @param service service for managing orders
     */
    @Autowired
    public OrderDefaultController(OrderService service) {
        this.service = service;
    }

    @Override
    public void deleteOrder(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        order -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}