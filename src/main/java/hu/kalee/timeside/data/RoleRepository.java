package hu.kalee.timeside.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.kalee.timeside.data.entity.Role;

/**
 * RoleRepository.
 *
 * @author mkalinovits
 * @since 2017. 12. 30.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
