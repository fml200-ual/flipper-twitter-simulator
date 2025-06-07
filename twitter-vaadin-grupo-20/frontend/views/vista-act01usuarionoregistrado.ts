import { LitElement, html, css, customElement } from 'lit-element';
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
      }
      `;
  }

  render() {
    return html`
<vaadin-horizontal-layout class="content; " style="width: 100%; height: 100%; position:absolute" id="horizontalLayoutPrincipalNoRegistrado">
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;" id="verticalLayoutIzquierdoNoRegistrado">
  <span style="align-self: center; padding-top: var(--lumo-space-s);" id="spanListaUsuarios">Lista de usuarios</span>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; width: 100%;" id="verticalLayoutListaUsuarios"></vaadin-vertical-layout>
  <vaadin-button style="align-self: center; margin-top: var(--lumo-space-m);" tabindex="0" id="botonMasUsuarios">
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
  <vaadin-button style="align-self: center;" tabindex="0" id="botonIniciarSesionGoogle">
   <iron-icon icon="lumo:arrow-right" slot="suffix" id="ironIcon"></iron-icon>Iniciar sesión con <iron-icon src="./img/googleIcon.png"></iron-icon>
  </vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;" id="verticalLayoutDerechoNoRegistrado">
  <span style="align-self: center; padding-top: var(--lumo-space-s);" id="spanListaHashtagsNoRegistrado">Lista de hashtags</span>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; width: 100%;" id="verticalLayoutListaHashtagsNoRegistrado"></vaadin-vertical-layout>
  <vaadin-button style="align-self: center; margin-top: var(--lumo-space-m);" tabindex="0" id="botonMasHashtags">
    Más hashtags...
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
