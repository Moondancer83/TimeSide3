package hu.kalee.timeside.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.kalee.timeside.data.entity.User;

/**
 * UserRepository.
 *
 * @author mkalinovits
 * @since 2017. 12. 30.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
