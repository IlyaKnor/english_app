package study.englishApp.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import study.englishApp.models.dto.LanguageDto;
import study.englishApp.service.LanguageService;

import java.util.List;

@TestConfiguration
public class LanguageServiceImplTestContextConfiguration {

    @Bean
    public LanguageService languageService() {
        return new LanguageService() {
            @Override
            public LanguageDto create(LanguageDto dto) {
                return null;
            }

            @Override
            public List<LanguageDto> findAll() {
                return null;
            }

            @Override
            public LanguageDto read(Long id) {
                return null;
            }

            @Override
            public LanguageDto update(LanguageDto dto) {
                return null;
            }

            @Override
            public void delete(Long id) {

            }
        };
    }
}
