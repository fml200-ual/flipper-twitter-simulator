package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.PasswordField;

@Tag("vista-restablecercontrasea")
@JsModule("./views/vista-restablecercontrasea.ts")
public class VistaRestablecercontrasea extends LitTemplate {

	@Id("resetPasswordContainer")
	private Element resetPasswordContainer;
	@Id("messageBox")
	private Div messageBox;
	@Id("passwordField")
	private PasswordField passwordField;

	public VistaRestablecercontrasea() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getResetPasswordContainer() {
		return resetPasswordContainer;
	}

	public void setResetPasswordContainer(Element resetPasswordContainer) {
		this.resetPasswordContainer = resetPasswordContainer;
	}

	public Div getMessageBox() {
		return messageBox;
	}

	public void setMessageBox(Div messageBox) {
		this.messageBox = messageBox;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

}