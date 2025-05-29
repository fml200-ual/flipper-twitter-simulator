package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@Tag("vista-listadecomentarios")
@JsModule("./views/vista-listadecomentarios.ts")
public class VistaListadecomentarios extends LitTemplate {

    @Id("mainContainer")
	private Element mainContainer;
	@Id("contentLayout")
	private HorizontalLayout contentLayout;

	public VistaListadecomentarios() {
        // You can initialise any data required for the connected UI components here.
    }

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public HorizontalLayout getContentLayout() {
		return contentLayout;
	}

	public void setContentLayout(HorizontalLayout contentLayout) {
		this.contentLayout = contentLayout;
	}
	
}