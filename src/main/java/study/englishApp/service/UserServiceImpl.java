package study.englishApp.service;

import org.springframework.stereotype.Service;
import study.englishApp.models.ERole;
import study.englishApp.models.User;
import study.englishApp.models.dto.UserCreateDto;
import study.englishApp.models.dto.UserUpdatingDto;
import study.englishApp.repository.RoleRepository;
import study.englishApp.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User create(UserCreateDto userCreateDto) {
        if (!userRepository.existsByLogin(userCreateDto.getLogin())){
            User created = new User();
            created.setLogin(userCreateDto.getLogin());
            created.setEmail(userCreateDto.getEmail());
            created.setPassword(userCreateDto.getPassword());
            created.setEnabled(true);
            created.addRole(roleRepository.findByName(ERole.ROLE_USER));
            return userRepository.save(created);
        }
        else {
            throw new RuntimeException("Не удалось создать пользователя");
        }
    }

    @Override
    public User read(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    @Override
    public User update(UserUpdatingDto userUpdatingDto) {
        User found = read(userUpdatingDto.getId());
        found.setPassword(userUpdatingDto.getPassword());
        found.setEmail(userUpdatingDto.getEmail());
        found.setLogin(userUpdatingDto.getName());
       return userRepository.save(found);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
