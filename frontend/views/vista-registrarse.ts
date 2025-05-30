import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/password-field/src/vaadin-password-field.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-area/src/vaadin-text-area.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';

@customElement('vista-registrarse')
export class VistaRegistrarse extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        justify-content: center;
        align-items: flex-start; /* Alineado arriba para el contenido */
        width: 100%;
        height: 100%;
        min-height: 100vh; /* Asegura que el host ocupe al menos el 100% de la altura del viewport */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        padding: var(--lumo-space-xl) 0; /* Espacio superior e inferior */
      }

      #registerContainer {
        background-color: #000; /* Fondo del contenedor principal */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        padding: var(--lumo-space-l);
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: var(--lumo-space-m); /* Espacio entre elementos */
        width: 100%;
        max-width: 600px; /* Ancho máximo para el contenedor */
        box-sizing: border-box;
      }

      .bird-logo {
        width: 80px; /* Tamaño del logo del pájaro */
        height: auto;
        margin-bottom: var(--lumo-space-s);
        border-radius: 50%; /* Lo hace redondo */
        border: 2px solid #00FFFF; /* Borde cian */
        box-shadow: 0 0 10px #00FFFF; /* Efecto de brillo */
      }

      #requiredFieldsMessage {
        color: #FF0000; /* Rojo para el mensaje de campos obligatorios */
        font-size: 0.9em;
        align-self: flex-start; /* Alineado a la izquierda */
        margin-bottom: var(--lumo-space-s);
      }

      h2 {
        color: #fff; /* Color del texto del título */
        font-size: 2.2em;
        margin: 0 0 var(--lumo-space-l) 0; /* Espacio debajo del título */
        font-weight: bold;
        text-align: center;
      }

      /* Estilos para los campos de texto de Vaadin */
      vaadin-text-field, vaadin-password-field {
        width: 100%;
        --lumo-text-field-border-radius: var(--lumo-border-radius-s);
        --lumo-text-field-border-width: 2px;
        --lumo-text-field-focus-ring-color: #00FFFF; /* Cian al enfocar */
        --lumo-text-field-border-color: #00FFFF; /* Borde cian */
        --lumo-text-field-background-color: #333; /* Fondo oscuro para la entrada */
        --lumo-text-field-text-color: #fff; /* Color de texto blanco */
        --lumo-text-field-placeholder-color: #aaa; /* Placeholder color */
      }
      /* Estilo específico para la parte de entrada de los campos de texto */
      vaadin-text-field::part(input-field),
      vaadin-password-field::part(input-field) {
        background-color: #333; /* Fondo oscuro */
        color: #fff; /* Texto blanco */
        padding: var(--lumo-space-s); /* Relleno interno */
      }
      /* Estilo para las etiquetas de los campos de texto */
      vaadin-text-field::part(label),
      vaadin-password-field::part(label) {
        color: #fff; /* Texto de etiqueta blanco */
        font-size: 1.1em;
        margin-bottom: var(--lumo-space-xs); /* Espacio entre la etiqueta y la entrada */
      }
      /* Estilo para el indicador de campo obligatorio */
      vaadin-text-field[required]::part(label)::after,
      vaadin-password-field[required]::part(label)::after {
        content: '*';
        color: #FF0000;
        margin-left: 4px;
      }

      .preview-row {
        width: 100%;
        display: flex;
        align-items: center;
        gap: var(--lumo-space-m);
      }

      .preview-label {
        color: #fff;
        font-size: 1.1em;
        flex-shrink: 0; /* Evita que la etiqueta se encoja */
      }

      .preview-area {
        width: 60px;
        height: 60px;
        background-color: #555;
        border: 2px solid #00FFFF;
        border-radius: var(--lumo-border-radius-s);
        display: flex;
        justify-content: center;
        align-items: center;
        flex-shrink: 0;
      }

      .preview-icon {
        color: #fff;
        font-size: 2em;
      }
      
      vaadin-text-area {
        width: 100%;
        --lumo-text-field-border-radius: var(--lumo-border-radius-s);
        --lumo-text-field-border-width: 2px;
        --lumo-text-field-focus-ring-color: #00FFFF;
        --lumo-text-field-border-color: #00FFFF;
        --lumo-text-field-background-color: #333;
        --lumo-text-field-text-color: #fff;
        --lumo-text-field-placeholder-color: #aaa;
        min-height: 100px;
      }
      vaadin-text-area::part(input-field) {
        background-color: #333;
        color: #fff;
        padding: var(--lumo-space-s);
      }
      vaadin-text-area::part(label) {
        color: #fff;
        font-size: 1.1em;
        margin-bottom: var(--lumo-space-xs);
      }

      .button-group {
        width: 100%;
        display: flex;
        justify-content: space-between;
        gap: var(--lumo-space-m);
        margin-top: var(--lumo-space-l);
      }

      vaadin-button {
        flex-grow: 1;
        padding: var(--lumo-space-s) var(--lumo-space-l);
        border-radius: var(--lumo-border-radius-m);
        font-size: 1.1em;
        font-weight: bold;
        text-transform: uppercase;
        box-shadow: var(--lumo-box-shadow-s);
        border: 2px solid #00FFFF; /* Borde cian para todos los botones */
      }

      #googleLoginButton {
        background-color: #fff; /* White background for Google button */
        color: #000; /* Black text for Google button */
        display: flex;
        align-items: center;
        justify-content: center;
      }
      #googleLoginButton .google-icon {
        width: 20px; /* Size for Google icon */
        height: 20px;
        margin-left: var(--lumo-space-s);
      }

      #registerButton {
        background-color: #00FFFF; /* Cyan background for Register button */
        color: #000; /* Black text for Register button */
      }

      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #registerContainer {
          padding: var(--lumo-space-m);
          gap: var(--lumo-space-s);
          max-width: 95%;
        }
        .bird-logo {
          width: 60px;
        }
        h2 {
          font-size: 1.8em;
        }
        .preview-row {
          flex-direction: column;
          align-items: flex-start;
          gap: var(--lumo-space-s);
        }
        .preview-label {
          width: 100%;
          text-align: left;
        }
        .button-group {
          flex-direction: column;
          gap: var(--lumo-space-s);
        }
        vaadin-button {
          font-size: 1em;
          padding: var(--lumo-space-xs) var(--lumo-space-m);
        }
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="registerContainer">
 <img src="./img/imagenIcon.png" alt="Bird Logo" class="bird-logo">
 <span id="requiredFieldsMessage">Los campos marcados con * son obligatorios</span>
 <h2>Crea tu cuenta</h2>
 <vaadin-text-field label="Nombre" id="nameField" type="text"></vaadin-text-field>
 <vaadin-text-field label="Apellido" id="lastNameField" type="text"></vaadin-text-field>
 <vaadin-text-field label="Correo" id="emailField" required type="text"></vaadin-text-field>
 <vaadin-text-field label="Nick" id="nickField" required type="text"></vaadin-text-field>
 <vaadin-password-field label="Contraseña" id="passwordField" required type="password"></vaadin-password-field>
 <vaadin-text-field label="Arroba" id="atSignField" type="text"></vaadin-text-field>
 <vaadin-horizontal-layout class="preview-row">
  <vaadin-text-field label="Foto de perfil (URL)" id="profilePhotoUrlField" type="text"></vaadin-text-field>
  <span class="preview-label">Previsualización:</span>
  <div class="preview-area" id="profileImagePreview">
   <vaadin-icon icon="lumo:photo" id="profileImagePreviewIcon" size="1000"></vaadin-icon>
  </div>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="preview-row" id="vaadinHorizontalLayout">
  <vaadin-text-field label="Fondo (URL)" id="backgroundUrlField" type="text"></vaadin-text-field>
  <span class="preview-label">Previsualización:</span>
  <div class="preview-area" id="backgroundImagePreview">
   <vaadin-icon icon="lumo:photo" size="1000" id="backgroundImagePreviewIcon"></vaadin-icon>
  </div>
 </vaadin-horizontal-layout>
 <vaadin-text-area label="Descripción" id="descriptionField"></vaadin-text-area>
 <vaadin-horizontal-layout class="button-group">
  <vaadin-button id="googleLoginButton" tabindex="0">
    Iniciar Sesión con 
   <img src="./img/googleIcon.png" alt="Google Logo" class="google-icon" onerror="">
  </vaadin-button>
  <vaadin-button id="registerButton" tabindex="0">
    Registrarse 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

}
