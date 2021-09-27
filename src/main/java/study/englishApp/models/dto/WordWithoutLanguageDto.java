package study.englishApp.models.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordWithoutLanguageDto {
    private Long id;
    private String words;
}
