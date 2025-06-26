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
          background-color: #000000;
      }
      #mainContainer {
        width: 100%;
        height: 300px; /* Altura fija para permitir scroll de hashtags */
        max-width: 100%; /* Evita desbordamiento horizontal */
        overflow-y: auto; /* Permite desplazamiento vertical */
        overflow-x: hidden; /* Oculta el scroll horizontal */
        padding: 5px;
        align-items: stretch; /* Asegura que los items se estiren a lo ancho */
        gap: 3px; /* Espacio más pequeño entre hashtags */
        box-sizing: border-box;
        background-color: #000000 !important;
        border: 1px solid #333; /* Borde sutil */
        border-radius: 8px; /* Bordes redondeados */
        scrollbar-width: thin; /* Firefox: scroll más delgado */
      }
      
      /* Estilo personalizado para scrollbar en Webkit browsers */
      #mainContainer::-webkit-scrollbar {
        width: 6px; /* Más delgado que el de usuarios */
      }
      
      #mainContainer::-webkit-scrollbar-track {
        background: #1a1a1a;
        border-radius: 3px;
      }
      
      #mainContainer::-webkit-scrollbar-thumb {
        background: #555;
        border-radius: 3px;
      }
      
      #mainContainer::-webkit-scrollbar-thumb:hover {
        background: #777;
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