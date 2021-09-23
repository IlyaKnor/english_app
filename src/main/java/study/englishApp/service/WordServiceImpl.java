package study.englishApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.englishApp.Exceptions.ConflictException;
import study.englishApp.Exceptions.NotFoundExceptions;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;
import study.englishApp.models.dto.WordDto;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.dto.WordWithoutLanguageDto;
import study.englishApp.models.mapper.WordMapper;
import study.englishApp.models.mapper.context.WordMappingContext;
import study.englishApp.repository.LanguageRepository;
import study.englishApp.repository.WordRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {

    private final WordMappingContext wordMappingContext;
    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;


    @Override
    public WordDto create(WordCreationDto word) {
        if (!wordRepository.existsByWordAndLang_Id(word.getWord(), word.getLangId())) {
            Word created = wordRepository.save(WordMapper.INSTANCE.toEntity(word, wordMappingContext));
            return WordMapper.INSTANCE.toDto(created);
        }
        else {
            throw new ConflictException("Слово на таком языке уже существует.");
        }
    }

    @Override
    public WordDto read(Long id) {
        return WordMapper.INSTANCE.toDto(wordRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Слово не найдено по id: " + id)));
    }

    @Override
    public WordDto update(WordUpdatingDto dto) {
       Word word = wordRepository.findById(dto.getId())
               .orElseThrow(()-> new NotFoundExceptions("Слово не найдено по id: " + dto.getId()));

       if (wordRepository.existsByWordAndLang_Id(dto.getWord(),dto.getLangId())) {
           throw new ConflictException("Слово уже существует");
       }

       word.setWord(dto.getWord());
       word.setLang(languageRepository.findById(dto.getLangId())
               .orElseThrow(() -> new NotFoundExceptions("Не найден язык по id: " + dto.getLangId())));
       return WordMapper.INSTANCE.toDto(wordRepository.save(word));
    }

    @Override
    public void delete(Long id) {
        if (wordRepository.existsById(id)) {
            wordRepository.deleteById(id);
        }
    }

    @Override
    public List<WordWithoutLanguageDto> findAllByLang(String language) {
        return wordRepository.findWordsByLanguage(language)
                .stream()
                .map(WordMapper.INSTANCE::toWithoutLanguageDto)
                .collect(Collectors.toList());
    }
}
