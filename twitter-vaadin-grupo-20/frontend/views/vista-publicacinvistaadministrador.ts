import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout';
import '@vaadin/horizontal-layout';
import '@vaadin/icon';
import '@vaadin/icons';

@customElement('vista-publicacinvistaadministrador')
export class VistaPublicacinvistaadministrador extends LitElement {

  static get styles() {
    return css`
      :host {
        display: block;
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        width: 100vw;
        height: 100vh;
        font-family: Arial, sans-serif;
        background-color: #000;
        overflow-y: auto;
        box-sizing: border-box;
        margin: 0;
        padding: 0;
      }

      .contenedor-principal {
          width: 100%;
          max-width: 100%;
          height: 100%;
          display: flex;
          flex-direction: column;
          gap: 15px;
          padding: 20px;
          box-sizing: border-box;
      }

      /* --- ESTILOS PARA LA PUBLICACIÓN PRINCIPAL --- */
      .publicacion-principal-contenedor {
        display: block;
        border: 1px solid #444;
        border-radius: 8px;
        background-color: #2D2D2D;
        color: #eee;
        padding: 15px;
        width: 100%;
        max-width: 800px;
        margin: 0 auto;
        box-sizing: border-box;
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
        width: 100%;
        box-sizing: border-box;
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
          width: 16px; /* Ajustado al tamaño del ejemplo */
          height: 16px;
          color: #999;
      }
      .acciones vaadin-icon:hover { color: #fff; }
      .acciones span {
          font-size: 0.9em;
      }
      
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
      
      .comentarios-contenedor { 
        display: flex; 
        flex-direction: column; 
        gap: 10px; 
        width: 100%;
        box-sizing: border-box;
      }
      
      .mostrar-mas {
        color: #2E8B57;
        margin-top: 15px;
        font-size: 1.1em;
        cursor: pointer;
        text-decoration: none;
        text-align: center;
      }
      .mostrar-mas:hover { text-decoration: underline; }
      
      /* --- ESTILOS PARA EL BOTÓN DE VOLVER --- */
      .boton-volver {
        background-color: transparent;
        border: 1px solid #1DA1F2;
        color: #1DA1F2;
        border-radius: 20px;
        padding: 8px 16px;
        font-weight: bold;
        cursor: pointer;
        font-size: 0.9em;
        display: flex;
        align-items: center;
        gap: 8px;
        align-self: flex-start;
        margin-bottom: 10px;
      }
      .boton-volver:hover {
        background-color: rgba(29, 161, 242, 0.1);
      }
      .boton-volver vaadin-icon {
        width: 16px;
        height: 16px;
      }
    `;
  }

  render() {
    return html`
<div class="contenedor-principal" id="contenedorPrincipal">
 <button class="boton-volver" id="botonVolver">
  <vaadin-icon icon="vaadin:arrow-left"></vaadin-icon>
  Volver
 </button>
 <vaadin-vertical-layout class="publicacion-principal-contenedor" id="layoutPublicacionPrincipal">
  <vaadin-horizontal-layout class="cabecera" id="cabeceraPublicacion">
   <div class="avatar" id="avatarDivPrincipal">
    <img src="images/bird-avatar.svg" alt="Avatar" id="imgAvatarPrincipal">
   </div>
   <vaadin-vertical-layout class="info-usuario" id="layoutInfoUsuario">
    <span class="nombre-usuario" id="spanNombreUsuario">Nic</span>
    <span class="handle-usuario" id="spanHandleUsuario">@arroba</span>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
  <div class="contenido" id="divContenido">
   <p class="texto-publicacion" id="pTextoPublicacion">#hashtag texto texto</p>
   <vaadin-vertical-layout class="publicacion-citada-contenedor" id="layoutPublicacionCitada">
    <vaadin-horizontal-layout class="cabecera" id="cabeceraCitada">
     <div class="avatar" id="avatarDivCitado">
      <img src="images/bird-avatar.svg" alt="Avatar Citado" id="imgAvatarCitado">
     </div>
     <vaadin-vertical-layout class="info-usuario" id="layoutInfoUsuarioCitado">
      <span class="nombre-usuario" id="spanNombreUsuarioCitado">Nic</span>
      <span class="handle-usuario" id="spanHandleUsuarioCitado">@arroba</span>
     </vaadin-vertical-layout>
    </vaadin-horizontal-layout>
    <div class="contenido" id="divContenidoCitado">
     <p class="texto-publicacion" id="pTextoPublicacionCitada">#hashtag texto texto</p>
    </div>
   </vaadin-vertical-layout>
  </div>
  <div class="pie" id="divPieDePublicacion">
   <span id="spanFecha">3 sept 2023</span>
   <div class="acciones" id="divAcciones">
    <span id="spanContadorMeGusta">12</span>
    <vaadin-icon title="Me gusta" icon="vaadin:heart" id="iconoMeGusta" size="16"></vaadin-icon>
    <span id="spanContadorRetweet">12</span>
    <vaadin-icon title="Retweet" icon="vaadin:retweet" id="iconoRetweet" size="16"></vaadin-icon>
    <button class="boton-eliminar-tweet" id="botonEliminarTweet">Eliminar tweet</button>
    <span id="spanContadorComentarios">12</span>
    <vaadin-icon title="Comentar" icon="vaadin:comment" id="iconoComentar" size="16"></vaadin-icon>
   </div>
  </div>
 </vaadin-vertical-layout>
 <div class="comentarios-contenedor" id="contenedorComentarios">
 </div>
 <a href="#" class="mostrar-mas" id="linkMostrarMas">Mostrar más comentarios</a>
</div>
`;
  }
}
