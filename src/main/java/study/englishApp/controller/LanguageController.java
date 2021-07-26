package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.Language;
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
    public ResponseEntity<?> create(@RequestBody Language language) {
        languageService.create(language);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Language>> readAll(){
        final List<Language> languages = languageService.findAll();

        return languages != null && !languages.isEmpty()
                ? new ResponseEntity<>(languages, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Language> read(@PathVariable(name = "id") Long id) {
    final Language language = languageService.read(id);

    return language != null
            ? new ResponseEntity<>(language, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Language language) {
       languageService.update(language);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") Long id){
        languageService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
