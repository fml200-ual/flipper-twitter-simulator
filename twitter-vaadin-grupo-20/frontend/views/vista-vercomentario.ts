import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icons';
import '@vaadin/avatar/src/vaadin-avatar.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/icon/src/vaadin-icon.js';

@customElement('vista-vercomentario')
export class VistaVercomentario extends LitElement {
    static get styles() {
        return css`
            :host {
                display: block;
                background-color: #000; /* Fondo oscuro principal */
                color: #fff; /* Color de texto claro */
                font-family: 'Inter', sans-serif; /* Fuente Inter */
                padding: 20px;
                box-sizing: border-box;
                width: 100%;
            }

            .comment-container {
                max-width: 600px; /* Ancho máximo para el comentario */
                margin: 0 auto; /* Centrar el contenedor */
                background-color: #1a1a1a; /* Fondo más oscuro para el bloque del comentario */
                border: 2px solid #00acee; /* Borde azul de Twitter */
                border-radius: 8px; /* Esquinas redondeadas */
                padding: 15px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
                position: relative; /* Para posicionar el icono de mail */
            }

            .header-section {
                align-items: center;
                margin-bottom: 10px;
                position: relative; /* Para la superposición del ícono */
            }

            .mail-icon {
                position: absolute;
                left: -30px; /* Ajusta la posición del icono de mail fuera del borde */
                top: 5px; /* Ajusta la posición vertical */
                font-size: 1.8em;
                color: #8899a6;
            }

            .user-info {
                align-items: center;
                margin-left: 10px; /* Espacio para el icono de mail */
            }

            .username {
                font-weight: bold;
                font-size: 1.2em;
            }

            .handle {
                color: #8899a6;
                font-size: 0.9em;
            }

            .comment-content {
                background-color: #ffffff; /* Fondo blanco para el área de texto del comentario */
                color: #333; /* Color de texto oscuro para el comentario */
                border-radius: 6px;
                padding: 10px;
                margin-top: 15px;
                margin-bottom: 15px;
                font-size: 1.1em;
                line-height: 1.4;
                word-break: break-word; /* Asegura que las palabras largas se envuelvan */
            }

            .character-count {
                font-size: 0.8em;
                color: #666;
                text-align: right;
                margin-top: -10px; /* Superpone un poco con el cuadro de texto */
                margin-right: 5px;
            }

            .footer-section {
                justify-content: space-between;
                align-items: center;
                width: 100%;
                flex-wrap: wrap; /* Permite el ajuste en pantallas pequeñas */
            }

            .date {
                color: #8899a6;
                font-size: 0.85em;
                margin-right: 15px; /* Espacio entre fecha y botón */
            }

            .like-section {
                align-items: center;
            }

            .like-button {
                color: #e0245e; /* Rojo para el corazón */
                font-size: 1.3em;
                margin-right: 5px;
                cursor: pointer;
                transition: transform 0.2s ease-in-out;
            }

            .like-button:hover {
                transform: scale(1.1);
            }

            .like-count {
                color: #8899a6;
                font-size: 0.9em;
            }

            .delete-button {
                margin-left: auto; /* Empuja el botón a la derecha */
                background-color: #e0245e; /* Color rojo para el botón de eliminar */
                color: white;
                border-radius: 5px;
                padding: 8px 15px;
                font-weight: bold;
                cursor: pointer;
                transition: background-color 0.2s ease-in-out;
            }

            .delete-button:hover {
                background-color: #c01a4e; /* Tono más oscuro al pasar el ratón */
            }

            .back-button {
                background-color: #1DA1F2; /* Azul de Twitter */
                color: white;
                border: none;
                border-radius: 20px;
                padding: 8px 16px;
                font-weight: bold;
                cursor: pointer;
                font-size: 0.9em;
                display: flex;
                align-items: center;
                gap: 8px;
                margin-bottom: 20px;
                width: fit-content;
                transition: background-color 0.2s ease-in-out;
            }
            
            .back-button:hover {
                background-color: #1991db;
            }
            
            .back-button vaadin-icon {
                width: 16px;
                height: 16px;
            }

            /* Ajustes responsivos */
            @media (max-width: 480px) {
                .header-section {
                    flex-direction: column;
                    align-items: flex-start;
                }
                .mail-icon {
                    position: static; /* Elimina la posición absoluta en móviles */
                    margin-bottom: 10px;
                }
                .user-info {
                    margin-left: 0;
                }
                .footer-section {
                    flex-direction: column;
                    align-items: flex-start;
                }
                .date, .like-section, .delete-button {
                    margin-bottom: 10px;
                    margin-right: 0;
                    margin-left: 0;
                }
            }
        `;
    }

    render() {
        return html`
<vaadin-button id="backButton" class="back-button">
 <vaadin-icon icon="vaadin:arrow-left"></vaadin-icon>
 Volver
</vaadin-button>
<div id="commentMainContainer" class="comment-container">
 <vaadin-horizontal-layout id="commentHeader" class="header-section" theme="spacing">
  <vaadin-avatar id="commenterAvatar" img="https://placehold.co/40x40/cccccc/ffffff?text=Nic"></vaadin-avatar>
  <vaadin-vertical-layout id="commenterInfo">
   <span id="commenterUsername" class="username">Nick</span>
   <span id="commenterHandle" class="handle">@arroba</span>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <div id="commentContentArea" class="comment-content">
  <div id="characterCount" class="character-count">
    200 
  </div>
  <div id="commentText">
    texto texto 
  </div>
 </div>
 <vaadin-horizontal-layout id="commentFooter" class="footer-section" theme="spacing">
  <span id="commentDate" class="date">12 abril 2009</span>
  <vaadin-horizontal-layout id="commentLikeSection" class="like-section" theme="spacing-s">
   <vaadin-icon id="commentLikeButton" icon="vaadin:heart" class="like-button" size="1000"></vaadin-icon>
   <span id="commentLikeCount" class="like-count">12</span>
  </vaadin-horizontal-layout>
  <vaadin-button id="deleteCommentButton" class="delete-button" tabindex="0">
    Eliminar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</div>
`;
    }
}
