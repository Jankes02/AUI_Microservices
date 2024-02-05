package aui.lab5.order.controller.impl;

import aui.lab5.order.dto.PutOrderRequest;
import aui.lab5.order.function.RequestToOrderFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import aui.lab5.order.controller.api.OrderController;
import aui.lab5.order.dto.GetOrderResponse;
import aui.lab5.order.dto.GetOrdersResponse;
import aui.lab5.order.entity.Order;
import aui.lab5.order.function.OrderToResponseFunction;
import aui.lab5.order.function.OrdersToResponseFunction;
import aui.lab5.order.service.api.OrderService;

import java.util.List;
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
     * Converts {@link Order} to {@link GetOrderResponse}.
     */
    private final OrderToResponseFunction orderToResponse;

    /**
     * Coverts {@link List <Order>} to {@link GetOrdersResponse}.
     */
    private final OrdersToResponseFunction ordersToResponse;
    private final RequestToOrderFunction requestToOrder;

    /**
     * @param service               service for managing orders
     * @param orderToResponse  converts {@link Order} to {@link GetOrderResponse}
     * @param ordersToResponse coverts {@link List <Order>} to {@link GetOrdersResponse}
     */
    @Autowired
    public OrderDefaultController(
            OrderService service,
            OrderToResponseFunction orderToResponse,
            OrdersToResponseFunction ordersToResponse,
            RequestToOrderFunction requestToOrder
    ) {
        this.service = service;
        this.orderToResponse = orderToResponse;
        this.ordersToResponse = ordersToResponse;
        this.requestToOrder = requestToOrder;
    }

    @Override
    public GetOrdersResponse getOrders() {
        return ordersToResponse.apply(service.findAll());
    }

    @Override
    public GetOrderResponse getOrder(UUID id) {
        return service.find(id)
                .map(orderToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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

    @Override
    public void putOrder(UUID id, PutOrderRequest request) {
        service.create(requestToOrder.apply(id, request));
    }
}
