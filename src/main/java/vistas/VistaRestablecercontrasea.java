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

	private Element getResetPasswordContainer() {
		return resetPasswordContainer;
	}

	private void setResetPasswordContainer(Element resetPasswordContainer) {
		this.resetPasswordContainer = resetPasswordContainer;
	}

	private Div getMessageBox() {
		return messageBox;
	}

	private void setMessageBox(Div messageBox) {
		this.messageBox = messageBox;
	}

	private PasswordField getPasswordField() {
		return passwordField;
	}

	private void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

}