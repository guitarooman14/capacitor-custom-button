package com.guitarooman14.plugins.CustomButton;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
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
        implementation.stopMonitoring(getActivity());
    }

    private void notifyCustomButtonListener(JSObject ret) {
        notifyListeners(CUSTOM_BUTTON_PRESSED_EVENT, ret);
    }
}
