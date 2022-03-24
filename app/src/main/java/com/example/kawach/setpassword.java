package com.example.kawach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class setpassword extends AppCompatActivity {
    private ImageView fingerprint;
    private  FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;
    private TextView paraLabel;
    AppCompatButton proccedbtn;
    private int numberofpasswordset=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpassword);
        try {
            paraLabel=findViewById(R.id.paralabel);
            fingerprint=(ImageView) findViewById(R.id.fingerprintimg);
            fingerprint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    fingerprint();
                }
            });
            proccedbtn=findViewById(R.id.proceed_btn);

        }catch (Exception e){
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_LONG).show();
        }

    }

    private void fingerprint() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            fingerprintManager= (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            keyguardManager=(KeyguardManager) getSystemService(KEYGUARD_SERVICE);
            if(!fingerprintManager.isHardwareDetected()){
                paraLabel.setText("Finger print Scanner not detected");
                //Toast.makeText(this,"Finger print Scanner not detected",Toast.LENGTH_SHORT).show();

            } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT)!= PackageManager.PERMISSION_GRANTED) {
                paraLabel.setText("Permission not granted to ise fingerprint in your device");
                //Toast.makeText(this,"Permission not granted to ise fingerprint in your device",Toast.LENGTH_SHORT).show();

            } else if (!keyguardManager.isKeyguardSecure()) {
                paraLabel.setText("Add lock  to your phone in settings");
                //Toast.makeText(this,"Add lock  to your phone in settings",Toast.LENGTH_SHORT).show();

            } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                paraLabel.setText("Add atleast 1 finger print to use this feature");
                //Toast.makeText(this,"Add atleast 1 finger print to use this feature",Toast.LENGTH_SHORT).show();

            }
            else{
               // Toast.makeText(this,"Place your Finger on Scanner to access fingerprint scanner",Toast.LENGTH_SHORT).show();
                paraLabel.setText("Place your Finger on Scanner to access fingerprint scanner");
                FingerprintHandler fingerprintHandler=new FingerprintHandler(this);
                fingerprintHandler.startAuth(fingerprintManager,null);
                proceed();
            }

        }

    }

    private void proceed() {
            proccedbtn.setBackgroundColor(getResources().getColor(R.color.green_proceed));
            proccedbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),MainActivity1.class));
                }
            });
        }

}