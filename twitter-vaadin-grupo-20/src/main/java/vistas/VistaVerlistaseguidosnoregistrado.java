package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.button.Button;

@Tag("vista-verlistaseguidosnoregistrado")
@JsModule("./views/vista-verlistaseguidosnoregistrado.ts")
public class VistaVerlistaseguidosnoregistrado extends LitTemplate {

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

	public Span getNoFollowedMessageNoReg() {
		return noFollowedMessageNoReg;
	}

	public void setNoFollowedMessageNoReg(Span noFollowedMessageNoReg) {
		this.noFollowedMessageNoReg = noFollowedMessageNoReg;
	}

	public Element getFollowedListContainerNoReg() {
		return followedListContainerNoReg;
	}

	public void setFollowedListContainerNoReg(Element followedListContainerNoReg) {
		this.followedListContainerNoReg = followedListContainerNoReg;
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	public Button getShowMoreFollowedButtonNoReg() {
		return showMoreFollowedButtonNoReg;
	}

	public void setShowMoreFollowedButtonNoReg(Button showMoreFollowedButtonNoReg) {
		this.showMoreFollowedButtonNoReg = showMoreFollowedButtonNoReg;
	}

	@Id("main-layout")
	private Element mainLayout;
	@Id("header-container")
	private Div headerContainer;
	@Id("title-layout")
	private Div titleLayout;
	@Id("list-title")
	private Span listTitle;
	@Id("username")
	private Span username;
	@Id("no-followed-message-no-reg")
	private Span noFollowedMessageNoReg;
	@Id("followed-list-container-no-reg")
	private Element followedListContainerNoReg;
	@Id("back-button")
	private Button backButton;
	@Id("show-more-followed-button-no-reg")
	private Button showMoreFollowedButtonNoReg;

	public VistaVerlistaseguidosnoregistrado() {
        // You can initialise any data required for the connected UI components here.
    }

}