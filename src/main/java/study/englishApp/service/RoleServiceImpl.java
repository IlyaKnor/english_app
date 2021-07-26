package study.englishApp.service;

import org.springframework.stereotype.Service;
import study.englishApp.models.Role;
import study.englishApp.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void create(Role role) {
        if (!roleRepository.existsByName(role.getName())){
            roleRepository.save(role);
        }else {
            throw new RuntimeException(String.format("Роль %s не найдена", role.getName()));
        }
    }

    @Override
    public Role find(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Роль по id: %d не найден", id)));
    }


    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
