package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Div;

@Tag("vista-listadetweetsyretweets_item")
@JsModule("./views/vista-listadetweetsyretweets_item.ts")
public class VistaListadetweetsyretweets_item extends LitTemplate {

    @Id("mainContainer")
	private Element mainContainer;
	@Id("headerLayout")
	private HorizontalLayout headerLayout;
	@Id("avatarIcon")
	private Icon avatarIcon;
	@Id("userInfo")
	private Element userInfo;
	@Id("nickName")
	private H4 nickName;
	@Id("username")
	private Label username;
	@Id("contentArea")
	private Div contentArea;
	@Id("contentText")
	private Label contentText;
	@Id("footerLayout")
	private HorizontalLayout footerLayout;
	@Id("dateLabel")
	private Label dateLabel;
	@Id("likesCountLabel")
	private Label likesCountLabel;
	@Id("heartIcon")
	private Icon heartIcon;
	@Id("xLabelContainer")
	private Label xLabelContainer;
	@Id("xLabel")
	private Label xLabel;
	@Id("retweetIcon")
	private Icon retweetIcon;
	@Id("zLabelContainer")
	private Label zLabelContainer;
	@Id("zLabel")
	private Label zLabel;
	@Id("commentsIcon")
	private Icon commentsIcon;

	public VistaListadetweetsyretweets_item() {
        // You can initialise any data required for the connected UI components here.
    }

	public Element getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(Element mainContainer) {
		this.mainContainer = mainContainer;
	}

	public HorizontalLayout getHeaderLayout() {
		return headerLayout;
	}

	public void setHeaderLayout(HorizontalLayout headerLayout) {
		this.headerLayout = headerLayout;
	}

	public Icon getAvatarIcon() {
		return avatarIcon;
	}

	public void setAvatarIcon(Icon avatarIcon) {
		this.avatarIcon = avatarIcon;
	}

	public Element getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Element userInfo) {
		this.userInfo = userInfo;
	}

	public H4 getNickName() {
		return nickName;
	}

	public void setNickName(H4 nickName) {
		this.nickName = nickName;
	}

	public Label getUsername() {
		return username;
	}

	public void setUsername(Label username) {
		this.username = username;
	}

	public Div getContentArea() {
		return contentArea;
	}

	public void setContentArea(Div contentArea) {
		this.contentArea = contentArea;
	}

	public Label getContentText() {
		return contentText;
	}

	public void setContentText(Label contentText) {
		this.contentText = contentText;
	}

	public HorizontalLayout getFooterLayout() {
		return footerLayout;
	}

	public void setFooterLayout(HorizontalLayout footerLayout) {
		this.footerLayout = footerLayout;
	}

	public Label getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(Label dateLabel) {
		this.dateLabel = dateLabel;
	}

	public Label getLikesCountLabel() {
		return likesCountLabel;
	}

	public void setLikesCountLabel(Label likesCountLabel) {
		this.likesCountLabel = likesCountLabel;
	}

	public Icon getHeartIcon() {
		return heartIcon;
	}

	public void setHeartIcon(Icon heartIcon) {
		this.heartIcon = heartIcon;
	}

	public Label getxLabelContainer() {
		return xLabelContainer;
	}

	public void setxLabelContainer(Label xLabelContainer) {
		this.xLabelContainer = xLabelContainer;
	}

	public Label getxLabel() {
		return xLabel;
	}

	public void setxLabel(Label xLabel) {
		this.xLabel = xLabel;
	}

	public Icon getRetweetIcon() {
		return retweetIcon;
	}

	public void setRetweetIcon(Icon retweetIcon) {
		this.retweetIcon = retweetIcon;
	}

	public Label getzLabelContainer() {
		return zLabelContainer;
	}

	public void setzLabelContainer(Label zLabelContainer) {
		this.zLabelContainer = zLabelContainer;
	}

	public Label getzLabel() {
		return zLabel;
	}

	public void setzLabel(Label zLabel) {
		this.zLabel = zLabel;
	}

	public Icon getCommentsIcon() {
		return commentsIcon;
	}

	public void setCommentsIcon(Icon commentsIcon) {
		this.commentsIcon = commentsIcon;
	}
	
}