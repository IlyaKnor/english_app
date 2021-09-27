package study.englishApp.models.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import study.englishApp.models.entity.Card;
import study.englishApp.models.dto.CardCreationDto;
import study.englishApp.models.dto.CardDto;
import study.englishApp.models.mapper.context.CardMappingContext;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDto toDto(Card entity);

    Card toEntity(CardDto dto);

    @Mapping(target = "id", ignore = true)
    Card toEntity(CardCreationDto dto, @Context CardMappingContext context);
}
