package study.englishApp.models.mapper.context;

import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import study.englishApp.models.entity.UserCard;
import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.repository.UserCardRepository;

@Component
@RequiredArgsConstructor
public class UserCardMappingContext {

    private final UserCardRepository userCardRepository;

    @AfterMapping
    public void map(@MappingTarget UserCard target, UserCardCreatedDto source) {
            target.setId(userCardRepository.findUserCardByName(source.getName()).getId());
    }
}
