package tw.com.msig.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UncheckedIOException;

/** 共用的controller邏輯 */
public abstract class AbstractController extends HttpServlet implements BeanFactory {

  /** 轉導到某個jsp上 */
  protected void forward(HttpServletRequest req, HttpServletResponse resp, String path)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/" + path + ".jsp");
    dispatcher.forward(req, resp);
  }

  protected void writeJson(HttpServletResponse response, Object src) {
    String json = new Gson().toJson(src);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    try {
      response.getWriter().write(json);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private BeanFactory getBeanFactory() {
    return WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
  }

  @Override
  public Object getBean(String name) throws BeansException {
    return getBeanFactory().getBean(name);
  }

  @Override
  public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return getBeanFactory().getBean(name, requiredType);
  }

  @Override
  public <T> T getBean(Class<T> requiredType) throws BeansException {
    return getBeanFactory().getBean(requiredType);
  }

  @Override
  public Object getBean(String name, Object... args) throws BeansException {
    return getBeanFactory().getBean(name, args);
  }

  @Override
  public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
    return getBeanFactory().getBean(requiredType, args);
  }

  @Override
  public boolean containsBean(String name) {
    return getBeanFactory().containsBean(name);
  }

  @Override
  public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
    return getBeanFactory().isSingleton(name);
  }

  @Override
  public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
    return getBeanFactory().isPrototype(name);
  }

  @Override
  public boolean isTypeMatch(String name, ResolvableType typeToMatch)
      throws NoSuchBeanDefinitionException {
    return getBeanFactory().isTypeMatch(name, typeToMatch);
  }

  @Override
  public boolean isTypeMatch(String name, Class<?> typeToMatch)
      throws NoSuchBeanDefinitionException {
    return getBeanFactory().isTypeMatch(name, typeToMatch);
  }

  @Override
  public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
    return getBeanFactory().getType(name);
  }

  @Override
  public String[] getAliases(String name) {
    return getBeanFactory().getAliases(name);
  }
}
