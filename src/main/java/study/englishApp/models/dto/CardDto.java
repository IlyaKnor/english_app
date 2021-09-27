package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.englishApp.models.entity.Word;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CardDto {

    @NotBlank
    private Long id;

    @NotBlank
    private Word word;

    @NotBlank
    private Word translation;
}
