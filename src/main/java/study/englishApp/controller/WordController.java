package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.dto.WordCreationDto;
import study.englishApp.models.dto.WordDto;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.dto.WordWithoutLanguageDto;
import study.englishApp.service.WordService;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping()
    public ResponseEntity<WordDto> create(@RequestBody WordCreationDto word) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(wordService.create(word));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<WordDto> read(@PathVariable(name = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(wordService.read(id));
    }

    @GetMapping(value = "/{language}/language")
    public ResponseEntity<List<WordWithoutLanguageDto>> findAllByLanguage(@PathVariable(name = "language") String language) {
        return ResponseEntity.ok(wordService.findAllByLang(language));
    }

    @PutMapping()
    public ResponseEntity<WordDto> update(@RequestBody WordUpdatingDto word) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(wordService.update(word));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        wordService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
