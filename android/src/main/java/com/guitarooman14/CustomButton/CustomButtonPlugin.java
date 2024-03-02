package com.guitarooman14.CustomButton;

import android.view.KeyEvent;
import android.view.View;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CustomButton")
public class CustomButtonPlugin extends Plugin {
    public static final String CUSTOM_BUTTON_PRESSED_EVENT = "customButtonPressed";

    private CustomButton implementation;

    @Override
    public void load() {
        implementation = new CustomButton(getActivity());
        implementation.seCustomButtonListener(this::notifyCustomButtonListener);
    }

    /**
     * Clean up callback to prevent leaks.
     */
    @Override
    protected void handleOnDestroy() {
        implementation.seCustomButtonListener(null);
    }

    /**
     * Register the IntentReceiver on resume
     */
    @Override
    protected void handleOnResume() {
        implementation.startMonitoring(getActivity());
    }

    /**
     * Unregister the IntentReceiver on pause to avoid leaking it
     */
    @Override
    protected void handleOnPause() {
        implementation.stopMonitoring(getActivity());
    }

    private void notifyCustomButtonListener(JSObject ret) {
        notifyListeners(CUSTOM_BUTTON_PRESSED_EVENT, ret);
    }
}
