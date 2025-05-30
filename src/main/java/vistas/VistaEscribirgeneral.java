package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextArea;

@Tag("vista-escribirgeneral")
@JsModule("./views/vista-escribirgeneral.ts")
public class VistaEscribirgeneral extends LitTemplate {

	@Id("dialogWrapper")
	private Div dialogWrapper;
	@Id("dialogContent")
	private Element dialogContent;
	@Id("closeButton")
	private Button closeButton;
	@Id("dialogHeader")
	private HorizontalLayout dialogHeader;
	@Id("messageIcon")
	private Icon messageIcon;
	@Id("questionText")
	private Span questionText;
	@Id("tweetTextArea")
	private TextArea tweetTextArea;
	@Id("footerActions")
	private HorizontalLayout footerActions;
	@Id("iconContainer")
	private HorizontalLayout iconContainer;
	@Id("cameraIcon")
	private Icon cameraIcon;
	@Id("playIcon")
	private Icon playIcon;
	@Id("publishButton")
	private Button publishButton;

	public VistaEscribirgeneral() {
		// You can initialise any data required for the connected UI components here.
	}

	public Div getDialogWrapper() {
		return dialogWrapper;
	}

	public void setDialogWrapper(Div dialogWrapper) {
		this.dialogWrapper = dialogWrapper;
	}

	public Element getDialogContent() {
		return dialogContent;
	}

	public void setDialogContent(Element dialogContent) {
		this.dialogContent = dialogContent;
	}

	public Button getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(Button closeButton) {
		this.closeButton = closeButton;
	}

	public HorizontalLayout getDialogHeader() {
		return dialogHeader;
	}

	public void setDialogHeader(HorizontalLayout dialogHeader) {
		this.dialogHeader = dialogHeader;
	}

	public Icon getMessageIcon() {
		return messageIcon;
	}

	public void setMessageIcon(Icon messageIcon) {
		this.messageIcon = messageIcon;
	}

	public Span getQuestionText() {
		return questionText;
	}

	public void setQuestionText(Span questionText) {
		this.questionText = questionText;
	}

	public TextArea getTweetTextArea() {
		return tweetTextArea;
	}

	public void setTweetTextArea(TextArea tweetTextArea) {
		this.tweetTextArea = tweetTextArea;
	}

	public HorizontalLayout getFooterActions() {
		return footerActions;
	}

	public void setFooterActions(HorizontalLayout footerActions) {
		this.footerActions = footerActions;
	}

	public HorizontalLayout getIconContainer() {
		return iconContainer;
	}

	public void setIconContainer(HorizontalLayout iconContainer) {
		this.iconContainer = iconContainer;
	}

	public Icon getCameraIcon() {
		return cameraIcon;
	}

	public void setCameraIcon(Icon cameraIcon) {
		this.cameraIcon = cameraIcon;
	}

	public Icon getPlayIcon() {
		return playIcon;
	}

	public void setPlayIcon(Icon playIcon) {
		this.playIcon = playIcon;
	}

	public Button getPublishButton() {
		return publishButton;
	}

	public void setPublishButton(Button publishButton) {
		this.publishButton = publishButton;
	}

}