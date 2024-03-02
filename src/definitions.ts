import type { PluginListenerHandle } from '@capacitor/core';

export declare type CustomButtonPressed = { isLongPress: boolean };
export declare type CustomButtonPressedListener = ({
  isLongPress
}: CustomButtonPressed) => void;

export interface CustomButtonPlugin {
  /**
   * Listen for presses on the hardware volume buttons
   *
   * @since 1.0.0
   */
  addListener(
    event: 'customButtonPressed',
    listenerFunc: CustomButtonPressedListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Removes all listeners for this plugin
   *
   * @since 1.0.0
   */
  removeAllListeners(): Promise<void>;
}
