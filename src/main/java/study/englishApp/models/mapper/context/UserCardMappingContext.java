package study.englishApp.models.mapper.context;

import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import study.englishApp.models.UserCard;
import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.repository.UserCardRepository;
import study.englishApp.service.UserCardService;

@Component
@RequiredArgsConstructor
public class UserCardMappingContext {

    private final UserCardRepository userCardRepository;

    @AfterMapping
    public void map(@MappingTarget UserCard target, UserCardCreatedDto source) {
            target.setId(userCardRepository.findUserCardByName(source.getName()).getId());
    }
}
