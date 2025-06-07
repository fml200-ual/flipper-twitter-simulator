import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout';
import '@vaadin/horizontal-layout';
import '@vaadin/button';

@customElement('vista-agruparretweets')
export class VistaAgruparretweets extends LitElement {
  static get styles() {
    return css`
      /*
       * EL HOST DEL COMPONENTE: FORZAR PANTALLA COMPLETA con position: fixed
       *
       * Esto hará que tu componente ocupe toda la ventana del navegador
       * sin importar el tamaño de sus elementos padres.
       */
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

      /*
       * El contenedor principal interno sigue expandiéndose al 100% de su padre (:host),
       * lo cual ahora será el 100% de la ventana.
       */
      #mainContainer {
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        align-items: stretch;
        background-color: #333;
        border: 2px solid #00FFFF;
        padding: var(--lumo-space-m);
        box-sizing: border-box;
        overflow-y: auto; /* Permite desplazamiento vertical si el contenido de los tweets excede la altura */
      }

      /* Contenedor de Tweets: CRECE para ocupar el espacio restante */
      #tweetsContainer {
        flex-grow: 1;
        width: 100%;
        overflow-y: auto;
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-m);
      }
      /* Contenedor del Botón: NO CRECE, se mantiene al final */
      #moreTweetsButtonContainer {
        width: 100%;
        flex-shrink: 0;
        display: flex;
        justify-content: center;
        padding-top: var(--lumo-space-m);
      }
      /* Estilos del botón */
      #mostrarMasTweetsButton {
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        color: #00FFFF;
        background: none;
        border: none;
        font-size: 1.5em;
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
  <vaadin-button theme="tertiary" id="mostrarMasTweetsButton" tabindex="0">
    Mostrar más tweets 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }
}