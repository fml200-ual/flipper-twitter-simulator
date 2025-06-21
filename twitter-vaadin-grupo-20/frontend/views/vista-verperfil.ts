import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';

@customElement('vista-verperfil')
export class VistaVerperfil extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 100vw; /* Ocupa todo el ancho del viewport */
        height: 100vh; /* Ocupa toda la altura del viewport */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        margin: 0; /* Elimina márgenes */
        padding: 0; /* Elimina padding */
        position: fixed; /* Fija la posición para ocupar toda la ventana */
        top: 0;
        left: 0;
        overflow-y: auto; /* Permite scroll si es necesario */
        
        /* -- 1. Variables CSS para un theming más fácil -- */
        --primary-color: #00ffff;
        --danger-color: #cc3333;
        --danger-color-hover: #e64a4a;
        --background-color: #000;
        --surface-color: #fff;
        --text-color-on-dark: #fff;        --text-color-on-light: #000;
        --secondary-text-color: #888;
        --placeholder-bg-color: #333;
        --border-color: #fff;
        
        /* Variables de spacing */
        --space-xs: 4px;
        --space-s: 8px;
        --space-m: 16px;
        --space-l: 24px;
        --space-xl: 32px;
      }
        /* Botón de volver */
      .back-button {
        position: fixed;
        top: 20px;
        left: 20px;
        background-color: rgba(0, 0, 0, 0.8);
        color: var(--primary-color);
        border: 1px solid var(--primary-color);
        border-radius: 25px;
        padding: 10px 20px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        z-index: 1000;
        transition: all 0.3s ease;
        backdrop-filter: blur(10px);
        --lumo-primary-color: var(--primary-color);
      }
      
      vaadin-button.back-button {
        position: fixed;
        top: 20px;
        left: 20px;
        background-color: rgba(0, 0, 0, 0.8);
        color: var(--primary-color);
        border: 1px solid var(--primary-color);
        border-radius: 25px;
        font-size: 16px;
        font-weight: bold;
        z-index: 1000;
        --lumo-primary-color: var(--primary-color);
        --lumo-primary-text-color: var(--primary-color);
      }
      
      vaadin-button.back-button:hover {
        background-color: var(--primary-color);
        color: var(--background-color);
        transform: scale(1.05);
      }
      .view-wrapper {
        position: relative;
        height: 100%;
        width: 100%;
      }
      .profile-container {
        display: flex;
        flex-direction: column;
        height: 100%;
        padding: 20px;
        box-sizing: border-box;
        background-color: var(--background-color);
        color: var(--text-color-on-dark);
        font-family: sans-serif;
      }
      .header {
        position: relative;
        margin-bottom: 70px;
        flex-shrink: 0;
      }
      .cover-photo {
        background-color: var(--placeholder-bg-color);
        border: 1px solid var(--border-color);
        height: 200px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 5rem;
        font-weight: bold;
        color: rgba(255, 255, 255, 0.5);
      }
      
      .profile-picture {
        position: absolute;
        top: 130px;
        left: 20px;
        background-color: #555;
        border: 4px solid var(--background-color);
        width: 120px;
        height: 120px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 3rem;
        font-weight: bold;
        color: rgba(255, 255, 255, 0.5);
      }
      
      .profile-info, .description, .actions-and-tabs, .show-more {
        flex-shrink: 0;
      }
      .profile-info {
        padding-left: 160px;
        display: flex;
        align-items: center;
        flex-wrap: wrap; 
        gap: 15px 20px;
        margin-top: -50px;
        margin-bottom: 10px;
      }
      .profile-info .name {
          font-size: 1.2em;
          font-weight: bold;
      }
      .profile-info .username {
          color: var(--secondary-text-color);
      }
      
      /* -- 2. Estilos para los items con iconos -- */
      .info-item {
        display: flex;
        align-items: center;
        gap: 8px;
      }
      .description {
        border: 2px solid var(--primary-color);
        padding: 20px;
        margin: 20px 0;
        text-align: center;
        font-size: 1.2em;
        border-radius: 5px;
      }
      .tabs {
        display: flex;
        flex-wrap: wrap; 
        gap: 10px;
        margin-bottom: 20px;
      }
      .tabs button {
        background-color: var(--surface-color);
        color: var(--text-color-on-light);
        border: 1px solid var(--primary-color);
        padding: 10px 15px;
        border-radius: 20px;
        cursor: pointer;
        font-weight: bold;
        transition: transform 0.2s ease, background-color 0.2s ease, filter 0.2s ease;
      }
      /* -- 3. Efectos hover mejorados -- */
      .tabs button:not(.active):not(.danger-button):hover {
          background-color: #f0f0f0;
          transform: translateY(-2px);
      }
      .tabs button.active {
        background-color: var(--primary-color);
        color: var(--text-color-on-light);
      }
      .tabs button.active:hover {
        filter: brightness(1.1);
        transform: translateY(-2px);
      }
      
      .tabs button.danger-button {
        background-color: var(--danger-color);
        border-color: var(--danger-color);
        color: var(--text-color-on-dark);
      }
      .tabs button.danger-button:hover {
        background-color: var(--danger-color-hover);
        border-color: var(--danger-color-hover);
        transform: translateY(-2px);
      }
      .tweets-list {
        flex-grow: 1;
        overflow-y: auto;
        min-height: 100px;
        padding-right: 5px; /* Evita que el scrollbar tape el borde */
      }
      
      /* -- 4. Uso de <article> y mejora de hover -- */
      .list-item {
        background-color: var(--surface-color);
        color: var(--text-color-on-light);
        padding: 20px;
        border-radius: 5px;
        margin-bottom: 10px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-weight: bold;
        font-size: 1.1em;
        border: 2px solid transparent;
        transition: border-color 0.2s ease;
      }
      .list-item:hover {
          border-color: var(--primary-color);
          cursor: pointer;
      }
      .list-item .stats {
        display: flex;
        align-items: center;
        gap: 8px;
        color: #555;
      }
      .show-more {
        text-align: center;
        margin-top: 20px;
        color: var(--primary-color);
        cursor: pointer;
        font-size: 1.2em;
        transition: text-decoration 0.2s ease;
      }
      .show-more:hover {
          text-decoration: underline;
      }
      .edit-account-button {
        position: absolute;
        bottom: 20px;
        left: 20px;
        background-color: #d93636;
        color: white;
        border: 1px solid #ff4f4f;
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
        z-index: 100;
        transition: background-color 0.2s ease;
      }
      .edit-account-button:hover {
        background-color: var(--danger-color-hover);
      }
    `;
  }  render() {
    return html`
<vaadin-button class="back-button" id="backButton">← Volver</vaadin-button>
<div class="view-wrapper" id="viewWrapper">
 <div class="profile-container" id="profileContainer">
  <header class="header" id="header">
   <div class="cover-photo" id="coverPhoto">
     X 
   </div>
   <div class="profile-picture" id="profilePicture">
     X 
   </div>
  </header>
  <section class="profile-info" id="profileInfoSection">
   <div id="nameContainer">
    <div class="name" id="profileName">
      Nombre 
    </div>
    <div class="username" id="profileUsername">
      @usuario 
    </div>
   </div>
   <span class="info-item" id="followingCount">👥 <strong>142</strong> siguiendo</span>
   <span class="info-item" id="followersCount">👥 <strong>2,5K</strong> seguidores</span>
   <span class="info-item" id="joinDate">📅 Se unió en <strong>junio de 2025</strong></span>
  </section>
  <div class="description" id="description">
    Descripcion 
  </div>
  <div class="actions-and-tabs" id="actionsContainer" style="align-self: center;">
   <div class="tabs" id="tabsLayout">
    <button class="danger-button" id="banProfileButton">Banear perfil</button>
    <button class="danger-button" id="deleteProfileButton">Eliminar perfil</button>
    <button class="active" id="userTweetsTab">Tweets del usuario</button>
    <button id="likedTweetsTab">Tweets que le gustan</button>
    <button id="retweetsTab">Retweets</button>
   </div>
  </div>
  <div class="tweets-list" id="tweetsListLayout"></div>
  <div class="show-more" id="showMoreButton">
    Mostrar más tweets 
  </div>
 </div>
 <button class="edit-account-button" id="editAccountButton">Editar cuenta</button>
</div>
`;
  }
}