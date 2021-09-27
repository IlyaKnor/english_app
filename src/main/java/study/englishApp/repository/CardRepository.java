package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.englishApp.models.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
