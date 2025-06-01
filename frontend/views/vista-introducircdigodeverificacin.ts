import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js'; // Necesario para el botón "Reenviar código"

@customElement('vista-introducircdigodeverificacin')
export class VistaIntroducircdigodeverificacin extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100vw; /* Ocupa el 100% del ancho del viewport */
        height: 100vh; /* Ocupa el 100% de la altura del viewport */
        margin: 0 !important; /* Elimina cualquier margen por defecto con !important */
        padding: 0 !important; /* Elimina cualquier padding por defecto con !important */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box; /* El padding y borde se incluyen en el width/height total */
        position: fixed; /* Posición fija para ocupar toda la ventana */
        top: 0;
        left: 0;
        z-index: 1000; /* Z-index alto para asegurar que esté encima */
        overflow: auto; /* Permite scroll si es necesario */
      }
      
      /* Reseteo para asegurar que no haya espacios en blanco */
      * {
        box-sizing: border-box;
      }
      
      #verificationContainer {
        background-color: #000; /* Fondo del contenedor principal */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        padding: var(--lumo-space-l);
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: var(--lumo-space-m); /* Espacio entre elementos */
        width: 100%;
        max-width: 500px; /* Ancho máximo para el contenedor */
        box-sizing: border-box;
        min-height: auto; /* Permite que se ajuste al contenido */
      }
      
      .bird-logo {
        width: 100px; /* Tamaño del logo del pájaro */
        height: auto;
        margin-bottom: var(--lumo-space-m);
        border-radius: 50%; /* Lo hace redondo */
        border: 2px solid #00FFFF; /* Borde cian */
        box-shadow: 0 0 15px #00FFFF; /* Efecto de brillo */
      }
      
      h2 {
        color: #fff; /* Color del texto del título */
        font-size: 2.2em;
        margin: 0 0 var(--lumo-space-l) 0; /* Espacio debajo del título */
        font-weight: bold;
        text-align: center;
      }
      
      #codeFormBox {
        background-color: #333; /* Fondo oscuro del cuadro de formulario */
        border: 2px solid #00FFFF; /* Borde cian del cuadro de formulario */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        padding: var(--lumo-space-l);
        width: 90%; /* Ancho del cuadro dentro del contenedor principal */
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: var(--lumo-space-m);
        box-sizing: border-box;
      }
      
      .instruction-text {
        color: #fff; /* Color del texto de instrucción */
        font-size: 1.1em;
        text-align: center;
      }
      
      #codeInputs {
        display: flex;
        gap: var(--lumo-space-m); /* Espacio entre los círculos de entrada */
        justify-content: center;
        width: 100%;
      }
      
      .code-input {
        width: 60px; /* Ancho del círculo */
        height: 60px; /* Alto del círculo */
        border-radius: 50%; /* Lo hace circular */
        background-color: #555; /* Fondo del círculo */
        color: #fff; /* Color del texto dentro del círculo */
        font-size: 2em;
        font-weight: bold;
        text-align: center;
        border: 2px solid #666; /* Borde del círculo */
        outline: none; /* Elimina el contorno al enfocar */
        transition: border-color 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
      }
      
      .code-input:focus {
        border-color: #00FFFF; /* Cian al enfocar */
        box-shadow: 0 0 10px #00FFFF; /* Brillo al enfocar */
      }
      
      .resend-question {
        color: #fff; /* Color del texto de la pregunta de reenvío */
        font-size: 1em;
        margin-top: var(--lumo-space-s);
      }
      
      #resendCodeButton {
        background-color: #AAA; /* Fondo del botón gris claro */
        color: #333; /* Texto oscuro */
        border: 2px solid #666; /* Borde más oscuro */
        border-radius: var(--lumo-border-radius-m);
        padding: var(--lumo-space-s) var(--lumo-space-l);
        font-size: 1.1em;
        font-weight: bold;
        text-transform: uppercase;
        box-shadow: var(--lumo-box-shadow-s);
        cursor: pointer;
        transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
      }
      
      #resendCodeButton:hover {
        background-color: #BBB; /* Un poco más claro al pasar el ratón */
        color: #000;
      }
      
      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #verificationContainer {
          padding: var(--lumo-space-m);
          gap: var(--lumo-space-s);
          max-width: 90%;
        }
        
        .bird-logo {
          width: 80px;
        }
        
        h2 {
          font-size: 1.8em;
        }
        
        #codeFormBox {
          padding: var(--lumo-space-m);
          gap: var(--lumo-space-s);
        }
        
        .code-input {
          width: 50px;
          height: 50px;
          font-size: 1.8em;
        }
        
        #resendCodeButton {
          font-size: 1em;
          padding: var(--lumo-space-xs) var(--lumo-space-m);
        }
      }
      
      /* Ajuste para pantallas muy pequeñas */
      @media (max-height: 500px) {
        :host {
          align-items: flex-start;
          padding-top: 20px;
        }
        
        .bird-logo {
          width: 60px;
          margin-bottom: var(--lumo-space-s);
        }
        
        h2 {
          font-size: 1.5em;
          margin-bottom: var(--lumo-space-s);
        }
      }
    `;
  }

  render() {
    return html`
      <div id="verificationContainer">
        <img src="./img/imagenIcon.png" alt="Bird Logo" class="bird-logo">
        <h2>Crea tu cuenta</h2>
        <div id="codeFormBox">
          <span class="instruction-text">Introduce el código de verificación enviado:</span>
          
          <div id="codeInputs">
            <input type="text" maxlength="1" class="code-input" inputmode="numeric" pattern="[0-9]*" id="codeDigit1">
            <input type="text" maxlength="1" class="code-input" inputmode="numeric" pattern="[0-9]*" id="codeDigit2">
            <input type="text" maxlength="1" class="code-input" inputmode="numeric" pattern="[0-9]*" id="codeDigit3">
            <input type="text" maxlength="1" class="code-input" inputmode="numeric" pattern="[0-9]*" id="codeDigit4">
          </div>
          
          <span class="resend-question">¿No has recibido nada?</span>
          <vaadin-button id="resendCodeButton">
            Reenviar código
          </vaadin-button>
        </div>
      </div>
    `;
  }

  connectedCallback() {
    super.connectedCallback();
    // Asegurar que el body no tenga márgenes o padding
    document.body.style.margin = '0';
    document.body.style.padding = '0';
    document.body.style.overflow = 'hidden'; // Evita scrollbars en el body
  }

  disconnectedCallback() {
    super.disconnectedCallback();
    // Restaurar estilos del body cuando el componente se desconecta
    document.body.style.overflow = '';
  }
}