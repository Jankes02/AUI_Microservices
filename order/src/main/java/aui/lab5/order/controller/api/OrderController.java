package aui.lab5.order.controller.api;

import aui.lab5.order.dto.PutOrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import aui.lab5.order.dto.GetOrderResponse;
import aui.lab5.order.dto.GetOrdersResponse;

import java.util.UUID;

/**
 * Controller for order resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface OrderController {

    /**
     * @return list of orders
     */
    @GetMapping("api/orders")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetOrdersResponse getOrders();

    /**
     * @param id order's id
     * @return single order
     */
    @GetMapping("/api/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetOrderResponse getOrder(
            @PathVariable("id")
            UUID id
    );

    /**
     * Deletes selected order.
     *
     * @param id order's id
     */
    @DeleteMapping("/api/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrder(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/orders/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putOrder(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutOrderRequest request
    );
}