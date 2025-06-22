package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.Span;

@Tag("vista-perspectivabloqueado")
@JsModule("./views/vista-perspectivabloqueado.ts")
public class VistaPerspectivabloqueado extends LitTemplate {

	@Id("profileHeader")
	private Div profileHeader;
	@Id("bannerImage")
	private Image bannerImage;
	@Id("profileImage")
	private Image profileImage;
	@Id("userInfo")
	private Element userInfo;
	@Id("usernameText")
	private Span usernameText;
	@Id("handleText")
	private Span handleText;
	@Id("blockedMessageContainer")
	private Element blockedMessageContainer;
	@Id("birdLogoImage")
	private Image birdLogoImage;
	@Id("embarrassingText")
	private Span embarrassingText;
	@Id("blockedText")
	private Span blockedText;

	public VistaPerspectivabloqueado() {
	}

	public Div getProfileHeader() {
		return profileHeader;
	}

	public void setProfileHeader(Div profileHeader) {
		this.profileHeader = profileHeader;
	}

	public Image getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(Image bannerImage) {
		this.bannerImage = bannerImage;
	}

	public Image getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}

	public Element getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Element userInfo) {
		this.userInfo = userInfo;
	}

	public Span getUsernameText() {
		return usernameText;
	}

	public void setUsernameText(Span usernameText) {
		this.usernameText = usernameText;
	}

	public Span getHandleText() {
		return handleText;
	}

	public void setHandleText(Span handleText) {
		this.handleText = handleText;
	}

	public Element getBlockedMessageContainer() {
		return blockedMessageContainer;
	}

	public void setBlockedMessageContainer(Element blockedMessageContainer) {
		this.blockedMessageContainer = blockedMessageContainer;
	}

	public Image getBirdLogoImage() {
		return birdLogoImage;
	}

	public void setBirdLogoImage(Image birdLogoImage) {
		this.birdLogoImage = birdLogoImage;
	}

	public Span getEmbarrassingText() {
		return embarrassingText;
	}

	public void setEmbarrassingText(Span embarrassingText) {
		this.embarrassingText = embarrassingText;
	}

	public Span getBlockedText() {
		return blockedText;
	}

	public void setBlockedText(Span blockedText) {
		this.blockedText = blockedText;
	}

}