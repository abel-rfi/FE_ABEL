package id.co.lua.polua.models.repositories;

import id.co.lua.polua.models.accounts.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
