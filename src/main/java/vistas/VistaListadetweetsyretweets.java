package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;

@Tag("vista-listadetweetsyretweets")
@JsModule("./views/vista-listadetweetsyretweets.ts")
public class VistaListadetweetsyretweets extends LitTemplate {

    @Id("mainContainer")
	private Element mainContainer;

	public VistaListadetweetsyretweets() {
        // You can initialise any data required for the connected UI components here.
    }

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}
	
}