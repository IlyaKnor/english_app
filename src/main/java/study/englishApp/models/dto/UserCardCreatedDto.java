package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.englishApp.models.entity.Card;
import study.englishApp.models.entity.User;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserCardCreatedDto {
    @NotBlank
    private String name;
    private Card card;
    private User user;

}
