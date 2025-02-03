import type { PluginListenerHandle } from '@capacitor/core';

export declare type ButtonPressed = { isLongPress: boolean };
export declare type ButtonPressedListener = ({
  isLongPress
}: ButtonPressed) => void;

export interface CustomButtonPlugin {
  /**
   * Listen for presses on the hardware CUSTOM PTT button
   *
   * @since 1.0.0
   */
  addListener(
    event: 'pttButtonPressed',
    listenerFunc: ButtonPressedListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Listen for presses on the hardware HEADSET PTT button
   *
   * @since 1.0.0
   */
  addListener(
      event: 'headsetButtonPressed',
      listenerFunc: ButtonPressedListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Removes all listeners for this plugin
   *
   * @since 1.0.0
   */
  removeAllListeners(): Promise<void>;
}
