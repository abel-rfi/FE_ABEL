package id.co.lua.polua.services.accounts;

import id.co.lua.polua.models.accounts.Role;
import id.co.lua.polua.models.accounts.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    List<User> getAllUser();
    Long countByEmail(String email);
    Long countByUsername(String username);
    void save(User user);
    void delete(User user);

    User getByEmail(String email);

    Optional<User> getUserByToken(String token);

    User resetPassword(User user, String password);

    Optional<User> findUserByResetPasswordToken(String email);

    Optional<User> getUserByPassword(String password);

    Role getRoleById(Long role);

    User create(User user, String plainPassword);

    User update(User user, Long idProject);
}
