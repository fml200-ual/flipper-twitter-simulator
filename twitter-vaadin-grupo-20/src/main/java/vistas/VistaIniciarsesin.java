package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.button.Button;

@Tag("vista-iniciarsesin")
@JsModule("./views/vista-iniciarsesin.ts")
public class VistaIniciarsesin extends LitTemplate {

	@Id("backButton")
	private Button backButton;
	@Id("loginContainer")
	private Div loginContainer;
	@Id("usernameField")
	private TextField usernameField;
	@Id("passwordField")
	private PasswordField passwordField;
	@Id("forgotPasswordLink")
	private Element forgotPasswordLink;
	@Id("loginButton")
	private Button loginButton;
	@Id("registerButton")
	private Button registerButton;

	public VistaIniciarsesin() {
		// You can initialise any data required for the connected UI components here.
	}

	public Button getBackButton() {
		return backButton;
	}

	public Div getLoginContainer() {
		return loginContainer;
	}

	public void setLoginContainer(Div loginContainer) {
		this.loginContainer = loginContainer;
	}

	public TextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(TextField usernameField) {
		this.usernameField = usernameField;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public Element getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public void setForgotPasswordLink(Element forgotPasswordLink) {
		this.forgotPasswordLink = forgotPasswordLink;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}

	public Button getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(Button registerButton) {
		this.registerButton = registerButton;
	}

}