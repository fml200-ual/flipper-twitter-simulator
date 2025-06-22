package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.button.Button;

@Tag("vista-verlistaampliadadehashtags")
@JsModule("./views/vista-verlistaampliadadehashtags.ts")
public class VistaVerlistaampliadadehashtags extends LitTemplate {

	@Id("mainLayout")
	private Element mainLayout;
	@Id("pageTitle")
	private H1 pageTitle;
	@Id("hashtagsListContainer")
	private Div hashtagsListContainer;
	@Id("backButton")
	private Button backButton;

	public VistaVerlistaampliadadehashtags() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(Element mainLayout) {
		this.mainLayout = mainLayout;
	}

	public H1 getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(H1 pageTitle) {
		this.pageTitle = pageTitle;
	}

	public Div getHashtagsListContainer() {
		return hashtagsListContainer;
	}

	public void setHashtagsListContainer(Div hashtagsListContainer) {
		this.hashtagsListContainer = hashtagsListContainer;
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}
}