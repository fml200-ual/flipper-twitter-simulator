import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-listadecomentarios')
export class VistaListadecomentarios extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          width: 100%;
          background-color: transparent;
          color: white;
          font-family: 'Arial', sans-serif;
      }
      
      #mainContainer {
        width: 100%;
        background-color: transparent;
        display: flex;
        flex-direction: column;
        gap: 10px;
        padding: 0;
        margin: 0;
      }
      
      #contentLayout {
        width: 100%;
        background-color: transparent;
        display: flex;
        flex-direction: column;
        gap: 10px;
      }
      `;
  }

  render() {
    return html`
      <vaadin-vertical-layout id="mainContainer" style="width: 100%; background-color: transparent; margin: 0; padding: 0;">
        <vaadin-horizontal-layout id="contentLayout" style="width: 100%; background-color: transparent; flex-direction: column; align-items: stretch; gap: 10px;"></vaadin-horizontal-layout>
      </vaadin-vertical-layout>
    `;
  }

  createRenderRoot() {
    return this; // Light DOM para mejor integración
  }
}