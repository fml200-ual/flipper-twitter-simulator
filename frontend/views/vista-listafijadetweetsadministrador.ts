import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-listafijadetweetsadministrador')
export class VistaListafijadetweetsadministrador extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        justify-content: center;
        align-items: flex-start; /* Alineado arriba para el contenido */
        height: 100%;
        width: 100%;
        min-height: 100vh; /* Asegura que el host ocupe al menos el 100% de la altura del viewport */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        padding: var(--lumo-space-xl) 0; /* Espacio superior e inferior */
      }

      #mainContainer {
        background-color: #000; /* Fondo del contenedor principal */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        padding: var(--lumo-space-l);
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: var(--lumo-space-m); /* Espacio entre elementos */
        width: 100%;
        max-width: 600px; /* Ancho máximo para el contenedor */
        box-sizing: border-box;
        flex-grow: 1; /* AÑADIDO: Permite que el contenedor principal crezca y ocupe el espacio disponible */
      }

      #tweetsListContainer {
        width: 100%;
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-s); /* Espacio entre los ítems de tweet */
        overflow-y: auto; /* Permite desplazamiento si la lista es larga */
        padding: var(--lumo-space-s); /* Padding interno para la lista */
        box-sizing: border-box;
      }

      #showMoreButton {
        background-color: #333; /* Fondo oscuro para el botón */
        color: #00FFFF; /* Texto cian */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-m);
        padding: var(--lumo-space-s) var(--lumo-space-l);
        font-size: 1.1em;
        font-weight: bold;
        text-transform: uppercase;
        box-shadow: var(--lumo-box-shadow-s);
        cursor: pointer;
        margin-top: var(--lumo-space-l); /* Espacio superior para el botón */
        transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
      }

      #showMoreButton:hover {
        background-color: #00FFFF; /* Fondo cian al pasar el ratón */
        color: #000; /* Texto negro al pasar el ratón */
      }

      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #mainContainer {
          padding: var(--lumo-space-m);
          gap: var(--lumo-space-s);
          max-width: 95%;
        }
        #tweetsListContainer {
          padding: var(--lumo-space-xs);
        }
        #showMoreButton {
          font-size: 1em;
          padding: var(--lumo-space-xs) var(--lumo-space-m);
        }
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="mainContainer">
 <vaadin-vertical-layout id="tweetsListContainer"></vaadin-vertical-layout>
 <vaadin-button id="showMoreButton" tabindex="0">
   Mostrar más 
 </vaadin-button>
</vaadin-vertical-layout>
`;
  }

}
