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
	@Id("botonVolver")
	private NativeButton botonVolver;
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
	@Id("linkMostrarMas")
	private Element linkMostrarMas;

	public VistaPublicacinvistaadministrador() {
		// You can initialise any data required for the connected UI components here.
	}

	public Div getContenedorPrincipal() {
		return contenedorPrincipal;
	}

	public void setContenedorPrincipal(Div contenedorPrincipal) {
		this.contenedorPrincipal = contenedorPrincipal;
	}

	public NativeButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(NativeButton botonVolver) {
		this.botonVolver = botonVolver;
	}

	public Element getLayoutPublicacionPrincipal() {
		return layoutPublicacionPrincipal;
	}

	public void setLayoutPublicacionPrincipal(Element layoutPublicacionPrincipal) {
		this.layoutPublicacionPrincipal = layoutPublicacionPrincipal;
	}

	public HorizontalLayout getCabeceraPublicacion() {
		return cabeceraPublicacion;
	}

	public void setCabeceraPublicacion(HorizontalLayout cabeceraPublicacion) {
		this.cabeceraPublicacion = cabeceraPublicacion;
	}

	public Image getImgAvatarPrincipal() {
		return imgAvatarPrincipal;
	}

	public void setImgAvatarPrincipal(Image imgAvatarPrincipal) {
		this.imgAvatarPrincipal = imgAvatarPrincipal;
	}

	public Div getAvatarDivPrincipal() {
		return avatarDivPrincipal;
	}

	public void setAvatarDivPrincipal(Div avatarDivPrincipal) {
		this.avatarDivPrincipal = avatarDivPrincipal;
	}

	public Element getLayoutInfoUsuario() {
		return layoutInfoUsuario;
	}

	public void setLayoutInfoUsuario(Element layoutInfoUsuario) {
		this.layoutInfoUsuario = layoutInfoUsuario;
	}

	public Span getSpanNombreUsuario() {
		return spanNombreUsuario;
	}

	public void setSpanNombreUsuario(Span spanNombreUsuario) {
		this.spanNombreUsuario = spanNombreUsuario;
	}

	public Span getSpanHandleUsuario() {
		return spanHandleUsuario;
	}

	public void setSpanHandleUsuario(Span spanHandleUsuario) {
		this.spanHandleUsuario = spanHandleUsuario;
	}

	public Div getDivContenido() {
		return divContenido;
	}

	public void setDivContenido(Div divContenido) {
		this.divContenido = divContenido;
	}

	public Paragraph getPTextoPublicacion() {
		return pTextoPublicacion;
	}

	public void setPTextoPublicacion(Paragraph pTextoPublicacion) {
		this.pTextoPublicacion = pTextoPublicacion;
	}

	public Element getLayoutPublicacionCitada() {
		return layoutPublicacionCitada;
	}

	public void setLayoutPublicacionCitada(Element layoutPublicacionCitada) {
		this.layoutPublicacionCitada = layoutPublicacionCitada;
	}

	public HorizontalLayout getCabeceraCitada() {
		return cabeceraCitada;
	}

	public void setCabeceraCitada(HorizontalLayout cabeceraCitada) {
		this.cabeceraCitada = cabeceraCitada;
	}

	public Div getAvatarDivCitado() {
		return avatarDivCitado;
	}

	public void setAvatarDivCitado(Div avatarDivCitado) {
		this.avatarDivCitado = avatarDivCitado;
	}

	public Image getImgAvatarCitado() {
		return imgAvatarCitado;
	}

	public void setImgAvatarCitado(Image imgAvatarCitado) {
		this.imgAvatarCitado = imgAvatarCitado;
	}

	public Element getLayoutInfoUsuarioCitado() {
		return layoutInfoUsuarioCitado;
	}

	public void setLayoutInfoUsuarioCitado(Element layoutInfoUsuarioCitado) {
		this.layoutInfoUsuarioCitado = layoutInfoUsuarioCitado;
	}

	public Span getSpanNombreUsuarioCitado() {
		return spanNombreUsuarioCitado;
	}

	public void setSpanNombreUsuarioCitado(Span spanNombreUsuarioCitado) {
		this.spanNombreUsuarioCitado = spanNombreUsuarioCitado;
	}

	public Span getSpanHandleUsuarioCitado() {
		return spanHandleUsuarioCitado;
	}

	public void setSpanHandleUsuarioCitado(Span spanHandleUsuarioCitado) {
		this.spanHandleUsuarioCitado = spanHandleUsuarioCitado;
	}

	public Div getDivContenidoCitado() {
		return divContenidoCitado;
	}

	public void setDivContenidoCitado(Div divContenidoCitado) {
		this.divContenidoCitado = divContenidoCitado;
	}

	public Paragraph getPTextoPublicacionCitada() {
		return pTextoPublicacionCitada;
	}

	public void setPTextoPublicacionCitada(Paragraph pTextoPublicacionCitada) {
		this.pTextoPublicacionCitada = pTextoPublicacionCitada;
	}

	public Div getDivPieDePublicacion() {
		return divPieDePublicacion;
	}

	public void setDivPieDePublicacion(Div divPieDePublicacion) {
		this.divPieDePublicacion = divPieDePublicacion;
	}

	public Span getSpanFecha() {
		return spanFecha;
	}

	public void setSpanFecha(Span spanFecha) {
		this.spanFecha = spanFecha;
	}

	public Div getDivAcciones() {
		return divAcciones;
	}

	public void setDivAcciones(Div divAcciones) {
		this.divAcciones = divAcciones;
	}

	public Span getSpanContadorMeGusta() {
		return spanContadorMeGusta;
	}

	public void setSpanContadorMeGusta(Span spanContadorMeGusta) {
		this.spanContadorMeGusta = spanContadorMeGusta;
	}

	public Icon getIconoMeGusta() {
		return iconoMeGusta;
	}

	public void setIconoMeGusta(Icon iconoMeGusta) {
		this.iconoMeGusta = iconoMeGusta;
	}

	public Span getSpanContadorRetweet() {
		return spanContadorRetweet;
	}

	public void setSpanContadorRetweet(Span spanContadorRetweet) {
		this.spanContadorRetweet = spanContadorRetweet;
	}

	public Icon getIconoRetweet() {
		return iconoRetweet;
	}

	public void setIconoRetweet(Icon iconoRetweet) {
		this.iconoRetweet = iconoRetweet;
	}

	public NativeButton getBotonEliminarTweet() {
		return botonEliminarTweet;
	}

	public void setBotonEliminarTweet(NativeButton botonEliminarTweet) {
		this.botonEliminarTweet = botonEliminarTweet;
	}

	public Span getSpanContadorComentarios() {
		return spanContadorComentarios;
	}

	public void setSpanContadorComentarios(Span spanContadorComentarios) {
		this.spanContadorComentarios = spanContadorComentarios;
	}

	public Icon getIconoComentar() {
		return iconoComentar;
	}

	public void setIconoComentar(Icon iconoComentar) {
		this.iconoComentar = iconoComentar;
	}

	public Div getContenedorComentarios() {
		return contenedorComentarios;
	}

	public void setContenedorComentarios(Div contenedorComentarios) {
		this.contenedorComentarios = contenedorComentarios;
	}

	public Element getLinkMostrarMas() {
		return linkMostrarMas;
	}

	public void setLinkMostrarMas(Element linkMostrarMas) {
		this.linkMostrarMas = linkMostrarMas;
	}

}