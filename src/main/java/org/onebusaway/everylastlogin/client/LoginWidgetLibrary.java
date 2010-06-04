package org.onebusaway.everylastlogin.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import com.google.gwt.user.client.ui.RootPanel;

@Export
@ExportPackage("everylastlogin")
public class LoginWidgetLibrary implements Exportable {

  public static void createWidget(String targetPanelName,
      String loginServletUrl, String loginRedirectUrl) {

    RootPanel panel = RootPanel.get(targetPanelName);
    panel.add(new LoginWidget(loginServletUrl, loginRedirectUrl));
  }
}
