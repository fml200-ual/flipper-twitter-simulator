package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.button.Button;

@Tag("vista-verlistaseguidoresnoregistrado")
@JsModule("./views/vista-verlistaseguidoresnoregistrado.ts")
public class VistaVerlistaseguidoresnoregistrado extends LitTemplate {

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

	public Element getFollowersListContainer() {
		return followersListContainer;
	}

	public void setFollowersListContainer(Element followersListContainer) {
		this.followersListContainer = followersListContainer;
	}

	public Span getNoFollowersMessage() {
		return noFollowersMessage;
	}

	public void setNoFollowersMessage(Span noFollowersMessage) {
		this.noFollowersMessage = noFollowersMessage;
	}

	public Button getShowMoreFollowersButton() {
		return showMoreFollowersButton;
	}

	public void setShowMoreFollowersButton(Button showMoreFollowersButton) {
		this.showMoreFollowersButton = showMoreFollowersButton;
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
	@Id("followers-list-container")
	private Element followersListContainer;
	@Id("no-followers-message")
	private Span noFollowersMessage;
	@Id("show-more-followers-button")
	private Button showMoreFollowersButton;
	@Id("back-button")
	private Button backButton;

	public VistaVerlistaseguidoresnoregistrado() {
        // You can initialise any data required for the connected UI components here.
    }

}