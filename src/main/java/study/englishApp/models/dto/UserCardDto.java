package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import study.englishApp.models.Card;
import study.englishApp.models.User;

@AllArgsConstructor
@Getter
@Setter
public class UserCardDto {

    private Long id;
    private User user;
    private Card card;
    private String name;
}
