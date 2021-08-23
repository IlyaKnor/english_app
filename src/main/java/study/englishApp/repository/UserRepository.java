package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.englishApp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
