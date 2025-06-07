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

}