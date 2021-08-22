package study.englishApp.models.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.englishApp.models.dto.WordDto;
import study.englishApp.models.mapper.context.WordMappingContext;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;


@Mapper
public interface WordMapper {

    WordMapper INSTANCE = Mappers.getMapper(WordMapper.class);

    WordDto toDto(Word entity);

    Word toEntity(WordCreationDto dto, @Context WordMappingContext context);
}
