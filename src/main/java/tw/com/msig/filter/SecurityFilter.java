package tw.com.msig.filter;

import tw.com.msig.util.SecurityUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);
    String loginURI = request.getContextPath() + "/" + SecurityUtils.LOGIN_URL;

    boolean loggedIn = session != null && SecurityUtils.getLoginUser(request) != null;
    boolean loginRequest = request.getRequestURI().equals(loginURI);

    if (loggedIn || loginRequest) {
      chain.doFilter(request, response);
    } else {
      response.sendRedirect(loginURI);
    }
  }

  @Override
  public void destroy() {}
}
