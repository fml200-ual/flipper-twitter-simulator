package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.dom.Element;

@Tag("vista-vernotificacionesdemenciones")
@JsModule("./views/vista-vernotificacionesdemenciones.ts")
public class VistaVernotificacionesdemenciones extends LitTemplate {

	@Id("wrapper_menciones")
	private Div wrapper_menciones;
	@Id("titulo_notificaciones")
	private H1 titulo_notificaciones;
	@Id("contenedor_botones")
	private Div contenedor_botones;
	@Id("boton_seguimiento")
	private NativeButton boton_seguimiento;
	@Id("boton_menciones")
	private NativeButton boton_menciones;
	@Id("boton_retweets")
	private NativeButton boton_retweets;
	@Id("notification-list")
	private Div notificationList;
	@Id("enlace_mostrar_mas")
	private Element enlace_mostrar_mas;

	public VistaVernotificacionesdemenciones() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getWrapper_menciones() {
		return wrapper_menciones;
	}

	protected void setWrapper_menciones(Div wrapper_menciones) {
		this.wrapper_menciones = wrapper_menciones;
	}

	protected H1 getTitulo_notificaciones() {
		return titulo_notificaciones;
	}

	protected void setTitulo_notificaciones(H1 titulo_notificaciones) {
		this.titulo_notificaciones = titulo_notificaciones;
	}

	protected Div getContenedor_botones() {
		return contenedor_botones;
	}

	protected void setContenedor_botones(Div contenedor_botones) {
		this.contenedor_botones = contenedor_botones;
	}

	protected NativeButton getBoton_seguimiento() {
		return boton_seguimiento;
	}

	protected void setBoton_seguimiento(NativeButton boton_seguimiento) {
		this.boton_seguimiento = boton_seguimiento;
	}

	protected NativeButton getBoton_menciones() {
		return boton_menciones;
	}

	protected void setBoton_menciones(NativeButton boton_menciones) {
		this.boton_menciones = boton_menciones;
	}

	protected NativeButton getBoton_retweets() {
		return boton_retweets;
	}

	protected void setBoton_retweets(NativeButton boton_retweets) {
		this.boton_retweets = boton_retweets;
	}

	protected Div getNotificationList() {
		return notificationList;
	}

	protected void setNotificationList(Div notificationList) {
		this.notificationList = notificationList;
	}

	protected Element getEnlace_mostrar_mas() {
		return enlace_mostrar_mas;
	}

	protected void setEnlace_mostrar_mas(Element enlace_mostrar_mas) {
		this.enlace_mostrar_mas = enlace_mostrar_mas;
	}

}