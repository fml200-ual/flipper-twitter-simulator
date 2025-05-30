import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-listafijadehashtags')
export class VistaListafijadehashtags extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        justify-content: center;
        align-items: flex-start; /* Alineado arriba para que el título se vea bien */
        height: 100%;
        width: 100%;
        min-height: 100vh; /* Asegura que el host ocupe al menos el 100% de la altura del viewport */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        padding-top: var(--lumo-space-xl); /* Espacio superior para el título */
      }
      /* Usando vaadin-vertical-layout para el contenedor principal */
      #mainContainer {
        background-color: #000; /* Fondo del contenedor principal */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        padding: var(--lumo-space-l);
        align-items: center;
        gap: var(--lumo-space-m); /* Espacio entre elementos */
        width: 100%;
        max-width: 500px; /* Ancho máximo para el contenedor */
        box-sizing: border-box;
      }
      h2 {
        color: #fff; /* Color del texto del título */
        font-size: 2.2em;
        margin: 0 0 var(--lumo-space-l) 0; /* Espacio debajo del título */
        font-weight: bold;
        text-align: center;
      }
      /* Estilos para el contenedor donde irá el nuevo componente de lista de hashtags */
      /* Usando vaadin-vertical-layout para el contenedor de la lista */
      #hashtagsListContainer {
        width: 100%;
        background-color: #333; /* Fondo oscuro de la lista */
        border: 2px solid #00FFFF; /* Borde cian de la lista */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        /* min-height: 200px; -- Eliminado para mejor adaptabilidad */
        /* justify-content: center; -- Eliminado para que el contenido se alinee al inicio */
        /* align-items: center; -- Eliminado para que el contenido se estire por defecto */
        color: #fff;
        font-size: 1.2em;
        text-align: center;
        padding: var(--lumo-space-m);
        box-sizing: border-box;
        overflow-y: auto; /* Añadido: Permite desplazamiento vertical si el contenido excede la altura */
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
          max-width: 90%;
        }
        h2 {
          font-size: 1.8em;
        }
        #hashtagsListContainer {
          /* min-height: 150px; -- Si se necesita una altura mínima, se puede reintroducir aquí */
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
<vaadin-vertical-layout id="mainContainer" style="height: 90%;">
 <h2 id="pageTitle ">#Hashtag</h2>
 <vaadin-vertical-layout id="hashtagsListContainer" style="flex-shrink: 0; flex-grow: 1;"></vaadin-vertical-layout>
 <vaadin-button id="showMoreButton" tabindex="0">
   Mostrar más hashtags 
 </vaadin-button>
</vaadin-vertical-layout>
`;
  }
}
