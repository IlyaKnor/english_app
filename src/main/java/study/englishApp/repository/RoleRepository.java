package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.englishApp.models.ERole;
import study.englishApp.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(ERole name);
    Role findByName(ERole name);
}
