import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/icons';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-area/src/vaadin-text-area.js';
import '@vaadin/icon/src/vaadin-icon.js';

@customElement('vista-escribirgeneral')
export class VistaEscribirgeneral extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        height: 100%;
        box-sizing: border-box;
        background-color: #000; /* Full view black background */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
      }
      /* Main container simulating the dialog overlay */
      #dialogWrapper {
        position: fixed; /* Fixes the container to the viewport */
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent dark background */
        display: flex; /* Uses flexbox to center content */
        justify-content: center; /* Centers horizontally */
        align-items: center; /* Centers vertically */
        z-index: 1000; /* Ensures it's above other elements */
      }
      /* Dialog content */
      #dialogContent {
        background-color: #222; /* Dark dialog background */
        border: 2px solid #00FFFF; /* Cyan border */
        border-radius: var(--lumo-border-radius-l); /* Rounded corners */
        padding: var(--lumo-space-m);
        box-sizing: border-box;
        width: 60%; /* Window width, adjust as needed */
        max-width: 600px; /* Maximum window width */
        min-width: 300px;
        height: auto; /* Automatic height */
        display: flex; /* Ensures it's flexbox for its children */
        flex-direction: column; /* Stacks elements vertically */
        color: #fff; /* Default white text */
        position: relative; /* Necessary for absolute positioning of the close button */
        padding-top: var(--lumo-space-xl); /* Added: More top padding for the 'X' button */
        padding-right: var(--lumo-space-xl); /* Added: More right padding for the 'X' button */
      }
      /* Dialog header (X button and "¿Qué tienes en mente?" text) */
      #dialogHeader {
        display: flex;
        align-items: center;
        margin-bottom: var(--lumo-space-m);
      }
      #closeButton {
        position: absolute; /* Absolute positioning */
        top: var(--lumo-space-s); /* Distance from the top */
        right: var(--lumo-space-s); /* Changed: Distance from the right */
        background: none;
        border: none;
        color: #fff; /* White color for the 'X' */
        font-size: 2em; /* Large size for the 'X' */
        cursor: pointer;
        padding: 0;
        z-index: 1; /* Ensures the 'X' is above other elements */
      }
      
      #closeButton:hover {
        color: #00FFFF; /* Cyan on hover */
      }
      #messageIcon {
        color: #fff; /* Envelope icon color */
        font-size: 1.5em; /* Envelope icon size */
        margin-right: var(--lumo-space-s); /* Space to the right of the icon */
      }

      /* Styles for the static text "¿Qué tienes en mente?" */
      #questionText {
        color: #aaa; /* Question text color */
        font-size: 1.3em;
        flex-grow: 1; /* Allows the text to occupy the remaining space */
      }

      /* Styles for vaadin-text-area (tweetTextArea) */
      #tweetTextArea {
        width: 100%;
        flex-grow: 1;
        min-height: 100px;
        margin-bottom: var(--lumo-space-m);
        /* Lumo properties for overall component */
        --lumo-text-field-border-radius: var(--lumo-border-radius-s);
        --lumo-text-field-border-width: 2px;
        --lumo-text-field-focus-ring-color: #00FFFF; /* Cyan on focus */
        --lumo-text-field-border-color: #444; /* Subtle default border */
      }

      /* Target the internal input field part for tweetTextArea */
      #tweetTextArea::part(input-field) {
        background-color: #333; /* Dark background */
        color: #FFFFFF; /* White text (reverted to white) */
        padding: var(--lumo-space-s); /* Internal padding */
      }
      #tweetTextArea::part(input-field)::placeholder {
        color: #aaa; /* Lighter placeholder */
      }
      /* Ensure focus ring is visible */
      #tweetTextArea:focus-within {
        border-color: #00FFFF; /* Cyan border on focus */
      }

      /* Icon and publish button container */
      #footerActions {
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: space-between; /* Space between icons and button */
      }
      #iconContainer {
        display: flex;
        gap: var(--lumo-space-m); /* Space between icons */
      }
      .action-icon {
        color: #fff; /* White icons */
        font-size: 1.5em; /* Action icon size */
        cursor: pointer;
      }
      .action-icon:hover {
        color: #00FFFF; /* Cyan on hover */
      }
      #publishButton {
        background-color: #00FFFF; /* Cyan background */
        color: #000; /* Black text */
        border-radius: var(--lumo-border-radius-m); /* Rounded corners */
        padding: var(--lumo-space-s) var(--lumo-space-l);
        font-size: 1.1em;
        box-shadow: var(--lumo-box-shadow-s);
      }
    `;
  }
  render() {
    return html`
<div id="dialogWrapper">
 <vaadin-vertical-layout theme="spacing" id="dialogContent">
  <vaadin-button theme="icon tertiary" aria-label="Close" id="closeButton">
   <vaadin-icon icon="lumo:cross"></vaadin-icon>
  </vaadin-button>
  <vaadin-horizontal-layout id="dialogHeader">
   <vaadin-icon icon="vaadin:user" id="messageIcon"></vaadin-icon>
   <span id="questionText">¿Qué tienes en mente?</span>
  </vaadin-horizontal-layout>
  <vaadin-text-area placeholder="Escribe aquí tu mensaje..." id="tweetTextArea"></vaadin-text-area>
  <vaadin-horizontal-layout id="footerActions">
   <vaadin-horizontal-layout id="iconContainer">
    <vaadin-icon icon="vaadin:camera" class="action-icon" id="cameraIcon" size="16"></vaadin-icon>
    <vaadin-icon icon="lumo:play" class="action-icon" id="playIcon" size="1000"></vaadin-icon>
   </vaadin-horizontal-layout>
   <vaadin-button id="publishButton" tabindex="0">
     Publicar 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</div>
`;
  }
}
