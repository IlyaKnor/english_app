package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WordWithoutLanguageDto {
    private Long id;
    private String words;
}
