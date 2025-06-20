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
                justify-content: center;
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
            }

            vaadin-vertical-layout {
                width: 100vw;
                height: 100vh;
                background: transparent;
                align-items: center;
                justify-content: flex-start;
                box-sizing: border-box;
                padding: 0;
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
                <!-- Aquí irán los usuarios -->
            </vaadin-vertical-layout>
        `;
    }
}