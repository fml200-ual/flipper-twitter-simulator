package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.dom.Element;

@Tag("vista-vernotificacionesderetweets")
@JsModule("./views/vista-vernotificacionesderetweets.ts")
public class VistaVernotificacionesderetweets extends LitTemplate {

	@Id("wrapper_retweets")
	private Div wrapper_retweets;
	@Id("titulo_notificaciones_retweets")
	private H1 titulo_notificaciones_retweets;
	@Id("contenedor_botones_retweets")
	private Div contenedor_botones_retweets;
	@Id("boton_seguimiento_retweets")
	private NativeButton boton_seguimiento_retweets;
	@Id("boton_menciones_retweets")
	private NativeButton boton_menciones_retweets;
	@Id("boton_retweets_retweets")
	private NativeButton boton_retweets_retweets;
	@Id("notification-list-retweets")
	private Div notificationListRetweets;
	@Id("enlace_mostrar_mas_retweets")
	private Element enlace_mostrar_mas_retweets;

	public VistaVernotificacionesderetweets() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getWrapper_retweets() {
		return wrapper_retweets;
	}

	protected void setWrapper_retweets(Div wrapper_retweets) {
		this.wrapper_retweets = wrapper_retweets;
	}

	protected H1 getTitulo_notificaciones_retweets() {
		return titulo_notificaciones_retweets;
	}

	protected void setTitulo_notificaciones_retweets(H1 titulo_notificaciones_retweets) {
		this.titulo_notificaciones_retweets = titulo_notificaciones_retweets;
	}

	protected Div getContenedor_botones_retweets() {
		return contenedor_botones_retweets;
	}

	protected void setContenedor_botones_retweets(Div contenedor_botones_retweets) {
		this.contenedor_botones_retweets = contenedor_botones_retweets;
	}

	protected NativeButton getBoton_seguimiento_retweets() {
		return boton_seguimiento_retweets;
	}

	protected void setBoton_seguimiento_retweets(NativeButton boton_seguimiento_retweets) {
		this.boton_seguimiento_retweets = boton_seguimiento_retweets;
	}

	protected NativeButton getBoton_menciones_retweets() {
		return boton_menciones_retweets;
	}

	protected void setBoton_menciones_retweets(NativeButton boton_menciones_retweets) {
		this.boton_menciones_retweets = boton_menciones_retweets;
	}

	protected NativeButton getBoton_retweets_retweets() {
		return boton_retweets_retweets;
	}

	protected void setBoton_retweets_retweets(NativeButton boton_retweets_retweets) {
		this.boton_retweets_retweets = boton_retweets_retweets;
	}

	protected Div getNotificationListRetweets() {
		return notificationListRetweets;
	}

	protected void setNotificationListRetweets(Div notificationListRetweets) {
		this.notificationListRetweets = notificationListRetweets;
	}

	protected Element getEnlace_mostrar_mas_retweets() {
		return enlace_mostrar_mas_retweets;
	}

	protected void setEnlace_mostrar_mas_retweets(Element enlace_mostrar_mas_retweets) {
		this.enlace_mostrar_mas_retweets = enlace_mostrar_mas_retweets;
	}

}