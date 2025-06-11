package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.dom.Element;

@Tag("vista-vernotificacionesseguimiento")
@JsModule("./views/vista-vernotificacionesseguimiento.ts")
public class VistaVernotificacionesseguimiento extends LitTemplate {

	@Id("wrapper_seguimiento")
	private Div wrapper_seguimiento;
	@Id("titulo_notificaciones_seguimiento")
	private H1 titulo_notificaciones_seguimiento;
	@Id("contenedor_botones_seguimiento")
	private Div contenedor_botones_seguimiento;
	@Id("boton_seguimiento_seguimiento")
	private NativeButton boton_seguimiento_seguimiento;
	@Id("boton_menciones_seguimiento")
	private NativeButton boton_menciones_seguimiento;
	@Id("boton_retweets_seguimiento")
	private NativeButton boton_retweets_seguimiento;
	@Id("notification-list-seguimiento")
	private Div notificationListSeguimiento;
	@Id("enlace_mostrar_mas_seguimiento")
	private Element enlace_mostrar_mas_seguimiento;

	public VistaVernotificacionesseguimiento() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getWrapper_seguimiento() {
		return wrapper_seguimiento;
	}

	protected void setWrapper_seguimiento(Div wrapper_seguimiento) {
		this.wrapper_seguimiento = wrapper_seguimiento;
	}

	protected H1 getTitulo_notificaciones_seguimiento() {
		return titulo_notificaciones_seguimiento;
	}

	protected void setTitulo_notificaciones_seguimiento(H1 titulo_notificaciones_seguimiento) {
		this.titulo_notificaciones_seguimiento = titulo_notificaciones_seguimiento;
	}

	protected Div getContenedor_botones_seguimiento() {
		return contenedor_botones_seguimiento;
	}

	protected void setContenedor_botones_seguimiento(Div contenedor_botones_seguimiento) {
		this.contenedor_botones_seguimiento = contenedor_botones_seguimiento;
	}

	protected NativeButton getBoton_seguimiento_seguimiento() {
		return boton_seguimiento_seguimiento;
	}

	protected void setBoton_seguimiento_seguimiento(NativeButton boton_seguimiento_seguimiento) {
		this.boton_seguimiento_seguimiento = boton_seguimiento_seguimiento;
	}

	protected NativeButton getBoton_menciones_seguimiento() {
		return boton_menciones_seguimiento;
	}

	protected void setBoton_menciones_seguimiento(NativeButton boton_menciones_seguimiento) {
		this.boton_menciones_seguimiento = boton_menciones_seguimiento;
	}

	protected NativeButton getBoton_retweets_seguimiento() {
		return boton_retweets_seguimiento;
	}

	protected void setBoton_retweets_seguimiento(NativeButton boton_retweets_seguimiento) {
		this.boton_retweets_seguimiento = boton_retweets_seguimiento;
	}

	protected Div getNotificationListSeguimiento() {
		return notificationListSeguimiento;
	}

	protected void setNotificationListSeguimiento(Div notificationListSeguimiento) {
		this.notificationListSeguimiento = notificationListSeguimiento;
	}

	protected Element getEnlace_mostrar_mas_seguimiento() {
		return enlace_mostrar_mas_seguimiento;
	}

	protected void setEnlace_mostrar_mas_seguimiento(Element enlace_mostrar_mas_seguimiento) {
		this.enlace_mostrar_mas_seguimiento = enlace_mostrar_mas_seguimiento;
	}

}