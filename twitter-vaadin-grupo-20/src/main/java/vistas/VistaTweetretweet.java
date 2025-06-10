package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;

@Tag("vista-tweetretweet")
@JsModule("./views/vista-tweetretweet.ts")
public class VistaTweetretweet extends LitTemplate {

    public Div getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(Div mainLayout) {
		this.mainLayout = mainLayout;
	}

	public HorizontalLayout getCabeceraPrincipal() {
		return cabeceraPrincipal;
	}

	public void setCabeceraPrincipal(HorizontalLayout cabeceraPrincipal) {
		this.cabeceraPrincipal = cabeceraPrincipal;
	}

	public Element getContendorNombreArroba() {
		return contendorNombreArroba;
	}

	public void setContendorNombreArroba(Element contendorNombreArroba) {
		this.contendorNombreArroba = contendorNombreArroba;
	}

	public Span getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(Span nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Span getArrobaUsuario() {
		return arrobaUsuario;
	}

	public void setArrobaUsuario(Span arrobaUsuario) {
		this.arrobaUsuario = arrobaUsuario;
	}

	public NativeButton getBotonEliminarTweet() {
		return botonEliminarTweet;
	}

	public void setBotonEliminarTweet(NativeButton botonEliminarTweet) {
		this.botonEliminarTweet = botonEliminarTweet;
	}

	public Div getContenidoTweet() {
		return contenidoTweet;
	}

	public void setContenidoTweet(Div contenidoTweet) {
		this.contenidoTweet = contenidoTweet;
	}

	public Paragraph getTextoPublicacion() {
		return textoPublicacion;
	}

	public void setTextoPublicacion(Paragraph textoPublicacion) {
		this.textoPublicacion = textoPublicacion;
	}

	public Element getContenedorPublicacionCitada() {
		return contenedorPublicacionCitada;
	}

	public void setContenedorPublicacionCitada(Element contenedorPublicacionCitada) {
		this.contenedorPublicacionCitada = contenedorPublicacionCitada;
	}

	public HorizontalLayout getCabeceraPublicacionCitada() {
		return cabeceraPublicacionCitada;
	}

	public void setCabeceraPublicacionCitada(HorizontalLayout cabeceraPublicacionCitada) {
		this.cabeceraPublicacionCitada = cabeceraPublicacionCitada;
	}

	public Div getDiv() {
		return div;
	}

	public void setDiv(Div div) {
		this.div = div;
	}

	public Image getImg1() {
		return img1;
	}

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

	public Span getNombreUsuarioCitado() {
		return nombreUsuarioCitado;
	}

	public void setNombreUsuarioCitado(Span nombreUsuarioCitado) {
		this.nombreUsuarioCitado = nombreUsuarioCitado;
	}

	public Element getContenedorDatosUsuarioCitado() {
		return contenedorDatosUsuarioCitado;
	}

	public void setContenedorDatosUsuarioCitado(Element contenedorDatosUsuarioCitado) {
		this.contenedorDatosUsuarioCitado = contenedorDatosUsuarioCitado;
	}

	public Span getArrobaUsuarioCitado() {
		return arrobaUsuarioCitado;
	}

	public void setArrobaUsuarioCitado(Span arrobaUsuarioCitado) {
		this.arrobaUsuarioCitado = arrobaUsuarioCitado;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Div getDiv1() {
		return div1;
	}

	public void setDiv1(Div div1) {
		this.div1 = div1;
	}

	public Paragraph getTextoPublicacionCitada() {
		return textoPublicacionCitada;
	}

	public void setTextoPublicacionCitada(Paragraph textoPublicacionCitada) {
		this.textoPublicacionCitada = textoPublicacionCitada;
	}

	public Div getDiv2() {
		return div2;
	}

	public void setDiv2(Div div2) {
		this.div2 = div2;
	}

	public Span getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Span fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Div getDiv3() {
		return div3;
	}

	public void setDiv3(Div div3) {
		this.div3 = div3;
	}

	public Icon getIconoMeGusta() {
		return iconoMeGusta;
	}

	public void setIconoMeGusta(Icon iconoMeGusta) {
		this.iconoMeGusta = iconoMeGusta;
	}

	public Span getNumMegusta() {
		return numMegusta;
	}

	public void setNumMegusta(Span numMegusta) {
		this.numMegusta = numMegusta;
	}

	public Span getNumeroRetweets() {
		return numeroRetweets;
	}

	public void setNumeroRetweets(Span numeroRetweets) {
		this.numeroRetweets = numeroRetweets;
	}

	public Icon getIconoRetweet() {
		return iconoRetweet;
	}

	public void setIconoRetweet(Icon iconoRetweet) {
		this.iconoRetweet = iconoRetweet;
	}

	public Span getNumeroRetweets1() {
		return numeroRetweets1;
	}

	public void setNumeroRetweets1(Span numeroRetweets1) {
		this.numeroRetweets1 = numeroRetweets1;
	}

	public Icon getIconoComentarios() {
		return iconoComentarios;
	}

	public void setIconoComentarios(Icon iconoComentarios) {
		this.iconoComentarios = iconoComentarios;
	}

	public Element getMostrarMasComentarios() {
		return mostrarMasComentarios;
	}

	public void setMostrarMasComentarios(Element mostrarMasComentarios) {
		this.mostrarMasComentarios = mostrarMasComentarios;
	}

	public Div getDiv4() {
		return div4;
	}

	public void setDiv4(Div div4) {
		this.div4 = div4;
	}

	public Div getDivAvatar() {
		return divAvatar;
	}

	public void setDivAvatar(Div divAvatar) {
		this.divAvatar = divAvatar;
	}

	public Element getMainVerticalLayout() {
		return mainVerticalLayout;
	}

	public void setMainVerticalLayout(Element mainVerticalLayout) {
		this.mainVerticalLayout = mainVerticalLayout;
	}

	@Id("mainLayout")
	private Div mainLayout;
	@Id("cabeceraPrincipal")
	private HorizontalLayout cabeceraPrincipal;
	@Id("contendorNombreArroba")
	private Element contendorNombreArroba;
	@Id("nombreUsuario")
	private Span nombreUsuario;
	@Id("arrobaUsuario")
	private Span arrobaUsuario;
	@Id("botonEliminarTweet")
	private NativeButton botonEliminarTweet;
	@Id("contenidoTweet")
	private Div contenidoTweet;
	@Id("textoPublicacion")
	private Paragraph textoPublicacion;
	@Id("contenedorPublicacionCitada")
	private Element contenedorPublicacionCitada;
	@Id("cabeceraPublicacionCitada")
	private HorizontalLayout cabeceraPublicacionCitada;
	@Id("div")
	private Div div;
	@Id("img1")
	private Image img1;
	@Id("nombreUsuarioCitado")
	private Span nombreUsuarioCitado;
	@Id("contenedorDatosUsuarioCitado")
	private Element contenedorDatosUsuarioCitado;
	@Id("arrobaUsuarioCitado")
	private Span arrobaUsuarioCitado;
	@Id("img")
	private Image img;
	@Id("div1")
	private Div div1;
	@Id("textoPublicacionCitada")
	private Paragraph textoPublicacionCitada;
	@Id("div2")
	private Div div2;
	@Id("fechaPublicacion")
	private Span fechaPublicacion;
	@Id("div3")
	private Div div3;
	@Id("iconoMeGusta")
	private Icon iconoMeGusta;
	@Id("numMegusta")
	private Span numMegusta;
	@Id("numeroRetweets")
	private Span numeroRetweets;
	@Id("iconoRetweet")
	private Icon iconoRetweet;
	@Id("numeroRetweets1")
	private Span numeroRetweets1;
	@Id("iconoComentarios")
	private Icon iconoComentarios;
	@Id("mostrarMasComentarios")
	private Element mostrarMasComentarios;
	@Id("div4")
	private Div div4;
	@Id("divAvatar")
	private Div divAvatar;
	@Id("mainVerticalLayout")
	private Element mainVerticalLayout;

	public VistaTweetretweet() {
        // You can initialise any data required for the connected UI components here.
    }

}