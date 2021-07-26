package study.englishApp.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserUpdatingDto {
    @NotBlank
    Long id;
    String name;
    String password;
    String email;
}
