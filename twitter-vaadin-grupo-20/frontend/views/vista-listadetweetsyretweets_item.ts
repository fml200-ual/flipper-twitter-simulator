import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/icons';
import '@vaadin/vaadin-lumo-styles/icons.js';
import '@vaadin/avatar/src/vaadin-avatar.js';

@customElement('vista-listadetweetsyretweets_item')
export class VistaListadetweetsyretweets_item extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        box-sizing: border-box;
        padding: 5px;
        background-color: #f0f0f0;
      }

      #mainContainer {
        width: 100%;
        background-color: #333333; /* Fondo gris oscuro */
        border: 2px solid #00FFFF; /* Borde turquesa */
        border-radius: 8px;
        padding: var(--lumo-space-m);
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: stretch;
        color: #FFFFFF; /* Color de texto predeterminado blanco para el contenedor */
      }

      /* Encabezado del tweet/retweet */
      #headerLayout {
        width: 100%;
        align-items: center;
        margin-bottom: var(--lumo-space-s);
        gap: var(--lumo-space-s);
        flex-shrink: 0;
      }

      #avatarIcon {
        width: 32px; /* Tamaño aumentado para mejor visibilidad */
        height: 32px;
        color: #00FFFF; /* Color del icono del avatar (turquesa) */
        flex-shrink: 0;
        border-radius: 50%; /* Hacer circular */
        border: 2px solid #00FFFF; /* Borde turquesa */
        display: flex;
        align-items: center;
        justify-content: center;
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        overflow: hidden; /* Evita que la imagen se desborde */
        position: relative;
      }

      /* Estilo específico cuando tiene imagen de fondo */
      #avatarIcon[style*="background-image: url"] {
        color: transparent !important; /* Oculta el icono cuando hay imagen */
      }

      /* Asegurar que el icono SVG no se superponga */
      #avatarIcon svg {
        position: relative;
        z-index: 1;
      }

      #userInfo {
        flex-grow: 1;
        line-height: 1.2;
      }

      #nickName {
        margin: 0;
        color: #FFFFFF;
        font-size: var(--lumo-font-size-l);
        font-weight: bold;
      }

      #username {
        color: #AAAAAA;
        font-size: var(--lumo-font-size-s);
      }

      /* Área de contenido del tweet */
      #contentArea {
        width: 100%;
        background-color: #555555;
        padding: var(--lumo-space-s) var(--lumo-space-m);
        border-radius: 5px;
        color: #DDDDDD;
        font-size: 1.1em;
        text-align: left;
        box-sizing: border-box;
        flex-grow: 1;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      }
      
      #contentText {
        display: block;
      }

      /* Pie de página (fecha e iconos de acción) */
      #footerLayout {
        width: 100%;
        height: auto;
        align-items: center;
        justify-content: space-between;
        gap: 15px; /* Más espacio entre los grupos de elementos (fecha, likes, X, Z) */
        padding-top: var(--lumo-space-s);
        flex-shrink: 0;
      }

      #dateLabel {
        color: #AAAAAA;
        font-size: var(--lumo-font-size-s);
        /* flex-grow: 1; Quitado para que el espacio lo maneje justify-content: space-between */
        margin-right: auto; /* Empuja el resto de elementos a la derecha */
      }

      vaadin-icon {
        width: 20px; /* Tamaño por defecto de los iconos */
        height: 20px;
        color: #00FFFF; /* Color de todos los iconos de acción (turquesa) */
        cursor: pointer;
        flex-shrink: 0;
      }
      
      #heartIcon {
        color: #00FFFF; /* Color del corazón (turquesa) */
      }

      .action-label-container { /* Clase para los contenedores de los números */
        display: flex;
        align-items: center;
        gap: 5px; /* Espacio entre el icono y el número */
      }

      .action-count-label { /* Estilos para el número de likes/retweets/comentarios */
        color: #FFFFFF; /* Números en blanco */
        font-size: var(--lumo-font-size-s);
        font-weight: bold;
        min-width: 15px; /* Para que el número tenga un ancho mínimo y no se "mueva" */
        text-align: center;
      }

      #retweetIcon { /* Estilos para el icono de retweet, si lo necesitas más específico */
        color: #00FFFF; /* Turquesa */
      }

      #commentsIcon { /* Estilos para el icono de comentarios */
        color: #00FFFF; /* Turquesa */
      }

      #xLabelContainer { /* Contenedor para el icono 'X' y su número */
        border-radius: 50%; /* Hacerlo circular */
        background-color: #666666; /* Fondo gris para el círculo */
        width: 24px; /* Tamaño similar al de un icono */
        height: 24px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-shrink: 0;
        cursor: pointer;
      }
      #xLabel {
        color: #FFFFFF; /* La letra 'X' se mantiene blanca para contraste con su fondo gris */
        font-size: var(--lumo-font-size-s);
        font-weight: bold;
      }

      #zLabelContainer { /* Contenedor para la 'Z' y su número */
        border-radius: 50%; /* Hacerlo circular */
        background-color: #666666; /* Fondo gris para el círculo */
        width: 24px; /* Tamaño similar al de un icono */
        height: 24px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-shrink: 0;
        cursor: pointer;
      }
      #zLabel {
        color: #FFFFFF; /* La letra 'Z' se mantiene blanca para contraste con su fondo gris */
        font-size: var(--lumo-font-size-s);
        font-weight: bold;
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="mainContainer">
 <vaadin-horizontal-layout id="headerLayout">
  <vaadin-icon id="avatarIcon" icon="vaadin:envelope" size="16"></vaadin-icon>
  <vaadin-vertical-layout id="userInfo">
   <h4 id="nickName">Nic</h4>
   <label id="username">@arroba</label>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <div id="contentArea">
  <label id="contentText">#hashtag texto texto</label>
 </div>
 <vaadin-horizontal-layout id="footerLayout">
  <label id="dateLabel">3 sept 2023</label>
  <div class="action-label-container">
   <label id="likesCountLabel" class="action-count-label">Y </label>
   <vaadin-icon id="heartIcon" icon="vaadin:heart" size="16"></vaadin-icon>
  </div>
  <label id="xLabelContainer"><label id="xLabel">X</label></label>
  <vaadin-icon id="retweetIcon" icon="vaadin:exchange" size="16"></vaadin-icon>
  <label id="zLabelContainer"><label id="zLabel">Z</label></label>
  <vaadin-icon id="commentsIcon" icon="vaadin:comment" size="16"></vaadin-icon>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // ¡Recuerda comentar o eliminar esta línea para que los estilos funcionen correctamente con Shadow DOM!
  // createRenderRoot() {
  //   return this;
  // }
}