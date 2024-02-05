package aui.lab5.order.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Controller for order resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface OrderController {
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
}