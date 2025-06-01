import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/text-area/src/vaadin-text-area.js';

@customElement('vista-editarcuenta')
export class VistaEditarcuenta extends LitElement {
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
    	background-color: black;
      }

      #mainContainer {
        width: 100%;
        height: 100%;
        display: flex; /* Use flexbox for vertical layout */
        flex-direction: column; /* Stack elements vertically */
        align-items: center; /* Center content horizontally */
        padding: var(--lumo-space-l); /* General padding for the form */
        box-sizing: border-box;
        overflow-y: auto; /* Allows scrolling if content is too long */
      }

      /* Styles for the "Eliminar cuenta" button */
      #eliminarCuentaButton {
        align-self: flex-start; /* Aligns the button to the left */
        background-color: #ff0000; /* Red */
        color: #fff;
        border-radius: var(--lumo-border-radius-m); /* Rounded corners */
        padding: var(--lumo-space-s) var(--lumo-space-m);
        margin-bottom: var(--lumo-space-xl); /* Space below the button */
        box-shadow: var(--lumo-box-shadow-s);
      }

      /* Styles for titles and subtitles */
      #profileConfigTitle { /* Added ID */
        font-size: 2.5em; /* Large font size for the title */
        margin-top: 0;
        margin-bottom: var(--lumo-space-s);
        text-align: center;
    	color: white;
      }

      #subtitleText { /* Added ID */
        font-size: 1.2em; /* Font size for the subtitle */
        margin-bottom: var(--lumo-space-l);
        text-align: center;
    	color: white;
      }

      /* Form fields container */
      #formFieldsContainer {
        width: 60%; /* Width of the form fields */
        max-width: 600px; /* Maximum width for better readability */
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-m); /* Space between fields */
        margin-bottom: var(--lumo-space-xl);
      }

      /* Styles for text fields and text area using ::part() for internal elements */
      vaadin-text-field, vaadin-text-area {
        width: 100%;
        /* These Lumo properties are still good for overall component styling */
        --lumo-text-field-border-radius: var(--lumo-border-radius-m);
        --lumo-text-field-border-width: 2px;
        --lumo-text-field-focus-ring-color: #00FFFF;
        --lumo-text-field-border-color: #00FFFF; /* Constant cyan border */
      }

      /* Target the internal input field part */
      vaadin-text-field::part(input-field),
      vaadin-text-area::part(input-field) {
        background-color: #FFFFFF; /* CAMBIO AQUÍ: Fondo blanco para el input */
        color: #000000; /* CAMBIO AQUÍ: Texto negro para el usuario */
        padding: var(--lumo-space-s) var(--lumo-space-m); /* Adjust padding inside the input */
      }

      /* Target the label part */
      vaadin-text-field::part(label),
      vaadin-text-area::part(label) {
        color: #FFFFFF; /* White color for the label */
        font-size: 1.1em; /* Slightly increased font size for better readability */
      }

      /* Target the placeholder using ::part() and ::placeholder */
      vaadin-text-field::part(input-field)::placeholder,
      vaadin-text-area::part(input-field)::placeholder {
        color: #666666; /* CAMBIO AQUÍ: Gris oscuro para el placeholder */
        opacity: 1; /* Ensure placeholder is not transparent */
      }

      vaadin-text-area {
        min-height: 100px; /* Minimum height for description */
      }

      /* Image preview containers */
      .preview-container {
        display: flex;
        align-items: center;
        gap: var(--lumo-space-m);
        width: 100%;
      }

      .image-placeholder {
        width: 120px; /* Image placeholder size */
        height: 120px;
        border: 2px solid #fff; /* White border */
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 0.8em;
        color: #aaa;
        background-color: #222; /* Dark background for placeholder */
        border-radius: var(--lumo-border-radius-m);
      }

      /* Bottom buttons container */
      #bottomButtonsContainer {
        width: 60%; /* Same width as form fields */
        max-width: 600px;
        display: flex;
        justify-content: space-between; /* Space between buttons */
        gap: var(--lumo-space-m);
      }

      #continuarButton, #cancelarButton {
        flex-grow: 1; /* Buttons grow to fill space */
        padding: var(--lumo-space-s) var(--lumo-space-l);
        border-radius: var(--lumo-border-radius-m);
        font-size: 1.2em;
        box-shadow: var(--lumo-box-shadow-s);
      }

      #continuarButton {
        background-color: #fff; /* White background */
        color: #000; /* Black text */
      }

      #cancelarButton {
        background-color: #ff0000; /* Red background */
        color: #fff; /* White text */
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="mainContainer">
 <vaadin-button theme="error" id="eliminarCuentaButton" tabindex="0">
   Eliminar cuenta 
 </vaadin-button>
 <h2 id="profileConfigTitle">Configuración de tu perfil</h2>
 <p id="subtitleText">Introduce información en los campos que deseas cambiar</p>
 <vaadin-vertical-layout id="formFieldsContainer">
  <vaadin-text-field label="Arrob" placeholder="Introduce tu arroba" id="arrobField" type="text"></vaadin-text-field>
  <vaadin-text-field label="Nick" placeholder="Introduce tu nick" id="nickField" type="text"></vaadin-text-field>
  <vaadin-text-area label="Descripción" placeholder="Describe tu perfil" id="descripcionField"></vaadin-text-area>
  <vaadin-text-field label="Fondo" placeholder="URL de la imagen de fondo" id="fondoField" type="text"></vaadin-text-field>
  <div class="preview-container" id="fondoPreviewContainer">
   <label id="fondoPreviewLabel" style="color: white;">Previsualización :</label>
   <div class="image-placeholder" id="fondoImagePlaceholder">
     Fondo 
   </div>
  </div>
  <vaadin-text-field label="Foto de perfil" placeholder="URL de la foto de perfil" id="fotoPerfilField" type="text"></vaadin-text-field>
  <div class="preview-container" id="perfilPreviewContainer">
   <label id="perfilPreviewLabel" style="color: white;">Previsualización :</label>
   <div class="image-placeholder" id="perfilImagePlaceholder">
     Perfil 
   </div>
  </div>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout id="bottomButtonsContainer">
  <vaadin-button id="continuarButton" tabindex="0">
    Continuar 
  </vaadin-button>
  <vaadin-button theme="error" id="cancelarButton" tabindex="0">
    Cancelar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }
}
