package study.englishApp.service;

import org.springframework.stereotype.Service;
import study.englishApp.models.Card;
import study.englishApp.models.Word;
import study.englishApp.models.dto.CardCreationDto;
import study.englishApp.models.dto.WordDto;
import study.englishApp.models.mapper.WordMapper;
import study.englishApp.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {


    private final CardRepository cardRepository;
    private final WordService wordService;


    public CardServiceImpl(CardRepository cardRepository, WordService wordService) {
        this.cardRepository = cardRepository;
        this.wordService = wordService;
    }

    @Override
    public Card create(CardCreationDto card) {
        Card create = new Card();
        WordDto word = wordService.read(card.getWordId());
        WordDto translation = wordService.read(card.getTranslationId());
        create.setWord(WordMapper.INSTANCE.toEntity(word));
        create.setTranslation(WordMapper.INSTANCE.toEntity(translation));

        return cardRepository.save(create);
    }

    @Override
    public Card read(Long id) {
        return cardRepository.findById(id).
                orElseThrow(() -> new RuntimeException(String.format("Карточка по id: %d не найдена", id)));
    }


    @Override
    public void delete(Long id) {

        if (cardRepository.existsById(id)){
            cardRepository.deleteById(id);
        }
    }
}
