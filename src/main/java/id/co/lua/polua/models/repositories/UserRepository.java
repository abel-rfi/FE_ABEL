package id.co.lua.polua.models.repositories;

import id.co.lua.polua.models.accounts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    User findByUsernameAndRole(String username, Role role);
    Optional<User> findUserByResetPasswordToken(String email);
    Optional<User> findUserByEmail(String email);

    Long countByEmail(String email);
    Long countByUsername(String username);
    User findByEmail(String email);

    Optional<User> findUserByPassword(String password);
}
