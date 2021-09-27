package study.englishApp.models.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageDto {

    private Long id;
    @NotBlank
    private String language;

}
