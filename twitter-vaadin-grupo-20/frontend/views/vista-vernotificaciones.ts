import { LitElement, html, css, customElement } from 'lit-element';

@customElement('vista-vernotificaciones')
export class VistaVernotificaciones extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 100vw; /* Ocupa todo el ancho del viewport */
        height: 100vh; /* Ocupa toda la altura del viewport */
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        margin: 0; /* Elimina márgenes */
        padding: 0; /* Elimina padding */
        position: fixed; /* Fija la posición para ocupar toda la ventana */
        top: 0;
        left: 0;
        overflow-y: auto; /* Permite scroll si es necesario */
        font-family: 'Comic Sans MS', 'Chalkduster', 'cursive', sans-serif;
      }
      .wrapper {
        display: flex;
        flex-direction: column;
        align-items: center;
        background-color: #000;
        color: #fff;
        width: 100%;
        height: 100%;
        padding: 2rem;
        box-sizing: border-box;
      }
      h1 {
        font-size: 1.8rem;
        border: 2px solid #fff;
        padding: 0.5rem 1.5rem;
        margin-bottom: 1.5rem;
        /* Hacemos que el título no se encoja */
        flex-shrink: 0;
      }
      .button-container {
        display: flex;
        justify-content: center;
        gap: 1rem;
        margin-bottom: 2rem;
        flex-wrap: wrap;
        /* Hacemos que este contenedor no se encoja */
        flex-shrink: 0;
      }
      .filter-button {
        background-color: #333;
        color: #fff;
        border: 2px solid #fff;
        padding: 0.7rem 1rem;
        font-family: inherit;
        font-size: 0.9rem;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.2s;
      }
      .filter-button:hover, .filter-button:focus {
        background-color: #444;
        outline-color: #20c2c2;
      }
      .back-button {
        background-color: #555;
        color: #fff;
        border: 2px solid #fff;
        padding: 0.5rem 1rem;
        font-family: inherit;
        font-size: 0.9rem;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.2s;
        margin-bottom: 1rem;
        align-self: flex-start;
      }
      .back-button:hover, .back-button:focus {
        background-color: #666;
        outline-color: #20c2c2;
      }
      /* --- CAMBIOS PRINCIPALES AQUÍ --- */
      #notification-list {
        width: 100%;
        max-width: 800px;
        border: 3px solid #fff;
        border-radius: 5px;
        padding: 1rem;
        box-sizing: border-box;
        margin-bottom: 2rem;
        overflow-y: auto;
        /* 1. Hacemos que la lista crezca para ocupar el espacio disponible */
        flex-grow: 1;
        /* 2. Para evitar problemas de desbordamiento en algunos navegadores con flexbox */
        min-height: 0;  
        
        /* 3. Nos aseguramos de que el contenido interior también se comporte correctamente */
        display: flex; 
        flex-direction: column;
      }
      /* Importante: El componente hijo debe ocupar todo el alto del contenedor */
      #notification-list > vista-listadehashtags {
          height: 100%;
      }
    `;
  }

  render() {
    return html`
      <div class="wrapper" id="wrapper">
        <button class="back-button" id="boton_volver">← Volver</button>
        <h1 id="titulo_notificaciones">NOTIFICACIONES</h1>
        <div class="button-container" id="contenedor_botones">
          <button class="filter-button" id="boton_seguimiento">Notificaciones de seguimiento</button>
          <button class="filter-button" id="boton_menciones">Notificaciones de menciones</button>
          <button class="filter-button" id="boton_retweets">Notificaciones de retweets</button>
        </div>
        <div id="notification-list"></div>
      </div>
    `;
  }
}
