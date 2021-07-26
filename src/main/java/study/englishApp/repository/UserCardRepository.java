package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.englishApp.models.UserCard;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Long> {
}
