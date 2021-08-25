package study.englishApp.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.englishApp.models.Language;
import study.englishApp.models.dto.LanguageDto;

@Mapper
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    LanguageDto toDto(Language entity);

    Language toEntity(LanguageDto dto);
}
