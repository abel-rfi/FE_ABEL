package id.co.lua.polua.services.apps;

import id.co.lua.polua.exceptions.IdNotExistsException;
import id.co.lua.polua.models.accounts.User;
import id.co.lua.polua.models.apps.LogActivity;
import id.co.lua.polua.models.repositories.LogActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogActivityServicesImpl implements LogAcivityService {
    @Autowired
    private LogActivityRepository logActivityRepository;

    @Override
    public LogActivity getById(Long id) {
        Optional<LogActivity> logActivitiesOptional = logActivityRepository.findById(id);
        if (logActivitiesOptional != null) {
            if (!logActivitiesOptional.isPresent()) {
                return logActivitiesOptional.get();
            } else {
                return null;
            }
        } else {
            throw new IdNotExistsException();
        }
    }

    @Override
    public List<LogActivity> findByUserLimit50(Long id) {
        List<LogActivity> logActivities = logActivityRepository.findByUserLimit50(id);
        if (logActivities != null) {
            return logActivityRepository.findByUserLimit50(id);
        } else {
            return null;
        }
    }

    public LogActivity getLastLogin(User user) {
        return logActivityRepository.findTopByUserOrderByIdDesc(user);
    }

    @Override
    public List <LogActivity> getLogActivityByUser(User user){
       List<LogActivity> logActivityList = logActivityRepository.findAll();
        if (logActivityList !=null) {
            return logActivityRepository.findByUser(user);
        } else {
            return null;
        }
    }

    @Override
    public void login(User user, String ip) {
        LogActivity logActivity = new LogActivity()
                .setUser(user)
                .setLogin(new Date())
                .setIp(ip);
        logActivityRepository.save(logActivity);
    }

    @Override
    public void logout(User user) {
        LogActivity lastLogin = getLastLogin(user);
        if(lastLogin != null){
            lastLogin.setLogout(new Date());
            logActivityRepository.save(lastLogin);
        }else {
            throw new IdNotExistsException();
        }
    }
}
