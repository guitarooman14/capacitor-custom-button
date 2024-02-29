import type { ListenerCallback, PluginListenerHandle } from '@capacitor/core';
import { WebPlugin, Capacitor } from '@capacitor/core';

import type { CustomButtonPlugin } from './definitions';

export class CustomButtonWeb
  extends WebPlugin
  implements CustomButtonPlugin {
  private platform = Capacitor.getPlatform();

  addListener(
    eventName: string,
    listenerFunc: ListenerCallback,
  ): Promise<PluginListenerHandle> & PluginListenerHandle {
    if (this.platform === 'android') {
      return super.addListener(eventName, listenerFunc);
    } else {
      console.log('CustomButtonPlugin is not supported on web or ios');
      return super.addListener(eventName, listenerFunc);
    }
  }
}
