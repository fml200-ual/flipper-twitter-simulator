import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/icons';
import '@vaadin/vaadin-lumo-styles/icons.js';

@customElement('vista-listadeusuarios_item')
export class VistaListadeusuarios_item extends LitElement {  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        box-sizing: border-box; /* Incluye padding y borde en el tamaño total */
        padding: 5px; /* Pequeño padding alrededor del item para el efecto de borde exterior */
        background-color: #000000; /* Fondo negro para modo oscuro */
      }

      #mainContainer {
        width: 100%;
        background-color: #1a1a1a; /* Fondo gris muy oscuro */
        border: 2px solid #00FFFF; /* Borde turquesa */
        border-radius: 8px; /* Bordes redondeados */
        padding: var(--lumo-space-s); /* Padding interno Lumo-space-s (~8px) */
        box-sizing: border-box;
        /* vaadin-horizontal-layout maneja display:flex y align-items */
        justify-content: space-between; /* Distribuye espacio entre la sección de usuario y la descripción */
        color: #FFFFFF; /* Color de texto predeterminado blanco para el contenedor */
        transition: all 0.3s ease;
      }

      #mainContainer:hover {
        background-color: #2a2a2a;
        border-color: #ffffff;
      }

      #userInfoSection {
        /* vaadin-horizontal-layout ya tiene display:flex y align-items:center */
        gap: var(--lumo-space-s); /* Espacio entre el avatar y el texto */
        flex-shrink: 0; /* Evita que esta sección se encoja */
      }

      #avatarIcon {
        width: 40px; /* Tamaño del icono del avatar aumentado */
        height: 40px;
        color: #00FFFF; /* Color turquesa para el avatar */
        flex-shrink: 0;
        border-radius: 50%; /* Hacer circular */
        border: 2px solid #00FFFF; /* Borde turquesa */
        display: flex;
        align-items: center;
        justify-content: center;
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        overflow: hidden; /* Evita que la imagen se desborde */
        position: relative; /* Para controlar la superposición */
      }

      /* Estilo específico cuando tiene imagen de fondo */
      #avatarIcon[style*="background-image: url"] {
        color: transparent !important; /* Oculta el icono cuando hay imagen */
      }

      /* Asegurar que el icono SVG no se superponga */
      #avatarIcon svg {
        position: relative;
        z-index: 1;
      }

      #textInfo {
        /* vaadin-vertical-layout ya tiene display:flex y flex-direction:column */
        line-height: 1.2; /* Ajusta el interlineado */
      }

      #nickName {
        margin: 0; /* Elimina márgenes predeterminados del h4 */
        color: #FFFFFF;
        font-size: var(--lumo-font-size-m); /* Tamaño de fuente para Nic */
        font-weight: bold;
      }

      #followersSection {
        /* vaadin-horizontal-layout ya tiene display:flex y align-items:center */
        gap: 3px; /* Pequeño espacio entre el número y el icono */
      }

      #followersCount {
        color: #00FFFF; /* Color turquesa para el número de seguidores */
        font-size: var(--lumo-font-size-xs); /* Tamaño de fuente pequeño */
        font-weight: bold;
      }

      #followersIcon { /* Estilos para el vaadin-icon de seguidores */
        width: 16px; /* Tamaño del icono vaadin:users (ajustado para que sea visible) */
        height: 16px;
        color: #00FFFF; /* Color turquesa para el icono de seguidores (consistente) */
        flex-shrink: 0;
      }

      #descriptionContainer {
        flex-grow: 1; /* Permite que ocupe el espacio restante */
        background-color: #333333; /* Fondo gris más oscuro para la descripción */
        border: 1px solid #00FFFF; /* Borde turquesa para el cuadro de descripción */
        border-radius: 4px;
        padding: var(--lumo-space-s) var(--lumo-space-m); /* Padding interno */
        color: #FFFFFF; /* Color blanco para el texto de la descripción */
        font-size: var(--lumo-font-size-m);
        /* vaadin-horizontal-layout ya tiene display:flex y align-items:center */
        justify-content: center; /* Centra el texto horizontalmente */
        min-height: 32px; /* Altura mínima para que se vea como un cuadro */
        margin-left: var(--lumo-space-m); /* Espacio entre la sección de usuario y la descripción */
      }

      #descriptionText {
        margin: 0; /* Elimina márgenes predeterminados de la label */
        white-space: nowrap; /* Evita que el texto se rompa en varias líneas */
        overflow: hidden; /* Oculta el texto que desborda */
        text-overflow: ellipsis; /* Añade puntos suspensivos si el texto es muy largo */
        color: #FFFFFF; /* Texto blanco para mejor contraste */
      }
    `;
  }

  render() {
    return html`
<vaadin-horizontal-layout id="mainContainer">
 <vaadin-horizontal-layout id="userInfoSection">
  <vaadin-icon id="avatarIcon" icon="vaadin:user" size="16"></vaadin-icon>
  <vaadin-vertical-layout id="textInfo">
   <h4 id="nickName">Nic</h4>
   <vaadin-horizontal-layout id="followersSection">
    <label id="followersCount">953</label>
    <vaadin-icon id="followersIcon" icon="vaadin:users" size="16"></vaadin-icon>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout id="descriptionContainer">
  <label id="descriptionText">Descripción</label>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
//  createRenderRoot() {
//    return this;
//  }
}