package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;

@Tag("vista-vernotificacionesdemenciones")
@JsModule("./views/vista-vernotificacionesdemenciones.ts")
public class VistaVernotificacionesdemenciones extends LitTemplate {

	@Id("notification-list-menciones")
	private Div notificationListMenciones;

	public VistaVernotificacionesdemenciones() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getNotificationListMenciones() {
		return notificationListMenciones;
	}

	protected void setNotificationListMenciones(Div notificationListMenciones) {
		this.notificationListMenciones = notificationListMenciones;
	}

}