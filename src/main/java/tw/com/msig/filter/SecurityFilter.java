package tw.com.msig.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.msig.util.SecurityUtils;

@WebFilter("/*")
public class SecurityFilter implements Filter {

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
      throws ServletException, IOException {
    final HttpServletRequest request = (HttpServletRequest) req;
    final HttpServletResponse response = (HttpServletResponse) res;
    final HttpSession session = request.getSession(false);
    final String loginURI = request.getContextPath() + "/" + SecurityUtils.LOGIN_URL;

    final boolean loggedIn = session != null && SecurityUtils.getLoginUser(request).isPresent();
    final boolean loginRequest = request.getRequestURI().equals(loginURI);

    if (loggedIn || loginRequest) {
      chain.doFilter(request, response);
    } else {
      response.sendRedirect(loginURI);
    }
  }

  @Override
  public void destroy() {}
}
