import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import './vista-listadehashtags_item';

@customElement('vista-listadehashtags')
export class VistaListadehashtags extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        height: 100%; /* El host del componente ocupa el 100% de la altura de su padre. */
        width: 100%; /* Asegura que el host también ocupe el 100% del ancho. */
        /* padding: 10px; -- ELIMINADO: Para que el contenido se extienda hasta los bordes del padre. */
        box-sizing: border-box;
        background-color: transparent; /* CAMBIADO: Fondo transparente para que se vea el fondo del padre. */
      }
      #mainContainer {
        width: 100%;
        height: 100%; /* ¡CLAVE! El contenedor principal del layout ocupa el 100% del espacio del host. */
        overflow-y: auto; /* Permite desplazamiento si el contenido es demasiado largo. */
        padding: 0;
        align-items: stretch; /* Asegura que los ítems dentro de este VerticalLayout se estiren horizontalmente. */
        gap: 0; /* Asegura que no haya espacio extra entre los ítems por defecto. */
      }
    `;
  }
  render() {
    return html`
<vaadin-vertical-layout id="mainContainer">
 <vista-listadehashtags_item></vista-listadehashtags_item>
 <vista-listadehashtags_item></vista-listadehashtags_item>
 <vista-listadehashtags_item></vista-listadehashtags_item>
</vaadin-vertical-layout>
`;
  }
}
