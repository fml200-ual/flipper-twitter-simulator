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
                font-family: 'Inter', sans-serif;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                position: fixed;
                top: 0;
                left: 0;
                z-index: 1000;
                overflow-y: auto;
            }

            /* Botón de volver */
            vaadin-button.back-button {
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
                --lumo-primary-color: #00ffff;
                --lumo-primary-text-color: #00ffff;
            }
            
            vaadin-button.back-button:hover {
                background-color: #00ffff;
                color: #000;
            }

            vaadin-vertical-layout {
                width: 100vw;
                height: 100vh;
                background: transparent;
                align-items: center;
                justify-content: flex-start;
                box-sizing: border-box;
                padding: 80px 20px 20px 20px;
            }

            h1 {
                font-size: 2.5em;
                margin-bottom: 30px;
                color: #00FFFF;
                font-family: 'Comic Sans MS', cursive;
                text-align: center;
                width: 100%;
            }

            .hashtags-list-container {
                background-color: #333;
                border: 2px solid #00FFFF;
                border-radius: 8px;
                padding: 20px;
                margin-bottom: 30px;
                width: 90%;
                max-width: 800px;
                box-sizing: border-box;
            }

            vaadin-button#showMoreHashtagsButton {
                background-color: #00ffff;
                color: #000000;
                border: none;
                border-radius: 5px;
                padding: 15px 30px;
                font-size: 1.1em;
                font-weight: bold;
                margin-top: 20px;
                --lumo-primary-color: #00ffff;
            }

            vaadin-button#showMoreHashtagsButton:hover {
                background-color: #ffffff;
                color: #000000;
            }
        `;
    }

    render() {
        return html`
            <vaadin-button class="back-button" id="backButton">← Volver</vaadin-button>
            <vaadin-vertical-layout id="mainLayout">
                <h1 id="pageTitle">#Hashtags</h1>
                <div id="hashtagsListContainer" class="hashtags-list-container"></div>
                <vaadin-button id="showMoreHashtagsButton">
                    Mostrar más hashtags
                </vaadin-button>
            </vaadin-vertical-layout>
        `;
    }
}
