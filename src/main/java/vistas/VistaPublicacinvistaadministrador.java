package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.NativeButton;

@Tag("vista-publicacinvistaadministrador")
@JsModule("./views/vista-publicacinvistaadministrador.ts")
public class VistaPublicacinvistaadministrador extends LitTemplate {

	@Id("publicacionContenedorRaiz")
	private Element publicacionContenedorRaiz;
	@Id("cabeceraPrincipal")
	private HorizontalLayout cabeceraPrincipal;
	@Id("avatarPrincipalContenedor")
	private Div avatarPrincipalContenedor;
	@Id("imagenAvatarPrincipal")
	private Image imagenAvatarPrincipal;
	@Id("infoUsuarioPrincipalContenedor")
	private Element infoUsuarioPrincipalContenedor;
	@Id("nombreUsuarioPrincipal")
	private Span nombreUsuarioPrincipal;
	@Id("handleUsuarioPrincipal")
	private Span handleUsuarioPrincipal;
	@Id("contenidoPrincipalContenedor")
	private Div contenidoPrincipalContenedor;
	@Id("textoPublicacionPrincipal")
	private Paragraph textoPublicacionPrincipal;
	@Id("publicacionCitadaContenedor")
	private Element publicacionCitadaContenedor;
	@Id("cabeceraCitada")
	private HorizontalLayout cabeceraCitada;
	@Id("avatarCitadoContenedor")
	private Div avatarCitadoContenedor;
	@Id("infoUsuarioCitadoContenedor")
	private Element infoUsuarioCitadoContenedor;
	@Id("imagenAvatarCitado")
	private Image imagenAvatarCitado;
	@Id("nombreUsuarioCitado")
	private Span nombreUsuarioCitado;
	@Id("handleUsuarioCitado")
	private Span handleUsuarioCitado;
	@Id("contenidoCitadoContenedor")
	private Div contenidoCitadoContenedor;
	@Id("piePublicacionContenedor")
	private HorizontalLayout piePublicacionContenedor;
	@Id("fechaPublicacionSpan")
	private Span fechaPublicacionSpan;
	@Id("textoPublicacionCitada")
	private Paragraph textoPublicacionCitada;
	@Id("iconoRetweet")
	private Span iconoRetweet;
	@Id("accionesContenedor")
	private HorizontalLayout accionesContenedor;
	@Id("botonAccionY")
	private NativeButton botonAccionY;
	@Id("contadorRetweet")
	private Span contadorRetweet;
	@Id("botonAccionX")
	private NativeButton botonAccionX;
	@Id("botonAccionComentario")
	private NativeButton botonAccionComentario;
	@Id("iconoComentario")
	private Span iconoComentario;
	@Id("contadorComentario")
	private Span contadorComentario;
	@Id("botonEliminarInferior")
	private NativeButton botonEliminarInferior;

	public VistaPublicacinvistaadministrador() {
		// You can initialise any data required for the connected UI components here.
	}

	private Element getPublicacionContenedorRaiz() {
		return publicacionContenedorRaiz;
	}

	private void setPublicacionContenedorRaiz(Element publicacionContenedorRaiz) {
		this.publicacionContenedorRaiz = publicacionContenedorRaiz;
	}

	private HorizontalLayout getCabeceraPrincipal() {
		return cabeceraPrincipal;
	}

	private void setCabeceraPrincipal(HorizontalLayout cabeceraPrincipal) {
		this.cabeceraPrincipal = cabeceraPrincipal;
	}

	private Div getAvatarPrincipalContenedor() {
		return avatarPrincipalContenedor;
	}

	private void setAvatarPrincipalContenedor(Div avatarPrincipalContenedor) {
		this.avatarPrincipalContenedor = avatarPrincipalContenedor;
	}

	private Image getImagenAvatarPrincipal() {
		return imagenAvatarPrincipal;
	}

	private void setImagenAvatarPrincipal(Image imagenAvatarPrincipal) {
		this.imagenAvatarPrincipal = imagenAvatarPrincipal;
	}

	private Element getInfoUsuarioPrincipalContenedor() {
		return infoUsuarioPrincipalContenedor;
	}

	private void setInfoUsuarioPrincipalContenedor(Element infoUsuarioPrincipalContenedor) {
		this.infoUsuarioPrincipalContenedor = infoUsuarioPrincipalContenedor;
	}

	private Span getNombreUsuarioPrincipal() {
		return nombreUsuarioPrincipal;
	}

	private void setNombreUsuarioPrincipal(Span nombreUsuarioPrincipal) {
		this.nombreUsuarioPrincipal = nombreUsuarioPrincipal;
	}

	private Span getHandleUsuarioPrincipal() {
		return handleUsuarioPrincipal;
	}

	private void setHandleUsuarioPrincipal(Span handleUsuarioPrincipal) {
		this.handleUsuarioPrincipal = handleUsuarioPrincipal;
	}

	private Div getContenidoPrincipalContenedor() {
		return contenidoPrincipalContenedor;
	}

	private void setContenidoPrincipalContenedor(Div contenidoPrincipalContenedor) {
		this.contenidoPrincipalContenedor = contenidoPrincipalContenedor;
	}

	private Paragraph getTextoPublicacionPrincipal() {
		return textoPublicacionPrincipal;
	}

	private void setTextoPublicacionPrincipal(Paragraph textoPublicacionPrincipal) {
		this.textoPublicacionPrincipal = textoPublicacionPrincipal;
	}

	protected Element getPublicacionCitadaContenedor() {
		return publicacionCitadaContenedor;
	}

	private void setPublicacionCitadaContenedor(Element publicacionCitadaContenedor) {
		this.publicacionCitadaContenedor = publicacionCitadaContenedor;
	}

	private HorizontalLayout getCabeceraCitada() {
		return cabeceraCitada;
	}

	private void setCabeceraCitada(HorizontalLayout cabeceraCitada) {
		this.cabeceraCitada = cabeceraCitada;
	}

	private Div getAvatarCitadoContenedor() {
		return avatarCitadoContenedor;
	}

	private void setAvatarCitadoContenedor(Div avatarCitadoContenedor) {
		this.avatarCitadoContenedor = avatarCitadoContenedor;
	}

	private Element getInfoUsuarioCitadoContenedor() {
		return infoUsuarioCitadoContenedor;
	}

	private void setInfoUsuarioCitadoContenedor(Element infoUsuarioCitadoContenedor) {
		this.infoUsuarioCitadoContenedor = infoUsuarioCitadoContenedor;
	}

	private Image getImagenAvatarCitado() {
		return imagenAvatarCitado;
	}

	private void setImagenAvatarCitado(Image imagenAvatarCitado) {
		this.imagenAvatarCitado = imagenAvatarCitado;
	}

	private Span getNombreUsuarioCitado() {
		return nombreUsuarioCitado;
	}

	private void setNombreUsuarioCitado(Span nombreUsuarioCitado) {
		this.nombreUsuarioCitado = nombreUsuarioCitado;
	}

	private Span getHandleUsuarioCitado() {
		return handleUsuarioCitado;
	}

	private void setHandleUsuarioCitado(Span handleUsuarioCitado) {
		this.handleUsuarioCitado = handleUsuarioCitado;
	}

	private Div getContenidoCitadoContenedor() {
		return contenidoCitadoContenedor;
	}

	private void setContenidoCitadoContenedor(Div contenidoCitadoContenedor) {
		this.contenidoCitadoContenedor = contenidoCitadoContenedor;
	}

	private HorizontalLayout getPiePublicacionContenedor() {
		return piePublicacionContenedor;
	}

	private void setPiePublicacionContenedor(HorizontalLayout piePublicacionContenedor) {
		this.piePublicacionContenedor = piePublicacionContenedor;
	}

	private Span getFechaPublicacionSpan() {
		return fechaPublicacionSpan;
	}

	private void setFechaPublicacionSpan(Span fechaPublicacionSpan) {
		this.fechaPublicacionSpan = fechaPublicacionSpan;
	}

	private Paragraph getTextoPublicacionCitada() {
		return textoPublicacionCitada;
	}

	private void setTextoPublicacionCitada(Paragraph textoPublicacionCitada) {
		this.textoPublicacionCitada = textoPublicacionCitada;
	}

	private Span getIconoRetweet() {
		return iconoRetweet;
	}

	private void setIconoRetweet(Span iconoRetweet) {
		this.iconoRetweet = iconoRetweet;
	}

	private HorizontalLayout getAccionesContenedor() {
		return accionesContenedor;
	}

	private void setAccionesContenedor(HorizontalLayout accionesContenedor) {
		this.accionesContenedor = accionesContenedor;
	}

	protected NativeButton getBotonAccionY() {
		return botonAccionY;
	}

	private void setBotonAccionY(NativeButton botonAccionY) {
		this.botonAccionY = botonAccionY;
	}

	private Span getContadorRetweet() {
		return contadorRetweet;
	}

	private void setContadorRetweet(Span contadorRetweet) {
		this.contadorRetweet = contadorRetweet;
	}

	private NativeButton getBotonAccionX() {
		return botonAccionX;
	}

	private void setBotonAccionX(NativeButton botonAccionX) {
		this.botonAccionX = botonAccionX;
	}

	protected NativeButton getBotonAccionComentario() {
		return botonAccionComentario;
	}

	private void setBotonAccionComentario(NativeButton botonAccionComentario) {
		this.botonAccionComentario = botonAccionComentario;
	}

	private Span getIconoComentario() {
		return iconoComentario;
	}

	private void setIconoComentario(Span iconoComentario) {
		this.iconoComentario = iconoComentario;
	}

	private Span getContadorComentario() {
		return contadorComentario;
	}

	private void setContadorComentario(Span contadorComentario) {
		this.contadorComentario = contadorComentario;
	}

	protected NativeButton getBotonEliminarInferior() {
		return botonEliminarInferior;
	}

	private void setBotonEliminarInferior(NativeButton botonEliminarInferior) {
		this.botonEliminarInferior = botonEliminarInferior;
	}

}