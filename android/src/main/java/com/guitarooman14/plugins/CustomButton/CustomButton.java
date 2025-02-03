package com.guitarooman14.plugins.CustomButton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.getcapacitor.JSObject;

import java.util.Objects;

public class CustomButton {
    @Nullable
    private PttButtonListener pttButtonListener;
    @Nullable
    private HeadsetButtonListener headsetButtonListener;
    private BroadcastReceiver receiver;
    /**
     * Create custom button monitoring object.
     *
     * @param activity
     */
    public CustomButton(@NonNull AppCompatActivity activity) {
        // Into the main activity the custom button event is caught inside the dispatchKeyEvent and sent
        // to the broadcaster. This receiver catch those events and notify the js listeners.
        receiver =
                new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        if (intent.getAction().equals("com.proxima.PTT_BUTTON")) {
                            Log.d("PROXIMA Receiver", "PTT BUTTON PRESS Handled");
                            // Récupérez le nom de l'événement
                            String eventName = null;
                            boolean isLongPress = false;

                            // parcourez les clés pour trouver l'événement
                            for (String key : Objects.requireNonNull(intent.getExtras()).keySet()) {
                                if (key.equals("isPttButtonLongPress") || key.equals("isHeadsetButtonLongPress")) {
                                    eventName = key;
                                    isLongPress = intent.getBooleanExtra(key, false);
                                    break;
                                }
                            }
                            if (eventName != null) {
                                if (eventName.equals("isPttButtonLongPress")) {
                                    JSObject ret = new JSObject();
                                    ret.put("isLongPress", isLongPress);
                                    pttButtonListener.onPttButtonPressed(ret);
                                } else {
                                    JSObject ret = new JSObject();
                                    ret.put("isLongPress", isLongPress);
                                    headsetButtonListener.onHeadsetButtonPressed(ret);
                                }
                            }
                        }
                    }
                };
        activity.registerReceiver(receiver, new IntentFilter("com.proxima.PTT_BUTTON"));
    }

    /**
     * Set the object to receive callbacks.
     *
     * @param listener
     */
    public void setPttButtonListener(@Nullable PttButtonListener listener) {
        this.pttButtonListener = listener;
    }

    /**
     * Set the object to receive callbacks.
     *
     * @param listener
     */
    public void setHeadsetButtonListener(@Nullable HeadsetButtonListener listener) {
        this.headsetButtonListener = listener;
    }

    /**
     * Unregister the IntentReceiver to avoid leaking it.
     *
     * @param activity
     */
    public void stopMonitoring(@NonNull AppCompatActivity activity) {
        activity.unregisterReceiver(receiver);
    }

    /**
     * Interface for callbacks when custom button is triggered.
     */
    interface PttButtonListener {
        void onPttButtonPressed(JSObject keyEvent);
    }

    interface HeadsetButtonListener {
        void onHeadsetButtonPressed(JSObject keyEvent);
    }
}
