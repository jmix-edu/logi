// /home/vaschenkoda/IdeaProjects/logi/src/main/frontend/src/component/theme-toggle/theme-toggle.js

import {html, LitElement} from 'lit';
import {PolylitMixin} from '@vaadin/component-base/src/polylit-mixin.js';
import {defineCustomElement} from '@vaadin/component-base/src/define.js';
import {ElementMixin} from '@vaadin/component-base/src/element-mixin.js';
import {css, ThemableMixin} from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';
import {buttonStyles} from '@vaadin/button/src/vaadin-button-core-styles.js';
import {button as buttonLumoStyles} from '@vaadin/button/theme/lumo/vaadin-button-styles.js';
import {ButtonMixin} from '@vaadin/button/src/vaadin-button-mixin.js';

const themeToggleStyles = css`
  :host {
    background: transparent;
    color: var(--lumo-text-color);
  }
`;

class ThemeToggle extends ButtonMixin(ElementMixin(ThemableMixin(PolylitMixin(LitElement)))) {
  static get is() {
    return 'theme-toggle';
  }

  static get styles() {
    return [buttonStyles, buttonLumoStyles, themeToggleStyles];
  }

  static get properties() {
    return {
      ariaLabel: {
        type: String,
        attribute: 'aria-label',
        reflect: true
      },

      storageKey: {
        type: String,
        attribute: 'storage-key'
      }
    };
  }

  constructor() {
    super();

    this.ariaLabel = 'Theme toggle';
    this.storageKey = 'jmix.flowui.theme';

    this.addEventListener('click', () => this.toggleTheme());
  }

  render() {
    return html`
      <div class="vaadin-button-container">
        <span part="prefix" aria-hidden="true">
          <slot name="prefix"></slot>
        </span>
        <span part="label">
          <slot></slot>
        </span>
      </div>

      <slot name="tooltip"></slot>
    `;
  }

  /** @protected */
  ready() {
    super.ready();
    this.applyStorageTheme();
  }

  updated(changedProperties) {
    super.updated?.(changedProperties);

    if (changedProperties.has('storageKey')) {
      const oldStorageKey = changedProperties.get('storageKey');
      this._onStorageKeyChanged(this.storageKey, oldStorageKey);
    }
  }

  applyStorageTheme() {
    const storageTheme = this.getStorageTheme();
    const currentTheme = this.getCurrentTheme();
    if (storageTheme && currentTheme !== storageTheme) {
      this.applyTheme(storageTheme);
    }
  }

  getStorageTheme() {
    return localStorage.getItem(this.storageKey);
  }

  getCurrentTheme() {
    return document.documentElement.getAttribute('theme');
  }

  toggleTheme() {
    const theme = this.getCurrentTheme();
    this.applyTheme(theme === 'dark' ? '' : 'dark');
  }

  applyTheme(theme) {
    document.documentElement.setAttribute('theme', theme);
    localStorage.setItem(this.storageKey, theme);

    const customEvent = new CustomEvent('theme-changed', {detail: {value: theme}});
    this.dispatchEvent(customEvent);
  }

  /** @protected */
  _onStorageKeyChanged(storageKey, oldStorageKey) {
    if (!oldStorageKey) {
      return;
    }

    const theme = localStorage.getItem(oldStorageKey);
    localStorage.removeItem(oldStorageKey);

    if (theme) {
      localStorage.setItem(storageKey, theme);
    }
  }
}

defineCustomElement(ThemeToggle);

export {ThemeToggle};