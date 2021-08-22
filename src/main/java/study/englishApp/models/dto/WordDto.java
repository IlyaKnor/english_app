package study.englishApp.models.dto;

import lombok.Getter;
import lombok.Setter;
import study.englishApp.models.Language;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class WordDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String word;
    @NotBlank
    private Language lang;
}
