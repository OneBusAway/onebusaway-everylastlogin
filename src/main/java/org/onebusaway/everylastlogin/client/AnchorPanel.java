package org.onebusaway.everylastlogin.client;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Why an AnchorPanel? I'd use {@link Anchor} but we can't use it as a panel to
 * add internal widgets like an image. I'd use {@link AnchorElement}, but it's
 * not easy to add a {@link ClickHandler}. Granted you can call
 * {@link Anchor#wrap(com.google.gwt.dom.client.Element)}, but it requires that
 * the {@link Anchor} has already been inserted in the DOM, which makes it
 * tricky to use if we're calling from a Widget constructor that hasn't been
 * inserted into the DOM yet.
 * 
 * @author bdferris
 * 
 */
public class AnchorPanel extends ComplexPanel implements InsertPanel,
    HasClickHandlers {

  public AnchorPanel() {
    setElement(DOM.createAnchor());
  }

  public String getHref() {
    return getAnchorElement().getHref();
  }

  public void setHref(String href) {
    getAnchorElement().setHref(href);
  }

  public HandlerRegistration addClickHandler(ClickHandler handler) {
    return addDomHandler(handler, ClickEvent.getType());
  }

  /**
   * Adds a new child widget to the panel.
   * 
   * @param w the widget to be added
   */
  @Override
  public void add(Widget w) {
    add(w, getElement());
  }

  /**
   * Inserts a widget before the specified index.
   * 
   * @param w the widget to be inserted
   * @param beforeIndex the index before which it will be inserted
   * @throws IndexOutOfBoundsException if <code>beforeIndex</code> is out of
   *           range
   */
  @Override
  public void insert(Widget w, int beforeIndex) {
    insert(w, getElement(), beforeIndex, true);
  }

  private AnchorElement getAnchorElement() {
    return AnchorElement.as(getElement());
  }

}
