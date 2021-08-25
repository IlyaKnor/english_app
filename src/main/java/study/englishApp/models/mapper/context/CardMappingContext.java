package study.englishApp.models.mapper.context;

import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import study.englishApp.models.Card;
import study.englishApp.models.dto.CardCreationDto;
import study.englishApp.models.mapper.WordMapper;
import study.englishApp.service.WordService;

@Component
@RequiredArgsConstructor
public class CardMappingContext {

    private final WordService wordService;

    @AfterMapping
    public void map(@MappingTarget Card target, CardCreationDto source) {
        target.setWord(WordMapper.INSTANCE.toEntity(wordService.read(source.getWordId())));
        target.setTranslation(WordMapper.INSTANCE.toEntity(wordService.read(source.getTranslationId())));
    }
}
