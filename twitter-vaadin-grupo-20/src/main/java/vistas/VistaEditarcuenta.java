package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@Tag("vista-editarcuenta")
@JsModule("./views/vista-editarcuenta.ts")
public class VistaEditarcuenta extends LitTemplate {

	@Id("mainContainer")
	private Element mainContainer;
	@Id("eliminarCuentaButton")
	private Button eliminarCuentaButton;
	@Id("profileConfigTitle")
	private H2 profileConfigTitle;
	@Id("subtitleText")
	private Paragraph subtitleText;
	@Id("formFieldsContainer")
	private Element formFieldsContainer;
	@Id("arrobField")
	private TextField arrobField;
	@Id("nickField")
	private TextField nickField;
	@Id("descripcionField")
	private TextArea descripcionField;
	@Id("fondoField")
	private TextField fondoField;
	@Id("fondoPreviewContainer")
	private Div fondoPreviewContainer;
	@Id("fotoPerfilField")
	private TextField fotoPerfilField;
	@Id("fondoImagePlaceholder")
	private Div fondoImagePlaceholder;
	@Id("fondoPreviewLabel")
	private Label fondoPreviewLabel;
	@Id("perfilPreviewContainer")
	private Div perfilPreviewContainer;
	@Id("perfilPreviewLabel")
	private Label perfilPreviewLabel;
	@Id("perfilImagePlaceholder")
	private Div perfilImagePlaceholder;
	@Id("bottomButtonsContainer")
	private HorizontalLayout bottomButtonsContainer;
	@Id("continuarButton")
	private Button continuarButton;
	@Id("cancelarButton")
	private Button cancelarButton;

	public VistaEditarcuenta() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public Button getEliminarCuentaButton() {
		return eliminarCuentaButton;
	}

	public void setEliminarCuentaButton(Button eliminarCuentaButton) {
		this.eliminarCuentaButton = eliminarCuentaButton;
	}

	public H2 getProfileConfigTitle() {
		return profileConfigTitle;
	}

	public void setProfileConfigTitle(H2 profileConfigTitle) {
		this.profileConfigTitle = profileConfigTitle;
	}

	public Paragraph getSubtitleText() {
		return subtitleText;
	}

	public void setSubtitleText(Paragraph subtitleText) {
		this.subtitleText = subtitleText;
	}

	public Element getFormFieldsContainer() {
		return formFieldsContainer;
	}

	public void setFormFieldsContainer(Element formFieldsContainer) {
		this.formFieldsContainer = formFieldsContainer;
	}

	public TextField getArrobField() {
		return arrobField;
	}

	public void setArrobField(TextField arrobField) {
		this.arrobField = arrobField;
	}

	public TextField getNickField() {
		return nickField;
	}

	public void setNickField(TextField nickField) {
		this.nickField = nickField;
	}

	public TextArea getDescripcionField() {
		return descripcionField;
	}

	public void setDescripcionField(TextArea descripcionField) {
		this.descripcionField = descripcionField;
	}

	public TextField getFondoField() {
		return fondoField;
	}

	public void setFondoField(TextField fondoField) {
		this.fondoField = fondoField;
	}

	public Div getFondoPreviewContainer() {
		return fondoPreviewContainer;
	}

	public void setFondoPreviewContainer(Div fondoPreviewContainer) {
		this.fondoPreviewContainer = fondoPreviewContainer;
	}

	public TextField getFotoPerfilField() {
		return fotoPerfilField;
	}

	public void setFotoPerfilField(TextField fotoPerfilField) {
		this.fotoPerfilField = fotoPerfilField;
	}

	public Div getFondoImagePlaceholder() {
		return fondoImagePlaceholder;
	}

	public void setFondoImagePlaceholder(Div fondoImagePlaceholder) {
		this.fondoImagePlaceholder = fondoImagePlaceholder;
	}

	public Label getFondoPreviewLabel() {
		return fondoPreviewLabel;
	}

	public void setFondoPreviewLabel(Label fondoPreviewLabel) {
		this.fondoPreviewLabel = fondoPreviewLabel;
	}

	public Div getPerfilPreviewContainer() {
		return perfilPreviewContainer;
	}

	public void setPerfilPreviewContainer(Div perfilPreviewContainer) {
		this.perfilPreviewContainer = perfilPreviewContainer;
	}

	public Label getPerfilPreviewLabel() {
		return perfilPreviewLabel;
	}

	public void setPerfilPreviewLabel(Label perfilPreviewLabel) {
		this.perfilPreviewLabel = perfilPreviewLabel;
	}

	public Div getPerfilImagePlaceholder() {
		return perfilImagePlaceholder;
	}

	public void setPerfilImagePlaceholder(Div perfilImagePlaceholder) {
		this.perfilImagePlaceholder = perfilImagePlaceholder;
	}

	public HorizontalLayout getBottomButtonsContainer() {
		return bottomButtonsContainer;
	}

	public void setBottomButtonsContainer(HorizontalLayout bottomButtonsContainer) {
		this.bottomButtonsContainer = bottomButtonsContainer;
	}

	public Button getContinuarButton() {
		return continuarButton;
	}

	public void setContinuarButton(Button continuarButton) {
		this.continuarButton = continuarButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public void setCancelarButton(Button cancelarButton) {
		this.cancelarButton = cancelarButton;
	}

}