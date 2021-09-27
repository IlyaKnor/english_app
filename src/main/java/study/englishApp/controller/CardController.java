package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.dto.CardCreationDto;
import study.englishApp.models.dto.CardDto;
import study.englishApp.service.CardService;


@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping()
    public ResponseEntity<CardDto> create(@RequestBody CardCreationDto card) {
        cardService.create(card);
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardService.create(card));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CardDto> read(@PathVariable(name = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardService.read(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        cardService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}