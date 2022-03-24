package com.example.kawach;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

@RequiresApi(api = Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {
    private Context context;
    public FingerprintHandler(Context context) {
        this.context=context;
    }
    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){
        CancellationSignal cancellationSignal=new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject,cancellationSignal,0,this,null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {

        this.update("There was an auth error " +errString,false);
    }

    @Override
    public void onAuthenticationFailed() {

        this.update("Auth failed!",false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Error: "+helpString,false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("You can now access the fingerprint in app",true);
    }

    private void update(String s, boolean b) {
        TextView paralabel=(TextView)((Activity)context).findViewById(R.id.paralabel);
        ImageView fingerimage=(ImageView) ((Activity)context).findViewById(R.id.fingerprintimg);

     paralabel.setText(s);
     if(b==false){
         paralabel.setTextColor(ContextCompat.getColor(context, R.color.applock__create_choose_option_bg));

     }
     else
     {
         paralabel.setTextColor(ContextCompat.getColor(context, androidx.navigation.ui.R.color.design_default_color_primary));
         fingerimage.setImageResource(R.mipmap.action_done);
     }
    }
}
