package id.co.lua.polua.helpers;

import id.co.lua.polua.services.accounts.UserService;
import id.co.lua.polua.services.apps.LogAcivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler extends
SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    LogAcivityService logAcivityService;

    @Autowired
    UserService userService;

    @Override
    public void onLogoutSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication)
      throws IOException, ServletException {
        logAcivityService.logout(userService.getByUsername(authentication.getName()));
        super.onLogoutSuccess(request, response, authentication);
    }
}
