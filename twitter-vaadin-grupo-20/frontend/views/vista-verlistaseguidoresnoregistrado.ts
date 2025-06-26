import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-verlistaseguidoresnoregistrado')
export class VistaVerlistaseguidoresnoregistrado extends LitElement {

    connectedCallback() {
        super.connectedCallback();
        // Forzar estilos globales para asegurar pantalla completa
        document.body.style.margin = '0';
        document.body.style.padding = '0';
        document.body.style.overflow = 'hidden';
        document.documentElement.style.margin = '0';
        document.documentElement.style.padding = '0';
        document.documentElement.style.height = '100%';
        document.body.style.height = '100%';
    }

    disconnectedCallback() {
        super.disconnectedCallback();
        // Restaurar estilos cuando el componente se desconecte
        document.body.style.overflow = '';
    }
    static get styles() {
        return css`            :host {
                display: flex;
                flex-direction: column;
                width: 100vw; /* Ocupa todo el ancho del viewport */
                height: 100vh; /* Ocupa toda la altura del viewport */
                background-color: black; /* Fondo negro como en la imagen */
                color: white; /* Color de texto predeterminado */
                font-family: 'Arial', sans-serif; /* Fuente consistente */
                margin: 0; /* Elimina márgenes */
                padding: 0; /* Elimina padding */
                position: fixed; /* Fija la posición para ocupar toda la ventana */
                top: 0;
                left: 0;
                overflow-y: auto; /* Permite scroll si es necesario */
                box-sizing: border-box;
                --lumo-space-m: 1rem;
                --lumo-space-l: 1.5rem;
                --lumo-space-xl: 2rem;
            }

            #main-layout {
                width: 100%;
                height: 100%;
                padding: var(--lumo-space-l);
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: stretch; /* Ocupar todo el ancho disponible */
                margin: 0; /* Sin márgenes */
                max-width: none; /* Sin limitación de ancho máximo */
            }            #header-container {
                display: flex;
                flex-direction: column;
                align-items: flex-start; /* Alinear a la izquierda */
                margin-bottom: var(--lumo-space-l);
                width: 100%;
                padding-left: 10px; /* Pequeño padding izquierdo */
            }

            #message-icon {
                width: 80px; /* Tamaño del icono del sobre */
                height: 80px;
                background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="%2387CEEB"><path d="M22 6.002c0-1.104-.896-2-2-2H4c-1.104 0-2 .896-2 2v12c0 1.104.896 2 2 2h16c1.104 0 2-.896 2-2V6.002zm-2 0l-8 4-8-4H20zm0 12H4V8.002l8 4 8-4V18zm-1-6.19l-7.39 3.695-.61.305-.61-.305-7.39-3.695V17.99H20v-5.188z"/></svg>'); /* Un SVG de sobre genérico */
                background-size: contain;
                background-repeat: no-repeat;
                background-position: center;
                margin-bottom: var(--lumo-space-m);
            }

            #title-layout {
                display: flex;
                flex-direction: column; /* Apilar título y nombre de usuario */
                align-items: center;
                text-align: center;
            }

            #list-title {
                font-size: 1.8em;
                font-weight: bold;
                color: #00FFFF; /* Color turquesa para el título */
                font-family: 'Comic Sans MS', cursive; /* Estilo de fuente divertido */
                margin-bottom: 0.2em; /* Poco espacio entre título y usuario */
            }

            #username {
                font-size: 1.4em;
                color: #00FFFF; /* Mismo color turquesa para el nombre de usuario */
                font-family: 'Comic Sans MS', cursive;
            }            #followers-list-container {
                width: 100%;
                flex: 1; /* Ocupar el espacio disponible */
                background-color: #333; /* Fondo para el contenedor de la lista */
                border: 2px solid #00FFFF; /* Borde turquesa */
                border-radius: 8px;
                padding: var(--lumo-space-m);
                box-sizing: border-box;
                margin-bottom: var(--lumo-space-l);
                display: flex;
                flex-direction: column;
                justify-content: flex-start; /* Alinear contenido al inicio */
                align-items: stretch; /* Ocupar todo el ancho */
                text-align: left; /* Alineación izquierda para la lista */
                min-height: 300px; /* Altura mínima para el contenedor */
            }

            #no-followers-message {
                color: gray;
                font-size: 1.1em;
                padding: var(--lumo-space-xl);
            }
        `;
    } render() {
        return html`
            <div style="
                display: flex;
                flex-direction: column;
                width: 100vw;
                height: 100vh;
                background-color: black;
                color: white;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                position: fixed;
                top: 0;
                left: 0;
                overflow-y: auto;
                box-sizing: border-box;
                z-index: 9999;
            ">
                <vaadin-vertical-layout id="main-layout" style="
                    width: 100%;
                    height: 100%;
                    padding: 1.5rem;
                    box-sizing: border-box;
                    display: flex;
                    flex-direction: column;
                    align-items: stretch;
                    margin: 0;
                    max-width: none;
                ">
                    <vaadin-button id="back-button" style="align-self: flex-start; margin-bottom: 20px; background-color: #1da1f2; color: white;">
                        ← Volver
                    </vaadin-button>
                    <div id="header-container" style="
                        display: flex;
                        flex-direction: column;
                        align-items: flex-start;
                        margin-bottom: 1.5rem;
                        width: 100%;
                        padding-left: 10px;
                    ">
                        <div id="message-icon" style="
                            width: 80px;
                            height: 80px;
                            background-color: #87CEEB;
                            border-radius: 50%;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            margin-bottom: 1rem;
                            font-size: 2rem;
                        ">👥</div>
                        <div id="title-layout" style="
                            display: flex;
                            flex-direction: column;
                            align-items: flex-start;
                            text-align: left;
                            width: 100%;
                        ">
                            <span id="list-title" style="
                                font-size: 1.8em;
                                font-weight: bold;
                                color: #00FFFF;
                                font-family: 'Comic Sans MS', cursive;
                                margin-bottom: 0.2em;
                            ">Lista de seguidores de</span>
                            <span id="username" style="
                                font-size: 1.4em;
                                color: #00FFFF;
                                font-family: 'Comic Sans MS', cursive;
                            ">@usuario</span>
                        </div>
                    </div>

                    <vaadin-vertical-layout id="followers-list-container" style="
                        width: 100%;
                        flex: 1;
                        background-color: #333;
                        border: 2px solid #00FFFF;
                        border-radius: 8px;
                        padding: 1rem;
                        box-sizing: border-box;
                        margin-bottom: 1.5rem;
                        display: flex;
                        flex-direction: column;
                        justify-content: flex-start;
                        align-items: stretch;
                        text-align: left;
                        min-height: 300px;
                    ">
                        <span id="no-followers-message" style="color: gray; font-size: 1.1em; padding: 2rem;">No hay seguidores para mostrar.</span>
                    </vaadin-vertical-layout>
                </vaadin-vertical-layout>
            </div>
        `;
    }
}