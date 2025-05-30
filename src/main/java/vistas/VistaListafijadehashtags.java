package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;

@Tag("vista-listafijadehashtags")
@JsModule("./views/vista-listafijadehashtags.ts")
public class VistaListafijadehashtags extends LitTemplate {

	@Id("mainContainer")
	private Element mainContainer;
	@Id("hashtagsListContainer")
	private Element hashtagsListContainer;
	@Id("showMoreButton")
	private Button showMoreButton;
	@Id("pageTitle ")
	private H2 pageTitle;

	public VistaListafijadehashtags() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public Element getHashtagsListContainer() {
		return hashtagsListContainer;
	}

	public void setHashtagsListContainer(Element hashtagsListContainer) {
		this.hashtagsListContainer = hashtagsListContainer;
	}

	public Button getShowMoreButton() {
		return showMoreButton;
	}

	public void setShowMoreButton(Button showMoreButton) {
		this.showMoreButton = showMoreButton;
	}

	public H2 getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(H2 pageTitle) {
		this.pageTitle = pageTitle;
	}

}