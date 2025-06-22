import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout';
import '@vaadin/horizontal-layout';
import '@vaadin/button';

@customElement('vista-agruparretweets')
export class VistaAgruparretweets extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        width: 100%;
        height: 100%;
        box-sizing: border-box;
      }

      #mainContainer {
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        align-items: stretch;
        background-color: #333;
        border: 2px solid #00FFFF;
        padding: var(--lumo-space-m);
        box-sizing: border-box;
      }

      #tweetsContainer {
        flex: 1;
        width: 100%;
        overflow-y: auto;
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-m);
      }
      #moreTweetsButtonContainer {
        flex-shrink: 0;
        width: 100%;
        display: flex;
        justify-content: center;
        padding-top: var(--lumo-space-m);
      }
      #mostrarMasTweetsButton {
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        color: #00FFFF;
        background: none;
        border: none;
        font-size: 1.5em;
        cursor: pointer;
        padding: var(--lumo-space-s) var(--lumo-space-l);
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="mainContainer">
 <vaadin-vertical-layout id="tweetsContainer"></vaadin-vertical-layout>
 <vaadin-horizontal-layout id="moreTweetsButtonContainer">
  <vaadin-button theme="tertiary" id="mostrarMasTweetsButton" tabindex="0">
    Mostrar más tweets 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }
}