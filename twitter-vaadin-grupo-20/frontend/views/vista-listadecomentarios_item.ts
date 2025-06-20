import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/icons';
import '@vaadin/avatar/src/vaadin-avatar.js';

@customElement('vista-listadecomentarios_item')
export class VistaListadecomentarios_item extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        background-color: transparent;
        color: white;
        font-family: 'Arial', sans-serif;
        margin: 8px 0;
      }

      .comment-card {
        background-color: #1a1a1a;
        border: 1px solid #333;
        border-radius: 8px;
        padding: 12px;
        width: 100%;
        box-sizing: border-box;
        transition: all 0.2s ease;
      }
      
      .comment-card:hover {
        background-color: #2a2a2a;
        border-color: #00FFFF;
      }

      .comment-header {
        display: flex;
        align-items: center;
        margin-bottom: 8px;
        gap: 8px;
      }

      .avatar {
        width: 32px;
        height: 32px;
        background: linear-gradient(45deg, #00FFFF, #1da1f2);
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        font-weight: bold;
        font-size: 0.9em;
      }

      .user-info {
        flex: 1;
        display: flex;
        flex-direction: column;
      }

      .username {
        font-weight: bold;
        color: #00FFFF;
        font-size: 0.9em;
      }

      .time {
        color: #999;
        font-size: 0.8em;
      }

      .content {
        font-size: 0.95em;
        line-height: 1.4;
        margin-top: 8px;
        word-wrap: break-word;
        color: white;
      }
      `;
  }

  render() {
    return html`
      <div class="comment-card">
        <div class="comment-header">
          <div class="avatar">👤</div>
          <div class="user-info">
            <div class="username">@usuario</div>
            <div class="time">5m</div>
          </div>
        </div>
        <div class="content">Este es un comentario de ejemplo sobre el tweet.</div>
      </div>
    `;
  }

  // Método para actualizar el contenido del comentario
  updateCommentContent(username: string, content: string, time: string) {
    const usernameEl = this.querySelector('.username');
    const contentEl = this.querySelector('.content');
    const timeEl = this.querySelector('.time');
    const avatarEl = this.querySelector('.avatar');
    
    if (usernameEl) usernameEl.textContent = username;
    if (contentEl) contentEl.textContent = content;
    if (timeEl) timeEl.textContent = time;
    if (avatarEl) avatarEl.textContent = username.charAt(1).toUpperCase();
  }

  firstUpdated() {
    // Configurar efectos hover
    const commentCard = this.querySelector('.comment-card') as HTMLElement;
    if (commentCard) {
      commentCard.addEventListener('mouseenter', () => {
        commentCard.style.backgroundColor = '#2a2a2a';
        commentCard.style.borderColor = '#00FFFF';
      });
      
      commentCard.addEventListener('mouseleave', () => {
        commentCard.style.backgroundColor = '#1a1a1a';
        commentCard.style.borderColor = '#333';
      });
    }
  }

  createRenderRoot() {
    return this; // Light DOM para mejor integración
  }
}