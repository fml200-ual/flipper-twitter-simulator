import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/password-field/src/vaadin-password-field.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-restablecercontrasea')
export class VistaRestablecercontrasea extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 100vw; /* Ocupa todo el ancho del viewport */
        height: 100vh; /* Ocupa toda la altura del viewport */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        margin: 0; /* Elimina márgenes */
        padding: 0; /* Elimina padding */
        position: fixed; /* Fija la posición para ocupar toda la ventana */
        top: 0;
        left: 0;
        overflow-y: auto; /* Permite scroll si es necesario */
      }

      #resetPasswordContainer {
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
      }

      .bird-logo {
        width: 100px; /* Tamaño del logo del pájaro */
        height: auto;
        margin-bottom: var(--lumo-space-m);
        border-radius: 50%; /* Lo hace redondo */
        border: 2px solid #00FFFF; /* Borde cian */
        box-shadow: 0 0 10px #00FFFF; /* Efecto de brillo */
      }

      #messageBox {
        background-color: #333; /* Fondo oscuro para el cuadro de mensaje */
        border: 2px solid #fff; /* Borde blanco */
        border-radius: var(--lumo-border-radius-s);
        padding: var(--lumo-space-l);
        text-align: center;
        color: #fff;
        font-size: 1.2em;
        line-height: 1.5;
        margin-bottom: var(--lumo-space-l);
        box-sizing: border-box;
        width: 100%;
      }

      /* Estilos para el campo de contraseña de Vaadin */
      vaadin-password-field {
        width: 100%;
        --lumo-text-field-border-radius: var(--lumo-border-radius-s);
        --lumo-text-field-border-width: 2px;
        --lumo-text-field-focus-ring-color: #00FFFF; /* Cian al enfocar */
        --lumo-text-field-border-color: #00FFFF; /* Borde cian */
        --lumo-text-field-background-color: #333; /* Fondo oscuro para la entrada */
        --lumo-text-field-text-color: #fff; /* Color de texto blanco */
        --lumo-text-field-placeholder-color: #aaa; /* Placeholder color */
      }
      /* Estilo específico para la parte de entrada del campo de texto */
      vaadin-password-field::part(input-field) {
        background-color: #333; /* Fondo oscuro */
        color: #fff; /* Texto blanco */
        padding: var(--lumo-space-s); /* Relleno interno */
      }
      /* Estilo para las etiquetas de los campos de texto */
      vaadin-password-field::part(label) {
        color: #fff; /* Texto de etiqueta blanco */
        font-size: 1.1em;
        margin-bottom: var(--lumo-space-xs); /* Espacio entre la etiqueta y la entrada */
      }

      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #resetPasswordContainer {
          padding: var(--lumo-space-m);
          gap: var(--lumo-space-s);
          max-width: 95%;
        }
        .bird-logo {
          width: 80px;
        }
        #messageBox {
          font-size: 1em;
          padding: var(--lumo-space-s);
        }
        vaadin-password-field::part(label) {
          font-size: 1em;
        }
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="resetPasswordContainer">
 <img src="./img/imagenIcon.png" alt="Bird Logo" class="bird-logo">
 <div id="messageBox">
  <p>Introduce tu nueva contraseña.</p>
  <p>Y asegúrate de no olvidarla...</p>
 </div>
 <vaadin-password-field label="Contraseña" id="passwordField" type="password"></vaadin-password-field>
</vaadin-vertical-layout>
`;
  }

}
