package study.englishApp.convertors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;

@Component
public class WordCreationDtoConverter {

    private final ModelMapper modelMapper;

    public WordCreationDtoConverter() {
        this.modelMapper = new ModelMapper();
    }

    public Word convertToEntity(WordCreationDto dto) {
        return modelMapper.map(dto, Word.class);
    }

    public WordCreationDto convertToDto(Word entity) {
        return modelMapper.map(entity, WordCreationDto.class);
    }
}
