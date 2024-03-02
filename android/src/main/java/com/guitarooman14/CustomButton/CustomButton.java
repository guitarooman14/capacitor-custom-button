package com.guitarooman14.CustomButton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.getcapacitor.JSObject;

public class CustomButton {
    @Nullable
    private CustomButtonListener customButtonListener;
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
                        if (intent.getAction().equals("com.guitarooman14.CUSTOM_BUTTON")) {
                            JSObject ret = new JSObject();
                            boolean isLongPress = intent.getBooleanExtra("isLongPress", false);
                            ret.put("isLongPress", isLongPress);
                            customButtonListener.onCustomButtonPressed(ret);
                        }
                    }
                };
        activity.registerReceiver(receiver, new IntentFilter("com.guitarooman14.CUSTOM_BUTTON"));
    }

    /**
     * Return the object that is receiving the callbacks.
     *
     * @return
     */
    @Nullable
    public CustomButtonListener getCustomButtonChangeListener() {
        return customButtonListener;
    }

    /**
     * Set the object to receive callbacks.
     *
     * @param listener
     */
    public void seCustomButtonListener(@Nullable CustomButtonListener listener) {
        this.customButtonListener = listener;
    }

    /**
     * Register a Intent Receiver in the activity.
     *
     * @param activity
     */
    public void startMonitoring(@NonNull AppCompatActivity activity) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
        activity.registerReceiver(receiver, filter);
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
    interface CustomButtonListener {
        void onCustomButtonPressed(JSObject keyEvent);
    }
}
