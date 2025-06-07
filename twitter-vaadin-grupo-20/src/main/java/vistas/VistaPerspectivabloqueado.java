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

	private Div getProfileHeader() {
		return profileHeader;
	}

	private void setProfileHeader(Div profileHeader) {
		this.profileHeader = profileHeader;
	}

	private Image getBannerImage() {
		return bannerImage;
	}

	private void setBannerImage(Image bannerImage) {
		this.bannerImage = bannerImage;
	}

	private Image getProfileImage() {
		return profileImage;
	}

	private void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}

	private Element getUserInfo() {
		return userInfo;
	}

	private void setUserInfo(Element userInfo) {
		this.userInfo = userInfo;
	}

	private Span getUsernameText() {
		return usernameText;
	}

	private void setUsernameText(Span usernameText) {
		this.usernameText = usernameText;
	}

	private Span getHandleText() {
		return handleText;
	}

	private void setHandleText(Span handleText) {
		this.handleText = handleText;
	}

	private Element getBlockedMessageContainer() {
		return blockedMessageContainer;
	}

	private void setBlockedMessageContainer(Element blockedMessageContainer) {
		this.blockedMessageContainer = blockedMessageContainer;
	}

	private Image getBirdLogoImage() {
		return birdLogoImage;
	}

	private void setBirdLogoImage(Image birdLogoImage) {
		this.birdLogoImage = birdLogoImage;
	}

	private Span getEmbarrassingText() {
		return embarrassingText;
	}

	private void setEmbarrassingText(Span embarrassingText) {
		this.embarrassingText = embarrassingText;
	}

	private Span getBlockedText() {
		return blockedText;
	}

	private void setBlockedText(Span blockedText) {
		this.blockedText = blockedText;
	}

}