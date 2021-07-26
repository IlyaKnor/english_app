package study.englishApp.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class WordCreationDto {
    @NotBlank
    private String word;
    private Long langId;
}
