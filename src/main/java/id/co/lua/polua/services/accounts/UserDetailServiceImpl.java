package id.co.lua.polua.services.accounts;

import id.co.lua.polua.models.accounts.RoleFeature;
import id.co.lua.polua.models.accounts.User;
import id.co.lua.polua.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if(!user.isDeleted()){
            for(RoleFeature roleFeature:user.getRole().getRoleFeature()){
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleFeature.getFeature().getNama()));
            }
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getName()));
        }else{
            //TODO: Jika user sudah di delete
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
