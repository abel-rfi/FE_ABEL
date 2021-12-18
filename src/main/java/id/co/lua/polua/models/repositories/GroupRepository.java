package id.co.lua.polua.models.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import id.co.lua.polua.models.apps.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    
}
