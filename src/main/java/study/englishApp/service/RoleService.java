package study.englishApp.service;

import study.englishApp.models.Role;

import java.util.List;

public interface RoleService {
    void create(Role role);

    Role find(Long id);

    List<Role> findAll();

    void delete(Long id);
}
