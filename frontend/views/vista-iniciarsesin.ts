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
        display: flex;
        justify-content: center;
        align-items: center;
        /* --- CAMBIOS AQUI PARA QUE OCUPE TODA LA VENTANA --- */
        position: fixed; /* Fija el elemento al viewport */
        top: 0;          /* Ancla al borde superior */
        left: 0;         /* Ancla al borde izquierdo */
        right: 0;        /* Ancla al borde derecho */
        bottom: 0;       /* Ancla al borde inferior */
        /* --- FIN DE CAMBIOS --- */
        height: 100%; /* Aunque 'position: fixed' ya lo haría, es buena práctica */
        width: 100%;  /* Aunque 'position: fixed' ya lo haría, es buena práctica */
        min-height: 100vh;
        background-color: #000;
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
      }
      #loginContainer {
        background-color: #000;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: var(--lumo-space-l);
        gap: var(--lumo-space-m);
        width: 100%;
        max-width: 400px;
        box-sizing: border-box;
      }
      .bird-logo {
        width: 100px;
        height: auto;
        margin-bottom: var(--lumo-space-l);
        border-radius: 50%;
        border: 2px solid #00FFFF;
        box-shadow: 0 0 15px #00FFFF;
      }
      vaadin-text-field, vaadin-password-field {
        width: 100%;
        --lumo-text-field-border-radius: var(--lumo-border-radius-s);
        --lumo-text-field-border-width: 2px;
        --lumo-text-field-focus-ring-color: #00FFFF;
        --lumo-text-field-border-color: #00FFFF;
        --lumo-text-field-background-color: #333;
        --lumo-text-field-text-color: #fff;
        --lumo-text-field-placeholder-color: #aaa;
      }
      vaadin-text-field::part(input-field),
      vaadin-password-field::part(input-field) {
        background-color: #333;
        color: #fff;
        padding: var(--lumo-space-s);
      }
      vaadin-text-field::part(label),
      vaadin-password-field::part(label) {
        color: #fff;
        font-size: 1.1em;
        margin-bottom: var(--lumo-space-xs);
      }
      .forgot-password-link {
        color: #00FFFF;
        text-decoration: none;
        font-size: 0.9em;
        margin-top: var(--lumo-space-s);
        margin-bottom: var(--lumo-space-m);
      }
      .forgot-password-link:hover {
        text-decoration: underline;
      }
      vaadin-button {
        width: 100%;
        padding: var(--lumo-space-s) var(--lumo-space-l);
        border-radius: var(--lumo-border-radius-m);
        font-size: 1.1em;
        font-weight: bold;
        text-transform: uppercase;
        box-shadow: var(--lumo-box-shadow-s);
        border: 2px solid #00FFFF;
      }
      #googleLoginButton {
        background-color: #fff;
        color: #000;
        display: flex;
        align-items: center;
        justify-content: center;
      }
      #googleLoginButton .google-icon {
        width: 20px;
        height: 20px;
        margin-left: var(--lumo-space-s);
      }
      #loginButton {
        background-color: #00FFFF;
        color: #000;
      }
      #registerButton {
        background-color: #333;
        color: #00FFFF;
      }
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