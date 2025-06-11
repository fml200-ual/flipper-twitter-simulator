import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/avatar/src/vaadin-avatar.js';

@customElement('vista-verlistaampliadadeusuarios')
export class VistaVerListaAmpliadaDeUsuarios extends LitElement {
    static get styles() {
        return css`
            :host {
                display: block;
                background-color: black;
                color: white;
                font-family: sans-serif;
                padding: 20px;
                border-radius: 8px;
            }

            vaadin-vertical-layout {
                align-items: center; /* Center content horizontally within the layout */
                justify-content: center; /* Center content vertically if space allows */
                padding: 10px;
                background-color: black;
                border-radius: 5px;
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
<vaadin-vertical-layout theme="spacing" class="list-container" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout class="list-title-container" id="vaadinHorizontalLayout">
  <div class="list-title" id="div">
   Lista de elementos:
  </div>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`
}

}