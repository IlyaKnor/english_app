package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordUpdatingDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String word;
    @NotBlank
    private Long langId;
}
