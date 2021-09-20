package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.Exceptions.NotFoundExceptions;
import study.englishApp.models.Language;
import study.englishApp.models.dto.LanguageDto;
import study.englishApp.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping(value = "/languages")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    public ResponseEntity<LanguageDto> create(@RequestBody LanguageDto language) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(languageService.create(language));
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> readAll() {
        final List<LanguageDto> languages = languageService.findAll();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LanguageDto> read(@PathVariable(name = "id") Long id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(languageService.read(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LanguageDto> update(@PathVariable(name = "id") Long id, @RequestBody LanguageDto language) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(languageService.update(language));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        languageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
