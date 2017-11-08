package com.example.amiltonedev_lt030.iem_tp2_android.model;

/**
 * Created by amiltonedev_lt030 on 19/10/2017.
 */

public class DevicePolar implements Device {
    @Override
    public int getHeartRate() {
        return 65;
    }

    @Override
    public int getBloodPressure() {
        return 23;
    }

    @Override
    public String getDeviceName() {
        return "Polar";
    }
}
