package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.englishApp.models.entity.Card;
import study.englishApp.models.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCardDto {

    private Long id;
    private User user;
    private Card card;
    private String name;
}
