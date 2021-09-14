package study.englishApp.models.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LanguageDto {

    @NotBlank
    private Long id;
    @NotBlank
    private String language;

    public LanguageDto(String language) {
        this.language = language;
    }
}
