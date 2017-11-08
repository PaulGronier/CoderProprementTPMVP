package com.example.amiltonedev_lt030.iem_tp2_android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.amiltonedev_lt030.iem_tp2_android.IEMApplication;
import com.example.amiltonedev_lt030.iem_tp2_android.R;
import com.example.amiltonedev_lt030.iem_tp2_android.manager.BLEManager;

/**
 * Created by amiltonedev_lt030 on 19/10/2017.
 */

public class DetailActivity extends AppCompatActivity {
    // pour les propriétés graphiques sont toujours en private
    // le nom de la variable commence par le type de l'objet
    // puis on décrit à quoi il sert
    private Button buttonHeartRate;
    private Button buttonDeviceName;
    private TextView textViewHeartRate;
    private TextView textViewDeviceName;

    private BLEManager bleManager;

    /*
    Il est conseillé d'utiliser toujours le même ordre pour l'écriture des méthodes dans une clsse
    Particulierement dans les fragments & activité. Ici :

    Méthodes du cycle de vie
    Méthodes d'override d'hériatge
    Méthode publiques
    Méthodes privées
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // découpage de l'initialisation en méthodes
        initViews();
        initializeInjection();
    }

    private void requestHeartRate(){
        int heartRate = bleManager.getHeartRate();
        if(heartRate < 0){
            textViewHeartRate.setText(getString(R.string.heartrate_below_zero));
        }else{
            textViewHeartRate.setText(String.valueOf(heartRate));
        }
    }

    private void getDeviceName(){
        String deviceName = bleManager.getDeviceName();
        if (deviceName != null && !deviceName.isEmpty()){
            textViewDeviceName.setText(deviceName);
        }else{
            textViewDeviceName.setText(getString(R.string.connexion_status_none));
        }
    }

    private void initViews(){
        buttonHeartRate = (Button)findViewById(R.id.detail_button_rate);
        buttonHeartRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestHeartRate();
            }
        });
        textViewHeartRate = (TextView)findViewById(R.id.detail_textview_rate);

        buttonDeviceName = (Button)findViewById(R.id.detail_button_device_name);
        buttonDeviceName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDeviceName();
            }
        });
        textViewDeviceName =  (TextView)findViewById(R.id.detail_textviexw_device_name);
    }

    private void initializeInjection(){
        this.bleManager = IEMApplication.application().getBleManager();
    }
}
