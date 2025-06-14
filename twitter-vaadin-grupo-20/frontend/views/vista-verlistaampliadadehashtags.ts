import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icons';
import '@vaadin/avatar/src/vaadin-avatar.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('vista-verlistaampliadadehashtags')
export class VistaVerlistaampliadadehashtags extends LitElement {
    static get styles() {
        return css`
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            :host {
                display: block;
                height: 100vh; /* Altura de toda la ventana del navegador */
                width: 100vw; /* Ancho de toda la ventana del navegador */
                min-height: 100vh; /* Altura mínima de toda la ventana */
                margin: 0;
                padding: 0;
                background-color: black; /* Fondo oscuro como en la imagen */
                color: white; /* Texto blanco */
                font-family: 'Inter', sans-serif; /* Usar Inter como fuente principal */
                --lumo-space-m: 1rem; /* Define la variable de espacio lumo para padding */
                --lumo-space-l: 1.5rem;
                --lumo-space-s: 0.5rem;
                overflow-x: hidden; /* Evita scroll horizontal */
                position: fixed; /* Posición fija para ocupar toda la pantalla */
                top: 0;
                left: 0;
            }

            #main-layout {
                width: 100%;
                height: 100vh; /* Altura completa de la ventana */
                max-width: none; /* Eliminar restricción de ancho máximo */
                margin: 0; /* Sin margen para ocupar todo el espacio */
                padding: 0; /* Eliminar todo el padding */
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center; /* Centrar horizontalmente los elementos */
                overflow-y: auto; /* Permitir scroll vertical si es necesario */
            }

            h1 {
                font-size: 2.5em;
                margin: var(--lumo-space-m) 0 var(--lumo-space-l) 0; /* Solo margen vertical */
                padding: var(--lumo-space-s); /* Pequeño padding interno */
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
                margin: 0 var(--lumo-space-l) var(--lumo-space-m) var(--lumo-space-l); /* Margen lateral */
                width: calc(100% - 3rem); /* Ajustar ancho considerando los márgenes */
                flex: 1; /* Permitir que se expanda para ocupar el espacio disponible */
                min-height: 0; /* Permitir que se reduzca si es necesario */
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
                .hashtags-list-container {
                    margin: 0 var(--lumo-space-s) var(--lumo-space-m) var(--lumo-space-s);
                    width: calc(100% - 1rem);
                }
            }
        `;
    }

    render() {
        return html`
<vaadin-vertical-layout id="mainLayout" style="width: 100vw; height: 100vh; margin: 0; padding: 0;">
 <h1 id="pageTitle">#Hashtag</h1>
 <div id="hashtagsListContainer" class="hashtags-list-container"></div>
</vaadin-vertical-layout>
`;
    }

    // Este método se elimina para que el contenido de esta vista se renderice dentro del Shadow DOM
    // createRenderRoot() {
    //     return this;
    // }
}
