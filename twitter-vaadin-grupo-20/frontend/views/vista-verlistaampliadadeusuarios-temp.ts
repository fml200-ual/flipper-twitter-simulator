import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('vista-verlistaampliadadeusuarios')
export class VistaVerListaAmpliadaDeUsuarios extends LitElement {
    static get styles() {
        return css`
            :host {
                display: block;
                background-color: #000000;
                color: #ffffff;
                font-family: sans-serif;
                padding: 20px;
                height: 100%;
                width: 100%;
            }

            vaadin-button {
                background-color: #00ffff;
                color: #000000;
                border: none;
                border-radius: 5px;
                padding: 10px 20px;
                margin: 10px;
                cursor: pointer;
                font-weight: bold;
            }

            vaadin-button:hover {
                background-color: #ffffff;
                color: #000000;
            }

            .list-title {
                font-size: 1.5em;
                color: #00ffff;
                text-align: center;
                margin: 20px 0;
            }

            vaadin-vertical-layout {
                background-color: #000000;
                width: 100%;
                height: 100%;
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
            </vaadin-vertical-layout>
        `;
    }
}
