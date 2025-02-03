import type { PluginListenerHandle } from '@capacitor/core';

export declare type PttButtonPressed = { isLongPress: boolean };
export declare type PttButtonPressedListener = ({
  isLongPress
}: PttButtonPressed) => void;
export declare type HeadSetButtonPressed = { isLongPress: boolean };
export declare type HeadsetButtonPressedListener = ({
  isLongPress
}: HeadSetButtonPressed) => void;

export interface CustomButtonPlugin {
  /**
   * Listen for presses on the hardware CUSTOM PTT button
   *
   * @since 1.0.0
   */
  addListener(
    event: 'pttButtonPressed',
    listenerFunc: PttButtonPressedListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Listen for presses on the hardware HEADSET PTT button
   *
   * @since 1.0.0
   */
  addListener(
      event: 'headsetButtonPressed',
      listenerFunc: HeadsetButtonPressedListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Removes all listeners for this plugin
   *
   * @since 1.0.0
   */
  removeAllListeners(): Promise<void>;
}
