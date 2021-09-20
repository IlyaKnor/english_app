package study.englishApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.englishApp.Exceptions.ConflictException;
import study.englishApp.Exceptions.NotFoundExceptions;
import study.englishApp.models.Card;
import study.englishApp.models.UserCard;
import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.models.dto.UserCardDto;
import study.englishApp.models.dto.UserCardUpdatingDto;
import study.englishApp.models.mapper.CardMapper;
import study.englishApp.models.mapper.UserCardMapper;
import study.englishApp.models.mapper.context.UserCardMappingContext;
import study.englishApp.repository.UserCardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserCardServiceImpl implements UserCardService {

    private  final UserCardRepository userCardRepository;
    private final CardService cardService;
    private final UserCardMappingContext context;

    @Override
    public UserCardDto create(UserCardCreatedDto userCard) {

        UserCard created = userCardRepository.save(UserCardMapper.INSTANCE.toEntity(userCard, context));
        return UserCardMapper.INSTANCE.toDto(created);
    }

    @Override
    public List<UserCardDto> findAll() {
        return userCardRepository.findAll()
                .stream()
                .map(UserCardMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserCardDto read(Long id) {
        return UserCardMapper.INSTANCE.toDto(userCardRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions(String.format("Список карт по id: %d не найден", id))));
    }

    @Override
    public UserCardDto update(UserCardUpdatingDto userCard) {


        UserCard found = userCardRepository.findById(userCard.getId())
                .orElseThrow(() -> new ConflictException(String.format("Карточки по id: %d е существует", userCard.getId())));
        found.setName(userCard.getName());

        return UserCardMapper.INSTANCE.toDto(found);
    }

    @Override
    public void delete(Long id) {
        if (userCardRepository.existsById(id)){
            userCardRepository.deleteById(id);
        }
    }

    @Override
    public void addCard(Long id, Long cardsId) {
        UserCard found = UserCardMapper.INSTANCE.toEntity(read(id));
        Card card = CardMapper.INSTANCE.toEntity(cardService.read(cardsId));
        found.setCard(card);
        }

}
