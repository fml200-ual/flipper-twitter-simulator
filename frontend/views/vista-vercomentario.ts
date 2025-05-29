import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/icons';
import '@vaadin/avatar/src/vaadin-avatar.js';

@customElement('vista-vercomentario')
export class VistaVerComentarios extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex; /* Crucial para centrar y expandir */
        justify-content: center; /* Centra horizontalmente el card */
        align-items: center; /* Centra verticalmente el card */
        height: 100%; /* El host ocupa el 100% del alto de su padre */
        width: 100%; /* El host ocupa el 100% del ancho de su padre */
        padding: 0; /* Elimina padding del host para que el contenedor interno llegue a los bordes */
        box-sizing: border-box;
      }

      #VL_listacomentarios_mainContainer {
        width: 100%; /* Ocupa el 100% del ancho del host */
        height: 100%; /* Ocupa el 100% del alto del host */
        background-color: #333;
        border: 1px solid #00FFFF;
        border-radius: 8px; /* Todavía se verán las esquinas redondeadas */
        padding: var(--lumo-space-m);
        box-sizing: border-box;
        display: flex; /* Convertir a flexbox para controlar la distribución vertical */
        flex-direction: column; /* Apilar los elementos verticalmente */
        justify-content: space-between; /* Distribuye el espacio entre los elementos: header, content, footer */
        align-items: stretch; /* Estira los elementos hijos para ocupar el ancho completo */
      }

      /* Encabezado del comentario (icono, nick, username) */
      #HL_comentario_header {
        width: 100%;
        align-items: center;
        margin-bottom: var(--lumo-space-m);
        gap: var(--lumo-space-s);
        flex-shrink: 0; /* Asegura que el encabezado no se encoja */
      }

      #ironIcon_avatarUsuario {
        width: 24px;
        height: 24px;
        color: #fff;
        flex-shrink: 0;
      }

      #VL_nickYUsername {
        flex-grow: 1;
        line-height: 1.2;
      }

      #h4_nickUsuario {
        margin: 0;
        color: #fff;
        font-size: var(--lumo-font-size-l);
        font-weight: bold;
      }

      #label_username {
        color: #aaa;
        font-size: var(--lumo-font-size-s);
      }

      /* Contenedor del Texto del Comentario */
      #VL_contenidoComentario {
        width: 100%;
        background-color: #fff;
        padding: var(--lumo-space-m);
        border-radius: 5px;
        color: #333;
        font-size: 1.1em;
        text-align: center;
        box-sizing: border-box;
        border: none;
        box-shadow: inset 0 1px 3px rgba(0,0,0,0.1);
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-grow: 1; /* Permite que el contenido del comentario se estire para llenar el espacio vertical */
        overflow: auto; /* Si el texto es muy largo, permite desplazamiento interno */
      }

      /* Pie de página (fecha, avatar, like) */
      #HL_fechaYMeGusta {
        width: 100%;
        height: auto;
        align-items: center;
        justify-content: space-between;
        gap: var(--lumo-space-s);
        padding-top: var(--lumo-space-s); /* Espacio entre el contenido y el footer */
        flex-shrink: 0; /* Asegura que el footer no se encoja */
      }

      #label_fechaComentario {
        color: #aaa;
        font-size: var(--lumo-font-size-s);
        flex-grow: 1;
      }

      vaadin-avatar {
        --vaadin-avatar-size: 24px;
        background-color: #aaa;
        color: #333;
        font-size: var(--lumo-font-size-s);
        flex-shrink: 0;
      }

      #ironIcon_meGusta {
        width: 24px;
        height: 24px;
        color: black;
        flex-shrink: 0;
      }
    `;
  }

  render() {
    return html`
      <vaadin-vertical-layout id="VL_listacomentarios_mainContainer">
        <vaadin-horizontal-layout id="HL_comentario_header">
          <vaadin-icon id="ironIcon_avatarUsuario" icon="vaadin:envelope"></vaadin-icon>
          <vaadin-vertical-layout id="VL_nickYUsername">
            <h4 id="h4_nickUsuario">Nick</h4>
            <label id="label_username">@arroba</label>
          </vaadin-vertical-layout>
        </vaadin-horizontal-layout>

        <vaadin-vertical-layout id="VL_contenidoComentario">
          <label id="label_comentarioTexto">
            texto texto. Este es un ejemplo de texto más largo para demostrar cómo el componente se expande
            y el texto se ajusta dentro del área disponible. Si el texto es demasiado largo para el espacio,
            aparecerá una barra de desplazamiento.
          </label>
        </vaadin-vertical-layout>

        <vaadin-horizontal-layout id="HL_fechaYMeGusta">
          <label id="label_fechaComentario">3 sept 2023</label>
          <vaadin-avatar abbr="Y"></vaadin-avatar>
          <vaadin-icon id="ironIcon_meGusta" icon="vaadin:heart"></vaadin-icon>
        </vaadin-horizontal-layout>
      </vaadin-vertical-layout>
    `;
  }

  createRenderRoot() {
    return this;
  }
}