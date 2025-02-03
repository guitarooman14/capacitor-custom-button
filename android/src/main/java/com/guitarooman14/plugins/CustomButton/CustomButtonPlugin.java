package com.guitarooman14.plugins.CustomButton;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CustomButton")
public class CustomButtonPlugin extends Plugin {
    public static final String PTT_BUTTON_PRESSED_EVENT = "pttButtonPressed";
    public static final String HEADSET_BUTTON_PRESSED_EVENT = "headsetButtonPressed";

    private CustomButton implementation;

    @Override
    public void load() {
        implementation = new CustomButton(getActivity());
        implementation.setPttButtonListener(this::notifyPttButtonListener);
        implementation.setHeadsetButtonListener(this::notifyHeadsetButtonListener);
    }

    /**
     * Clean up callback to prevent leaks.
     */
    @Override
    protected void handleOnDestroy() {
        implementation.setPttButtonListener(null);
        implementation.setHeadsetButtonListener(null);
        implementation.stopMonitoring(getActivity());
    }

    private void notifyPttButtonListener(JSObject ret) {
        notifyListeners(PTT_BUTTON_PRESSED_EVENT, ret);
    }

    private void notifyHeadsetButtonListener(JSObject ret) {
        notifyListeners(HEADSET_BUTTON_PRESSED_EVENT, ret);
    }
}
