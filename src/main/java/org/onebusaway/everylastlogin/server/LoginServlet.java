package org.onebusaway.everylastlogin.server;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private LoginManager _loginManager = new LoginManager();

  public void setLoginManager(LoginManager loginManager) {
    _loginManager = loginManager;
  }

  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    String factoryClassName = config.getInitParameter("loginManagerFactory");
    if (factoryClassName != null) {
      try {
        Class<?> factoryClass = Class.forName(factoryClassName);
        if (!LoginManagerFactory.class.isAssignableFrom(factoryClass))
          throw new ServletException("class " + factoryClassName
              + " is not assignable to " + LoginManagerFactory.class);
        LoginManagerFactory factory = (LoginManagerFactory) factoryClass.newInstance();
        _loginManager = factory.createLoginManager(config);
      } catch (ClassNotFoundException e) {
        throw new ServletException("could not find loginManagerFactory class: "
            + factoryClassName, e);
      } catch (InstantiationException e) {
        throw new ServletException(
            "error instantiating loginManagerFactory class: "
                + factoryClassName, e);
      } catch (IllegalAccessException e) {
        throw new ServletException(
            "error instantiating loginManagerFactory class: "
                + factoryClassName, e);
      }
    }
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    handleRequest(req, resp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    handleRequest(req, resp);
  }

  private void handleRequest(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
    _loginManager.handleAuthentication(req, resp);
  }
}
