package study.englishApp.models.dto;

import lombok.Getter;
import lombok.Setter;
import study.englishApp.models.Word;

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
