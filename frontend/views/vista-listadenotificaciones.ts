import { LitElement, html, css, customElement } from 'lit-element';

@customElement('vista-listadenotificaciones')
export class VistaListadenotificaciones extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%; /* El host del componente ocupa el 100% de la altura de su padre. */
          width: 100%; /* Asegura que el host también ocupe el 100% del ancho. */
          padding: 10px; /* Considera si este padding es deseado si quieres que el contenido se extienda hasta los bordes. */
          box-sizing: border-box;
          background-color: #f0f0f0; /* Fondo claro para ver la lista */
      }
      #mainContainer {
        width: 100%;
        height: 100%;
        overflow-y: auto; /* Permite desplazamiento si la lista es muy larga */
        padding: 0;
        align-items: stretch; /* Asegura que los items se estiren a lo ancho */
        gap: 10px; /* Espacio entre los ítems */
      }
      `;
  }
  
  render() {
    // Instancias de vista-listadenotificaciones_item codificadas directamente
	// en el HTML
    return html`
<vaadin-vertical-layout id="mainContainer">
</vaadin-vertical-layout>
`;
  }
  
  // ¡Recuerda comentar o eliminar esta línea para que los estilos funcionen!
  // createRenderRoot() {
  // return this;
  // }
}
