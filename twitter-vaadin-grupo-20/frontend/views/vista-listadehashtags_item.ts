import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/icons';

@customElement('vista-listadehashtags_item')
export class VistaListadehashtags_item extends LitElement {  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        height: 100%; /* ¡CLAVE AÑADIDA! Asegura que el host del componente ocupe el 100% de la altura de su padre. */
        box-sizing: border-box;
        background-color: #000000; /* Fondo negro para modo oscuro */
      }

      #hashtagContainer {
        width: 100%;
        height: 100%; /* ¡CLAVE AÑADIDA! Asegura que el contenedor interno ocupe el 100% del espacio del host. */
        display: flex;
        align-items: center;
        justify-content: space-between;
        background-color: #1a1a1a; /* Fondo gris muy oscuro */
        border: 2px solid #00FFFF; /* Borde turquesa */
        border-radius: 8px;
        padding: 12px 16px;
        box-shadow: 0 2px 4px rgba(0, 255, 255, 0.1); /* Sombra turquesa */
        margin-bottom: 10px; /* Si necesitas espacio entre ítems, puedes ajustarlo. Si cada ítem debe llenar su espacio, esto podría no ser necesario. */
        transition: all 0.3s ease; /* Transición para hover */
      }

      #hashtagContainer:hover {
        background-color: #2a2a2a;
        border-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 255, 255, 0.3);
      }

      #hashtagText {
        font-size: 1.5em;
        font-weight: bold;
        color: #00FFFF; /* Color turquesa para el hashtag */
        margin-right: 10px;
      }

      #postCount {
        font-size: 1.1em;
        color: #FFFFFF; /* Color blanco para el contador */
        flex-shrink: 0;
        font-weight: bold;
      }

      vaadin-icon {
        width: 24px;
        height: 24px;
        color: #00FFFF; /* Color turquesa para el icono */
        margin-left: 10px;
        flex-shrink: 0;
      }
    `;
  }  render() {
    return html`
      <vaadin-horizontal-layout id="hashtagContainer" style="justify-content: center;">
        <label id="hashtagText"></label>
        <label id="postCount"></label>
        <vaadin-icon icon="vaadin:comment" id="iconComment" size="16"></vaadin-icon>
      </vaadin-horizontal-layout>
    `;
  }
  // createRenderRoot() { return this; } // Mantén esta línea comentada para usar Shadow DOM
}