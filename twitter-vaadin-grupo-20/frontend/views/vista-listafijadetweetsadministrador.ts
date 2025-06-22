import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('vista-listafijadetweetsadministrador')
export class VistaListafijadetweetsadministrador extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        width: 100%;
        height: 100%;
        background-color: #000;
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
        margin: 0;
        padding: 0;
      }
      
      #tweetsListContainer {
        width: 100%;
        height: 100%;
        background-color: #000;
        border: 2px solid #00FFFF;
        border-radius: var(--lumo-border-radius-l);
        padding: var(--lumo-space-m);
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        gap: var(--lumo-space-s);
        overflow-y: auto;
        overflow-x: hidden;
        /* Estilos para el scrollbar */
        scrollbar-width: thin;
        scrollbar-color: #00FFFF #333;
      }
      
      /* Estilos para los elementos hijos de la lista */
      #tweetsListContainer > * {
        flex-shrink: 0;
        margin-bottom: var(--lumo-space-xs);
      }
      
      #tweetsListContainer > *:last-child {
        margin-bottom: 0;
      }
      
      #tweetsListContainer::-webkit-scrollbar {
        width: 8px;
      }
      
      #tweetsListContainer::-webkit-scrollbar-track {
        background: #333;
        border-radius: 4px;
      }
      
      #tweetsListContainer::-webkit-scrollbar-thumb {
        background: #00FFFF;
        border-radius: 4px;
      }
      
      #tweetsListContainer::-webkit-scrollbar-thumb:hover {
        background: #00CCCC;
      }
      
      /* Estilos específicos para vaadin-vertical-layout */
      vaadin-vertical-layout {
        --lumo-space: var(--lumo-space-m);
        height: 100%;
        width: 100%;
      }
      
      /* Ajustes responsivos */
      @media (max-width: 768px) {
        #tweetsListContainer {
          padding: var(--lumo-space-s);
          gap: var(--lumo-space-xs);
          border-radius: var(--lumo-border-radius-m);
        }
      }
      
      @media (max-width: 480px) {
        #tweetsListContainer {
          padding: var(--lumo-space-xs);
          border-radius: var(--lumo-border-radius-s);
          border-width: 1px;
        }
      }
    `;
  }

  render() {
    return html`
      <vaadin-vertical-layout id="tweetsListContainer"></vaadin-vertical-layout>
    `;
  }
}