import { LitElement, html, css, customElement } from 'lit-element';

@customElement('vista-agrupartweets')
export class VistaAgrupartweets extends LitElement {
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
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-m);
        overflow-y: auto;
      }

      #moreTweetsButtonContainer {
        flex-shrink: 0;
        width: 100%;
        display: flex;
        justify-content: center;
        padding-top: var(--lumo-space-m);
      }

      #mostrarMasTweetsButton {
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif; /* Fuente de la imagen */
        color: #00FFFF; /* Color cian como en la imagen */
        background: none; /* Sin fondo */
        border: none; /* Sin borde */
        font-size: 1.5em; /* Tamaño de fuente grande */
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
  <vaadin-button theme="tertiary" id="mostrarMasTweetsButton">
   Mostrar más tweets
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Mantén esta línea comentada para usar Shadow DOM, que es la práctica
  // recomendada.
  // Si deseas Light DOM, descoméntala, pero asegúrate de que los estilos se
  // propaguen correctamente.
  // createRenderRoot() {
  //   return this;
  // }
}