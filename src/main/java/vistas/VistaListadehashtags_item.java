package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;

@Tag("vista-listadehashtags_item")
@JsModule("./views/vista-listadehashtags_item.ts")
public class VistaListadehashtags_item extends LitTemplate {

    @Id("hashtagContainer")
	private HorizontalLayout hashtagContainer;
	@Id("hashtagText")
	private Label hashtagText;
	@Id("postCount")
	private Label postCount;
	@Id("iconComment")
	private Icon iconComment;

	public VistaListadehashtags_item() {
        // You can initialise any data required for the connected UI components here.
    }

	public HorizontalLayout getHashtagContainer() {
		return hashtagContainer;
	}

	public void setHashtagContainer(HorizontalLayout hashtagContainer) {
		this.hashtagContainer = hashtagContainer;
	}

	public Label getHashtagText() {
		return hashtagText;
	}

	public void setHashtagText(Label hashtagText) {
		this.hashtagText = hashtagText;
	}

	public Label getPostCount() {
		return postCount;
	}

	public void setPostCount(Label postCount) {
		this.postCount = postCount;
	}

	public Icon getIconComment() {
		return iconComment;
	}

	public void setIconComment(Icon iconComment) {
		this.iconComment = iconComment;
	}
}