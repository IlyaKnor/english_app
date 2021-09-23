package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.models.dto.UserCardDto;
import study.englishApp.models.dto.UserCardUpdatingDto;
import study.englishApp.service.UserCardService;

import java.util.List;

@RestController
@RequestMapping(value = "/user_cards")
public class UserCardController {

    private final UserCardService userCardService;

    public UserCardController(UserCardService userCardService) {
        this.userCardService = userCardService;
    }


    @PostMapping()
    public ResponseEntity<UserCardDto> create(@RequestBody UserCardCreatedDto userCard) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userCardService.create(userCard));
    }

    @GetMapping()
    public ResponseEntity<List<UserCardDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userCardService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCardDto> read(@PathVariable(name = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userCardService.read(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserCardDto> update(@PathVariable(name = "id") long id, @RequestBody UserCardUpdatingDto userCard) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userCardService.update(userCard));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        userCardService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/{card_id}")
    public ResponseEntity<UserCardDto> addCard(@PathVariable(name = "id") long id, @PathVariable(name = "card_id") long cardId) {
        userCardService.addCard(id, cardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
