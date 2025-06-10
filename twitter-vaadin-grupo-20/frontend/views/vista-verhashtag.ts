import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/icons';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-verhashtag')
export class VistaVerhashtag extends LitElement {
    static get styles() {
        return css`
            :host {
                display: block;
                height: 100%;
                width: 100%;
                background-color: black; /* Fondo oscuro como en la imagen */
                color: white; /* Texto blanco */
                font-family: 'Arial', sans-serif; /* O la fuente que desees */
                --lumo-space-m: 1rem; /* Define la variable de espacio lumo para padding */
            }

            #main-layout {
                width: 100%;
                max-width: 800px; /* Ancho máximo para centrar el contenido */
                margin: 0 auto; /* Centrar el contenido */
                padding: var(--lumo-space-m);
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center; /* Centrar horizontalmente los elementos */
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
    }

    render() {
        // Función auxiliar para renderizar una "tarjeta" de tweet
        const renderTweetCard = (name: string, handle: string, date: string, content: string) => html`
            <div class="tweet-card">
                <div class="tweet-header">
                    <div class="profile-pic"></div>
                    <div class="user-info">
                        <span class="name">${name}</span>
                        <span class="handle">${handle}</span>
                        <span class="date">${date}</span>
                    </div>
                </div>
                <div class="tweet-content">
                    ${content}
                </div>
                <div class="tweet-actions">
                    <button class="action-button">
                        <vaadin-icon icon="lumo:heart"></vaadin-icon>
                        <span></span>
                    </button>
                    <button class="action-button">
                        <vaadin-icon icon="lumo:redo"></vaadin-icon>
                        <span></span>
                    </button>
                    <button class="action-button">
                        <vaadin-icon icon="lumo:chat"></vaadin-icon>
                        <span>2</span>
                    </button>
                </div>
            </div>
        `;

        return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <h1 style="align-self: center;" id="h1">#Hashtag</h1>
 <vaadin-vertical-layout id="main-layout" style="width: 100%; height: 100%; flex-shrink: 1;"></vaadin-vertical-layout>
 <button id="show-more-button" style="align-self: center;">Mostrar más</button>
</vaadin-vertical-layout>
`;
    }

    // Remove this method to render the contents of this view inside Shadow DOM
    createRenderRoot() {
        return this;
    }
}