package study.englishApp.mapper;

import org.mapstruct.Mapper;
import study.englishApp.models.Word;
import study.englishApp.models.dto.WordCreationDto;

@Mapper
public interface SimpleSourceDestinationMapper {
    WordCreationDto sourceToDestination(Word source);
    Word destinationToSource(WordCreationDto destination);
}
