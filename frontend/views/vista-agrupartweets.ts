import { LitElement, html, css, customElement } from 'lit-element';

@customElement('vista-agrupartweets')
export class VistaAgrupartweets extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block; /* Sigue siendo buena práctica */
        position: fixed; /* <<-- CLAVE: Posicionamiento fijo respecto al viewport */
        top: 0;          /* <<-- Ancla el elemento al borde superior de la ventana */
        left: 0;         /* <<-- Ancla el elemento al borde izquierdo de la ventana */
        right: 0;        /* <<-- Ancla el elemento al borde derecho de la ventana */
        bottom: 0;       /* <<-- Ancla el elemento al borde inferior de la ventana */
        /* No necesitamos width/height 100%/100vw/100vh aquí si usamos top/left/right/bottom: 0 */
        box-sizing: border-box; /* Asegura que el padding/border no aumenten el tamaño */
        z-index: 1;      /* Controla el orden de apilamiento (ajusta si tienes otros elementos fijos) */
      }

      #mainContainer {
        width: 100%;
        height: 100%;
        display: flex; /* Usar flexbox para el layout vertical */
        flex-direction: column; /* Apilar elementos verticalmente */
        align-items: stretch; /* Los hijos se estiran para ocupar el ancho completo */
        background-color: #333; /* Color de fondo oscuro como en la imagen */
        border: 2px solid #00FFFF; /* Borde cian como en la imagen */
        padding: var(--lumo-space-m); /* Espaciado interno */
        box-sizing: border-box;
        overflow-y: auto; /* Permite desplazamiento vertical si el contenido excede el espacio de la vista completa */
      }

      #tweetsContainer {
        flex-grow: 1; /* Este contenedor de tweets crecerá para ocupar todo el espacio disponible */
        width: 100%;
        overflow-y: auto; /* Permite desplazamiento interno si hay muchos tweets */
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-m); /* Espacio entre los tweets */
      }

      #moreTweetsButtonContainer {
        width: 100%;
        flex-shrink: 0; /* Evita que este contenedor se encoja */
        display: flex;
        justify-content: center; /* Centra el botón horizontalmente */
        padding-top: var(--lumo-space-m); /* Espacio por encima del botón */
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
