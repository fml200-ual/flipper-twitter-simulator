import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('vista-act06sesininiciada')
export class VistaAct06sesininiciada extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
          overflow: auto;
      }
      
      .scrollable-content {
          overflow-y: auto;
          max-height: 100%;
      }
      
      #horizontalLayoutPrincipalSesionIniciada {
          overflow: hidden;
      }
      
      #verticalLayoutIzquierdoSesionIniciada,
      #verticalLayoutCentralSesionIniciada,
      #verticalLayoutDerechoSesionIniciada {
          overflow-y: auto;
          padding: 8px;
          box-sizing: border-box;
      }
      
      #verticalLayoutListaUsuarios {
          overflow-y: auto;
          max-height: 300px;
          scrollbar-width: thin;
      }
      
      #verticalLayoutListaTweets {
          overflow-y: auto;
          max-height: 400px;
          scrollbar-width: thin;
      }
      
      #verticalLayoutListaHashtagsSesionIniciada {
          overflow-y: auto;
          max-height: 300px;
          scrollbar-width: thin;
      }
      
      /* Estilos personalizados para scrollbar webkit */
      #verticalLayoutListaUsuarios::-webkit-scrollbar,
      #verticalLayoutListaTweets::-webkit-scrollbar,
      #verticalLayoutListaHashtagsSesionIniciada::-webkit-scrollbar {
          width: 6px;
      }
      
      #verticalLayoutListaUsuarios::-webkit-scrollbar-track,
      #verticalLayoutListaTweets::-webkit-scrollbar-track,
      #verticalLayoutListaHashtagsSesionIniciada::-webkit-scrollbar-track {
          background: #f1f1f1;
          border-radius: 3px;
      }
      
      #verticalLayoutListaUsuarios::-webkit-scrollbar-thumb,
      #verticalLayoutListaTweets::-webkit-scrollbar-thumb,
      #verticalLayoutListaHashtagsSesionIniciada::-webkit-scrollbar-thumb {
          background: #c1c1c1;
          border-radius: 3px;
      }
      
      #verticalLayoutListaUsuarios::-webkit-scrollbar-thumb:hover,
      #verticalLayoutListaTweets::-webkit-scrollbar-thumb:hover,
      #verticalLayoutListaHashtagsSesionIniciada::-webkit-scrollbar-thumb:hover {
          background: #a1a1a1;
      }
      `;
  }

  render() {
    return html`
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%; position:absolute; overflow: hidden;" id="horizontalLayoutPrincipalSesionIniciada">
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; width: 100%; overflow-y: auto; max-height: 100%;" id="verticalLayoutIzquierdoSesionIniciada">
  <vaadin-vertical-layout style="margin-top: var(--lumo-space-xl); width: 25%; margin-left: var(--lumo-space-s); align-self: center;" id="verticalLayoutImagenAdministrador">
   <img id="imagenAdministrador" style="width: 100%; height: 100%; align-self: center;" src="https://icons.getbootstrap.com/assets/icons/person.svg">
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%; justify-content: center;" id="horizontalLayoutBotonesSesionIniciada">
   <vaadin-button tabindex="0" style="align-self: center;" id="botonPerfilPropioRegistrado">
     Tu Perfil 
   </vaadin-button>
   <vaadin-button tabindex="0" style="align-self: center; margin: var(--lumo-space-s);" id="botonCerrarSesionPrimerBoton">
     Cerrar Sesión 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-vertical-layout theme="spacing" style="align-self: center; width: 100%; flex-grow: 1; overflow-y: auto;" id="verticalLayoutListaUsuarios"></vaadin-vertical-layout>
  <vaadin-button tabindex="0" style="align-self: center; margin: var(--lumo-space-s);" id="botonMasUsuarios">
    Más usuarios 
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; width: 100%; overflow-y: auto; max-height: 100%;" id="verticalLayoutCentralSesionIniciada">
  <vaadin-vertical-layout theme="spacing" id="verticalLayoutImagenRegistrado" style="width: 100%;">
   <img id="imagenIconoCentral" style="width: 25%; align-self: center; margin-top: var(--lumo-space-xl);" src="./img/imagenIcon.png">
  </vaadin-vertical-layout>
  <span style="align-self: center;" id="spanRecomendadoParaTi">Recomendado para ti</span>
  <span style="align-self: center;" id="spanListaTweetsRecientes">Lista de Tweets más recientes</span>
  <vaadin-vertical-layout theme="spacing" style="width: 100%; flex-grow: 1; overflow-y: auto;" id="verticalLayoutListaTweets"></vaadin-vertical-layout>
  <vaadin-button style="align-self: center;" tabindex="0" id="botonEscribirTweet">
    Escribir Tweet 
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; flex-shrink: 1; width: 100%; overflow-y: auto; max-height: 100%;" id="verticalLayoutDerechoSesionIniciada">
  <vaadin-button style="align-self: center;" tabindex="0" id="botonNotificacionesRegistrado">
   <iron-icon icon="lumo:bell" slot="prefix" id="iconoNotificaciones"></iron-icon>Notificaciones 
  </vaadin-button>
  <vaadin-vertical-layout theme="spacing" style="width: 100%; flex-grow: 1; overflow-y: auto;" id="verticalLayoutListaHashtagsSesionIniciada"></vaadin-vertical-layout>
  <vaadin-button tabindex="0" style="align-self: center; margin: var(--lumo-space-s);" id="botonMasHashtags">
    Más hashtags 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  // createRenderRoot() {
  //   return this;
  // }
}
