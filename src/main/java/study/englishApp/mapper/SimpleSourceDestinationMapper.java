package study.englishApp.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import study.englishApp.mapper.context.WordMappingContext;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;

@Mapper
public interface SimpleSourceDestinationMapper {
    @Mappings({
            @Mapping(source = "lang.id", target = "langId"),
    })
    WordCreationDto toWordCreationDto(Word source);
    Word toEntity(WordCreationDto destination, @Context WordMappingContext context);
}
