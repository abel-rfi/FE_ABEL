package id.co.lua.polua.services.apps;

import id.co.lua.polua.models.accounts.User;
import id.co.lua.polua.models.apps.LogActivity;

import java.util.List;


public interface LogAcivityService {
    LogActivity getById(Long id);

    List<LogActivity> findByUserLimit50(Long id);
    LogActivity getLastLogin(User user);

    List <LogActivity> getLogActivityByUser(User user);

    void login(User user, String ip);
    void logout(User user);
}
