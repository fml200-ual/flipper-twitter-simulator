import { LitElement, html, css } from 'lit';
import { customElement } from 'lit/decorators.js';
import '@vaadin/vertical-layout';
import '@vaadin/horizontal-layout';
import '@vaadin/button';
import '@vaadin/icon';
import '@vaadin/avatar';

// Apply global styles to remove default margins
const globalStyle = document.createElement('style');
globalStyle.textContent = `
    html, body {
        margin: 0 !important;
        padding: 0 !important;
        width: 100% !important;
        height: 100% !important;
        overflow: hidden !important;
    }
    
    body > * {
        margin: 0 !important;
        padding: 0 !important;
    }
`;
document.head.appendChild(globalStyle);

@customElement('vista-verlistaampliadadeusuarios')
export class VistaVerListaAmpliadaDeUsuarios extends LitElement {
    static get styles() {
        return css`
            /* Reset global styles */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            :host {
                display: block;
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                margin: 0;
                padding: 0;
                background-color: black;
                color: white;
                font-family: sans-serif;
                box-sizing: border-box;
                overflow: auto;
                z-index: 1000;
            }

            vaadin-vertical-layout {
                width: 100%;
                height: 100%;
                align-items: center;
                justify-content: flex-start;
                padding: 20px;
                background-color: black;
                box-sizing: border-box;
            }

            .list-title-container {
                width: 100%;
                text-align: center;
                margin-bottom: 15px;
            }

            .list-title {
                font-size: 1.5em;
                color: #ADD8E6; /* Light blue for title */
                margin: 0; /* Remove default margin from div */
            }

            .no-items-message {
                text-align: center;
                color: #888; /* Grey color for the message */
                font-style: italic;
                margin-top: 20px;
                padding: 10px;
                border: 1px dashed #555; /* A subtle border for the empty state */
                border-radius: 5px;
                width: fit-content; /* Adjust width to content */
            }

            vaadin-button {
                margin-top: 20px;
                background-color: transparent; /* Make button background transparent by default */
                color: #ADD8E6; /* Light blue for button text */
                font-size: 1.2em;
                --vaadin-button-border-radius: 5px; /* Adjust button border radius */
                padding: 10px 20px;
                box-shadow: none; /* Remove default shadow */
                border: 1px solid #ADD8E6; /* Add a border to mimic glow */
                text-shadow: 0 0 5px #ADD8E6; /* A subtle glow for the text */
            }

            vaadin-button:hover {
                background-color: rgba(173, 216, 230, 0.1); /* Slight blue tint on hover */
                text-decoration: none; /* Vaadin buttons don't typically underline */
            }

            vaadin-button[theme="tertiary"] {
                /* Using tertiary theme to keep it minimalist as per previous discussion,
                   but custom styles will override its background/border for glow effect */
                border: 1px solid #ADD8E6; /* Re-apply border if tertiary removes it */
                text-shadow: 0 0 5px #ADD8E6; /* Re-apply text shadow if tertiary removes it */
            }
        `;
    }

    render() {
        return html`
            <vaadin-vertical-layout theme="spacing" class="list-container" id="vaadinVerticalLayout" style="width: 100%; height: 100%;">
                <vaadin-horizontal-layout class="list-title-container" id="vaadinHorizontalLayout">
                    <div class="list-title" id="div">
                        Lista de usuarios:
                    </div>
                </vaadin-horizontal-layout>
                <div class="no-items-message">
                    No hay usuarios para mostrar
                </div>
            </vaadin-vertical-layout>
        `;
    }

}