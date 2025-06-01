import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-listafijadehashtags')
export class VistaListafijadehashtags extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* Altura completa del viewport */
        width: 100vw; /* Ancho completo del viewport */
        background-color: #000; /* Fondo negro */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        margin: 0 !important;
        padding: 0 !important;
        position: fixed; /* Posición fija para ocupar toda la ventana */
        top: 0;
        left: 0;
        z-index: 1000; /* Z-index alto para asegurar que esté encima */
        overflow: auto; /* Permite scroll si es necesario */
      }
      
      /* Usando vaadin-vertical-layout para el contenedor principal */
      #mainContainer {
        background-color: #000; /* Fondo del contenedor principal */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        padding: var(--lumo-space-l);
        width: 100%;
        max-width: 500px; /* Ancho máximo para el contenedor */
        height: 90vh; /* Altura expandida del contenedor */
        min-height: 600px; /* Altura mínima para asegurar usabilidad */
        box-sizing: border-box;
        display: flex !important; /* Fuerza display flex */
        flex-direction: column !important; /* Dirección vertical */
      }
      
      h2 {
        color: #fff; /* Color del texto del título */
        font-size: 2.2em;
        margin: 0 0 var(--lumo-space-l) 0; /* Espacio debajo del título */
        font-weight: bold;
        text-align: center;
        flex-shrink: 0; /* No se encoge */
        align-self: center; /* Centrado dentro del contenedor flex */
        width: 100%; /* Asegura que ocupe todo el ancho para el centrado */
      }
      
      /* Estilos para el contenedor donde irá el nuevo componente de lista de hashtags */
      #hashtagsListContainer {
        width: 100%;
        background-color: #333; /* Fondo oscuro de la lista */
        border: 2px solid #00FFFF; /* Borde cian de la lista */
        border-radius: var(--lumo-border-radius-l); /* Bordes redondeados */
        color: #fff;
        font-size: 1.2em;
        padding: var(--lumo-space-m);
        box-sizing: border-box;
        overflow-y: auto; /* Permite desplazamiento vertical si el contenido excede la altura */
        flex-grow: 1; /* Se expande para ocupar el espacio disponible */
        flex-shrink: 1; /* Puede encogerse si es necesario */
        min-height: 200px; /* Altura mínima para el contenedor de hashtags */
        display: flex !important;
        flex-direction: column !important;
        gap: var(--lumo-space-s); /* Espacio entre elementos de la lista */
        align-items: stretch !important; /* Los elementos ocupan todo el ancho */
      }

      /* Estilos para los elementos individuales de hashtag */
      .hashtag-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #222; /* Fondo más oscuro para cada item */
        border: 1px solid #555; /* Borde sutil */
        border-radius: var(--lumo-border-radius-m);
        padding: var(--lumo-space-s) var(--lumo-space-m);
        margin-bottom: var(--lumo-space-xs);
        transition: all 0.2s ease-in-out;
        cursor: pointer;
        min-height: 50px; /* Altura mínima para cada item */
      }

      .hashtag-item:hover {
        background-color: #444; /* Efecto hover */
        border-color: #00FFFF; /* Borde cian al hover */
        box-shadow: 0 0 5px rgba(0, 255, 255, 0.3); /* Brillo sutil */
      }

      .hashtag-item:last-child {
        margin-bottom: 0; /* Sin margen en el último elemento */
      }

      .hashtag-name {
        font-weight: bold;
        color: #00FFFF; /* Color cian para el nombre del hashtag */
        font-size: 1.1em;
        flex-grow: 1;
        text-align: left;
      }

      .hashtag-stats {
        display: flex;
        align-items: center;
        gap: var(--lumo-space-s);
        color: #AAA; /* Color gris para las estadísticas */
        font-size: 0.9em;
      }

      .hashtag-count {
        font-weight: normal;
      }

      .hashtag-icon {
        color: #666;
        font-size: 1.2em;
      }

      /* Estilo para cuando la lista está vacía */
      .empty-state {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        color: #666;
        font-style: italic;
        text-align: center;
        gap: var(--lumo-space-m);
      }

      .empty-state-icon {
        font-size: 3em;
        color: #444;
      }
      
      #showMoreButton {
        background-color: #333; /* Fondo oscuro para el botón */
        color: #00FFFF; /* Texto cian */
        border: 2px solid #00FFFF; /* Borde cian */
        border-radius: var(--lumo-border-radius-m);
        padding: var(--lumo-space-s) var(--lumo-space-l);
        font-size: 1.1em;
        font-weight: bold;
        text-transform: uppercase;
        box-shadow: var(--lumo-box-shadow-s);
        cursor: pointer;
        margin: var(--lumo-space-l) auto 0 auto; /* Centrado horizontalmente con margen automático */
        transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
        flex-shrink: 0; /* No se encoge */
        align-self: center; /* Centrado dentro del contenedor flex */
      }
      
      #showMoreButton:hover {
        background-color: #00FFFF; /* Fondo cian al pasar el ratón */
        color: #000; /* Texto negro al pasar el ratón */
      }
      
      /* Ajustes responsivos */
      @media (max-width: 600px) {
        #mainContainer {
          padding: var(--lumo-space-m);
          max-width: 95%;
          height: 85vh; /* Altura ligeramente menor en móviles */
          min-height: 500px;
        }
        
        h2 {
          font-size: 1.8em;
        }
        
        #hashtagsListContainer {
          min-height: 150px;
          gap: var(--lumo-space-xs); /* Menor espacio entre elementos en móvil */
        }

        .hashtag-item {
          padding: var(--lumo-space-xs) var(--lumo-space-s);
          min-height: 45px;
        }

        .hashtag-name {
          font-size: 1em;
        }

        .hashtag-stats {
          font-size: 0.8em;
        }
        
        #showMoreButton {
          font-size: 1em;
          padding: var(--lumo-space-xs) var(--lumo-space-m);
        }
      }
      
      /* Ajuste para pantallas muy pequeñas en altura */
      @media (max-height: 500px) {
        #mainContainer {
          height: 95vh;
          min-height: 400px;
        }
        
        h2 {
          font-size: 1.5em;
          margin-bottom: var(--lumo-space-s);
        }
        
        #hashtagsListContainer {
          min-height: 100px;
        }
      }
    `;
  }
  
  render() {
    return html`
      <vaadin-vertical-layout id="mainContainer">
        <h2 id="pageTitle ">#Hashtag</h2>
        <vaadin-vertical-layout id="hashtagsListContainer">
          <!-- Estado vacío (se puede mostrar cuando no hay hashtags) -->
          <!-- 
          <div class="empty-state">
            <span class="empty-state-icon">#</span>
            <span>No hay hashtags disponibles</span>
          </div>
          -->
        </vaadin-vertical-layout>
        <vaadin-button id="showMoreButton" tabindex="0">
          Mostrar más hashtags 
        </vaadin-button>
      </vaadin-vertical-layout>
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