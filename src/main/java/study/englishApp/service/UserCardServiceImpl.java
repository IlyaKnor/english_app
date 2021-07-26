package study.englishApp.service;

import org.springframework.stereotype.Service;
import study.englishApp.models.Card;
import study.englishApp.models.UserCard;
import study.englishApp.models.dto.UserCardCreatedDto;
import study.englishApp.models.dto.UserCardUpdatingDto;
import study.englishApp.repository.UserCardRepository;

import java.util.List;

@Service
public class UserCardServiceImpl implements UserCardService {

    private  final UserCardRepository userCardRepository;
    private final CardService cardService;

    public UserCardServiceImpl(UserCardRepository userCardRepository, CardService cardService) {
        this.userCardRepository = userCardRepository;
        this.cardService = cardService;
    }

    @Override
    public UserCard create(UserCardCreatedDto userCard) {
        UserCard created = new UserCard();
        created.setName(userCard.getName());
        created.setUser(userCard.getUser());
        created.setCard(userCard.getCard());

        return userCardRepository.save(created);
    }

    @Override
    public List<UserCard> findAll() {
        return userCardRepository.findAll();
    }

    @Override
    public UserCard read(Long id) {
        return userCardRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Список карт по id: %d не найден", id)));
    }

    @Override
    public UserCard update(UserCardUpdatingDto userCard) {
        UserCard found = read(userCard.getId());
        found.setName(userCard.getName());

        return userCardRepository.save(found);
    }

    @Override
    public void delete(Long id) {
        if (userCardRepository.existsById(id)){
            userCardRepository.deleteById(id);
        }
    }

    @Override
    public void addCard(Long id, Long cardsId) {
        UserCard found = read(id);
        Card card = cardService.read(cardsId);
        found.setCard(card);
        }

}
