import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('vista-verlistaampliadadeusuarios')
export class VistaVerListaAmpliadaDeUsuarios extends LitElement {
    static get styles() {
        return css`
            :host {
                display: flex;
                flex-direction: column;
                justify-content: flex-start;
                align-items: center;
                width: 100vw;
                height: 100vh;
                min-height: 100vh;
                min-width: 100vw;
                background-color: #000000;
                color: #ffffff;
                font-family: sans-serif;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                position: fixed;
                top: 0;
                left: 0;
                z-index: 1000;
                overflow: hidden;
            }

            vaadin-vertical-layout {
                width: 100vw;
                height: 100vh;
                background: transparent;
                align-items: center;
                justify-content: flex-start;
                box-sizing: border-box;
                padding: 0;
                overflow-y: auto;
                overflow-x: hidden;
            }

            vaadin-horizontal-layout {
                width: 100%;
                justify-content: center;
            }

            .list-title {
                font-size: 2em;
                color: #00ffff;
                text-align: center;
                margin: 40px 0 20px 0;
            }

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
            }

            #backButton:hover {
                background-color: #00ffff;
                color: #000;
            }

            .users-container {
                width: 100%;
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                background-color: #111;
                border-radius: 10px;
                border: 1px solid #333;
                max-height: calc(100vh - 200px);
                overflow-y: auto;
                overflow-x: hidden;
            }

            .no-users-message {
                text-align: center;
                color: #666;
                font-style: italic;
                padding: 40px 20px;
                font-size: 1.1em;
            }

            .user-item {
                background-color: #1a1a1a;
                border: 1px solid #00ffff;
                border-radius: 8px;
                padding: 15px;
                margin: 10px 0;
                display: flex;
                align-items: center;
                gap: 15px;
                transition: all 0.3s ease;
            }

            .user-item:hover {
                background-color: #2a2a2a;
                border-color: #ffffff;
                transform: translateY(-2px);
            }

            .user-avatar {
                width: 50px;
                height: 50px;
                border-radius: 50%;
                background-color: #00ffff;
                display: flex;
                align-items: center;
                justify-content: center;
                color: #000;
                font-weight: bold;
                font-size: 1.2em;
            }

            .user-info {
                flex: 1;
            }

            .user-name {
                color: #ffffff;
                font-size: 1.1em;
                font-weight: bold;
                margin: 0 0 5px 0;
            }

            .user-followers {
                color: #00ffff;
                font-size: 0.9em;
            }

            /* Estilos personalizados para scrollbar */
            .users-container::-webkit-scrollbar {
                width: 8px;
            }

            .users-container::-webkit-scrollbar-track {
                background: #222;
                border-radius: 4px;
            }

            .users-container::-webkit-scrollbar-thumb {
                background: #00ffff;
                border-radius: 4px;
            }

            .users-container::-webkit-scrollbar-thumb:hover {
                background: #ffffff;
            }

            vaadin-vertical-layout::-webkit-scrollbar {
                width: 8px;
            }

            vaadin-vertical-layout::-webkit-scrollbar-track {
                background: #111;
                border-radius: 4px;
            }

            vaadin-vertical-layout::-webkit-scrollbar-thumb {
                background: #333;
                border-radius: 4px;
            }

            vaadin-vertical-layout::-webkit-scrollbar-thumb:hover {
                background: #555;
            }
        `;
    }

    render() {
        return html`
            <vaadin-button id="backButton">← Volver</vaadin-button>
            <vaadin-vertical-layout id="vaadinVerticalLayout">
                <vaadin-horizontal-layout id="vaadinHorizontalLayout">
                    <div id="div" class="list-title">
                        Lista de Usuarios
                    </div>
                </vaadin-horizontal-layout>
                <div class="users-container" id="usersContainer">
                </div>
            </vaadin-vertical-layout>
        `;
    }
}