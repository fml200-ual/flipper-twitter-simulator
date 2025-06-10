import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/avatar/src/vaadin-avatar.js';

@customElement('vista-verlistaampliadadeusuarios')
export class VistaVerListaAmpliadaDeUsuarios extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        font-family: sans-serif;
        background-color: #000000;
        color: white;
        padding: 16px;
      }

      .title {
        font-size: 20px;
        font-weight: bold;
        text-align: center;
        margin-bottom: 16px;
      }

      .user-list {
        border: 2px solid cyan;
        border-radius: 10px;
        padding: 10px;
        background-color: #1a1a1a;
      }

      vaadin-horizontal-layout.user-entry {
        border: 1px solid #00f0f0;
        border-radius: 6px;
        margin: 5px 0;
        padding: 5px;
        align-items: center;
        background-color: #222;
        justify-content: space-between;
      }

      .avatar {
        display: flex;
        align-items: center;
        gap: 8px;
      }

      .description {
        background-color: #333;
        color: white;
        padding: 4px 8px;
        border-radius: 4px;
        flex-grow: 1;
        margin-left: 10px;
        text-align: center;
      }

      vaadin-button.load-more {
        margin-top: 16px;
        background-color: #000;
        color: cyan;
        border: none;
      }
    `;
  }

  render() {
    return html`

`;
  }
}
