package study.englishApp.convertors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordUpdatingDto;
import study.englishApp.models.dto.WordWithoutLanguageDto;

@Component
public class WordWithoutLanguageDtoConverter {

    private final ModelMapper modelMapper;

    public WordWithoutLanguageDtoConverter(){
        this.modelMapper = new ModelMapper();
    }

    public WordWithoutLanguageDto convertToDto (Word entity){
        return modelMapper.map(entity, WordWithoutLanguageDto.class);
    }
}
