package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.button.Button;

@Tag("vista-verlistadeseguidosregistrado")
@JsModule("./views/vista-verlistadeseguidosregistrado.ts")
public class VistaVerlistadeseguidosregistrado extends LitTemplate {

	public Element getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(Element mainLayout) {
		this.mainLayout = mainLayout;
	}

	public Div getHeaderContainer() {
		return headerContainer;
	}

	public void setHeaderContainer(Div headerContainer) {
		this.headerContainer = headerContainer;
	}

	public Div getMessageIcon() {
		return messageIcon;
	}

	public void setMessageIcon(Div messageIcon) {
		this.messageIcon = messageIcon;
	}

	public Div getTitleLayout() {
		return titleLayout;
	}

	public void setTitleLayout(Div titleLayout) {
		this.titleLayout = titleLayout;
	}

	public Span getListTitle() {
		return listTitle;
	}

	public void setListTitle(Span listTitle) {
		this.listTitle = listTitle;
	}

	public Span getUsername() {
		return username;
	}

	public void setUsername(Span username) {
		this.username = username;
	}

	public Element getFollowedListContainer() {
		return followedListContainer;
	}

	public void setFollowedListContainer(Element followedListContainer) {
		this.followedListContainer = followedListContainer;
	}

	public Span getNoFollowedMessage() {
		return noFollowedMessage;
	}

	public void setNoFollowedMessage(Span noFollowedMessage) {
		this.noFollowedMessage = noFollowedMessage;
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	@Id("main-layout")
	private Element mainLayout;
	@Id("header-container")
	private Div headerContainer;
	@Id("message-icon")
	private Div messageIcon;
	@Id("title-layout")
	private Div titleLayout;
	@Id("list-title")
	private Span listTitle;
	@Id("username")
	private Span username;
	@Id("followed-list-container")
	private Element followedListContainer;
	@Id("no-followed-message")
	private Span noFollowedMessage;
	@Id("back-button")
	private Button backButton;

	public VistaVerlistadeseguidosregistrado() {
		// You can initialise any data required for the connected UI components here.
	}

}