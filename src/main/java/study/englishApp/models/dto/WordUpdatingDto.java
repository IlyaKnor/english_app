package study.englishApp.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class WordUpdatingDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String word;
    @NotBlank
    private Long langId;
}
