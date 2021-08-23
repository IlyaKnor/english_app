package study.englishApp.service;

import study.englishApp.models.dto.WordCreationDto;
import study.englishApp.models.dto.WordDto;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.dto.WordWithoutLanguageDto;

import java.util.List;

public interface WordService {

    WordDto create(WordCreationDto word);

    WordDto read(Long id);

    WordDto update(WordUpdatingDto word);

    void delete(Long id);

    List<WordWithoutLanguageDto> findAllByLang(String language);
}
