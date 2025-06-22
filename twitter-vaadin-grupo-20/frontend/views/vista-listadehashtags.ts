import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import './vista-listadehashtags_item';

@customElement('vista-listadehashtags')
export class VistaListadehashtags extends LitElement {  static get styles() {
    return css`
      :host {
        display: block;
        height: 100%;
        width: 100%;
        box-sizing: border-box;
        background-color: #000000; /* Fondo negro para modo oscuro */
      }
      
      #mainContainer {
        width: 100%;
        height: 100%;
        overflow-y: auto;
        overflow-x: hidden; /* Evita scroll horizontal innecesario */
        padding: 8px; /* Pequeño padding para separar del borde */
        align-items: stretch;
        gap: 8px; /* Espacio consistente entre items */
        box-sizing: border-box;
        background-color: #000000 !important; /* Fondo negro para el contenedor */
      }
      
      /* Estilos para los items de la lista */
      vista-listadehashtags_item {
        min-height: 60px; /* Altura mínima consistente */
        max-height: 120px; /* Evita que se hagan demasiado altos */
        flex-shrink: 0; /* Los items no se comprimen */
        width: 100%;
        margin: 0;
        border-radius: 8px; /* Bordes redondeados para mejor apariencia */
        transition: all 0.2s ease; /* Transición suave para interacciones */
        box-shadow: 0 2px 4px rgba(0, 255, 255, 0.1); /* Sombra turquesa sutil */
      }
      
      /* Efecto hover para mejor interactividad */
      vista-listadehashtags_item:hover {
        transform: translateY(-2px);
        box-shadow: 0 4px 8px rgba(0, 255, 255, 0.3); /* Sombra turquesa más intensa */
      }
      
      /* Animación para items que se añaden */
      vista-listadehashtags_item[data-new] {
        animation: slideInFade 0.3s ease-out;
      }
      
      @keyframes slideInFade {
        from {
          opacity: 0;
          transform: translateY(-20px);
        }
        to {
          opacity: 1;
          transform: translateY(0);
        }
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
        padding: 20px;
        text-align: center;
      }
      
      /* Responsive: en pantallas pequeñas */
      @media (max-width: 768px) {
        #mainContainer {
          padding: 4px;
          gap: 6px;
        }
        
        vista-listadehashtags_item {
          min-height: 50px;
        }
      }
    `;
  }

  render() {
    return html`
<vaadin-vertical-layout id="mainContainer" style="justify-content: flex-start; align-items: stretch;">
</vaadin-vertical-layout>
`;
  }
}