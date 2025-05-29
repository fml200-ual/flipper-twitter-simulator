import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import './vista-listadeusuarios_item';

@customElement('vista-listadeusuarios')
export class VistaListadeusuarios extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex; /* Utiliza flexbox para que el host pueda expandirse */
        flex-direction: column; /* Organiza los elementos hijos en columna */
        width: 100%; /* Ocupa el ancho completo disponible */
        height: 100%; /* Ocupa la altura completa disponible */
        box-sizing: border-box; /* Incluye padding y borde en el tamaño total */
      }
      
      #listaUsuariosContainer {
        width: 100%;
        height: 100%; /* ¡Importante! Hace que el layout vertical ocupe el 100% del espacio del host */
        flex-grow: 1; /* Permite que este contenedor crezca y ocupe todo el espacio disponible */
        overflow-y: auto; /* Permite desplazamiento vertical si hay muchos ítems */
        /* vaadin-vertical-layout ya maneja display:flex y flex-direction:column */
        gap: 5px; /* Espacio entre los ítems de la lista */
        padding: 5px; /* Pequeño padding alrededor de la lista de ítems */
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="listaUsuariosContainer">
 <vista-listadeusuarios_item></vista-listadeusuarios_item>
 <vista-listadeusuarios_item></vista-listadeusuarios_item>
 <vista-listadeusuarios_item></vista-listadeusuarios_item>
</vaadin-vertical-layout>
`;
  }

  // Se mantiene este método para renderizar el contenido directamente en el
  // DOM ligero,
  // permitiendo que Vaadin Flow añada componentes hijos directamente.
  createRenderRoot() {
    return this;
  }
}