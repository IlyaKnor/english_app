package study.englishApp.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LanguageDto {

    @NotBlank
    private Long id;
    @NotBlank
    private String language;
}
