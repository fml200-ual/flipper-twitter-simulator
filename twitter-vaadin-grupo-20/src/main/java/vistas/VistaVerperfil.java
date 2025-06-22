package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Section;

@Tag("vista-verperfil")
@JsModule("./views/vista-verperfil.ts")
public class VistaVerperfil extends LitTemplate {

	@Id("viewWrapper")
	private Div viewWrapper;
	@Id("profileContainer")
	private Div profileContainer;
	@Id("header")
	private Header header;
	@Id("coverPhoto")
	private Div coverPhoto;
	@Id("profilePicture")
	private Div profilePicture;
	@Id("profileInfoSection")
	private Section profileInfoSection;
	@Id("nameContainer")
	private Div nameContainer;
	@Id("profileName")
	private Div profileName;
	@Id("profileUsername")
	private Div profileUsername;
	@Id("followingCount")
	private Span followingCount;
	@Id("followersCount")
	private Span followersCount;
	@Id("joinDate")
	private Span joinDate;
	@Id("description")
	private Div description;
	@Id("actionsContainer")
	private Div actionsContainer;
	@Id("tabsLayout")
	private Div tabsLayout;
	@Id("backButton")
	private Button backButton;
	@Id("tweetsListLayout")
	private Div tweetsListLayout;
	@Id("banProfileButton")
	private NativeButton banProfileButton;
	@Id("deleteProfileButton")
	private NativeButton deleteProfileButton;
	@Id("userTweetsTab")
	private NativeButton userTweetsTab;
	@Id("likedTweetsTab")
	private NativeButton likedTweetsTab;
	@Id("retweetsTab")
	private NativeButton retweetsTab;
	@Id("editAccountButton")
	private NativeButton editAccountButton;

	public VistaVerperfil() {
		// You can initialise any data required for the connected UI components here.
	}

	protected Div getViewWrapper() {
		return viewWrapper;
	}

	protected void setViewWrapper(Div viewWrapper) {
		this.viewWrapper = viewWrapper;
	}

	protected Div getProfileContainer() {
		return profileContainer;
	}

	protected void setProfileContainer(Div profileContainer) {
		this.profileContainer = profileContainer;
	}

	protected Header getHeader() {
		return header;
	}

	protected void setHeader(Header header) {
		this.header = header;
	}

	protected Div getCoverPhoto() {
		return coverPhoto;
	}

	protected void setCoverPhoto(Div coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	protected Div getProfilePicture() {
		return profilePicture;
	}

	protected void setProfilePicture(Div profilePicture) {
		this.profilePicture = profilePicture;
	}

	protected Section getProfileInfoSection() {
		return profileInfoSection;
	}

	protected void setProfileInfoSection(Section profileInfoSection) {
		this.profileInfoSection = profileInfoSection;
	}

	protected Div getNameContainer() {
		return nameContainer;
	}

	protected void setNameContainer(Div nameContainer) {
		this.nameContainer = nameContainer;
	}

	protected Div getProfileName() {
		return profileName;
	}

	protected void setProfileName(Div profileName) {
		this.profileName = profileName;
	}

	protected Div getProfileUsername() {
		return profileUsername;
	}

	protected void setProfileUsername(Div profileUsername) {
		this.profileUsername = profileUsername;
	}

	protected Span getFollowingCount() {
		return followingCount;
	}

	protected void setFollowingCount(Span followingCount) {
		this.followingCount = followingCount;
	}

	protected Span getFollowersCount() {
		return followersCount;
	}

	protected void setFollowersCount(Span followersCount) {
		this.followersCount = followersCount;
	}

	protected Span getJoinDate() {
		return joinDate;
	}

	protected void setJoinDate(Span joinDate) {
		this.joinDate = joinDate;
	}

	protected Div getDescription() {
		return description;
	}

	protected void setDescription(Div description) {
		this.description = description;
	}

	protected Div getActionsContainer() {
		return actionsContainer;
	}

	protected void setActionsContainer(Div actionsContainer) {
		this.actionsContainer = actionsContainer;
	}

	protected Div getTabsLayout() {
		return tabsLayout;
	}

	protected void setTabsLayout(Div tabsLayout) {
		this.tabsLayout = tabsLayout;
	}

	protected Button getBackButton() {
		return backButton;
	}

	protected void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	protected Div getTweetsListLayout() {
		return tweetsListLayout;
	}

	protected void setTweetsListLayout(Div tweetsListLayout) {
		this.tweetsListLayout = tweetsListLayout;
	}

	protected NativeButton getBanProfileButton() {
		return banProfileButton;
	}

	protected void setBanProfileButton(NativeButton banProfileButton) {
		this.banProfileButton = banProfileButton;
	}

	protected NativeButton getDeleteProfileButton() {
		return deleteProfileButton;
	}

	protected void setDeleteProfileButton(NativeButton deleteProfileButton) {
		this.deleteProfileButton = deleteProfileButton;
	}

	protected NativeButton getUserTweetsTab() {
		return userTweetsTab;
	}

	protected void setUserTweetsTab(NativeButton userTweetsTab) {
		this.userTweetsTab = userTweetsTab;
	}

	protected NativeButton getLikedTweetsTab() {
		return likedTweetsTab;
	}

	protected void setLikedTweetsTab(NativeButton likedTweetsTab) {
		this.likedTweetsTab = likedTweetsTab;
	}

	protected NativeButton getRetweetsTab() {
		return retweetsTab;
	}

	protected void setRetweetsTab(NativeButton retweetsTab) {
		this.retweetsTab = retweetsTab;
	}

	protected NativeButton getEditAccountButton() {
		return editAccountButton;
	}

	protected void setEditAccountButton(NativeButton editAccountButton) {
		this.editAccountButton = editAccountButton;
	}

}