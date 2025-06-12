import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/icons';

@customElement('vista-verlistadeseguidoresregistrado')
export class VistaVerlistadeseguidoresregistrado extends LitElement {
    static get styles() {
        return css`
            :host {
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 100vw; /* Ocupa todo el ancho del viewport */
                height: 100vh; /* Ocupa toda la altura del viewport */
                background-color: #000; /* Fondo negro */
                font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
                box-sizing: border-box;
                margin: 0; /* Elimina márgenes */
                padding: 0; /* Elimina padding */
                position: fixed; /* Fija la posición para ocupar toda la ventana */
                top: 0;
                left: 0;
                overflow-y: auto; /* Permite scroll si es necesario */


                background-color: black; /* Fondo negro como en la imagen */
                color: white; /* Color de texto predeterminado */
                font-family: 'Arial', sans-serif; /* Fuente consistente */
            }

            #main-layout {
                width: 100%;
                max-width: 600px; /* Ancho máximo para el contenido */
                margin: 0 auto; /* Centrar el contenido */
                padding: var(--lumo-space-l);
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center; /* Centrar elementos horizontalmente */
            }

            #header-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                margin-bottom: var(--lumo-space-l);
            }

            #message-icon {
                width: 80px; /* Tamaño del icono del sobre */
                height: 80px;
                background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="%2387CEEB"><path d="M22 6.002c0-1.104-.896-2-2-2H4c-1.104 0-2 .896-2 2v12c0 1.104.896 2 2 2h16c1.104 0 2-.896 2-2V6.002zm-2 0l-8 4-8-4H20zm0 12H4V8.002l8 4 8-4V18zm-1-6.19l-7.39 3.695-.61.305-.61-.305-7.39-3.695V17.99H20v-5.188z"/></svg>'); /* Un SVG de sobre genérico */
                background-size: contain;
                background-repeat: no-repeat;
                background-position: center;
                margin-bottom: var(--lumo-space-m);
            }

            #title-layout {
                display: flex;
                flex-direction: column; /* Apilar título y nombre de usuario */
                align-items: center;
                text-align: center;
            }

            #list-title {
                font-size: 1.8em;
                font-weight: bold;
                color: #00FFFF; /* Color turquesa para el título */
                font-family: 'Comic Sans MS', cursive; /* Estilo de fuente divertido */
                margin-bottom: 0.2em; /* Poco espacio entre título y usuario */
            }

            #username {
                font-size: 1.4em;
                color: #00FFFF; /* Mismo color turquesa para el nombre de usuario */
                font-family: 'Comic Sans MS', cursive;
            }

            #followers-list-container {
                width: 100%;
                background-color: #333; /* Fondo para el contenedor de la lista */
                border: 2px solid #00FFFF; /* Borde turquesa */
                border-radius: 8px;
                padding: var(--lumo-space-m);
                box-sizing: border-box;
                margin-bottom: var(--lumo-space-l);
                display: flex;
                flex-direction: column;
                justify-content: center; /* Centrar verticalmente el mensaje si está vacío */
                align-items: center; /* Centrar horizontalmente el mensaje si está vacío */
                text-align: center;
            }

            #no-followers-message {
                color: gray;
                font-size: 1.1em;
                padding: var(--lumo-space-xl);
            }

            #show-more-followers-button {
                background-color: #00FFFF; /* Botón "Mostrar más seguidores" turquesa */
                color: black;
                padding: var(--lumo-space-s) var(--lumo-space-l);
                border-radius: 20px;
                font-weight: bold;
                margin-top: var(--lumo-space-m);
                cursor: pointer;
                border: none;
                font-size: 1.1em;
            }
        `;
    }

    render() {
        return html`
<vaadin-vertical-layout id="main-layout">
 <div id="header-container">
  <div id="message-icon"></div>
  <div id="title-layout">
   <span id="list-title">Lista de seguidores de</span>
   <span id="username">@usuario</span>
  </div>
 </div>
 <vaadin-vertical-layout id="followers-list-container">
  <span id="no-followers-message">No hay seguidores para mostrar.</span>
 </vaadin-vertical-layout>
 <vaadin-button id="show-more-followers-button" tabindex="0">
   Mostrar más seguidores 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

}