package study.englishApp.models.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {

    private Long id;
    @NotBlank
    private String language;

}
