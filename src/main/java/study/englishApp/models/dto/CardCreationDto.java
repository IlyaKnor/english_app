package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CardCreationDto {
    private Long wordId;
    private Long translationId;
}
