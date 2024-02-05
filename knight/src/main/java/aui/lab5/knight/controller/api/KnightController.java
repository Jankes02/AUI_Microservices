package aui.lab5.knight.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import aui.lab5.knight.dto.GetKnightResponse;
import aui.lab5.knight.dto.GetKnightsResponse;
import aui.lab5.knight.dto.PutKnightRequest;

import java.util.UUID;

/**
 * Controller for knight resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface KnightController {

    /**
     * @return list of knights
     */
    @GetMapping("api/knights")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetKnightsResponse getKnights();

    /**
     * @param orderId knights' order
     * @return list of knights
     */
    @GetMapping("/api/orders/{orderId}/knights")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetKnightsResponse getOrderKnights(
            @PathVariable("orderId")
            UUID orderId
    );

    /**
     * @param id knight's id
     * @return single knight
     */
    @GetMapping("/api/knights/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetKnightResponse getKnight(
            @PathVariable("id")
            UUID id
    );

    /**
     * @param id      knight's id
     * @param request new knight
     */
    @PutMapping("/api/knights/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putKnight(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutKnightRequest request
    );

    /**
     * Deletes selected knight.
     *
     * @param id knight's id
     */
    @DeleteMapping("/api/knights/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteKnight(
            @PathVariable("id")
            UUID id
    );

}
