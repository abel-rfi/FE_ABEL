package id.co.lua.polua.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MySimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {
    protected final Log logger = LogFactory.getLog(this.getClass());
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException, ServletException {

        String email = request.getParameter("username");
        String error = exception.getMessage();
        System.out.println("A failed login attempt with username: "
                + email + ". Reason: " + error);

        String redirectUrl = request.getContextPath() + "/loginspse?error";
        response.sendRedirect(redirectUrl);
        //TODO: bedakan gagal untuk admin dan user spse

//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        Map<String, Object> data = new HashMap<>();
//        data.put(
//                "timestamp",
//                Calendar.getInstance().getTime());
//        data.put(
//                "exception",
//                exception.getMessage());
//
//        response.getOutputStream()
//                .println(objectMapper.writeValueAsString(data));
    }
}
