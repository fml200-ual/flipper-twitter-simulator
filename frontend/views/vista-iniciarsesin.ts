import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/password-field/src/vaadin-password-field.js';

@customElement('vista-iniciarsesin')
export class VistaIniciarsesin extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex; /* Usa flexbox para centrar el contenido */
        justify-content: center; /* Centra horizontalmente */
        align-items: center; /* Centra verticalmente */
        height: 100%;
        width: 100%;
        min-height: 100vh; /* Asegura que el host ocupe al menos el 100% de la altura del viewport */
        background-color: #000; /* Fondo negro según la imagen */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
      }
      #loginContainer {
        background-color: #000; /* Fondo del contenedor principal */
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: var(--lumo-space-l);
        gap: var(--lumo-space-m); /* Espacio entre elementos */
        width: 100%;
        max-width: 400px; /* Ancho máximo para el formulario */
        box-sizing: border-box;
      }
      .bird-logo {
        width: 100px; /* Ajusta el tamaño según sea necesario */
        height: auto;
        margin-bottom: var(--lumo-space-l);
        border-radius: 50%; /* Lo hace redondo */
        border: 2px solid #00FFFF; /* Borde cian para el logo */
        box-shadow: 0 0 15px #00FFFF; /* Efecto de brillo */
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
        --lumo-text-field-placeholder-color: #aaa; /* Color del placeholder */
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
      .forgot-password-link {
        color: #00FFFF; /* Color cian para el enlace */
        text-decoration: none;
        font-size: 0.9em;
        margin-top: var(--lumo-space-s);
        margin-bottom: var(--lumo-space-m);
      }
      .forgot-password-link:hover {
        text-decoration: underline;
      }
      /* Estilos para los botones de Vaadin */
      vaadin-button {
        width: 100%;
        padding: var(--lumo-space-s) var(--lumo-space-l);
        border-radius: var(--lumo-border-radius-m);
        font-size: 1.1em;
        font-weight: bold;
        text-transform: uppercase;
        box-shadow: var(--lumo-box-shadow-s);
        border: 2px solid #00FFFF; /* Borde cian para todos los botones */
      }
      #googleLoginButton {
        background-color: #fff; /* Fondo blanco para el botón de Google */
        color: #000; /* Texto negro para el botón de Google */
        display: flex;
        align-items: center;
        justify-content: center;
      }
      #googleLoginButton .google-icon {
        width: 20px; /* Tamaño para el icono de Google */
        height: 20px;
        margin-left: var(--lumo-space-s);
      }
      #loginButton {
        background-color: #00FFFF; /* Fondo cian para el botón de Iniciar Sesión */
        color: #000; /* Texto negro para el botón de Iniciar Sesión */
      }
      #registerButton {
        background-color: #333; /* Fondo oscuro para el botón de Registrarse */
        color: #00FFFF; /* Texto cian para el botón de Registrarse */
      }
      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #loginContainer {
          padding: var(--lumo-space-m);
          gap: var(--lumo-space-s);
        }
        .bird-logo {
          width: 80px;
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
<div id="loginContainer">
 <img src="./img/imagenIcon.png" alt="Bird Logo" class="bird-logo">
 <vaadin-text-field label="Nick o correo electrónico" id="usernameField"></vaadin-text-field>
 <vaadin-password-field label="Contraseña" id="passwordField"></vaadin-password-field>
 <a href="#" class="forgot-password-link" id="forgotPasswordLink">¿Has olvidado tu contraseña?</a>
 <vaadin-button id="googleLoginButton">
   Iniciar Sesión con 
  <img src="./img/googleIcon.png" alt="Google Logo" class="google-icon" onerror="">
 </vaadin-button>
 <vaadin-button id="loginButton">
   Iniciar Sesión 
 </vaadin-button>
 <vaadin-button id="registerButton">
   Registrarse 
 </vaadin-button>
</div>
`;
  }
}
