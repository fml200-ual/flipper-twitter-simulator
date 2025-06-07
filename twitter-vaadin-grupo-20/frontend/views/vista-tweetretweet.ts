import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/icon/src/vaadin-icon.js';
import '@vaadin/icons';
import '@vaadin/avatar/src/vaadin-avatar.js';

@customElement('vista-tweetretweet')
export class VistaTweetretweet extends LitElement {

    // Define los estilos del componente
    static get styles() {
    return css`
      :host {
        display: flex;
        flex-direction: column;
        align-items: center; /* Centra el contenido en el host */
        font-family: Arial, sans-serif;
        background-color: #000;
        padding: 20px;
        box-sizing: border-box;
      }

      .contenedor-principal {
          max-width: 550px;
          width: 100%;
          display: flex;
          flex-direction: column;
          gap: 15px;
      }

      /* --- ESTILOS PARA LA PUBLICACIÓN PRINCIPAL --- */
      .publicacion-principal-contenedor {
        display: block;
        border: 1px solid #444;
        border-radius: 8px;
        background-color: #2D2D2D;
        color: #eee;
        padding: 15px;
      }

      .publicacion-principal-contenedor .cabecera {
        align-items: center;
        gap: 10px;
      }

      .avatar {
        width: 50px;
        height: 50px;
        border-radius: 50%;
        flex-shrink: 0;
        background-color: #1DA1F2;
        display: flex;
        align-items: center;
        justify-content: center;
        overflow: hidden;
      }
      
      .avatar img {
          width: 70%;
          height: 70%;
          object-fit: contain;
      }

      .info-usuario { flex-grow: 1; }
      .nombre-usuario { font-weight: bold; color: #fff; }
      .handle-usuario { font-size: 0.9em; color: #aaa; }
      .contenido { margin: 10px 0; }
      .texto-publicacion { white-space: pre-wrap; color: #ddd; margin: 0; font-size: 1em; }
      
      .publicacion-citada-contenedor {
        border: 1px solid #555;
        border-radius: 8px;
        padding: 10px;
        margin-top: 15px;
        background-color: #202020;
        gap: 8px;
      }
      .publicacion-citada-contenedor .cabecera { align-items: center; gap: 8px; }
      .publicacion-citada-contenedor .avatar { width: 25px; height: 25px; }

      .pie {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-top: 10px;
        width: 100%;
        color: #999;
        font-size: 0.9em;
      }

      .acciones {
        display: flex;
        align-items: center;
        gap: 12px;
      }
      
      .acciones vaadin-icon {
          cursor: pointer;
          width: 20px;
          height: 20px;
          color: #999;
      }
      .acciones vaadin-icon:hover { color: #fff; }
      
      .boton-eliminar-tweet {
        background-color: #e0245e;
        color: white;
        border: none;
        border-radius: 15px;
        padding: 6px 12px;
        font-weight: bold;
        cursor: pointer;
        font-size: 0.8em;
      }
      .boton-eliminar-tweet:hover { background-color: #c71e52; }
      
      .comentarios-contenedor { display: flex; flex-direction: column; gap: 10px; }
      
      .comentario-item {
          display: flex;
          flex-direction: row;
          border: 1px solid #005A9C;
          background-color: #2D2D2D;
          border-radius: 8px;
          padding: 12px;
          gap: 10px;
      }
      
      .comentario-item .avatar { width: 40px; height: 40px; }
      .comentario-contenido-wrapper { display: flex; flex-direction: column; flex-grow: 1; gap: 5px; }
      .comentario-contenido-wrapper .cabecera-info { display: flex; align-items: center; gap: 8px; }
      .comentario-contenido-wrapper .texto-comentario { color: #ddd; margin: 0; }
      .comentario-contenido-wrapper .pie {
          display: flex;
          justify-content: space-between;
          align-items: center;
          font-size: 0.8em;
          padding-top: 5px;
      }
      
      .acciones-comentario { display: flex; gap: 15px; }
      .acciones-comentario vaadin-icon { width: 16px; height: 16px; color: #999; cursor: pointer; }
      .acciones-comentario vaadin-icon:hover { color: #fff; }

      .mostrar-mas {
        color: #2E8B57;
        margin-top: 15px;
        font-size: 1.1em;
        cursor: pointer;
        text-decoration: none;
        text-align: center;
      }
      .mostrar-mas:hover { text-decoration: underline; }
    `;
  }

    // `createRenderRoot()` se utiliza para evitar el Shadow DOM
    // de modo que los estilos globales (como los importados de los temas de Vaadin) se apliquen directamente.
    createRenderRoot() {
        return this;
    }

  render() {
    return html`
<div class="contenedor-principal">
 <vaadin-vertical-layout class="publicacion-principal-contenedor">
  <vaadin-horizontal-layout class="cabecera">
   <div class="avatar">
    <img src="images/bird-avatar.svg" alt="Avatar">
   </div>
   <vaadin-vertical-layout class="info-usuario">
    <span class="nombre-usuario">Nic</span>
    <span class="handle-usuario">@arroba</span>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
  <div class="contenido">
   <p class="texto-publicacion">#hashtag texto texto</p>
   <vaadin-vertical-layout class="publicacion-citada-contenedor">
    <vaadin-horizontal-layout class="cabecera">
     <div class="avatar">
      <img src="images/bird-avatar.svg" alt="Avatar Citado">
     </div>
     <vaadin-vertical-layout class="info-usuario">
      <span class="nombre-usuario">Nic</span>
      <span class="handle-usuario">@arroba</span>
     </vaadin-vertical-layout>
    </vaadin-horizontal-layout>
    <div class="contenido">
     <p class="texto-publicacion">#hashtag texto texto</p>
    </div>
   </vaadin-vertical-layout>
  </div>
  <div class="pie">
   <span>3 sept 2023</span>
   <div class="acciones">
    <span>12</span>
    <vaadin-icon title="Me gusta" icon="vaadin:heart" size="16"></vaadin-icon>
    <span>12</span>
    <vaadin-icon title="Retweet" icon="vaadin:retweet" size="16"></vaadin-icon>
    <button class="boton-eliminar-tweet">Eliminar tweet</button>
    <span>12</span>
    <vaadin-icon title="Comentar" icon="vaadin:comment" size="16"></vaadin-icon>
   </div>
  </div>
 </vaadin-vertical-layout>
 <div class="comentarios-contenedor"></div>
 <a href="#" class="mostrar-mas">Mostrar más comentarios</a>
</div>
`;
  }
}
