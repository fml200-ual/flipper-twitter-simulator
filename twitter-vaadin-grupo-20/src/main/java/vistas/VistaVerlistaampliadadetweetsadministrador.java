package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.NativeButton;

@Tag("vista-verlistaampliadadetweetsadministrador")
@JsModule("./views/vista-verlistaampliadadetweetsadministrador.ts")
public class VistaVerlistaampliadadetweetsadministrador extends LitTemplate {

    public Element getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(Element mainLayout) {
		this.mainLayout = mainLayout;
	}

	public Div getTwitterBirdIcon() {
		return twitterBirdIcon;
	}

	public void setTwitterBirdIcon(Div twitterBirdIcon) {
		this.twitterBirdIcon = twitterBirdIcon;
	}

	public H2 getMainHeader() {
		return mainHeader;
	}

	public void setMainHeader(H2 mainHeader) {
		this.mainHeader = mainHeader;
	}

	public HorizontalLayout getSearchSection() {
		return searchSection;
	}

	public void setSearchSection(HorizontalLayout searchSection) {
		this.searchSection = searchSection;
	}

	public TextField getSearchField() {
		return searchField;
	}

	public void setSearchField(TextField searchField) {
		this.searchField = searchField;
	}

	public Button getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(Button searchButton) {
		this.searchButton = searchButton;
	}

	public HorizontalLayout getControlsLayout() {
		return controlsLayout;
	}

	public void setControlsLayout(HorizontalLayout controlsLayout) {
		this.controlsLayout = controlsLayout;
	}

	public Button getCreateNewButton() {
		return createNewButton;
	}

	public void setCreateNewButton(Button createNewButton) {
		this.createNewButton = createNewButton;
	}

	public Button getDeleteSelectedButton() {
		return deleteSelectedButton;
	}

	public void setDeleteSelectedButton(Button deleteSelectedButton) {
		this.deleteSelectedButton = deleteSelectedButton;
	}

	public Element getTweetListContainer() {
		return tweetListContainer;
	}

	public void setTweetListContainer(Element tweetListContainer) {
		this.tweetListContainer = tweetListContainer;
	}

	public Span getSpan() {
		return span;
	}

	public void setSpan(Span span) {
		this.span = span;
	}

	public NativeButton getShowMoreButton() {
		return showMoreButton;
	}

	public void setShowMoreButton(NativeButton showMoreButton) {
		this.showMoreButton = showMoreButton;
	}

	@Id("main-layout")
	private Element mainLayout;
	@Id("twitter-bird-icon")
	private Div twitterBirdIcon;
	@Id("main-header")
	private H2 mainHeader;
	@Id("search-section")
	private HorizontalLayout searchSection;
	@Id("search-field")
	private TextField searchField;
	@Id("search-button")
	private Button searchButton;
	@Id("controls-layout")
	private HorizontalLayout controlsLayout;
	@Id("create-new-button")
	private Button createNewButton;
	@Id("delete-selected-button")
	private Button deleteSelectedButton;
	@Id("tweet-list-container")
	private Element tweetListContainer;
	@Id("span")
	private Span span;
	@Id("show-more-button")
	private NativeButton showMoreButton;

	public VistaVerlistaampliadadetweetsadministrador() {
        // You can initialise any data required for the connected UI components here.
    }

}