import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-perspectivabloqueado')
export class VistaPerspectivabloqueado extends LitElement {
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

      #profileHeader {
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        position: relative; /* Para posicionar elementos absolutos dentro */
        box-shadow: 0 5px 15px rgba(0, 255, 255, 0.3); /* Mejora: Sombra sutil para el encabezado */
        flex-shrink: 0; /* Evita que se comprima */
      }

      #bannerImage {
        width: 100%;
        height: 150px; /* Altura del banner */
        object-fit: cover; /* Asegura que la imagen cubra el área sin distorsionarse */
        border-bottom: 2px solid #00FFFF; /* Borde cian */
        display: block; /* Elimina el espacio extra debajo de la imagen */
      }

      #profileImage {
        width: 100px;
        height: 100px;
        border-radius: 50%;
        background-color: #555; /* Color de fondo para el placeholder de la imagen de perfil */
        border: 3px solid #00FFFF; /* Borde cian */
        position: absolute;
        top: 75px; /* CAMBIO: Ajusta la posición vertical para mayor superposición */
        left: var(--lumo-space-l); /* Alineado a la izquierda */
        /* transform: translateY(50%); -- ELIMINADO: Ya no es necesario con el nuevo 'top' */
        display: block; /* Elimina el espacio extra debajo de la imagen */
        object-fit: cover; /* Asegura que la imagen cubra el área circular */
        z-index: 1; /* Asegura que esté por encima del banner */
        box-shadow: 0 0 10px rgba(0, 255, 255, 0.5); /* Mejora: Sombra para la imagen de perfil */
      }

      #userInfo {
        width: 100%;
        padding: var(--lumo-space-xl) var(--lumo-space-l) var(--lumo-space-m);
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        color: #fff;
        /* CAMBIO: Ajusta el margen superior para que el texto se alinee correctamente debajo de la imagen de perfil */
        margin-top: calc(100px - 75px + var(--lumo-space-s)); /* (Altura img - top img) + espacio */
        flex-shrink: 0; /* Evita que se comprima */
      }

      #usernameText {
        font-size: 1.8em;
        font-weight: bold;
        margin-bottom: var(--lumo-space-xs);
        text-shadow: 0 0 5px rgba(0, 255, 255, 0.5); /* Mejora: Sombra de texto sutil */
      }

      #handleText {
        font-size: 1.2em;
        color: #aaa;
      }

      #blockedMessageContainer {
        background-color: #222; /* Fondo oscuro del mensaje de bloqueo */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        padding: var(--lumo-space-l);
        margin-top: var(--lumo-space-xl); /* Espacio superior para el mensaje */
        text-align: center;
        color: #fff;
        font-size: 1.5em;
        font-weight: bold;
        max-width: 400px;
        box-sizing: border-box;
        box-shadow: 0 0 25px rgba(0, 255, 255, 0.5); /* Mejora: Mayor brillo para el mensaje */
        text-shadow: 0 0 5px rgba(0, 255, 255, 0.7); /* Mejora: Sombra de texto para el mensaje */
        flex-shrink: 0; /* Evita que se comprima */
      }

      #embarrassingText, #blockedText {
        display: block; /* Asegura que cada span ocupe su propia línea */
      }

      /* Estilo para el pájaro de la imagen */
      #birdLogoImage {
        width: 150px; /* Ajusta el tamaño del pájaro */
        height: auto;
        margin-top: var(--lumo-space-xl); /* Espacio entre el mensaje y el pájaro */
        margin-bottom: var(--lumo-space-xl); /* Espacio inferior */
        filter: drop-shadow(0 0 10px rgba(0, 255, 255, 0.7)); /* Mejora: Efecto de brillo alrededor del pájaro */
        flex-shrink: 0; /* Evita que se comprima */
      }

      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #bannerImage {
          height: 100px;
        }
        #profileImage {
          width: 80px;
          height: 80px;
          top: 60px; /* Ajuste responsivo para la posición de la imagen de perfil */
          left: var(--lumo-space-m);
        }
        #userInfo {
          padding: var(--lumo-space-l) var(--lumo-space-m) var(--lumo-space-s);
          margin-top: calc(80px - 60px + var(--lumo-space-s)); /* Ajuste responsivo del margen superior */
        }
        #usernameText {
          font-size: 1.5em;
        }
        #handleText {
          font-size: 1em;
        }
        #blockedMessageContainer {
          font-size: 1.2em;
          padding: var(--lumo-space-m);
          max-width: 90%;
        }
        #birdLogoImage {
          width: 120px;
        }
      }
    `;
  }

  render() {
    return html`
      <div id="profileHeader">
        <img id="bannerImage" src="https://placehold.co/800x150/333333/00FFFF?text=Banner+Image" alt="Banner">
        <img id="profileImage" src="https://placehold.co/100x100/555555/00FFFF?text=Profile" alt="Profile Image">
      </div>

      <vaadin-vertical-layout id="userInfo">
        <span id="usernameText">Nombre</span>
        <span id="handleText">@usuario</span>
      </vaadin-vertical-layout>

      <vaadin-vertical-layout id="blockedMessageContainer">
        <span id="embarrassingText">Esto es embarazoso...</span>
        <span id="blockedText">¡Este perfil te ha bloqueado!</span>
      </vaadin-vertical-layout>

      <img id="birdLogoImage" src="./img/imagenIcon.png" alt="Pájaro">
    `;
  }
}