import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout';
import '@vaadin/horizontal-layout';

@customElement('vista-publicacinvistaadministrador')
export class VistaPublicacinvistaadministrador extends LitElement {

  // Ya no hay propiedades (@property) aquí.
  // El contenido y la visibilidad se definirán directamente en el método render().

  static get styles() {
    return css`
      :host {
        display: block;
        font-family: Arial, sans-serif;
        border: 1px solid #444; /* Borde exterior como en las imágenes */
        border-radius: 8px;
        background-color: #333; /* Fondo oscuro como en las imágenes */
        color: #eee;
        padding: 15px;
        margin: 10px;
        max-width: 500px; /* Ancho máximo para la publicación */
      }

      /* Estilos para los layouts de Vaadin y otros elementos */
      /* El .publicacion-contenedor ahora es un vaadin-vertical-layout */
      vaadin-vertical-layout.publicacion-contenedor {
        gap: 10px; /* Espacio entre secciones principales */
        /* display: flex y flex-direction son manejados por vaadin-vertical-layout */
      }

      /* El .cabecera ahora es un vaadin-horizontal-layout */
      vaadin-horizontal-layout.cabecera {
        align-items: center; /* Vaadin maneja la alineación, pero se puede especificar */
        gap: 10px;
        width: 100%;
      }

      .avatar { /* Este sigue siendo un div o img, los estilos se mantienen */
        width: 40px;
        height: 40px;
        border-radius: 50%;
        background-color: #555;
        display: flex; /* Para centrar contenido dentro del div avatar */
        align-items: center;
        justify-content: center;
        font-size: 20px;
        flex-shrink: 0; /* Evita que el avatar se encoja en un flex container */
      }

      .avatar img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
      }

      /* El .info-usuario ahora es un vaadin-vertical-layout */
      vaadin-vertical-layout.info-usuario {
        flex-grow: 1; /* Para que ocupe el espacio disponible */
        /* display: flex y flex-direction son manejados por vaadin-vertical-layout */
      }

      .nombre-usuario {
        font-weight: bold;
        color: #fff;
      }

      .handle-usuario {
        font-size: 0.9em;
        color: #aaa;
      }

      .contenido {
        /* margin-top: 5px; Puede ser manejado por el 'gap' del layout padre */
      }

      .texto-publicacion {
        margin: 0 0 10px 0;
        white-space: pre-wrap;
        color: #ddd;
      }

      /* Estilos para la publicación anidada/citada */
      /* El .publicacion-citada-contenedor ahora es un vaadin-vertical-layout */
      vaadin-vertical-layout.publicacion-citada-contenedor {
        border: 1px solid #555;
        border-radius: 6px;
        padding: 10px 0px; /* Padding vertical de 10px, padding horizontal de 0px */
        margin: 0; /* El gap del contenedor padre maneja el espacio exterior */
        background-color: #3a3a3a;
        gap: 8px; /* Espacio interno */
        width: 100%; /* Asegura que intente ocupar el ancho */
        box-sizing: border-box; /* Para que el padding no incremente el ancho total */
      }

      .publicacion-citada-contenedor .cabecera { /* vaadin-horizontal-layout */
         /* Estilos específicos para la cabecera citada si son diferentes */
         /* Si se quiere un pequeño padding interno para la cabecera y contenido citado, se puede añadir aquí o a sus hijos */
         padding-left: 5px; /* Ejemplo de padding interno para los hijos si el contenedor tiene 0 padding */
         padding-right: 5px;
         box-sizing: border-box;
      }
       .publicacion-citada-contenedor .contenido {
         padding-left: 5px; /* Ejemplo de padding interno para los hijos si el contenedor tiene 0 padding */
         padding-right: 5px;
         box-sizing: border-box;
         width: 100%;
       }


      .publicacion-citada-contenedor .avatar {
        width: 32px;
        height: 32px;
        font-size: 16px;
      }

      .publicacion-citada-contenedor .texto-publicacion {
        font-size: 0.95em;
        margin-bottom: 0;
      }
      /* Fin de estilos para la publicación anidada/citada */

      /* El .pie ahora es un vaadin-horizontal-layout */
      vaadin-horizontal-layout.pie {
        justify-content: space-between; /* Alinea fecha a la izq y acciones a la der */
        align-items: center;
        gap: 8px;
        margin-top: 10px; /* Espacio sobre el pie */
        border-top: 1px solid #444;
        padding-top: 10px;
        width: 100%;
      }

      .fecha-publicacion {
        font-size: 0.8em;
        color: #999;
        /* margin-right: auto; // No es necesario si pie es space-between */
      }

      /* El .acciones ahora es un vaadin-horizontal-layout */
      vaadin-horizontal-layout.acciones {
        align-items: center;
        gap: 8px; /* Espacio entre botones de acción */
      }

      .acciones button { /* Estilo general para botones de acción */
        background-color: #555;
        color: #eee;
        border: 1px solid #666;
        padding: 6px 10px;
        border-radius: 15px;
        cursor: pointer;
        font-size: 0.9em;
        display: flex; /* Para alinear icono y texto/número dentro del botón */
        align-items: center;
        gap: 5px; /* Espacio entre icono y número */
      }
      .acciones button:hover {
        background-color: #666;
      }
      .acciones .boton-eliminar-inferior {
        background-color: #d9534f;
        color: white;
        border-color: #d43f3a;
      }
      .acciones .boton-eliminar-inferior:hover {
        background-color: #c9302c;
      }
      
      /* Estilos para los iconos dentro de los botones de acción */
      .acciones .icono-accion {
        /* font-size: 1.2em; Se puede ajustar si es necesario, o heredar */
        /* El color puede ser específico por icono si se desea */
      }
      .acciones .corazon-icono { /* Estilo específico para el icono de corazón */
        color: #fff; /* O el color que prefieras para el corazón */
      }

      .acciones .contador-accion { /* Estilo para los números */
        /* font-weight: bold; Opcional */
      }

      [hidden] { /* Aunque no se usa activamente ahora, es bueno tenerlo */
        display: none !important;
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="publicacionContenedorRaiz" class="publicacion-contenedor">
 <vaadin-horizontal-layout id="cabeceraPrincipal" class="cabecera">
  <div id="avatarPrincipalContenedor" class="avatar">
   <img id="imagenAvatarPrincipal" src="frontend/images/avatar_placeholder.png" alt="Avatar">
  </div>
  <vaadin-vertical-layout id="infoUsuarioPrincipalContenedor" class="info-usuario">
   <span id="nombreUsuarioPrincipal" class="nombre-usuario">Nic</span>
   <span id="handleUsuarioPrincipal" class="handle-usuario">@arroba</span>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <div id="contenidoPrincipalContenedor" class="contenido">
  <p id="textoPublicacionPrincipal" class="texto-publicacion">#hashtag texto texto</p>
 </div>
 <vaadin-vertical-layout id="publicacionCitadaContenedor" class="publicacion-citada-contenedor">
  <vaadin-horizontal-layout id="cabeceraCitada" class="cabecera">
   <div id="avatarCitadoContenedor" class="avatar">
    <img id="imagenAvatarCitado" src="frontend/images/avatar_placeholder.png" alt="Avatar Citado">
   </div>
   <vaadin-vertical-layout id="infoUsuarioCitadoContenedor" class="info-usuario">
    <span id="nombreUsuarioCitado" class="nombre-usuario">Nic</span>
    <span id="handleUsuarioCitado" class="handle-usuario">@arroba</span>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
  <div id="contenidoCitadoContenedor" class="contenido">
   <p id="textoPublicacionCitada" class="texto-publicacion">#hashtag texto texto</p>
  </div>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout id="piePublicacionContenedor" class="pie">
  <span id="fechaPublicacionSpan" class="fecha-publicacion">3 sept 2023</span>
  <vaadin-horizontal-layout id="accionesContenedor" class="acciones">
   <button id="botonAccionY" class="accion-y" @click="${this._handleAccionY}"><span id="iconoRetweet" class="icono-accion">↪️</span><span id="contadorRetweet" class="contador-accion">23</span></button>
   <button id="botonAccionX" class="accion-x" @click="${this._handleAccionX}"><span id="iconoLike" class="icono-accion corazon-icono">❤️</span><span id="contadorLike" class="contador-accion">105</span></button>
   <button id="botonAccionComentario" class="accion-comentario" @click="${this._handleAccionComentario}"><span id="iconoComentario" class="icono-accion">💬</span><span id="contadorComentario" class="contador-accion">12</span></button>
   <button id="botonEliminarInferior" class="boton-eliminar-inferior" @click="${this._handleEliminar}">Eliminar tweet</button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // --- Manejadores de eventos (como los proporcionaste) ---
  _handleEliminar(event: Event) {
    console.log('Acción: Eliminar, elemento ID:', (event.currentTarget as HTMLElement).id);
  }

  _handleAccionY(event: Event) { // Representa Retweets
    console.log('Acción: Y (Retweets), elemento ID:', (event.currentTarget as HTMLElement).id);
  }

  _handleAccionCorazon(event: Event) { // Este manejador ya no está atado a un elemento visible si el span del corazón fue removido
    console.log('Acción: Corazón (manejador obsoleto si el span fue removido), elemento ID:', (event.currentTarget as HTMLElement).id);
  }

  _handleAccionX(event: Event) { // Representa Likes
    console.log('Acción: X (Likes), elemento ID:', (event.currentTarget as HTMLElement).id);
  }

  _handleAccionCompartir(event: Event) { // Este manejador ya no está atado a un elemento visible si el botón de compartir fue removido
    console.log('Acción: Compartir (manejador obsoleto si el botón fue removido), elemento ID:', (event.currentTarget as HTMLElement).id);
  }

  _handleAccionComentario(event: Event) { // Representa Comentarios
    console.log('Acción: Comentario, elemento ID:', (event.currentTarget as HTMLElement).id);
  }

  /*
  createRenderRoot() {
    // Comentado para usar Shadow DOM, lo cual es bueno para la encapsulación de estilos.
    return this;
  }
  */
}
