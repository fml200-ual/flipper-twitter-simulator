import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/icons';
import '@vaadin/icon';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-verhashtag')
export class VistaVerhashtag extends LitElement {
    static get styles() {        return css`
            :host {
                display: block;
                height: 100%;
                width: 100%;
                background-color: black !important; /* Fondo oscuro como en la imagen */
                color: white; /* Texto blanco */
                font-family: 'Arial', sans-serif; /* O la fuente que desees */
                --lumo-space-m: 1rem; /* Define la variable de espacio lumo para padding */
                margin: 0;
                padding: 0;
                overflow: hidden;
            }

            /* Asegurar que todos los elementos Vaadin tengan fondo negro */
            vaadin-vertical-layout {
                background-color: black !important;
            }

            #main-layout {
                width: 100%;
                max-width: 800px; /* Ancho máximo para centrar el contenido */
                margin: 0 auto; /* Centrar el contenido */
                padding: 0;
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center; /* Centrar horizontalmente los elementos */
                background-color: transparent !important;
                flex: 1;
                overflow-y: auto;
            }

            h1 {
                font-size: 2.5em;
                margin-bottom: var(--lumo-space-l);
                color: #50b7f5; /* Color similar al azul de Twitter o un turquesa */
                font-family: 'Comic Sans MS', cursive; /* Estilo de fuente divertido como en la imagen */
            }

            .tweet-card {
                background-color: #333; /* Fondo más claro para cada tweet */
                border: 2px solid #00FFFF; /* Borde turquesa como en la imagen */
                border-radius: 8px;
                padding: var(--lumo-space-s) var(--lumo-space-m);
                margin-bottom: var(--lumo-space-m);
                width: 100%;
                box-sizing: border-box;
            }

            .tweet-header {
                display: flex;
                align-items: center;
                margin-bottom: var(--lumo-space-s);
            }

            .profile-pic {
                width: 40px;
                height: 40px;
                background-color: #555; /* Placeholder para foto de perfil */
                border-radius: 50%;
                margin-right: var(--lumo-space-s);
            }

            .user-info {
                display: flex;
                flex-direction: column;
                font-size: 0.9em;
            }

            .user-info .name {
                font-weight: bold;
                color: #00FFFF; /* Nombre en turquesa */
            }

            .user-info .handle, .user-info .date {
                color: #AAA;
            }

            .tweet-content {
                font-size: 1.1em;
                margin-bottom: var(--lumo-space-s);
                word-wrap: break-word; /* Para que el texto se ajuste si es largo */
            }

            .tweet-actions {
                display: flex;
                justify-content: space-around;
                margin-top: var(--lumo-space-s);
            }

            .action-button {
                background: none;
                border: none;
                color: white;
                cursor: pointer;
                font-size: 1.1em;
                display: flex;
                align-items: center;
                gap: 5px;
            }

            .action-button vaadin-icon {
                color: #00FFFF; /* Color de los iconos */
            }

            #show-more-button {
                background-color: #00FFFF; /* Botón "Mostrar más" turquesa */
                color: black;
                padding: var(--lumo-space-s) var(--lumo-space-l);
                border-radius: 20px;
                font-weight: bold;
                margin-top: var(--lumo-space-l);
                cursor: pointer;
                border: none;
                font-size: 1.1em;
            }
        `;
    }    render() {
        return html`
            <vaadin-vertical-layout style="width: 100vw; height: 100vh; margin: 0; padding: 20px; box-sizing: border-box; background-color: black; color: white; overflow-y: auto;" id="vaadinVerticalLayout">
                <vaadin-button id="volver-button" style="align-self: flex-start; margin-bottom: 20px; background-color: #1da1f2; color: white;">
                    <vaadin-icon icon="lumo:arrow-left"></vaadin-icon>
                    Volver
                </vaadin-button>
                <h1 style="align-self: center; color: #50b7f5; font-size: 2.5em; margin-bottom: 30px;" id="h1">#Hashtag</h1>
                <vaadin-vertical-layout id="main-layout" style="width: 100%; max-width: 800px; align-self: center; flex: 1; background-color: transparent; padding: 0; margin: 0;">
                    <!-- Los tweets con este hashtag se cargarán aquí dinámicamente -->
                </vaadin-vertical-layout>
                <vaadin-button id="show-more-button" style="align-self: center; background-color: #00FFFF; color: black; margin: 20px 0; padding: 10px 30px; border-radius: 25px; font-weight: bold; border: none; cursor: pointer;">
                    Mostrar más
                </vaadin-button>
            </vaadin-vertical-layout>
        `;
    }firstUpdated() {
        // El botón de volver se maneja ahora desde Java con navegación backend
        // No se necesita lógica de navegación en TypeScript

        // Configurar el botón de mostrar más
        const showMoreButton = this.shadowRoot?.getElementById('show-more-button');
        if (showMoreButton) {
            showMoreButton.addEventListener('click', () => {
                // Lógica para cargar más tweets con este hashtag
                console.log('Mostrar más tweets con este hashtag');
            });
        }
    }
}