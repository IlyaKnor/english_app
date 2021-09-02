package study.englishApp.service;

import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.models.dto.UserCardDto;
import study.englishApp.models.dto.UserCardUpdatingDto;

import java.util.List;

public interface UserCardService {

    UserCardDto create(UserCardCreatedDto userCard);

    List<UserCardDto> findAll();

    UserCardDto read(Long id);

    UserCardDto update(UserCardUpdatingDto userCard);

    void delete(Long id);

    void addCard(Long id, Long cardsId);
}
