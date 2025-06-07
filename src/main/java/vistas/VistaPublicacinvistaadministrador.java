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
import com.vaadin.flow.component.icon.Icon;

@Tag("vista-publicacinvistaadministrador")
@JsModule("./views/vista-publicacinvistaadministrador.ts")
public class VistaPublicacinvistaadministrador extends LitTemplate {

	@Id("contenedorPrincipal")
	private Div contenedorPrincipal;
	@Id("layoutPublicacionPrincipal")
	private Element layoutPublicacionPrincipal;
	@Id("cabeceraPublicacion")
	private HorizontalLayout cabeceraPublicacion;
	@Id("imgAvatarPrincipal")
	private Image imgAvatarPrincipal;
	@Id("avatarDivPrincipal")
	private Div avatarDivPrincipal;
	@Id("layoutInfoUsuario")
	private Element layoutInfoUsuario;
	@Id("spanNombreUsuario")
	private Span spanNombreUsuario;
	@Id("spanHandleUsuario")
	private Span spanHandleUsuario;
	@Id("divContenido")
	private Div divContenido;
	@Id("pTextoPublicacion")
	private Paragraph pTextoPublicacion;
	@Id("layoutPublicacionCitada")
	private Element layoutPublicacionCitada;
	@Id("cabeceraCitada")
	private HorizontalLayout cabeceraCitada;
	@Id("avatarDivCitado")
	private Div avatarDivCitado;
	@Id("imgAvatarCitado")
	private Image imgAvatarCitado;
	@Id("layoutInfoUsuarioCitado")
	private Element layoutInfoUsuarioCitado;
	@Id("spanNombreUsuarioCitado")
	private Span spanNombreUsuarioCitado;
	@Id("spanHandleUsuarioCitado")
	private Span spanHandleUsuarioCitado;
	@Id("divContenidoCitado")
	private Div divContenidoCitado;
	@Id("pTextoPublicacionCitada")
	private Paragraph pTextoPublicacionCitada;
	@Id("divPieDePublicacion")
	private Div divPieDePublicacion;
	@Id("spanFecha")
	private Span spanFecha;
	@Id("divAcciones")
	private Div divAcciones;
	@Id("spanContadorMeGusta")
	private Span spanContadorMeGusta;
	@Id("iconoMeGusta")
	private Icon iconoMeGusta;
	@Id("spanContadorRetweet")
	private Span spanContadorRetweet;
	@Id("iconoRetweet")
	private Icon iconoRetweet;
	@Id("botonEliminarTweet")
	private NativeButton botonEliminarTweet;
	@Id("spanContadorComentarios")
	private Span spanContadorComentarios;
	@Id("iconoComentar")
	private Icon iconoComentar;
	@Id("contenedorComentarios")
	private Div contenedorComentarios;
	@Id("itemListaHashtags")
	private Element itemListaHashtags;
	@Id("linkMostrarMas")
	private Element linkMostrarMas;

	public VistaPublicacinvistaadministrador() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getContenedorPrincipal() {
		return contenedorPrincipal;
	}

	protected void setContenedorPrincipal(Div contenedorPrincipal) {
		this.contenedorPrincipal = contenedorPrincipal;
	}

	protected Element getLayoutPublicacionPrincipal() {
		return layoutPublicacionPrincipal;
	}

	protected void setLayoutPublicacionPrincipal(Element layoutPublicacionPrincipal) {
		this.layoutPublicacionPrincipal = layoutPublicacionPrincipal;
	}

	protected HorizontalLayout getCabeceraPublicacion() {
		return cabeceraPublicacion;
	}

	protected void setCabeceraPublicacion(HorizontalLayout cabeceraPublicacion) {
		this.cabeceraPublicacion = cabeceraPublicacion;
	}

	protected Image getImgAvatarPrincipal() {
		return imgAvatarPrincipal;
	}

	protected void setImgAvatarPrincipal(Image imgAvatarPrincipal) {
		this.imgAvatarPrincipal = imgAvatarPrincipal;
	}

	protected Div getAvatarDivPrincipal() {
		return avatarDivPrincipal;
	}

	protected void setAvatarDivPrincipal(Div avatarDivPrincipal) {
		this.avatarDivPrincipal = avatarDivPrincipal;
	}

	protected Element getLayoutInfoUsuario() {
		return layoutInfoUsuario;
	}

	protected void setLayoutInfoUsuario(Element layoutInfoUsuario) {
		this.layoutInfoUsuario = layoutInfoUsuario;
	}

	protected Span getSpanNombreUsuario() {
		return spanNombreUsuario;
	}

	protected void setSpanNombreUsuario(Span spanNombreUsuario) {
		this.spanNombreUsuario = spanNombreUsuario;
	}

	protected Span getSpanHandleUsuario() {
		return spanHandleUsuario;
	}

	protected void setSpanHandleUsuario(Span spanHandleUsuario) {
		this.spanHandleUsuario = spanHandleUsuario;
	}

	protected Div getDivContenido() {
		return divContenido;
	}

	protected void setDivContenido(Div divContenido) {
		this.divContenido = divContenido;
	}

	protected Paragraph getpTextoPublicacion() {
		return pTextoPublicacion;
	}

	protected void setpTextoPublicacion(Paragraph pTextoPublicacion) {
		this.pTextoPublicacion = pTextoPublicacion;
	}

	protected Element getLayoutPublicacionCitada() {
		return layoutPublicacionCitada;
	}

	protected void setLayoutPublicacionCitada(Element layoutPublicacionCitada) {
		this.layoutPublicacionCitada = layoutPublicacionCitada;
	}

	protected HorizontalLayout getCabeceraCitada() {
		return cabeceraCitada;
	}

	protected void setCabeceraCitada(HorizontalLayout cabeceraCitada) {
		this.cabeceraCitada = cabeceraCitada;
	}

	protected Div getAvatarDivCitado() {
		return avatarDivCitado;
	}

	protected void setAvatarDivCitado(Div avatarDivCitado) {
		this.avatarDivCitado = avatarDivCitado;
	}

	protected Image getImgAvatarCitado() {
		return imgAvatarCitado;
	}

	protected void setImgAvatarCitado(Image imgAvatarCitado) {
		this.imgAvatarCitado = imgAvatarCitado;
	}

	protected Element getLayoutInfoUsuarioCitado() {
		return layoutInfoUsuarioCitado;
	}

	protected void setLayoutInfoUsuarioCitado(Element layoutInfoUsuarioCitado) {
		this.layoutInfoUsuarioCitado = layoutInfoUsuarioCitado;
	}

	protected Span getSpanNombreUsuarioCitado() {
		return spanNombreUsuarioCitado;
	}

	protected void setSpanNombreUsuarioCitado(Span spanNombreUsuarioCitado) {
		this.spanNombreUsuarioCitado = spanNombreUsuarioCitado;
	}

	protected Span getSpanHandleUsuarioCitado() {
		return spanHandleUsuarioCitado;
	}

	protected void setSpanHandleUsuarioCitado(Span spanHandleUsuarioCitado) {
		this.spanHandleUsuarioCitado = spanHandleUsuarioCitado;
	}

	protected Div getDivContenidoCitado() {
		return divContenidoCitado;
	}

	protected void setDivContenidoCitado(Div divContenidoCitado) {
		this.divContenidoCitado = divContenidoCitado;
	}

	protected Paragraph getpTextoPublicacionCitada() {
		return pTextoPublicacionCitada;
	}

	protected void setpTextoPublicacionCitada(Paragraph pTextoPublicacionCitada) {
		this.pTextoPublicacionCitada = pTextoPublicacionCitada;
	}

	protected Div getDivPieDePublicacion() {
		return divPieDePublicacion;
	}

	protected void setDivPieDePublicacion(Div divPieDePublicacion) {
		this.divPieDePublicacion = divPieDePublicacion;
	}

	protected Span getSpanFecha() {
		return spanFecha;
	}

	protected void setSpanFecha(Span spanFecha) {
		this.spanFecha = spanFecha;
	}

	protected Div getDivAcciones() {
		return divAcciones;
	}

	protected void setDivAcciones(Div divAcciones) {
		this.divAcciones = divAcciones;
	}

	protected Span getSpanContadorMeGusta() {
		return spanContadorMeGusta;
	}

	protected void setSpanContadorMeGusta(Span spanContadorMeGusta) {
		this.spanContadorMeGusta = spanContadorMeGusta;
	}

	protected Icon getIconoMeGusta() {
		return iconoMeGusta;
	}

	protected void setIconoMeGusta(Icon iconoMeGusta) {
		this.iconoMeGusta = iconoMeGusta;
	}

	protected Span getSpanContadorRetweet() {
		return spanContadorRetweet;
	}

	protected void setSpanContadorRetweet(Span spanContadorRetweet) {
		this.spanContadorRetweet = spanContadorRetweet;
	}

	protected Icon getIconoRetweet() {
		return iconoRetweet;
	}

	protected void setIconoRetweet(Icon iconoRetweet) {
		this.iconoRetweet = iconoRetweet;
	}

	protected NativeButton getBotonEliminarTweet() {
		return botonEliminarTweet;
	}

	protected void setBotonEliminarTweet(NativeButton botonEliminarTweet) {
		this.botonEliminarTweet = botonEliminarTweet;
	}

	protected Span getSpanContadorComentarios() {
		return spanContadorComentarios;
	}

	protected void setSpanContadorComentarios(Span spanContadorComentarios) {
		this.spanContadorComentarios = spanContadorComentarios;
	}

	protected Icon getIconoComentar() {
		return iconoComentar;
	}

	protected void setIconoComentar(Icon iconoComentar) {
		this.iconoComentar = iconoComentar;
	}

	protected Div getContenedorComentarios() {
		return contenedorComentarios;
	}

	protected void setContenedorComentarios(Div contenedorComentarios) {
		this.contenedorComentarios = contenedorComentarios;
	}

	protected Element getItemListaHashtags() {
		return itemListaHashtags;
	}

	protected void setItemListaHashtags(Element itemListaHashtags) {
		this.itemListaHashtags = itemListaHashtags;
	}

	protected Element getLinkMostrarMas() {
		return linkMostrarMas;
	}

	protected void setLinkMostrarMas(Element linkMostrarMas) {
		this.linkMostrarMas = linkMostrarMas;
	}

}