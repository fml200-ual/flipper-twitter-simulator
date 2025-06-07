package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.button.Button;

@Tag("vista-listafijadeusuarios")
@JsModule("./views/vista-listafijadeusuarios.ts")
public class VistaListafijadeusuarios extends LitTemplate {

	@Id("mainContainer")
	private Element mainContainer;
	@Id("pageTitle")
	private H2 pageTitle;
	@Id("usersListContainer")
	private Element usersListContainer;
	@Id("showMoreUsersButton")
	private Button showMoreUsersButton;

	public VistaListafijadeusuarios() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public H2 getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(H2 pageTitle) {
		this.pageTitle = pageTitle;
	}

	public Element getUsersListContainer() {
		return usersListContainer;
	}

	public void setUsersListContainer(Element usersListContainer) {
		this.usersListContainer = usersListContainer;
	}

	public Button getShowMoreUsersButton() {
		return showMoreUsersButton;
	}

	public void setShowMoreUsersButton(Button showMoreUsersButton) {
		this.showMoreUsersButton = showMoreUsersButton;
	}

}