package com.example.amiltonedev_lt030.iem_tp2_android.manager;

import com.example.amiltonedev_lt030.iem_tp2_android.model.Device;



/**
 * Created by amiltonedev_lt030 on 19/10/2017.
 */

public class BLEManager {
    // variable de classe privée
    private Device pairedDevice;

    // constructeur public
    public BLEManager() {
    }

    // nom de variable : clair, précis, verbeux si necessaire, en ANGLAIS !
    public boolean isThereDevicePaired(){
        return pairedDevice != null;
    }

    public String getDeviceName(){
        if(pairedDevice != null){
            return pairedDevice.getDeviceName();
        }else{
            return null;
        }
    }

    public int getHeartRate(){
        if(pairedDevice != null){
            return pairedDevice.getHeartRate();
        }else{
            return -1;
        }
    }

    public void pairDevice(Device device){
        this.pairedDevice = device;
    }

    public void disconnectDevice(){
        this.pairedDevice = null;
    }
}
