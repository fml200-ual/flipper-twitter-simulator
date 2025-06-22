import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/icons';

@customElement('vista-verlistaampliadadetweetsadministrador')
export class VistaVerlistaampliadadetweetsadministrador extends LitElement {
    static get styles() {
        return css`
            :host {
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                background-color: black;
                color: white;
                font-family: 'Arial', sans-serif;
                --lumo-space-m: 1rem;
                --lumo-space-l: 1.5rem;
                margin: 0;
                padding: 0;
                overflow: hidden;
                z-index: 1;
            }

            #main-layout {
                width: 100%;
                height: 100vh;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center;
                overflow: hidden;
            }

            #twitter-bird-icon {
                width: 60px;
                height: 60px;
                margin: var(--lumo-space-m) 0;
                flex-shrink: 0;
                background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100"><path d="M85 25c-3 1-6 2-10 2 4-2 6-6 7-10-3 2-7 3-11 4-3-3-8-5-13-5-10 0-18 8-18 18 0 1 0 3 1 4-15-1-28-8-37-19-2 3-2 6-2 10 0 6 3 11 8 14-3 0-5-1-7-2v1c0 9 6 16 14 18-1 0-3 1-5 1-1 0-2 0-3 0 2 6 8 11 15 11-5 4-12 7-20 7-1 0-3 0-4 0 7 5 16 7 25 7 30 0 47-25 47-47v-2c3-2 6-5 8-8z" fill="%2300FFFF"/></svg>');
                background-size: contain;
                background-repeat: no-repeat;
                background-position: center;
            }

            #tweet-list-container {
                width: 100%;
                height: 100%;
                flex: 1;
                display: flex;
                flex-direction: column;
                gap: 0;
                overflow-y: auto;
                overflow-x: hidden;
                padding: 0 var(--lumo-space-m);
                box-sizing: border-box;
                scrollbar-width: thin;
                scrollbar-color: #00FFFF #333;
            }

            /* Estilos para webkit browsers (Chrome, Safari) */
            #tweet-list-container::-webkit-scrollbar {
                width: 8px;
            }

            #tweet-list-container::-webkit-scrollbar-track {
                background: #333;
            }

            #tweet-list-container::-webkit-scrollbar-thumb {
                background: #00FFFF;
                border-radius: 4px;
            }

            #tweet-list-container::-webkit-scrollbar-thumb:hover {
                background: #00CCCC;
            }

            /* Estilos para el componente de tweet que se añadirá */
            .tweet-item {
                background-color: #1a1a1a;
                border: 2px solid #00FFFF;
                border-radius: 15px;
                padding: var(--lumo-space-m);
                margin-bottom: var(--lumo-space-s);
                width: 100%;
                max-width: 800px;
                margin-left: auto;
                margin-right: auto;
                display: flex;
                flex-direction: column;
                gap: var(--lumo-space-m);
                box-sizing: border-box;
            }

            .tweet-header {
                display: flex;
                align-items: center;
                gap: var(--lumo-space-m);
                color: white;
                font-weight: bold;
            }

            .tweet-icon {
                width: 40px;
                height: 40px;
                background-color: #00FFFF;
                border-radius: 5px;
                display: flex;
                align-items: center;
                justify-content: center;
                color: black;
                font-weight: bold;
                font-size: 1.2em;
            }

            .tweet-username {
                display: flex;
                flex-direction: column;
                gap: 2px;
            }

            .tweet-handle {
                color: #00FFFF;
                font-size: 0.9em;
            }

            .tweet-date {
                color: #999;
                font-size: 0.9em;
                margin-left: auto;
            }

            .tweet-content {
                background-color: #f0f0f0;
                color: black;
                padding: var(--lumo-space-m);
                border-radius: 10px;
                font-size: 1.1em;
                text-align: center;
            }

            .tweet-actions {
                display: flex;
                justify-content: space-around;
                align-items: center;
                padding-top: var(--lumo-space-m);
            }

            .tweet-action-btn {
                background: none;
                border: none;
                color: #999;
                cursor: pointer;
                padding: 8px 12px;
                border-radius: 15px;
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: 1.2em;
                min-width: 40px;
                height: 40px;
            }

            .tweet-action-btn:hover {
                background-color: rgba(255, 255, 255, 0.1);
            }

            #back-button-container {
                position: fixed;
                top: 20px;
                left: 20px;
                z-index: 10;
            }

            .back-button {
                background-color: #00FFFF;
                color: black;
                border: none;
                padding: 10px 20px;
                border-radius: 20px;
                font-weight: bold;
                cursor: pointer;
                font-size: 16px;
                display: flex;
                align-items: center;
                gap: 8px;
            }

            .back-button:hover {
                background-color: #00CCCC;
            }
        `;
    }

    render() {
        return html`
<vaadin-vertical-layout id="main-layout">
 <div id="back-button-container">
  <!-- El botón se añadirá dinámicamente aquí -->
 </div>
 <div id="twitter-bird-icon"></div>
 <vaadin-vertical-layout id="tweet-list-container">
  <!-- Aquí se añadirán dinámicamente los componentes de tweet -->
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }
}
