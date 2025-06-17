package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Div;

@Tag("vista-verlistaampliadadetweetsadministrador")
@JsModule("./views/vista-verlistaampliadadetweetsadministrador.ts")
public class VistaVerlistaampliadadetweetsadministrador extends LitTemplate {

	@Id("main-layout")
	private Element mainLayout;
	@Id("twitter-bird-icon")
	private Div twitterBirdIcon;
	@Id("tweet-list-container")
	private Element tweetListContainer;
	@Id("back-button-container")
	private Div backButtonContainer;

	public VistaVerlistaampliadadetweetsadministrador() {
		// You can initialise any data required for the connected UI components here.
	}

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

	public Element getTweetListContainer() {
		return tweetListContainer;
	}

	public void setTweetListContainer(Element tweetListContainer) {
		this.tweetListContainer = tweetListContainer;
	}

	public Div getBackButtonContainer() {
		return backButtonContainer;
	}

	public void setBackButtonContainer(Div backButtonContainer) {
		this.backButtonContainer = backButtonContainer;
	}

}