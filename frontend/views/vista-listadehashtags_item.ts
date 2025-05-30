import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/icons';

@customElement('vista-listadehashtags_item')
export class VistaListadehashtags_item extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        height: 100%; /* ¡CLAVE AÑADIDA! Asegura que el host del componente ocupe el 100% de la altura de su padre. */
        box-sizing: border-box;
      }

      #hashtagContainer {
        width: 100%;
        height: 100%; /* ¡CLAVE AÑADIDA! Asegura que el contenedor interno ocupe el 100% del espacio del host. */
        display: flex;
        align-items: center;
        justify-content: space-between;
        background-color: #FFFFFF;
        border: 2px solid #00BFFF;
        border-radius: 8px;
        padding: 12px 16px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin-bottom: 10px; /* Si necesitas espacio entre ítems, puedes ajustarlo. Si cada ítem debe llenar su espacio, esto podría no ser necesario. */
      }

      #hashtagText {
        font-size: 1.5em;
        font-weight: bold;
        color: #333333;
        margin-right: 10px;
      }

      #postCount {
        font-size: 1.1em;
        color: #666666;
        flex-shrink: 0;
      }

      vaadin-icon {
        width: 24px;
        height: 24px;
        color: black;
        margin-left: 10px;
        flex-shrink: 0;
      }
    `;
  }

  render() {
    return html`
      <vaadin-horizontal-layout id="hashtagContainer" style="justify-content: center;">
        <label id="hashtagText">#hashtag1</label>
        <label id="postCount">180k</label>
        <vaadin-icon icon="vaadin:comment" id="iconComment" size="16"></vaadin-icon>
      </vaadin-horizontal-layout>
    `;
  }
  // createRenderRoot() { return this; } // Mantén esta línea comentada para usar Shadow DOM
}