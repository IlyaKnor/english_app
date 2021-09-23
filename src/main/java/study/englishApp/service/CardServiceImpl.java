package study.englishApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.englishApp.Exceptions.BadRequestException;
import study.englishApp.Exceptions.ConflictException;
import study.englishApp.Exceptions.NotFoundExceptions;
import study.englishApp.models.Card;
import study.englishApp.models.dto.CardCreationDto;
import study.englishApp.models.dto.CardDto;
import study.englishApp.models.mapper.CardMapper;
import study.englishApp.models.mapper.context.CardMappingContext;
import study.englishApp.repository.CardRepository;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {


    private final CardRepository cardRepository;
    private final CardMappingContext context;

    @Override
    public CardDto create(CardCreationDto card) {
        if (card.getTranslationId().equals(card.getWordId())){
            throw new ConflictException("Исходное слово и перевод совпадают.");
        }

        Card entity = cardRepository.save(CardMapper.INSTANCE.toEntity(card, context));
        return CardMapper.INSTANCE.toDto(entity);
    }

    @Override
    public CardDto read(Long id) {
        return CardMapper.INSTANCE.toDto(cardRepository.findById(id).
                orElseThrow(() -> new NotFoundExceptions(String.format("Карточка по id: %d не найдена", id))));
    }


    @Override
    public void delete(Long id) {
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
        }
    }
}
