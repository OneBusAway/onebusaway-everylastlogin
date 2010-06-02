package org.onebusaway.everylastlogin.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public interface LoginManagerFactory {
  public LoginManager createLoginManager(ServletConfig config) throws ServletException;
}
