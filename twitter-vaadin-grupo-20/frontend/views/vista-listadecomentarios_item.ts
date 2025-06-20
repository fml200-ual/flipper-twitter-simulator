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

  createRenderRoot() {
    return this; // Light DOM para mejor integración
  }
}

      #VL_nickYUsername {
        flex-grow: 1;
        line-height: 1.2;
      }

      #h4_nickUsuario {
        margin: 0;
        color: #fff;
        font-size: var(--lumo-font-size-l);
        font-weight: bold;
      }

      #label_username {
        color: #aaa;
        font-size: var(--lumo-font-size-s);
      }

      /* Contenedor del Texto del Comentario */
      #VL_contenidoComentario {
        width: 100%;
        background-color: #fff;
        padding: var(--lumo-space-m);
        border-radius: 5px;
        color: #333;
        font-size: 1.1em;
        text-align: center;
        box-sizing: border-box;
        border: none;
        box-shadow: inset 0 1px 3px rgba(0,0,0,0.1);
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-grow: 1; /* Permite que el contenido del comentario se estire para llenar el espacio vertical */
        overflow: auto; /* Si el texto es muy largo, permite desplazamiento interno */
      }

      /* Pie de página (fecha, avatar, like) */
      #HL_fechaYMeGusta {
        width: 100%;
        height: auto;
        align-items: center;
        justify-content: space-between;
        gap: var(--lumo-space-s);
        padding-top: var(--lumo-space-s); /* Espacio entre el contenido y el footer */
        flex-shrink: 0; /* Asegura que el footer no se encoja */
      }

      #label_fechaComentario {
        color: #aaa;
        font-size: var(--lumo-font-size-s);
        flex-grow: 1;
      }

      vaadin-avatar {
        --vaadin-avatar-size: 24px;
        background-color: #aaa;
        color: #333;
        font-size: var(--lumo-font-size-s);
        flex-shrink: 0;
      }

      #ironIcon_meGusta {
        width: 24px;
        height: 24px;
        color: black;
        flex-shrink: 0;
      }
    `;
  }
  render() {
    return html`
      <div class="comment-card">
        <div class="comment-header">
          <div class="avatar">👤</div>
          <div class="user-info">
            <div class="username" id="h4_nickUsuario">Usuario</div>
            <div class="handle" id="label_username">@usuario</div>
          </div>
        </div>
        <div class="comment-content">
          <div id="label_comentarioTexto">Este es un comentario de ejemplo. Aquí se mostraría el texto del comentario seleccionado.</div>
        </div>
        <div class="comment-footer">
          <span id="label_fechaComentario" class="date">2h</span>
          <div class="actions">
            <button class="action-btn">❤️ <span>5</span></button>
            <button class="action-btn">💬 <span>2</span></button>
          </div>
        </div>
      </div>
    `;
  }

  createRenderRoot() {
    return this; // Light DOM para mejor integración
  }
}