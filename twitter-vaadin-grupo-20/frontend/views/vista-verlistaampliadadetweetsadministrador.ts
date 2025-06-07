import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/icons';

@customElement('vista-verlistaampliadadetweetsadministrador')
export class VistaVerlistaampliadadetweetsadministrador extends LitElement {
    static get styles() {
        return css`
            :host {
                display: block;
                height: 100%;
                width: 100%;
                background-color: black; /* Fondo oscuro */
                color: white; /* Color de texto predeterminado */
                font-family: 'Arial', sans-serif;
                --lumo-space-m: 1rem;
                --lumo-space-l: 1.5rem;
                --lumo-space-xl: 2rem;
            }

            #main-layout {
                width: 100%;
                max-width: 900px; /* Ancho máximo para el contenido */
                margin: 0 auto; /* Centrar el contenido */
                padding: var(--lumo-space-l);
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center; /* Centrar elementos horizontalmente */
            }

            #twitter-bird-icon {
                width: 100px; /* Tamaño del icono */
                height: 100px;
                margin-bottom: var(--lumo-space-l);
                /* Para un icono SVG, podrías insertarlo directamente aquí o usar un <img> con una URL */
                /* Ejemplo de SVG simple (ajusta los colores y formas según tu pájaro) */
                background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="%2387CEEB"><path d="M23.643 4.937c-.886.398-1.834.665-2.835.787 1.017-.609 1.795-1.574 2.162-2.723-.951.565-2.002.977-3.128 1.196-1.02-.924-2.47-1.503-4.072-1.503-3.076 0-5.578 2.502-5.578 5.578 0 .436.05.86.147 1.267-4.636-.233-8.74-2.45-11.492-5.807-.48.825-.754 1.776-.754 2.793 0 1.933.986 3.637 2.482 4.63-.91-.028-1.765-.28-2.516-.694v.07c0 2.71 1.928 4.965 4.484 5.49-.467.127-.96.195-1.472.195-.36 0-.71-.035-1.05-.1.71 2.222 2.775 3.839 5.21 3.882-1.916 1.5-4.33 2.404-6.967 2.404-.453 0-.898-.027-1.334-.078 2.47 1.588 5.406 2.518 8.567 2.518 10.282 0 15.93-8.527 15.93-15.923 0-.243-.005-.487-.014-.728.974-.703 1.81-1.576 2.474-2.573z"/></svg>');
                background-size: contain;
                background-repeat: no-repeat;
                background-position: center;
            }

            #main-header {
                font-size: 2em;
                font-weight: bold;
                color: #00FFFF; /* Color turquesa */
                margin-bottom: var(--lumo-space-l);
            }

            #search-section {
                width: 100%;
                margin-bottom: var(--lumo-space-l);
            }

            #search-field {
                width: 100%;
            }

            #controls-layout {
                width: 100%;
                justify-content: flex-end; /* Alinear los botones a la derecha */
                gap: var(--lumo-space-s); /* Espacio entre botones */
                margin-bottom: var(--lumo-space-l);
            }

            .vaadin-button {
                background-color: #50b7f5; /* Azul de Twitter o similar */
                color: white;
                border-radius: 20px;
                padding: 0.5em 1.5em;
                font-weight: bold;
                cursor: pointer;
            }

            .vaadin-button.secondary {
                background-color: #666; /* Botón secundario */
            }

            #tweet-list-container {
                width: 100%;
                /* Define aquí el estilo si necesitas un contenedor con scroll o un fondo específico */
                /* min-height: 300px; /* Altura mínima para mostrar el espacio */ */
                /* border: 1px dashed gray; /* Para visualizar el área donde irían los tweets */ */
                margin-bottom: var(--lumo-space-l);
                display: flex;
                flex-direction: column;
                gap: var(--lumo-space-m); /* Espacio entre los tweets si se renderizaran */
            }

            #show-more-button {
                background-color: #00FFFF; /* Botón "Mostrar más" turquesa */
                color: black;
                padding: var(--lumo-space-s) var(--lumo-space-l);
                border-radius: 20px;
                font-weight: bold;
                margin-top: var(--lumo-space-m);
                cursor: pointer;
                border: none;
                font-size: 1.1em;
            }
        `;
    }

    render() {
        return html`
<vaadin-vertical-layout id="main-layout">
 <!-- Icono de pájaro de Twitter (o similar) -->
 <div id="twitter-bird-icon"></div>
 <!-- Sección de Cabecera (ej: "Ver Hashtag" o "Administrar Tweets") -->
 <h2 id="main-header">Administrar Tweets</h2>
 <!-- Sección de búsqueda o filtro (si aplica) -->
 <vaadin-horizontal-layout id="search-section">
  <!-- Ejemplo de campo de búsqueda, puedes usar vaadin-text-field si es necesario -->
  <vaadin-text-field id="search-field" placeholder="Buscar tweets..." style="flex-grow: 1;" type="text"></vaadin-text-field>
  <vaadin-button id="search-button">
   Buscar
  </vaadin-button>
 </vaadin-horizontal-layout>
 <!-- Controles del administrador (ej: "Crear Nuevo", "Eliminar Seleccionados") -->
 <vaadin-horizontal-layout id="controls-layout">
  <vaadin-button id="create-new-button" class="vaadin-button" tabindex="0">
   Crear Nuevo
  </vaadin-button>
  <vaadin-button id="delete-selected-button" class="vaadin-button secondary" tabindex="0">
   Eliminar Seleccionados
  </vaadin-button>
 </vaadin-horizontal-layout>
 <!-- Contenedor donde irían los tweets (vacío como se solicitó) -->
 <vaadin-vertical-layout id="tweet-list-container">
  <!-- Aquí irían los tweets, cuando se añadan dinámicamente -->
  <span style="color: gray; margin: var(--lumo-space-xl);">No hay tweets para mostrar en esta vista de administrador.</span>
 </vaadin-vertical-layout>
 <!-- Botón "Mostrar más" -->
 <button id="show-more-button">Mostrar más</button>
</vaadin-vertical-layout>
`;
    }

    // Mantener esta configuración para renderizar directamente en el DOM ligero.
    // Esto es común en componentes LitElement usados directamente en Vaadin Flow.
    createRenderRoot() {
        return this;
    }
}
