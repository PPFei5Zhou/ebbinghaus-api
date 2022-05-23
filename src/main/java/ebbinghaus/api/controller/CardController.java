package ebbinghaus.api.controller;

import ebbinghaus.api.model.entity.Card;
import ebbinghaus.api.model.request.card.CardBody;
import ebbinghaus.api.model.response.card.CardResponse;
import ebbinghaus.api.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Card controller.
 *
 * @author Easy
 */
@RestController
@RequestMapping("api/card")
public class CardController {
    @Resource
    private CardService service;

    @PostMapping
    public ResponseEntity<CardResponse> insert(@RequestBody CardBody body) {
        Card card = body.ofCreate();
        CardResponse response = CardResponse.build(service.insert(card));
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<CardResponse> update(@PathVariable String id, @RequestBody CardBody body) {
        Card card = body.ofUpdate(id);
        return ResponseEntity.ok(CardResponse.build(service.update(card)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBatchById(@RequestBody String[] ids) {
        service.deleteBatchById(ids);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CardResponse> findById(@PathVariable String id) {
        Card card = service.findById(id);
        return ResponseEntity.ok(CardResponse.build(card));
    }

    @PostMapping("findAllBy")
    public ResponseEntity<List<CardResponse>> findAllBy(@RequestBody CardBody body) {
        return ResponseEntity.ok(CardResponse.build(service.findAllBy(body.ofSearch())));
    }
}
