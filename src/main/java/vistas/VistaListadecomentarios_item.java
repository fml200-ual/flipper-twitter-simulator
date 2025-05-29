package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.avatar.Avatar;

@Tag("vista-listadecomentarios_item")
@JsModule("./views/vista-listadecomentarios_item.ts")
public class VistaListadecomentarios_item extends LitTemplate {


	@Id("VL_listacomentarios_mainContainer")
	private Element vL_listacomentarios_mainContainer;
	@Id("HL_comentario_header")
	private HorizontalLayout hL_comentario_header;
	@Id("ironIcon_avatarUsuario")
	private Icon ironIcon_avatarUsuario;
	@Id("VL_nickYUsername")
	private Element vL_nickYUsername;
	@Id("h4_nickUsuario")
	private H4 h4_nickUsuario;
	@Id("label_username")
	private Label label_username;
	@Id("VL_contenidoComentario")
	private Element vL_contenidoComentario;
	@Id("label_comentarioTexto")
	private Label label_comentarioTexto;
	@Id("HL_fechaYMeGusta")
	private HorizontalLayout hL_fechaYMeGusta;
	@Id("label_fechaComentario")
	private Label label_fechaComentario;
	@Id("ironIcon_meGusta")
	private Icon ironIcon_meGusta;
	@Id("avatar")
	private Avatar avatar;

	public VistaListadecomentarios_item() {
        // You can initialise any data required for the connected UI components here.
    }

	public Element getvL_listacomentarios_mainContainer() {
		return vL_listacomentarios_mainContainer;
	}

	public void setvL_listacomentarios_mainContainer(Element vL_listacomentarios_mainContainer) {
		this.vL_listacomentarios_mainContainer = vL_listacomentarios_mainContainer;
	}

	public HorizontalLayout gethL_comentario_header() {
		return hL_comentario_header;
	}

	public void sethL_comentario_header(HorizontalLayout hL_comentario_header) {
		this.hL_comentario_header = hL_comentario_header;
	}

	public Icon getIronIcon_avatarUsuario() {
		return ironIcon_avatarUsuario;
	}

	public void setIronIcon_avatarUsuario(Icon ironIcon_avatarUsuario) {
		this.ironIcon_avatarUsuario = ironIcon_avatarUsuario;
	}

	public Element getvL_nickYUsername() {
		return vL_nickYUsername;
	}

	public void setvL_nickYUsername(Element vL_nickYUsername) {
		this.vL_nickYUsername = vL_nickYUsername;
	}

	public H4 getH4_nickUsuario() {
		return h4_nickUsuario;
	}

	public void setH4_nickUsuario(H4 h4_nickUsuario) {
		this.h4_nickUsuario = h4_nickUsuario;
	}

	public Label getLabel_username() {
		return label_username;
	}

	public void setLabel_username(Label label_username) {
		this.label_username = label_username;
	}

	public Element getvL_contenidoComentario() {
		return vL_contenidoComentario;
	}

	public void setvL_contenidoComentario(Element vL_contenidoComentario) {
		this.vL_contenidoComentario = vL_contenidoComentario;
	}

	public Label getLabel_comentarioTexto() {
		return label_comentarioTexto;
	}

	public void setLabel_comentarioTexto(Label label_comentarioTexto) {
		this.label_comentarioTexto = label_comentarioTexto;
	}

	public HorizontalLayout gethL_fechaYMeGusta() {
		return hL_fechaYMeGusta;
	}

	public void sethL_fechaYMeGusta(HorizontalLayout hL_fechaYMeGusta) {
		this.hL_fechaYMeGusta = hL_fechaYMeGusta;
	}

	public Label getLabel_fechaComentario() {
		return label_fechaComentario;
	}

	public void setLabel_fechaComentario(Label label_fechaComentario) {
		this.label_fechaComentario = label_fechaComentario;
	}

	public Icon getIronIcon_meGusta() {
		return ironIcon_meGusta;
	}

	public void setIronIcon_meGusta(Icon ironIcon_meGusta) {
		this.ironIcon_meGusta = ironIcon_meGusta;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
}