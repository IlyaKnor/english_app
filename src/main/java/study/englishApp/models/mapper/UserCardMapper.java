package study.englishApp.models.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import study.englishApp.models.UserCard;
import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.models.dto.UserCardDto;
import study.englishApp.models.dto.UserCardUpdatingDto;
import study.englishApp.models.mapper.context.UserCardMappingContext;

@Mapper
public interface UserCardMapper {

    UserCardMapper INSTANCE = Mappers.getMapper(UserCardMapper.class);

    UserCardDto toDto(UserCard entity);

    UserCard toEntity(UserCardCreatedDto dto, @Context UserCardMappingContext context);

    UserCard toEntity(UserCardDto dto);

    @Mappings({
            @Mapping(target = "card", ignore = true),
            @Mapping(target = "user", ignore = true)
    })
    UserCard toEntity(UserCardUpdatingDto dto);
}
