import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-listadetweetsyretweets')
export class VistaListadetweetsyretweets extends LitElement {  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
          width: 100%;
          background-color: transparent !important;
          color: white;
          font-family: 'Arial', sans-serif;
          margin: 0;
          padding: 0;
      }
      
      #mainContainer {
        width: 100%;
        height: 100%;
        overflow-y: auto;
        padding: 0;
        margin: 0;
        display: flex;
        flex-direction: column;
        gap: 15px;
        background-color: transparent !important;
      }
      
      /* Asegurar que todos los elementos Vaadin tengan fondo transparente */
      vaadin-vertical-layout {
        background-color: transparent !important;
      }
      
      .tweet-card {
        background-color: #1a1a1a;
        border: 1px solid #333;
        border-radius: 8px;
        padding: 15px;
        margin: 8px 0;
        cursor: pointer;
        transition: all 0.2s ease;
        color: white;
      }
      
      .tweet-card:hover {
        background-color: #2a2a2a;
        border-color: #00FFFF;
        transform: translateY(-2px);
      }
      
      .tweet-header {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
      }
      
      .profile-pic {
        width: 40px;
        height: 40px;
        background: linear-gradient(45deg, #00FFFF, #1da1f2);
        border-radius: 50%;
        margin-right: 12px;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        font-weight: bold;
      }
      
      .user-info {
        flex: 1;
      }
      
      .username {
        font-weight: bold;
        color: #00FFFF;
        margin-bottom: 2px;
      }
      
      .time {
        color: #999;
        font-size: 0.9em;
      }
      
      .tweet-content {
        font-size: 1.1em;
        line-height: 1.4;
        margin: 10px 0;
        word-wrap: break-word;
      }
      
      .hashtag {
        color: #00FFFF;
        font-weight: bold;
      }
      `;
  }
    render() {
    return html`
      <vaadin-vertical-layout id="mainContainer" style="background-color: transparent !important; width: 100%; height: 100%; margin: 0; padding: 0; box-sizing: border-box;">
        <!-- Los tweets se agregan dinámicamente aquí -->
      </vaadin-vertical-layout>
    `;
  }
  
  createRenderRoot() {
    return this; // Usar Light DOM para mejor integración con estilos externos
  }
}
