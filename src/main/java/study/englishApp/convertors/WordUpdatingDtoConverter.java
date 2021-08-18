package study.englishApp.convertors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordUpdatingDto;

@Component
public class WordUpdatingDtoConverter {
    private final ModelMapper modelMapper;

    public WordUpdatingDtoConverter() {
        this.modelMapper = new ModelMapper();
    }

    public WordUpdatingDto convertToDto (Word entity){
        return modelMapper.map(entity, WordUpdatingDto.class);
    }

}
