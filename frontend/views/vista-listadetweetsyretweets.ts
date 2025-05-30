import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-listadetweetsyretweets')
export class VistaListadetweetsyretweets extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%; /* El host del componente ocupa el 100% de la altura de su padre. */
    	  width: 100%; /* Asegura que el host también ocupe el 100% del ancho. */
          padding: 10px; /* Un poco de padding alrededor de la lista */
          box-sizing: border-box;
          background-color: #f0f0f0; /* Fondo claro para ver la lista */
      }
      #mainContainer { /* Renombrado para evitar conflictos si se usa en otro lado */
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
  
  // Mantén esta línea comentada para usar Shadow DOM, que es la práctica recomendada.
  // Si deseas Light DOM, descoméntala, pero asegúrate de que los estilos se propaguen correctamente.
  // createRenderRoot() {
  //   return this; 
  // }
}
