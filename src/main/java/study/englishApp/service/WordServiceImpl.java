package study.englishApp.service;

import org.springframework.stereotype.Service;
import study.englishApp.models.Language;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.dto.WordWithoutLanguageDto;
import study.englishApp.repository.WordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService{

    private final WordRepository wordRepository;
    private final LanguageService languageService;

    public WordServiceImpl(WordRepository wordRepository, LanguageService languageService) {
        this.wordRepository = wordRepository;
        this.languageService = languageService;
    }

    @Override
    public Word create(WordCreationDto word) {
        if (!wordRepository.existsByWordAndLang_Id(word.getWord(), word.getLangId())){
            Language language = languageService.read(word.getLangId());
            Word created = new Word(word.getWord(), language);
            return wordRepository.save(created);
        }
        throw new RuntimeException("Слово на таком языке уже существует.");
    }

    @Override
    public Word read(Long id) {
        return wordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Слово не найдено по id: "+ id));
    }


    @Override
    public Word update(WordUpdatingDto word) {
        Word found = read(word.getId());
        Language language = languageService.read(word.getLangId());
        found.setLang(language);
        found.setWord(word.getWord());
        return wordRepository.save(found);
    }

    @Override
    public void delete(Long id) {
        if (wordRepository.existsById(id)) {
            wordRepository.deleteById(id);
        }
    }

    @Override
    public List<WordWithoutLanguageDto> findAllByLang(String language) {
        List<WordWithoutLanguageDto> wordsDto = new ArrayList<>();
        for (Word word : wordRepository.findWordsByLanguage(language)) {
            WordWithoutLanguageDto wordDto = new WordWithoutLanguageDto(word.getId(), word.getWord());
            wordsDto.add(wordDto);
        }
        return wordsDto;
    }
}
