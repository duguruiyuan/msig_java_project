package tw.com.msig.util;

import tw.com.msig.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class SecurityUtils {

  public static final String SESSION_USER_DATA = "user_data";
  public static final String LOGIN_URL = "login";

  /** 檢查是否有登入, 若無登入則回到登入畫面 */
  public static void requireLogin(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    final HttpSession session = req.getSession();
    if (Objects.isNull(session.getAttribute(SESSION_USER_DATA))) {
      resp.sendRedirect(LOGIN_URL);
    }
  }

  /** 將登入資料塞入 */
  public static void setLoginUser(HttpServletRequest req, Employee user) {
    req.getSession().setAttribute(SESSION_USER_DATA, user);
  }

  /** 取得目前登入者的資料 */
  public static Employee getLoginUser(HttpServletRequest req) {
    return (Employee) req.getSession().getAttribute(SESSION_USER_DATA);
  }

  public static void removeUser(HttpServletRequest req) {
    req.getSession().removeAttribute(SESSION_USER_DATA);
  }
}
