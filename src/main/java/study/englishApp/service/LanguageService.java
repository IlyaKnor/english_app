package study.englishApp.service;


import study.englishApp.models.Language;
import study.englishApp.models.dto.LanguageDto;

import java.util.List;


public interface LanguageService {

    LanguageDto create(LanguageDto dto);

    List<LanguageDto> findAll();

    LanguageDto read(Long id);

    LanguageDto update (LanguageDto dto);

    void delete (Long id);
}
