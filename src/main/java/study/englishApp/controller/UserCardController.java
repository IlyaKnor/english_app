package study.englishApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.UserCard;
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
    public ResponseEntity<?> create(@RequestBody UserCardCreatedDto userCard) {
       userCardService.create(userCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserCardDto>> findAll() {
        List<UserCardDto> userCards = userCardService.findAll();
        return new ResponseEntity<>(userCards, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCardDto> read(@PathVariable(name = "id") long id) {
        UserCardDto userCard = userCardService.read(id);
        return new ResponseEntity<>(userCard, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody UserCardUpdatingDto userCard) {
        userCardService.update(userCard);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
         userCardService.delete(id);

         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/{card_id}")
    public ResponseEntity<?> addCard(@PathVariable(name = "id") long id, @PathVariable(name = "card_id") long cardId){
        userCardService.addCard(id, cardId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
