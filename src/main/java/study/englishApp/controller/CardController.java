package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.Card;
import study.englishApp.models.dto.CardCreationDto;
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
    public ResponseEntity<Card> read(@PathVariable(name = "id") long id) {
        final Card card = cardService.read(id);

        return card != null
                ? new ResponseEntity<>(card, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        cardService.delete(id);

        return  new ResponseEntity<>(HttpStatus.OK);
    }

}