package study.englishApp.service;

import study.englishApp.models.dto.CardCreationDto;
import study.englishApp.models.dto.CardDto;

public interface CardService {

    CardDto create(CardCreationDto card);

    CardDto read(Long id);

    void delete(Long id);
}
