package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;

@Tag("vista-listadetweetsyretweets_item")
@JsModule("./views/vista-listadetweetsyretweets_item.ts")
public class VistaListadetweetsyretweets_item extends LitTemplate {

	@Id("mainContainer")
	private Element mainContainer;
	@Id("headerLayout")
	private Element headerLayout;
	@Id("avatarIcon")
	private Element avatarIcon;
	@Id("userInfo")
	private Element userInfo;
	@Id("nickName")
	private Element nickName;
	@Id("username")
	private Element username;
	@Id("contentArea")
	private Element contentArea;
	@Id("contentText")
	private Element contentText;
	@Id("footerLayout")
	private Element footerLayout;
	@Id("dateLabel")
	private Element dateLabel;
	@Id("heartIcon")
	private Element heartIcon;
	@Id("retweetIcon")
	private Element retweetIcon;	@Id("commentsIcon")
	private Icon commentsIcon;
	@Id("likesCountLabel")
	private Element likesCountLabel;

	public VistaListadetweetsyretweets_item() {
		// You can initialise any data required for the connected UI components here.
	}

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public Element getNickName() {
		return nickName;
	}

	public void setNickName(Element nickName) {
		this.nickName = nickName;
	}
	public Element getContentText() {
		return contentText;
	}

	public void setContentText(Element contentText) {
		this.contentText = contentText;
	}
	
	public Element getAvatarIcon() {
		return avatarIcon;
	}
	
	public Element getDateLabel() {
		return dateLabel;
	}
	
	public Element getLikesCountLabel() {
		return likesCountLabel;
	}
	
	public Element getUsername() {
		return username;
	}

	// Método para actualizar el contenido del tweet
	public void updateTweetContent(String usernameText, String content, String timeText) {
		this.addAttachListener(e -> {
			// Usar executeJs para llamar al método updateTweetContent del componente
			// TypeScript
			this.getElement().executeJs(
					"this.updateTweetContent($0, $1, $2)",
					usernameText, content, timeText);
		});
	}

}