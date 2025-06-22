import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-listafijadehashtags')
export class VistaListafijadehashtags extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%; /* El host del componente ocupa el 100% de la altura de su padre. */
          width: 100%; /* Asegura que el host también ocupe el 100% del ancho. */
          max-width: 100%; /* Evita que se desborde horizontalmente */
          padding: 5px; /* Padding reducido para evitar desbordamientos */
          box-sizing: border-box;
      }
      #mainContainer {
        width: 100%;
        height: 100%;
        max-width: 100%; /* Evita desbordamiento horizontal */
        overflow-y: auto; /* Permite desplazamiento si la lista es muy larga */
        overflow-x: hidden; /* Oculta el scroll horizontal */
        padding: 0;
        align-items: stretch; /* Asegura que los items se estiren a lo ancho */
        gap: 5px; /* Espacio reducido entre los ítems */
        box-sizing: border-box;
        /* Removido position: absolute que causaba que se saliera del layout */
      }
      `;
  }

  render() {
    // Instancias de vista-listadenotificaciones_item codificadas directamente
    // en el HTML
    return html`
<vaadin-vertical-layout id="mainContainer"></vaadin-vertical-layout>
`;
  }

  //  createRenderRoot() {
  //    return this; // Render into the light DOM for Vaadin Flow
  //  }
}