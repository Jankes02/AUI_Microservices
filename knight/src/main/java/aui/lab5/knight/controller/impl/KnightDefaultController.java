package aui.lab5.knight.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import aui.lab5.knight.controller.api.KnightController;
import aui.lab5.knight.dto.GetKnightResponse;
import aui.lab5.knight.dto.GetKnightsResponse;
import aui.lab5.knight.dto.PutKnightRequest;
import aui.lab5.knight.entity.Knight;
import aui.lab5.knight.function.KnightToResponseFunction;
import aui.lab5.knight.function.KnightsToResponseFunction;
import aui.lab5.knight.function.RequestToKnightFunction;
import aui.lab5.knight.service.api.KnightService;

import java.util.List;
import java.util.UUID;

/**
 * Controller for knight resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
public class KnightDefaultController implements KnightController {

    /**
     * Service for managing knights.
     */
    private final KnightService service;

    /**
     * Converts {@link Knight} to {@link GetKnightResponse}.
     */
    private final KnightToResponseFunction knightToResponse;

    /**
     * Coverts {@link List <Knight>} to {@link GetKnightsResponse}.
     */
    private final KnightsToResponseFunction knightsToResponse;

    /**
     * Converts {@link PutKnightRequest} to {@link Knight}.
     */
    private final RequestToKnightFunction requestToKnight;

    /**
     * @param service              service for managing knights
     * @param knightToResponse  converts {@link Knight} to {@link GetKnightResponse}
     * @param knightsToResponse coverts {@link List <Knight>} to {@link GetKnightsResponse}
     * @param requestToKnight   converts {@link PutKnightRequest} to {@link Knight}
     */
    @Autowired
    public KnightDefaultController(
            KnightService service,
            KnightToResponseFunction knightToResponse,
            KnightsToResponseFunction knightsToResponse,
            RequestToKnightFunction requestToKnight
    ) {
        this.service = service;
        this.knightToResponse = knightToResponse;
        this.knightsToResponse = knightsToResponse;
        this.requestToKnight = requestToKnight;
    }

    @Override
    public GetKnightsResponse getKnights() {
        return knightsToResponse.apply(service.findAll());
    }

    @Override
    public GetKnightsResponse getOrderKnights(UUID orderId) {
        return service.findAllByOrder(orderId)
                .map(knightsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetKnightResponse getKnight(UUID id) {
        return service.find(id)
                .map(knightToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putKnight(UUID id, PutKnightRequest request) {
        service.create(requestToKnight.apply(id, request));
    }

    @Override
    public void deleteKnight(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        knight -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}