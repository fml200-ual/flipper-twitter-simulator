package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.checkbox.Checkbox;

@Tag("vista-listadenotificaciones_item")
@JsModule("./views/vista-listadenotificaciones_item.ts")
public class VistaListadenotificaciones_item extends LitTemplate {

    @Id("notificationContainer")
	private HorizontalLayout notificationContainer;
	@Id("descriptionLabel")
	private Label descriptionLabel;
	@Id("seenCheckbox")
	private Checkbox seenCheckbox;

	public VistaListadenotificaciones_item() {
        // You can initialise any data required for the connected UI components here.
    }

	public HorizontalLayout getNotificationContainer() {
		return notificationContainer;
	}

	public void setNotificationContainer(HorizontalLayout notificationContainer) {
		this.notificationContainer = notificationContainer;
	}

	public Label getDescriptionLabel() {
		return descriptionLabel;
	}

	public void setDescriptionLabel(Label descriptionLabel) {
		this.descriptionLabel = descriptionLabel;
	}

	public Checkbox getSeenCheckbox() {
		return seenCheckbox;
	}

	public void setSeenCheckbox(Checkbox seenCheckbox) {
		this.seenCheckbox = seenCheckbox;
	}
	
}