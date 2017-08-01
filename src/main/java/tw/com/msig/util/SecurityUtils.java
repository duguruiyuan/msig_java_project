package tw.com.msig.util;

import tw.com.msig.entity.Employee;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {

	public static final String SESSION_USER_DATA = "user_data";
	public static final String LOGIN_URL = "login";

	/** 將登入資料塞入 */
	public static void setLoginUser(HttpServletRequest req, Employee user) {
		req.getSession().setAttribute(SESSION_USER_DATA, user);
	}

	/** 取得目前登入者的資料 */
	public static Optional<Employee> getLoginUser(HttpServletRequest req) {
		return Optional.ofNullable(req.getSession(false))
				.map(session -> (Employee) session.getAttribute(SESSION_USER_DATA));
	}

	public static void removeUser(HttpServletRequest req) {
		Optional.ofNullable(req.getSession(false)).ifPresent(session -> session.removeAttribute(SESSION_USER_DATA));
	}
}
