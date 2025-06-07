import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
// No se incluye el icono de sobre porque se asume que esta vista es "no registrado" y podría no necesitarlo.
// Si necesitas un icono específico, impórtalo aquí o usa un SVG/imagen.
// import '@vaadin/icons';

@customElement('vista-verlistaseguidosnoregistrado')
export class VistaVerlistaseguidosnoregistrado extends LitElement {
    static get styles() {
        return css`
            :host {
                display: block;
                height: 100%;
                width: 100%;
                background-color: black; /* Fondo negro */
                color: white; /* Color de texto predeterminado */
                font-family: 'Arial', sans-serif; /* Fuente consistente */
                --lumo-space-m: 1rem;
                --lumo-space-l: 1.5rem;
                --lumo-space-xl: 2rem;
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

            /* No se incluye el icono de sobre si la vista es para "no registrado" y no tiene un propósito específico */
            /* Si necesitas un elemento decorativo similar, considera un div vacío o un icono genérico */

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

            #followed-list-container-no-reg { /* Nuevo ID específico para no registrado */
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

            #no-followed-message-no-reg { /* Nuevo ID específico */
                color: gray;
                font-size: 1.1em;
                padding: var(--lumo-space-xl);
            }

            #show-more-followed-button-no-reg { /* Nuevo ID específico */
                background-color: #00FFFF; /* Botón "Mostrar más seguidos" turquesa */
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
                    <div id="title-layout">
                        <span id="list-title">Lista de seguidos de</span>
                        <span id="username">@usuario</span>
                    </div>
                </div>

                <vaadin-vertical-layout id="followed-list-container-no-reg">
                    <span id="no-followed-message-no-reg">No hay seguidos para mostrar.</span>
                    </vaadin-vertical-layout>

                <vaadin-button id="show-more-followed-button-no-reg">Mostrar más seguidos</vaadin-button>
            </vaadin-vertical-layout>
        `;
    }

    // Mantener esta configuración para renderizar directamente en el DOM ligero.
    createRenderRoot() {
        return this;
    }
}