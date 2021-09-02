package study.englishApp.service;

import org.springframework.stereotype.Service;
import study.englishApp.Exceptions.BadRequestException;
import study.englishApp.Exceptions.NotFoundExceptions;
import study.englishApp.models.Language;
import study.englishApp.models.dto.LanguageDto;
import study.englishApp.models.mapper.LanguageMapper;
import study.englishApp.repository.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {


    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageDto create(LanguageDto dto) {
        dto.setLanguage(dto.getLanguage().toUpperCase());
        if (!languageRepository.existsByLanguage(dto.getLanguage()) && dto.getLanguage().length() < 3) {
            languageRepository.save(LanguageMapper.INSTANCE.toEntity(dto));
            return dto;
        } else {
            throw new BadRequestException("Не верно введен код языка.");
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
        if (languageRepository.existsById(dto.getId())){
            dto.setId(dto.getId());
            languageRepository.save(LanguageMapper.INSTANCE.toEntity(dto));
            return dto;
        }else {
            throw new BadRequestException(String.format("Языка %s не существует", dto.getLanguage()));
        }
    }

    @Override
    public void delete(Long id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
        }
    }
}
