import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-verlistaampliadadeusuarios')
export class VistaVerListaAmpliadaDeUsuarios extends LitElement {
    static get styles() {
        return css`
            :host {
                display: block;
                height: 100%;
                width: 100%;
                background-color: black; /* Fondo negro como en la imagen */
                color: white; /* Color de texto predeterminado */
                font-family: 'Arial', sans-serif; /* Fuente consistente con las otras vistas */
                --lumo-space-m: 1rem;
                --lumo-space-l: 1.5rem;
                --lumo-space-xl: 2rem;
            }

            #main-layout {
                width: 100%;
                max-width: 600px; /* Ancho máximo para la lista de usuarios */
                margin: 0 auto; /* Centrar el contenido */
                padding: var(--lumo-space-l);
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center; /* Centrar elementos horizontalmente */
            }

            #list-title {
                font-size: 2em;
                font-weight: bold;
                color: #00FFFF; /* Color turquesa para el título */
                margin-bottom: var(--lumo-space-l);
                text-align: center;
                font-family: 'Comic Sans MS', cursive; /* Estilo de fuente divertido */
            }

            #user-list-container {
                width: 100%;
                /* Puedes añadir un borde o fondo para visualizar el área donde irán los usuarios */
                /* border: 1px dashed gray; */
                /* min-height: 300px; /* Altura mínima para que se vea el contenedor vacío */ */
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

            #no-users-message {
                color: gray;
                font-size: 1.1em;
                padding: var(--lumo-space-xl);
            }

            #show-more-users-button {
                background-color: #00FFFF; /* Botón "Mostrar más usuarios" turquesa */
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
 <h1 id="list-title">Lista de usuarios:</h1>
 <vaadin-vertical-layout id="user-list-container">
  <span id="no-users-message">No hay usuarios para mostrar.</span>
 </vaadin-vertical-layout>
 <vaadin-button id="show-more-users-button">
  Mostrar más usuarios
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    // Mantener esta configuración para renderizar directamente en el DOM ligero.
    createRenderRoot() {
        return this;
    }
}