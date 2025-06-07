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

	private Element getRegisterContainer() {
		return registerContainer;
	}

	private void setRegisterContainer(Element registerContainer) {
		this.registerContainer = registerContainer;
	}

	private Span getRequiredFieldsMessage() {
		return requiredFieldsMessage;
	}

	private void setRequiredFieldsMessage(Span requiredFieldsMessage) {
		this.requiredFieldsMessage = requiredFieldsMessage;
	}

	private TextField getNameField() {
		return nameField;
	}

	private void setNameField(TextField nameField) {
		this.nameField = nameField;
	}

	private TextField getLastNameField() {
		return lastNameField;
	}

	private void setLastNameField(TextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	private TextField getEmailField() {
		return emailField;
	}

	private void setEmailField(TextField emailField) {
		this.emailField = emailField;
	}

	private TextField getNickField() {
		return nickField;
	}

	private void setNickField(TextField nickField) {
		this.nickField = nickField;
	}

	private PasswordField getPasswordField() {
		return passwordField;
	}

	private void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

	private TextField getAtSignField() {
		return atSignField;
	}

	private void setAtSignField(TextField atSignField) {
		this.atSignField = atSignField;
	}

	private TextField getProfilePhotoUrlField() {
		return profilePhotoUrlField;
	}

	private void setProfilePhotoUrlField(TextField profilePhotoUrlField) {
		this.profilePhotoUrlField = profilePhotoUrlField;
	}

	private Div getProfileImagePreview() {
		return profileImagePreview;
	}

	private void setProfileImagePreview(Div profileImagePreview) {
		this.profileImagePreview = profileImagePreview;
	}

	private Icon getProfileImagePreviewIcon() {
		return profileImagePreviewIcon;
	}

	private void setProfileImagePreviewIcon(Icon profileImagePreviewIcon) {
		this.profileImagePreviewIcon = profileImagePreviewIcon;
	}

	private HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	private void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	private TextField getBackgroundUrlField() {
		return backgroundUrlField;
	}

	private void setBackgroundUrlField(TextField backgroundUrlField) {
		this.backgroundUrlField = backgroundUrlField;
	}

	private Div getBackgroundImagePreview() {
		return backgroundImagePreview;
	}

	private void setBackgroundImagePreview(Div backgroundImagePreview) {
		this.backgroundImagePreview = backgroundImagePreview;
	}

	private Icon getBackgroundImagePreviewIcon() {
		return backgroundImagePreviewIcon;
	}

	private void setBackgroundImagePreviewIcon(Icon backgroundImagePreviewIcon) {
		this.backgroundImagePreviewIcon = backgroundImagePreviewIcon;
	}

	private TextArea getDescriptionField() {
		return descriptionField;
	}

	private void setDescriptionField(TextArea descriptionField) {
		this.descriptionField = descriptionField;
	}

	private Button getGoogleLoginButton() {
		return googleLoginButton;
	}

	private void setGoogleLoginButton(Button googleLoginButton) {
		this.googleLoginButton = googleLoginButton;
	}

	private Button getRegisterButton() {
		return registerButton;
	}

	private void setRegisterButton(Button registerButton) {
		this.registerButton = registerButton;
	}

}