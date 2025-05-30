import { LitElement, html, css, customElement } from 'lit-element';

@customElement('vista-listadehashtags')
export class VistaListadehashtags extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        height: 100%; /* El host del componente ocupa el 100% de la altura de su padre. */
        width: 100%; /* Asegura que el host también ocupe el 100% del ancho. */
        padding: 10px; /* Considera si este padding es deseado si quieres que el contenido se extienda hasta los bordes. */
        box-sizing: border-box;
        background-color: #f0f0f0;
      }
      #mainContainer {
        width: 100%;
        height: 100%; /* ¡CLAVE! El contenedor principal del layout ocupa el 100% del espacio del host. */
        overflow-y: auto;
        padding: 0;
        align-items: stretch; /* Asegura que los ítems dentro de este VerticalLayout se estiren horizontalmente. */
      }
    `;
  }
  render() {
    return html`
      <vaadin-vertical-layout id="mainContainer"></vaadin-vertical-layout>
    `;
  }
  // createRenderRoot() { return this; } // Mantén esta línea comentada para usar Shadow DOM
}