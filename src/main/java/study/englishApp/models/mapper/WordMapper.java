package study.englishApp.models.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import study.englishApp.models.dto.WordDto;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.dto.WordWithoutLanguageDto;
import study.englishApp.models.mapper.context.WordMappingContext;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;


@Mapper
public interface WordMapper {

    WordMapper INSTANCE = Mappers.getMapper(WordMapper.class);

    @Mapping(target = "words", source = "word")
    WordWithoutLanguageDto toWithoutLanguageDto(Word entity);

    WordDto toDto(Word entity);

    Word toEntity(WordCreationDto dto, @Context WordMappingContext context);

    Word toEntity(WordDto dto);

    Word toEntity(WordUpdatingDto dto, @Context WordMappingContext context);
}
