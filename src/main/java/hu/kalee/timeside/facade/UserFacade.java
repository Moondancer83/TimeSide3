package hu.kalee.timeside.facade;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import hu.kalee.timeside.data.entity.Role;
import hu.kalee.timeside.data.RoleRepository;
import hu.kalee.timeside.data.entity.User;
import hu.kalee.timeside.data.UserRepository;

/**
 * UserFacade.
 *
 * @author mkalinovits
 * @since 2017. 12. 30.
 */
@Component
public class UserFacade {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}
