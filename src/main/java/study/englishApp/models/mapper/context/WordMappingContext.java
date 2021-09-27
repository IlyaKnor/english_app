package study.englishApp.models.mapper.context;

import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import study.englishApp.models.entity.Word;
import study.englishApp.models.dto.WordCreationDto;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.mapper.LanguageMapper;
import study.englishApp.service.LanguageService;

@Component
@RequiredArgsConstructor
public class WordMappingContext {

    private final LanguageService languageService;

    @AfterMapping
    public void map(@MappingTarget Word target, WordCreationDto source) {
        target.setLang(LanguageMapper.INSTANCE.toEntity(languageService.read(source.getLangId())));
    }

    @AfterMapping
    public void map(@MappingTarget Word target, WordUpdatingDto source) {
        target.setLang(LanguageMapper.INSTANCE.toEntity(languageService.read(source.getLangId())));
    }

}
