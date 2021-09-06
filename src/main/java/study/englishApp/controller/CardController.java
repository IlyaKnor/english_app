package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.Card;
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
    public ResponseEntity<?> create(@RequestBody CardCreationDto card) {
        cardService.create(card);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CardDto> read(@PathVariable(name = "id") long id) {
        final CardDto card = cardService.read(id);

        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        cardService.delete(id);

        return  new ResponseEntity<>(HttpStatus.OK);
    }

}