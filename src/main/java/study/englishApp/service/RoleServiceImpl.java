package study.englishApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.englishApp.exceptions.NotFoundExceptions;
import study.englishApp.models.entity.Role;
import study.englishApp.repository.RoleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;

    @Override
    public void create(Role role) {
        if (!roleRepository.existsByName(role.getName())){
            roleRepository.save(role);
        }else {
            throw new NotFoundExceptions(String.format("Роль %s не найдена", role.getName()));
        }
    }

    @Override
    public Role find(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundExceptions(String.format("Роль по id: %d не найден", id)));
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
