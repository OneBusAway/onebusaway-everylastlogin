package org.onebusaway.everylastlogin.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.ExporterUtil;
import org.timepedia.exporter.client.NoExport;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

@Export
@ExportPackage("everylastlogin")
public class LoginWidgetLibrary implements EntryPoint {

  public void createWidget(String targetPanelName, String loginServletUrl,
      String loginRedirectUrl) {

    RootPanel panel = RootPanel.get(targetPanelName);
    panel.add(new LoginWidget(loginServletUrl, loginRedirectUrl));
  }

  @Override
  @NoExport
  public void onModuleLoad() {
    try {
      ExporterUtil.exportAll();
    } catch (Exception e) {
      Window.alert("Exception " + e.toString());
    }
  }
}
