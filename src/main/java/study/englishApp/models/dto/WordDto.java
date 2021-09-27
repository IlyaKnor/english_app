package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.englishApp.models.entity.Language;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String word;
    @NotBlank
    private Language lang;
}
