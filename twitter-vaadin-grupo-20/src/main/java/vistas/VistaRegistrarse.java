package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.button.Button;

@Tag("vista-registrarse")
@JsModule("./views/vista-registrarse.ts")
public class VistaRegistrarse extends LitTemplate {

	@Id("backButton")
	private Button backButton;
	@Id("registerContainer")
	private Element registerContainer;
	@Id("requiredFieldsMessage")
	private Span requiredFieldsMessage;
	@Id("nameField")
	private TextField nameField;
	@Id("lastNameField")
	private TextField lastNameField;
	@Id("emailField")
	private TextField emailField;
	@Id("nickField")
	private TextField nickField;
	@Id("passwordField")
	private PasswordField passwordField;
	@Id("atSignField")
	private TextField atSignField;
	@Id("profilePhotoUrlField")
	private TextField profilePhotoUrlField;
	@Id("profileImagePreview")
	private Div profileImagePreview;
	@Id("profileImagePreviewIcon")
	private Icon profileImagePreviewIcon;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("backgroundUrlField")
	private TextField backgroundUrlField;
	@Id("backgroundImagePreview")
	private Div backgroundImagePreview;
	@Id("backgroundImagePreviewIcon")
	private Icon backgroundImagePreviewIcon;
	@Id("descriptionField")
	private TextArea descriptionField;
	@Id("googleLoginButton")
	private Button googleLoginButton;
	@Id("registerButton")
	private Button registerButton;
	public VistaRegistrarse() {
		// You can initialise any data required for the connected UI components here.
	}

	public Button getBackButton() {
		return backButton;
	}

	public Element getRegisterContainer() {
		return registerContainer;
	}

	public void setRegisterContainer(Element registerContainer) {
		this.registerContainer = registerContainer;
	}

	public Span getRequiredFieldsMessage() {
		return requiredFieldsMessage;
	}

	public void setRequiredFieldsMessage(Span requiredFieldsMessage) {
		this.requiredFieldsMessage = requiredFieldsMessage;
	}

	public TextField getNameField() {
		return nameField;
	}

	public void setNameField(TextField nameField) {
		this.nameField = nameField;
	}

	public TextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(TextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public TextField getEmailField() {
		return emailField;
	}

	public void setEmailField(TextField emailField) {
		this.emailField = emailField;
	}

	public TextField getNickField() {
		return nickField;
	}

	public void setNickField(TextField nickField) {
		this.nickField = nickField;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public TextField getAtSignField() {
		return atSignField;
	}

	public void setAtSignField(TextField atSignField) {
		this.atSignField = atSignField;
	}

	public TextField getProfilePhotoUrlField() {
		return profilePhotoUrlField;
	}

	public void setProfilePhotoUrlField(TextField profilePhotoUrlField) {
		this.profilePhotoUrlField = profilePhotoUrlField;
	}

	public Div getProfileImagePreview() {
		return profileImagePreview;
	}

	public void setProfileImagePreview(Div profileImagePreview) {
		this.profileImagePreview = profileImagePreview;
	}

	public Icon getProfileImagePreviewIcon() {
		return profileImagePreviewIcon;
	}

	public void setProfileImagePreviewIcon(Icon profileImagePreviewIcon) {
		this.profileImagePreviewIcon = profileImagePreviewIcon;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public TextField getBackgroundUrlField() {
		return backgroundUrlField;
	}

	public void setBackgroundUrlField(TextField backgroundUrlField) {
		this.backgroundUrlField = backgroundUrlField;
	}

	public Div getBackgroundImagePreview() {
		return backgroundImagePreview;
	}

	public void setBackgroundImagePreview(Div backgroundImagePreview) {
		this.backgroundImagePreview = backgroundImagePreview;
	}

	public Icon getBackgroundImagePreviewIcon() {
		return backgroundImagePreviewIcon;
	}

	public void setBackgroundImagePreviewIcon(Icon backgroundImagePreviewIcon) {
		this.backgroundImagePreviewIcon = backgroundImagePreviewIcon;
	}

	public TextArea getDescriptionField() {
		return descriptionField;
	}

	public void setDescriptionField(TextArea descriptionField) {
		this.descriptionField = descriptionField;
	}

	public Button getGoogleLoginButton() {
		return googleLoginButton;
	}

	public void setGoogleLoginButton(Button googleLoginButton) {
		this.googleLoginButton = googleLoginButton;
	}

	public Button getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(Button registerButton) {
		this.registerButton = registerButton;
	}

}