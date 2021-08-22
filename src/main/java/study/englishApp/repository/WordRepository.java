package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.englishApp.models.Word;
import java.util.List;

@Repository
public interface WordRepository extends JpaRepository <Word, Long> {
    @Query("SELECT u FROM Word u WHERE u.lang = ?1")
    List<Word> findWordsByLanguage(String lang);

    boolean existsByWordAndLang_Id(String word, long id);

    Word findWordByWordAndLang(String word, long id);
}
