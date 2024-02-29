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

    @Override
    public void load() {
        getBridge()
            .getWebView()
            .setOnKeyListener(
                new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
                        boolean isKeyDown = event.getAction() == KeyEvent.ACTION_DOWN;
                        JSObject ret = new JSObject();
                        if (isKeyDown) {
                            ret.put("key", keyCode);
                            ret.put("isGamepadButton", android.view.KeyEvent.isGamepadButton(keyCode));
                            notifyListeners(CUSTOM_BUTTON_PRESSED_EVENT, ret);
                            return true;
                        }

                        return false;
                    }
                }
            );
    }
}
