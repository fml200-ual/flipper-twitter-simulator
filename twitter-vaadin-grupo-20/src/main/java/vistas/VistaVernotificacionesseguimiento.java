package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;

@Tag("vista-vernotificacionesseguimiento")
@JsModule("./views/vista-vernotificacionesseguimiento.ts")
public class VistaVernotificacionesseguimiento extends LitTemplate {

	@Id("notification-list-seguimiento")
	private Div notificationListSeguimiento;

	public VistaVernotificacionesseguimiento() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getNotificationListSeguimiento() {
		return notificationListSeguimiento;
	}

	protected void setNotificationListSeguimiento(Div notificationListSeguimiento) {
		this.notificationListSeguimiento = notificationListSeguimiento;
	}

}