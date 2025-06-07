import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-listafijadeusuarios')
export class VistaListafijadeusuarios extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        justify-content: center;
        align-items: stretch; /* Cambiado para que se estire verticalmente */
        height: 100vh; /* Ocupa toda la altura del viewport */
        width: 100vw; /* Ocupa todo el ancho del viewport */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        margin: 0; /* Elimina márgenes */
        padding: 0; /* Elimina padding */
        position: fixed; /* Fija la posición para ocupar toda la ventana */
        top: 0;
        left: 0;
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
        width: calc(100% - 2 * var(--lumo-space-m)); /* Ocupa todo el ancho menos los márgenes */
        height: calc(100% - 2 * var(--lumo-space-m)); /* Ocupa toda la altura menos los márgenes */
        max-width: none; /* Elimina el límite de ancho máximo */
        box-sizing: border-box;
        margin: var(--lumo-space-m); /* Pequeño margen para el borde */
      }
      
      h2 {
        color: #fff; /* Color del texto del título */
        font-size: 2.2em;
        margin: 0 0 var(--lumo-space-l) 0; /* Espacio debajo del título */
        font-weight: bold;
        text-align: center;
        flex-shrink: 0; /* Evita que el título se comprima */
      }
      
      #usersListContainer {
        width: 100%;
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-s); /* Espacio entre los ítems de usuario */
        overflow-y: auto; /* Permite desplazamiento si la lista es larga */
        padding: var(--lumo-space-s); /* Padding interno para la lista */
        box-sizing: border-box;
        flex: 1; /* Ocupa todo el espacio disponible verticalmente */
      }
      
      #showMoreUsersButton {
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
        flex-shrink: 0; /* Evita que el botón se comprima */
      }
      
      #showMoreUsersButton:hover {
        background-color: #00FFFF; /* Fondo cian al pasar el ratón */
        color: #000; /* Texto negro al pasar el ratón */
      }
      
      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #mainContainer {
          padding: var(--lumo-space-m);
          gap: var(--lumo-space-s);
          margin: var(--lumo-space-s); /* Margen más pequeño en móviles */
          width: calc(100% - 2 * var(--lumo-space-s)); /* Ajuste para móviles */
          height: calc(100% - 2 * var(--lumo-space-s)); /* Ajuste para móviles */
        }
        h2 {
          font-size: 1.8em;
        }
        #usersListContainer {
          padding: var(--lumo-space-xs);
        }
        #showMoreUsersButton {
          font-size: 1em;
          padding: var(--lumo-space-xs) var(--lumo-space-m);
        }
      }
    `;
  }
  
  render() {
    return html`
      <vaadin-vertical-layout id="mainContainer">
        <h2 id="pageTitle">Lista de usuarios:</h2>
        <vaadin-vertical-layout id="usersListContainer"></vaadin-vertical-layout>
        <vaadin-button id="showMoreUsersButton" tabindex="0">
          Mostrar más usuarios 
        </vaadin-button>
      </vaadin-vertical-layout>
    `;
  }
}