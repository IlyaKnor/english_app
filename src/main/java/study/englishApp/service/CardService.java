package study.englishApp.service;

import study.englishApp.models.Card;
import study.englishApp.models.dto.CardCreationDto;

public interface CardService {

    Card create(CardCreationDto card);

    Card read(Long id);

    void delete(Long id);
}
