package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import study.englishApp.models.Card;
import study.englishApp.models.User;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class UserCardCreatedDto {
    @NotBlank
    private String name;
    private Card card;
    private User user;

}
