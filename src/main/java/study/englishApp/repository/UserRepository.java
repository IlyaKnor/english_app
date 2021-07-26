package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.englishApp.models.User;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByLogin (String login);
    boolean existsByLogin (String login);
    boolean existsByEmail (String email);
}
