package org.onebusaway.everylastlogin.client;

import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

public class LoginWidgetEntryPoint implements EntryPoint {

  @Override
  public void onModuleLoad() {
    try {
      ExporterUtil.exportAll();
    } catch (Exception e) {
      Window.alert("Exception " + e.toString());
    }
  }
}
