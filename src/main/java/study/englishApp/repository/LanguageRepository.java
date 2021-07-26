package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.englishApp.models.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    boolean existsByLanguage(String language);
}
