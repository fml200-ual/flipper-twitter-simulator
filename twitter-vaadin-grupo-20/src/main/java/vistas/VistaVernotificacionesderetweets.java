package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;

@Tag("vista-vernotificacionesderetweets")
@JsModule("./views/vista-vernotificacionesderetweets.ts")
public class VistaVernotificacionesderetweets extends LitTemplate {

	@Id("notification-list-retweets")
	private Div notificationListRetweets;

	public VistaVernotificacionesderetweets() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getNotificationListRetweets() {
		return notificationListRetweets;
	}

	protected void setNotificationListRetweets(Div notificationListRetweets) {
		this.notificationListRetweets = notificationListRetweets;
	}

}