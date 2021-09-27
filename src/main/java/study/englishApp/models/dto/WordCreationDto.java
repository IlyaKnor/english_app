package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class WordCreationDto {
    @NotBlank
    private String word;
    private Long langId;
}
