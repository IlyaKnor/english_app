package study.englishApp.service;


import study.englishApp.models.Language;
import java.util.List;


public interface LanguageService {

    void create(Language language);

    List<Language> findAll();

    Language read(Long id);

    Language update (Language language);

    void delete (Long id);
}
