package study.englishApp.service;

import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.dto.WordWithoutLanguageDto;

import java.util.List;

public interface WordService {

    Word create(WordCreationDto word);

    Word read(Long id);

    Word update(WordUpdatingDto word);

    void delete(Long id);

    List<WordWithoutLanguageDto> findAllByLang(String language);
}
