import { LitElement, html, css, customElement } from 'lit-element';

@customElement('vista-vernotificacionesderetweets')
export class VistaVernotificacionesderetweets extends LitElement {
  static get styles() {
    return css`
      :host {
        display: flex;
        flex-direction: column;
        width: 100%;
        height: 100%;
        font-family: 'Comic Sans MS', 'Comic Neue', cursive, sans-serif;
        box-sizing: border-box;
      }
      
      #notification-list-retweets {
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
      }
    `;
  }

  render() {
    return html`
      <div id="notification-list-retweets"></div>
    `;
  }
}
