import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('vista-act01usuarionoregistrado')
export class VistaAct01usuarionoregistrado extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
          background-color: #000000;
          color: #ffffff;
      }
      
      /* Fondo general */
      .content {
          background-color: #000000 !important;
      }
      
      /* Títulos de secciones */
      #spanListaUsuarios,
      #spanListaHashtagsNoRegistrado {
          color: #00ffff !important;
          font-weight: bold;
          font-size: 1.2em;
      }
      
      /* Botones principales */
      #botonIniciarSesion,
      #botonRegistrarse {
          background-color: #00ffff !important;
          color: #000000 !important;
          border: 2px solid #00ffff !important;
          font-weight: bold;
          margin: 8px 0;
          transition: all 0.3s ease;
      }
      
      #botonIniciarSesion:hover,
      #botonRegistrarse:hover {
          background-color: #ffffff !important;
          color: #000000 !important;
          border-color: #ffffff !important;
      }
      
      /* Botones de "Más" */
      #botonMasUsuarios,
      #botonMasHashtags {
          background-color: #333333 !important;
          color: #00ffff !important;
          border: 1px solid #00ffff !important;
          transition: all 0.3s ease;
      }
      
      #botonMasUsuarios:hover,
      #botonMasHashtags:hover {
          background-color: #00ffff !important;
          color: #000000 !important;
      }
      
      /* Imagen */
      img {
          filter: brightness(0.9) contrast(1.1);
      }
      
      /* Layouts */
      vaadin-horizontal-layout,
      vaadin-vertical-layout {
          background-color: #000000 !important;
      }
      `;
  }

  render() {
    return html`
<vaadin-horizontal-layout class="content; " style="width: 100%; height: 100%; position:absolute" id="horizontalLayoutPrincipalNoRegistrado">
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;" id="verticalLayoutIzquierdoNoRegistrado">
  <span style="align-self: center; padding-top: var(--lumo-space-s);" id="spanListaUsuarios">Lista de usuarios</span>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; width: 100%;" id="verticalLayoutListaUsuarios"></vaadin-vertical-layout>
  <vaadin-button style="align-self: center; margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-xl);" tabindex="0" id="botonMasUsuarios">
    Más usuarios...
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;" id="verticalLayoutCentralNoRegistrado">
  <vaadin-vertical-layout theme="spacing" id="verticalLayoutImagenNoRegistrado" style="align-self: center;">
   <img style="width: 25%; align-self: center; margin-top: var(--lumo-space-xl);" src="./img/imagenIcon.png">
  </vaadin-vertical-layout>
  <vaadin-button style="align-self: center;" tabindex="0" id="botonIniciarSesion">
    Iniciar Sesión 
  </vaadin-button>
  <vaadin-button style="align-self: center;" tabindex="0" id="botonRegistrarse">
    Registrarse 
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;" id="verticalLayoutDerechoNoRegistrado">
  <span style="align-self: center; padding-top: var(--lumo-space-s);" id="spanListaHashtagsNoRegistrado">Lista de hashtags</span>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; width: 100%;" id="verticalLayoutListaHashtagsNoRegistrado"></vaadin-vertical-layout>
  <vaadin-button style="align-self: center; margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-xl);" tabindex="0" id="botonMasHashtags">
    Más hashtags...
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }
}
