import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/icons';
import '@vaadin/icon';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-verhashtag')
export class VistaVerhashtag extends LitElement {
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

                background-color: black; /* Fondo oscuro como en la imagen */
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

            #volver-button {
                --lumo-primary-color: #333;
                --lumo-primary-contrast-color: white;
                --lumo-contrast-10pct: #555;
                margin: 10px;
                font-size: 0.9em;
            }

            #volver-button:hover {
                --lumo-primary-color: #555;
            }
        `;
    }

    render() {
        return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-button id="volver-button" style="align-self: flex-start; margin: 10px;">← Volver</vaadin-button>
 <h1 style="align-self: center;" id="h1">#Hashtag</h1>
 <vaadin-vertical-layout id="main-layout" style="width: 100%; height: 100%; flex-shrink: 1;"></vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }


}