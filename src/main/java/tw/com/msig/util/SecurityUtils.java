package tw.com.msig.util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import tw.com.msig.entity.Employee;

public class SecurityUtils {

	public static final String SESSION_USER_DATA = "user_data";
	public static final String LOGIN_URL = "login";
	public static final String RESOURCES_URL = "resources";
	
	/** 將登入資料塞入 */
	public static void setLoginUser(final HttpServletRequest req, final Employee user) {
		req.getSession().setAttribute(SESSION_USER_DATA, user);
	}

	/** 取得目前登入者的資料 */
	public static Optional<Employee> getLoginUser(final HttpServletRequest req) {
		return Optional.ofNullable(req.getSession(false))
				.map(session -> (Employee) session.getAttribute(SESSION_USER_DATA));
	}

	public static void removeUser(final HttpServletRequest req) {
		Optional.ofNullable(req.getSession(false)).ifPresent(session -> session.removeAttribute(SESSION_USER_DATA));
	}
}
