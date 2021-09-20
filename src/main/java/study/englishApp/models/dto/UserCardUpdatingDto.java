package study.englishApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class UserCardUpdatingDto {
    @NotBlank
    private Long id;
    private String name;
}
