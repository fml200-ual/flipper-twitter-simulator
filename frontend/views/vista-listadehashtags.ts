import { LitElement, html, css, customElement } from 'lit-element';
import './vista-listadehashtags_item';

@customElement('vista-listadehashtags')
export class VistaListadehashtags extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
          padding: 10px;
          box-sizing: border-box;
          background-color: #f0f0f0;
      }
      #mainContainer {
        width: 100%;
        height: 100%;
        overflow-y: auto;
        padding: 0;
        align-items: stretch;
      }
      `;
  }
  render() {
    return html`
<vaadin-vertical-layout id="mainContainer">
 <vista-listadehashtags_item></vista-listadehashtags_item>
 <vista-listadehashtags_item></vista-listadehashtags_item>
 <vista-listadehashtags_item></vista-listadehashtags_item>
 <vista-listadehashtags_item></vista-listadehashtags_item>
</vaadin-vertical-layout>
`;
  }
  // Comenta o elimina esta línea para que funcione el Shadow DOM
  // createRenderRoot() {
  //   return this;
  // }
}