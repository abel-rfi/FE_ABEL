package id.co.lua.polua.services.accounts;

import id.co.lua.polua.exceptions.IdNotExistsException;
import id.co.lua.polua.models.accounts.Role;
import id.co.lua.polua.models.accounts.User;
import id.co.lua.polua.models.repositories.RoleRepository;
import id.co.lua.polua.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder pEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user==null) {
            throw new RuntimeException("Username tidak ditemukan!");
        } else {
            return user;
        }
    }

    @Override
    public User getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }else{
            throw new IdNotExistsException();
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        if(userList!=null){
            if(!userList.isEmpty()){
                return userList;
            }
            else{
                return null;
            }
        }else{
            throw new IdNotExistsException();
        }
    }
    @Override
    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    @Override
    public Long countByUsername(String username) {
        return userRepository.countByUsername(username);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public void delete(User user){
        user.setDeleted(true);
        userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) { return userRepository.findByEmail(email); }

    @Override
    public Optional<User> getUserByToken(String token) { return userRepository.findUserByResetPasswordToken(token); }

    @Override
    public User resetPassword(User user, String password){
        user.setPassword(pEncoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByResetPasswordToken(String token) { return userRepository.findUserByResetPasswordToken(token);
    }

    @Override
    public Optional<User> getUserByPassword(String password) { return userRepository.findUserByPassword(password); }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(!roleOptional.isPresent()){
            throw new IdNotExistsException();
        }
        return roleOptional.get();
    }

    @Override
    public User create(User user, String plainPassword) {
        user.setPassword(pEncoder.encode(plainPassword))
                .setDeleted(false);
        return userRepository.save(user);
    }

    @Override
    public User update(User user, Long idProject) {
        User userUpdate = getById(user.getId());

        userUpdate.setName(user.getName())
                .setEmail(user.getEmail());

        return userRepository.save(userUpdate);
    }
}
