package study.englishApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.englishApp.Exceptions.ConflictException;
import study.englishApp.Exceptions.NotFoundExceptions;
import study.englishApp.models.Language;
import study.englishApp.models.dto.LanguageDto;
import study.englishApp.models.mapper.LanguageMapper;
import study.englishApp.repository.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public LanguageDto create(LanguageDto dto) {
        dto.setLanguage(dto.getLanguage().toUpperCase());
        if (!languageRepository.existsByLanguage(dto.getLanguage()) && dto.getLanguage().length() < 3) {
            languageRepository.save(LanguageMapper.INSTANCE.toEntity(dto));
            return dto;
        } else {
            throw new ConflictException("Язык уже существует или задано неверное значение.");
        }
    }

    @Override
    public List<LanguageDto> findAll() {
        return languageRepository.findAll()
                .stream()
                .map(LanguageMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageDto read(Long id) {
        return LanguageMapper.INSTANCE.toDto(languageRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Язык не найден по id: " + id)));
    }

    @Override
    public LanguageDto update(LanguageDto dto) {
        Language language = languageRepository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundExceptions(String.format("Языка %s не существует", dto.getLanguage())));
        language.setLanguage(dto.getLanguage());
        return LanguageMapper.INSTANCE.toDto(languageRepository.save(language));
    }

    @Override
    public void delete(Long id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
        }
    }
}
