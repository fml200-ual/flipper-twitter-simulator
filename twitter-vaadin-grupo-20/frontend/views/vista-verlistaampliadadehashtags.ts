import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icons';
import '@vaadin/avatar/src/vaadin-avatar.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('vista-verlistaampliadadehashtags')
export class VistaVerlistaampliadadehashtags extends LitElement {
    static get styles() {
        return css`            :host {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                width: 100vw;
                height: 100vh;
                min-height: 100vh;
                min-width: 100vw;
                background-color: #000000;
                color: #ffffff;
                font-family: 'Inter', sans-serif;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                position: fixed;
                top: 0;
                left: 0;
                z-index: 1000;
                --lumo-space-m: 1rem;
                --lumo-space-l: 1.5rem;
                --lumo-space-s: 0.5rem;
            }            #main-layout {
                width: 100vw;
                height: 100vh;
                background: transparent;
                align-items: center;
                justify-content: flex-start;
                box-sizing: border-box;
                padding: 0;
                display: flex;
                flex-direction: column;
            }
            
            /* Botón de volver */
            #backButton {
                position: absolute;
                top: 30px;
                left: 30px;
                background-color: #222;
                color: #00ffff;
                border: 1px solid #00ffff;
                border-radius: 5px;
                font-size: 1.1em;
                padding: 10px 24px;
                z-index: 1100;
                transition: background 0.2s;
                --lumo-primary-color: #00ffff;
                --lumo-primary-text-color: #00ffff;
            }
            
            #backButton:hover {
                background-color: #00ffff;
                color: #000;
            }

            h1 {
                font-size: 2.5em;
                margin-bottom: var(--lumo-space-l);
                color: #00FFFF; /* Color turquesa como en la imagen */
                font-family: 'Comic Sans MS', cursive; /* Estilo de fuente divertido como en la imagen */
                text-align: center;
                width: 100%;
            }

            .hashtags-list-container {
                background-color: #333; /* Fondo más oscuro para el contenedor de la lista */
                border: 2px solid #00FFFF; /* Borde turquesa como en la imagen */
                border-radius: 8px;
                padding: var(--lumo-space-s) 0; /* Padding vertical, horizontal 0 para los elementos */
                margin-bottom: var(--lumo-space-m);
                width: 100%;
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
            }

            .hashtag-item {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: var(--lumo-space-s) var(--lumo-space-m); /* Relleno a los lados */
                border-bottom: 1px solid rgba(0, 255, 255, 0.2); /* Línea divisoria suave */
            }

            .hashtag-item:last-child {
                border-bottom: none; /* No hay línea en el último elemento */
            }

            .hashtag-name {
                font-size: 1.1em;
                font-weight: bold;
                color: white; /* Texto blanco */
            }

            .hashtag-count {
                font-size: 1em;
                color: #AAA; /* Color de texto más claro para el conteo */
                display: flex;
                align-items: center;
                gap: 5px;
            }

            .hashtag-count vaadin-icon {
                color: white; /* Color del icono del cuadrito */
                font-size: 0.8em; /* Tamaño del icono */
            }

            #show-more-hashtags-button {
                background-color: #00FFFF; /* Botón "Mostrar más" turquesa */
                color: black;
                padding: var(--lumo-space-s) var(--lumo-space-l);
                border-radius: 20px;
                font-weight: bold;
                margin-top: var(--lumo-space-l);
                cursor: pointer;
                border: none;
                font-size: 1.1em;
                text-transform: uppercase; /* Para que coincida con el estilo de la imagen */
                transition: background-color 0.2s ease-in-out;
            }

            #show-more-hashtags-button:hover {
                background-color: #00b3b3; /* Un tono más oscuro al pasar el ratón */
            }

            /* Responsive adjustments */
            @media (max-width: 600px) {
                h1 {
                    font-size: 2em;
                }
                .hashtag-name {
                    font-size: 1em;
                }
                .hashtag-count {
                    font-size: 0.9em;
                }
                #show-more-hashtags-button {
                    font-size: 1em;
                    padding: var(--lumo-space-s) var(--lumo-space-m);
                }
            }
        `;    }    render() {
        return html`
            <vaadin-button id="backButton">← Volver</vaadin-button>
            <vaadin-vertical-layout id="mainLayout" style="width: 100%; height: 100%;" theme="spacing">
                <h1 id="pageTitle">#Hashtags</h1>
                <div id="hashtagsListContainer" class="hashtags-list-container"></div>
                <vaadin-button id="showMoreHashtagsButton" style="align-self: center;" tabindex="0">
                    Mostrar más hashtags
                </vaadin-button>
            </vaadin-vertical-layout>
        `;
    }
}
