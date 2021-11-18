package id.co.lua.polua.models.repositories;

import id.co.lua.polua.models.accounts.User;
import id.co.lua.polua.models.apps.LogActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogActivityRepository extends JpaRepository<LogActivity, Long> {
    @Query( value = "select l.* from log_activity l " +
            "where l.id = ?1 order by l.id",
            nativeQuery = true)
    List<LogActivity> findAllByLogactivity(Long id);
    List<LogActivity> findByUser(User user);


    @Query( value="select * from log_activity where user_id=?1 Order by login asc limit 50",
                    nativeQuery = true)
    List<LogActivity> findByUserLimit50(Long id);

    LogActivity findTopByUserOrderByIdDesc(User user);
}
