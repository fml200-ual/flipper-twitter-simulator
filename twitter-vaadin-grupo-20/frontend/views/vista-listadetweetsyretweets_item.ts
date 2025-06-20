import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/icons';
import '@vaadin/vaadin-lumo-styles/icons.js';
import '@vaadin/avatar/src/vaadin-avatar.js';

@customElement('vista-listadetweetsyretweets_item')
export class VistaListadetweetsyretweets_item extends LitElement {
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
      
      #mainContainer {
        width: 100%;
        background-color: #1a1a1a;
        border: 1px solid #333;
        border-radius: 8px;
        padding: 15px;
        cursor: pointer;
        transition: all 0.2s ease;
        color: white;
        box-sizing: border-box;
      }
      
      #mainContainer:hover {
        background-color: #2a2a2a;
        border-color: #00FFFF;
        transform: translateY(-2px);
      }
      
      #headerLayout {
        width: 100%;
        align-items: center;
        margin-bottom: 10px;
        gap: 12px;
      }
      
      #avatarIcon {
        width: 40px;
        height: 40px;
        background: linear-gradient(45deg, #00FFFF, #1da1f2);
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        font-weight: bold;
        font-size: 1.2em;
      }
      
      #userInfo {
        flex: 1;
      }
      
      #nickName {
        font-weight: bold;
        color: #00FFFF;
        margin: 0 0 2px 0;
        font-size: 1em;
      }
      
      #username {
        color: #999;
        font-size: 0.9em;
        margin: 0;
      }
      
      #contentArea {
        font-size: 1.1em;
        line-height: 1.4;
        margin: 10px 0;
        word-wrap: break-word;
        background-color: transparent;
        border: none;
        padding: 0;
      }
      
      #contentText {
        color: white;
      }
      
      .hashtag {
        color: #00FFFF;
        font-weight: bold;
      }
      
      #footerLayout {
        width: 100%;
        align-items: center;
        justify-content: space-between;
        margin-top: 15px;
        padding-top: 10px;
        border-top: 1px solid #333;
      }
      
      #dateLabel {
        color: #999;
        font-size: 0.9em;
      }
      
      .action-label-container {
        display: flex;
        align-items: center;
        gap: 5px;
        cursor: pointer;
        padding: 5px;
        border-radius: 4px;
        transition: color 0.2s ease;
      }
      
      .action-label-container:hover {
        color: #00FFFF;
      }
      
      .action-count-label {
        color: #999;
        font-size: 0.9em;
      }
      
      vaadin-icon {
        width: 18px;
        height: 18px;
        color: #999;
      }
      
      .action-label-container:hover vaadin-icon {
        color: #00FFFF;
      }    `;
  }
  
  render() {
    return html`
      <vaadin-vertical-layout id="mainContainer" style="background-color: #1a1a1a; border: 1px solid #333; border-radius: 8px; padding: 15px; margin: 8px 0; color: white;">
        <vaadin-horizontal-layout id="headerLayout" style="width: 100%; align-items: center; margin-bottom: 10px;">
          <div id="avatarIcon" style="width: 40px; height: 40px; background: linear-gradient(45deg, #00FFFF, #1da1f2); border-radius: 50%; display: flex; align-items: center; justify-content: center; color: white; font-weight: bold; margin-right: 12px;">👤</div>
          <vaadin-vertical-layout id="userInfo" style="flex: 1;">
            <h3 id="nickName" style="margin: 0; color: #00FFFF; font-size: 1em; font-weight: bold;">@usuario</h3>
            <span id="username" style="color: #999; font-size: 0.9em;">1h</span>
          </vaadin-vertical-layout>
        </vaadin-horizontal-layout>
        
        <div id="contentArea" style="font-size: 1.1em; line-height: 1.4; margin: 10px 0; word-wrap: break-word; color: white;">
          <span id="contentText">Este es el contenido del tweet con el <span class="hashtag" style="color: #00FFFF; font-weight: bold;">#Hashtag</span> correspondiente.</span>
        </div>
        
        <vaadin-horizontal-layout id="footerLayout" style="width: 100%; align-items: center; justify-content: space-between; margin-top: 15px; padding-top: 10px; border-top: 1px solid #333;">
          <span id="dateLabel" style="color: #999; font-size: 0.9em;">Hace 1h</span>
          
          <div class="action-label-container" style="display: flex; align-items: center; gap: 15px;">
            <div style="display: flex; align-items: center; gap: 5px; cursor: pointer;">
              <vaadin-icon id="commentsIcon" icon="lumo:chat" style="color: #999;"></vaadin-icon>
              <span class="action-count-label" style="color: #999; font-size: 0.9em;">12</span>
            </div>
            
            <div style="display: flex; align-items: center; gap: 5px; cursor: pointer;">
              <vaadin-icon id="retweetIcon" icon="lumo:reload" style="color: #999;"></vaadin-icon>
              <span class="action-count-label" style="color: #999; font-size: 0.9em;">5</span>
            </div>
            
            <div style="display: flex; align-items: center; gap: 5px; cursor: pointer;">
              <vaadin-icon id="heartIcon" icon="lumo:heart" style="color: #999;"></vaadin-icon>
              <span class="action-count-label" style="color: #999; font-size: 0.9em;">23</span>
            </div>
            
            <div style="display: flex; align-items: center; gap: 5px; cursor: pointer;">
              <vaadin-icon icon="lumo:arrow-right" style="color: #999;"></vaadin-icon>
            </div>
          </div>
        </vaadin-horizontal-layout>
      </vaadin-vertical-layout>
    `;
  }
  
  createRenderRoot() {
    return this; // Usar Light DOM para mejor integración
  }
  
  // Métodos para actualizar el contenido del tweet
  updateTweetContent(username: string, content: string, time: string) {
    const nicknameEl = this.querySelector('#nickName');
    const contentEl = this.querySelector('#contentText');
    const usernameEl = this.querySelector('#username');
    const avatarEl = this.querySelector('#avatarIcon');
    
    if (nicknameEl) nicknameEl.textContent = username;
    if (contentEl) contentEl.innerHTML = content.replace(/#(\w+)/g, '<span class="hashtag" style="color: #00FFFF; font-weight: bold;">#$1</span>');
    if (usernameEl) usernameEl.textContent = time;
    if (avatarEl) avatarEl.textContent = username.charAt(1).toUpperCase();
  }
  
  firstUpdated() {
    // Configurar evento de clic en el tweet
    const mainContainer = this.querySelector('#mainContainer');
    if (mainContainer) {
      mainContainer.addEventListener('click', (e) => {
        // Añadir efectos hover con JavaScript
        this.setupHoverEffects();
        
        // Disparar evento personalizado para navegación
        this.dispatchEvent(new CustomEvent('tweet-clicked', {
          detail: {
            username: this.querySelector('#nickName')?.textContent,
            content: this.querySelector('#contentText')?.textContent
          },
          bubbles: true
        }));
      });
    }
    
    // Configurar efectos hover
    this.setupHoverEffects();
  }
    setupHoverEffects() {
    const mainContainer = this.querySelector('#mainContainer') as HTMLElement;
    if (mainContainer) {
      mainContainer.addEventListener('mouseenter', () => {
        mainContainer.style.backgroundColor = '#2a2a2a';
        mainContainer.style.borderColor = '#00FFFF';
        mainContainer.style.transform = 'translateY(-2px)';
      });
      
      mainContainer.addEventListener('mouseleave', () => {
        mainContainer.style.backgroundColor = '#1a1a1a';
        mainContainer.style.borderColor = '#333';
        mainContainer.style.transform = 'translateY(0)';
      });
    }
  }
}