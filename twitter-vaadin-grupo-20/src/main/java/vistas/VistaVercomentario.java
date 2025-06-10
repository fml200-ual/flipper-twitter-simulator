package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.button.Button;

@Tag("vista-vercomentario")
@JsModule("./views/vista-vercomentario.ts")
public class VistaVercomentario extends LitTemplate {

    @Id("commentMainContainer")
	private Div commentMainContainer;
	public Div getCommentMainContainer() {
		return commentMainContainer;
	}

	public void setCommentMainContainer(Div commentMainContainer) {
		this.commentMainContainer = commentMainContainer;
	}

	public HorizontalLayout getCommentHeader() {
		return commentHeader;
	}

	public void setCommentHeader(HorizontalLayout commentHeader) {
		this.commentHeader = commentHeader;
	}

	public Avatar getCommenterAvatar() {
		return commenterAvatar;
	}

	public void setCommenterAvatar(Avatar commenterAvatar) {
		this.commenterAvatar = commenterAvatar;
	}

	public Element getCommenterInfo() {
		return commenterInfo;
	}

	public void setCommenterInfo(Element commenterInfo) {
		this.commenterInfo = commenterInfo;
	}

	public Span getCommenterUsername() {
		return commenterUsername;
	}

	public void setCommenterUsername(Span commenterUsername) {
		this.commenterUsername = commenterUsername;
	}

	public Span getCommenterHandle() {
		return commenterHandle;
	}

	public void setCommenterHandle(Span commenterHandle) {
		this.commenterHandle = commenterHandle;
	}

	public Div getCommentContentArea() {
		return commentContentArea;
	}

	public void setCommentContentArea(Div commentContentArea) {
		this.commentContentArea = commentContentArea;
	}

	public Div getCharacterCount() {
		return characterCount;
	}

	public void setCharacterCount(Div characterCount) {
		this.characterCount = characterCount;
	}

	public Div getCommentText() {
		return commentText;
	}

	public void setCommentText(Div commentText) {
		this.commentText = commentText;
	}

	public HorizontalLayout getCommentFooter() {
		return commentFooter;
	}

	public void setCommentFooter(HorizontalLayout commentFooter) {
		this.commentFooter = commentFooter;
	}

	public Span getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Span commentDate) {
		this.commentDate = commentDate;
	}

	public HorizontalLayout getCommentLikeSection() {
		return commentLikeSection;
	}

	public void setCommentLikeSection(HorizontalLayout commentLikeSection) {
		this.commentLikeSection = commentLikeSection;
	}

	public Icon getCommentLikeButton() {
		return commentLikeButton;
	}

	public void setCommentLikeButton(Icon commentLikeButton) {
		this.commentLikeButton = commentLikeButton;
	}

	public Span getCommentLikeCount() {
		return commentLikeCount;
	}

	public void setCommentLikeCount(Span commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}

	public Button getDeleteCommentButton() {
		return deleteCommentButton;
	}

	public void setDeleteCommentButton(Button deleteCommentButton) {
		this.deleteCommentButton = deleteCommentButton;
	}

	@Id("commentHeader")
	private HorizontalLayout commentHeader;
	@Id("commenterAvatar")
	private Avatar commenterAvatar;
	@Id("commenterInfo")
	private Element commenterInfo;
	@Id("commenterUsername")
	private Span commenterUsername;
	@Id("commenterHandle")
	private Span commenterHandle;
	@Id("commentContentArea")
	private Div commentContentArea;
	@Id("characterCount")
	private Div characterCount;
	@Id("commentText")
	private Div commentText;
	@Id("commentFooter")
	private HorizontalLayout commentFooter;
	@Id("commentDate")
	private Span commentDate;
	@Id("commentLikeSection")
	private HorizontalLayout commentLikeSection;
	@Id("commentLikeButton")
	private Icon commentLikeButton;
	@Id("commentLikeCount")
	private Span commentLikeCount;
	@Id("deleteCommentButton")
	private Button deleteCommentButton;

	public VistaVercomentario() {
        // You can initialise any data required for the connected UI components here.
    }

}