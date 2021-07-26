package study.englishApp.service;

import study.englishApp.models.UserCard;
import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.models.dto.UserCardUpdatingDto;

import java.util.List;

public interface UserCardService {

    UserCard create(UserCardCreatedDto userCard);

    List<UserCard> findAll();

    UserCard read(Long id);

    UserCard update(UserCardUpdatingDto userCard);

    void delete(Long id);

    void addCard(Long id, Long cardsId);
}
