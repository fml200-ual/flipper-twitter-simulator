package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

@Tag("vista-act06sesininiciada")
@JsModule("./views/vista-act06sesininiciada.ts")
public class VistaAct06sesininiciada extends LitTemplate {

	@Id("horizontalLayoutPrincipalSesionIniciada")
	private HorizontalLayout horizontalLayoutPrincipalSesionIniciada;
	@Id("verticalLayoutIzquierdoSesionIniciada")
	private Element verticalLayoutIzquierdoSesionIniciada;
	@Id("verticalLayoutImagenAdministrador")
	private Element verticalLayoutImagenAdministrador;
	@Id("imagenAdministrador")
	private Image imagenAdministrador;
	@Id("horizontalLayoutBotonesSesionIniciada")
	private HorizontalLayout horizontalLayoutBotonesSesionIniciada;
	@Id("botonPerfilPropioRegistrado")
	private Button botonPerfilPropioRegistrado;
	@Id("botonCerrarSesionPrimerBoton")
	private Button botonCerrarSesionPrimerBoton;
	@Id("verticalLayoutListaUsuarios")
	private Element verticalLayoutListaUsuarios;
	@Id("botonMasUsuarios")
	private Button botonMasUsuarios;
	@Id("verticalLayoutCentralSesionIniciada")
	private Element verticalLayoutCentralSesionIniciada;
	@Id("verticalLayoutImagenRegistrado")
	private Element verticalLayoutImagenRegistrado;
	@Id("imagenIconoCentral")
	private Image imagenIconoCentral;
	@Id("spanRecomendadoParaTi")
	private Span spanRecomendadoParaTi;
	@Id("spanListaTweetsRecientes")
	private Span spanListaTweetsRecientes;
	@Id("verticalLayoutListaTweets")
	private Element verticalLayoutListaTweets;
	@Id("botonEscribirTweet")
	private Button botonEscribirTweet;
	@Id("verticalLayoutDerechoSesionIniciada")
	private Element verticalLayoutDerechoSesionIniciada;
	@Id("botonNotificacionesRegistrado")
	private Button botonNotificacionesRegistrado;
	@Id("verticalLayoutListaHashtagsSesionIniciada")
	private Element verticalLayoutListaHashtagsSesionIniciada;
	@Id("botonMasHashtags")
	private Button botonMasHashtags;

	public VistaAct06sesininiciada() {
		// You can initialise any data required for the connected UI components here.
	}

	public HorizontalLayout getHorizontalLayoutPrincipalSesionIniciada() {
		return horizontalLayoutPrincipalSesionIniciada;
	}

	public void setHorizontalLayoutPrincipalSesionIniciada(HorizontalLayout horizontalLayoutPrincipalSesionIniciada) {
		this.horizontalLayoutPrincipalSesionIniciada = horizontalLayoutPrincipalSesionIniciada;
	}

	public Element getVerticalLayoutIzquierdoSesionIniciada() {
		return verticalLayoutIzquierdoSesionIniciada;
	}

	public void setVerticalLayoutIzquierdoSesionIniciada(Element verticalLayoutIzquierdoSesionIniciada) {
		this.verticalLayoutIzquierdoSesionIniciada = verticalLayoutIzquierdoSesionIniciada;
	}

	public Element getVerticalLayoutImagenAdministrador() {
		return verticalLayoutImagenAdministrador;
	}

	public void setVerticalLayoutImagenAdministrador(Element verticalLayoutImagenAdministrador) {
		this.verticalLayoutImagenAdministrador = verticalLayoutImagenAdministrador;
	}

	public Image getImagenAdministrador() {
		return imagenAdministrador;
	}

	public void setImagenAdministrador(Image imagenAdministrador) {
		this.imagenAdministrador = imagenAdministrador;
	}

	public HorizontalLayout getHorizontalLayoutBotonesSesionIniciada() {
		return horizontalLayoutBotonesSesionIniciada;
	}

	public void setHorizontalLayoutBotonesSesionIniciada(HorizontalLayout horizontalLayoutBotonesSesionIniciada) {
		this.horizontalLayoutBotonesSesionIniciada = horizontalLayoutBotonesSesionIniciada;
	}

	public Button getBotonPerfilPropioRegistrado() {
		return botonPerfilPropioRegistrado;
	}

	public void setBotonPerfilPropioRegistrado(Button botonPerfilPropioRegistrado) {
		this.botonPerfilPropioRegistrado = botonPerfilPropioRegistrado;
	}

	public Button getBotonCerrarSesionPrimerBoton() {
		return botonCerrarSesionPrimerBoton;
	}

	public void setBotonCerrarSesionPrimerBoton(Button botonCerrarSesionPrimerBoton) {
		this.botonCerrarSesionPrimerBoton = botonCerrarSesionPrimerBoton;
	}

	public Element getVerticalLayoutListaUsuarios() {
		return verticalLayoutListaUsuarios;
	}

	public void setVerticalLayoutListaUsuarios(Element verticalLayoutListaUsuarios) {
		this.verticalLayoutListaUsuarios = verticalLayoutListaUsuarios;
	}

	public Button getBotonMasUsuarios() {
		return botonMasUsuarios;
	}

	public void setBotonMasUsuarios(Button botonMasUsuarios) {
		this.botonMasUsuarios = botonMasUsuarios;
	}

	public Element getVerticalLayoutCentralSesionIniciada() {
		return verticalLayoutCentralSesionIniciada;
	}

	public void setVerticalLayoutCentralSesionIniciada(Element verticalLayoutCentralSesionIniciada) {
		this.verticalLayoutCentralSesionIniciada = verticalLayoutCentralSesionIniciada;
	}

	public Element getVerticalLayoutImagenRegistrado() {
		return verticalLayoutImagenRegistrado;
	}

	public void setVerticalLayoutImagenRegistrado(Element verticalLayoutImagenRegistrado) {
		this.verticalLayoutImagenRegistrado = verticalLayoutImagenRegistrado;
	}

	public Image getImagenIconoCentral() {
		return imagenIconoCentral;
	}

	public void setImagenIconoCentral(Image imagenIconoCentral) {
		this.imagenIconoCentral = imagenIconoCentral;
	}

	public Span getSpanRecomendadoParaTi() {
		return spanRecomendadoParaTi;
	}

	public void setSpanRecomendadoParaTi(Span spanRecomendadoParaTi) {
		this.spanRecomendadoParaTi = spanRecomendadoParaTi;
	}

	public Span getSpanListaTweetsRecientes() {
		return spanListaTweetsRecientes;
	}

	public void setSpanListaTweetsRecientes(Span spanListaTweetsRecientes) {
		this.spanListaTweetsRecientes = spanListaTweetsRecientes;
	}

	public Element getVerticalLayoutListaTweets() {
		return verticalLayoutListaTweets;
	}

	public void setVerticalLayoutListaTweets(Element verticalLayoutListaTweets) {
		this.verticalLayoutListaTweets = verticalLayoutListaTweets;
	}

	public Button getBotonEscribirTweet() {
		return botonEscribirTweet;
	}

	public void setBotonEscribirTweet(Button botonEscribirTweet) {
		this.botonEscribirTweet = botonEscribirTweet;
	}

	public Element getVerticalLayoutDerechoSesionIniciada() {
		return verticalLayoutDerechoSesionIniciada;
	}

	public void setVerticalLayoutDerechoSesionIniciada(Element verticalLayoutDerechoSesionIniciada) {
		this.verticalLayoutDerechoSesionIniciada = verticalLayoutDerechoSesionIniciada;
	}

	public Button getBotonNotificacionesRegistrado() {
		return botonNotificacionesRegistrado;
	}

	public void setBotonNotificacionesRegistrado(Button botonNotificacionesRegistrado) {
		this.botonNotificacionesRegistrado = botonNotificacionesRegistrado;
	}

	public Element getVerticalLayoutListaHashtagsSesionIniciada() {
		return verticalLayoutListaHashtagsSesionIniciada;
	}

	public void setVerticalLayoutListaHashtagsSesionIniciada(Element verticalLayoutListaHashtagsSesionIniciada) {
		this.verticalLayoutListaHashtagsSesionIniciada = verticalLayoutListaHashtagsSesionIniciada;
	}

	public Button getBotonMasHashtags() {
		return botonMasHashtags;
	}

	public void setBotonMasHashtags(Button botonMasHashtags) {
		this.botonMasHashtags = botonMasHashtags;
	}

}