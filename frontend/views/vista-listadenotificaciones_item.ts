import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-lumo-styles/color.js';

@customElement('vista-listadenotificaciones_item')
export class VistaListadenotificaciones_item extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        box-sizing: border-box; /* Incluye padding y borde en el tamaño total */
        padding: 5px; /* Pequeño padding alrededor del item para el efecto de borde */
        background-color: #f0f0f0; /* Fondo claro si es parte de una lista con espacio */
      }

      #notificationContainer {
        width: 100%;
        min-height: 50px; /* Altura mínima para el item */
        background-color: #333333; /* Fondo gris oscuro */
        border: 2px solid #00FFFF; /* Borde turquesa */
        border-radius: 8px; /* Bordes redondeados */
        display: flex; /* Para usar flexbox en el contenedor */
        align-items: center; /* Centrar verticalmente los elementos internos */
        justify-content: space-between; /* Distribuye el espacio entre descripción y checkbox */
        padding: 10px 15px; /* Padding interno */
        box-sizing: border-box; /* Incluye padding en el tamaño del contenedor */
        color: #FFFFFF; /* Color de texto blanco para la descripción */
      }

      #descriptionLabel {
        flex-grow: 1; /* Permite que la descripción ocupe el espacio disponible */
        text-align: center; /* Centra el texto "Descripción" */
        font-size: 1.2em; /* Tamaño de fuente para la descripción */
        font-weight: bold;
        white-space: nowrap; /* Evita que el texto se rompa */
        overflow: hidden; /* Oculta el desbordamiento si el texto es muy largo */
        text-overflow: ellipsis; /* Añade puntos suspensivos si el texto se corta */
      }

      vaadin-checkbox {
        color: #FFFFFF; /* Color del texto del checkbox */
        --vaadin-checkbox-label-spacing: 0.5em; /* Espacio entre el checkbox y su label */
        flex-shrink: 0; /* Evita que el checkbox se encoja */
      }

      /* Estilo para el propio cuadro del checkbox (vaadin-checkbox::part(checkbox)) */
      vaadin-checkbox::part(checkbox) {
          border: 2px solid #FFFFFF; /* Borde blanco para el cuadro del checkbox */
          background-color: transparent; /* Fondo transparente */
          width: 20px; /* Tamaño del cuadro */
          height: 20px;
      }
      /* Estilo cuando el checkbox está marcado */
      vaadin-checkbox[checked]::part(checkbox) {
          background-color: #00FFFF; /* Turquesa cuando está marcado */
          border-color: #00FFFF; /* Borde turquesa cuando está marcado */
      }
      /* Estilo para el "checkmark" dentro del cuadro */
      vaadin-checkbox::part(checkmark) {
          color: #333333; /* Color oscuro para el checkmark */
      }
    `;
  }

  render() {
    return html`
<vaadin-horizontal-layout id="notificationContainer">
 <label id="descriptionLabel">Descripción</label>
 <vaadin-checkbox id="seenCheckbox" label="Visto" type="checkbox" value="on"></vaadin-checkbox>
</vaadin-horizontal-layout>
`;
  }

  // Remueve o comenta esta línea para que los estilos se apliquen
  // dentro del Shadow DOM para encapsulamiento.
  // createRenderRoot() {
  //   return this;
  // }
}