import { LitElement, html, css, customElement } from 'lit-element';

@customElement('vista-listadetweetsyretweets')
export class VistaListadetweetsyretweets extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
          padding: 10px; /* Un poco de padding alrededor de la lista */
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
    return html`
<vaadin-vertical-layout id="mainContainer"></vaadin-vertical-layout>
`;
  }
  
  // ¡Recuerda comentar o eliminar esta línea para que los estilos funcionen!
  // createRenderRoot() {
  //   return this;
  // }
}
