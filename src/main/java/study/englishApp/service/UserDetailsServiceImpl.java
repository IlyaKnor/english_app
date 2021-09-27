package study.englishApp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import study.englishApp.models.UserDetailsImpl;
import study.englishApp.models.entity.User;
import study.englishApp.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(login);
        if (user == null){
            throw new UsernameNotFoundException(String.format("User with %s not found!", login));
        }
        return UserDetailsImpl.build(user);
    }
}
