package study.englishApp.service;

import org.springframework.stereotype.Service;
import study.englishApp.models.Language;
import study.englishApp.repository.LanguageRepository;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {


    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void create(Language language) {
        language.setLanguage(language.getLanguage().toUpperCase());
        if (!languageRepository.existsByLanguage(language.getLanguage()) && language.getLanguage().length() < 3) {
            languageRepository.save(language);
        } else {
            throw new RuntimeException("Не верно введен код языка.");
        }
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language read(Long id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Язык не найден по id: " + id));
    }

    @Override
    public Language update(Language language) {
        if (languageRepository.existsById(language.getId())){
            language.setId(language.getId());
            return languageRepository.save(language);
        }else {
            throw new RuntimeException(String.format("Языка %s не существует", language.getLanguage()));
        }
    }

    @Override
    public void delete(Long id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
        }
    }
}
