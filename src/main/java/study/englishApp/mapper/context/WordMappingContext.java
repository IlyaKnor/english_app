package study.englishApp.mapper.context;

import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;
import study.englishApp.service.LanguageService;

@Component
@RequiredArgsConstructor
public class WordMappingContext {

    private final LanguageService languageService;

    @AfterMapping
    public void map(@MappingTarget Word target, WordCreationDto source) {
        target.setLang(languageService.read(source.getLangId()));
    }

}
