package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;

@Tag("vista-listadeusuarios_item")
@JsModule("./views/vista-listadeusuarios_item.ts")
public class VistaListadeusuarios_item extends LitTemplate {

    @Id("mainContainer")
	private HorizontalLayout mainContainer;
	@Id("userInfoSection")
	private HorizontalLayout userInfoSection;
	@Id("avatarIcon")
	private Icon avatarIcon;
	@Id("textInfo")
	private Element textInfo;
	@Id("nickName")
	private H4 nickName;
	@Id("followersSection")
	private HorizontalLayout followersSection;
	@Id("followersCount")
	private Label followersCount;
	@Id("followersIcon")
	private Icon followersIcon;
	@Id("descriptionContainer")
	private HorizontalLayout descriptionContainer;
	@Id("descriptionText")
	private Label descriptionText;

	public VistaListadeusuarios_item() {
        // You can initialise any data required for the connected UI components here.
    }

	public HorizontalLayout getMainContainer() {
		return mainContainer;
	}

	public void setMainContainer(HorizontalLayout mainContainer) {
		this.mainContainer = mainContainer;
	}

	public HorizontalLayout getUserInfoSection() {
		return userInfoSection;
	}

	public void setUserInfoSection(HorizontalLayout userInfoSection) {
		this.userInfoSection = userInfoSection;
	}

	public Icon getAvatarIcon() {
		return avatarIcon;
	}

	public void setAvatarIcon(Icon avatarIcon) {
		this.avatarIcon = avatarIcon;
	}

	public Element getTextInfo() {
		return textInfo;
	}

	public void setTextInfo(Element textInfo) {
		this.textInfo = textInfo;
	}

	public H4 getNickName() {
		return nickName;
	}

	public void setNickName(H4 nickName) {
		this.nickName = nickName;
	}

	public HorizontalLayout getFollowersSection() {
		return followersSection;
	}

	public void setFollowersSection(HorizontalLayout followersSection) {
		this.followersSection = followersSection;
	}

	public Label getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(Label followersCount) {
		this.followersCount = followersCount;
	}

	public Icon getFollowersIcon() {
		return followersIcon;
	}

	public void setFollowersIcon(Icon followersIcon) {
		this.followersIcon = followersIcon;
	}

	public HorizontalLayout getDescriptionContainer() {
		return descriptionContainer;
	}

	public void setDescriptionContainer(HorizontalLayout descriptionContainer) {
		this.descriptionContainer = descriptionContainer;
	}

	public Label getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(Label descriptionText) {
		this.descriptionText = descriptionText;
	}
	
}