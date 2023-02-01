package com.example.aftestallen;
import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private  static final  String LOG_TAG ="allentest";

private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> eventValues = new HashMap<String, Object>();
                eventValues.put(AFInAppEventParameterName.PRICE, 1234.56);
                eventValues.put(AFInAppEventParameterName.CONTENT_ID,"1234567");

                AppsFlyerLib.getInstance().logEvent(getApplicationContext(),
                        AFInAppEventType.PURCHASE, eventValues, new AppsFlyerRequestListener() {
                            @Override
                            public void onSuccess() {
                                Log.d(LOG_TAG, "onSuccess     ");
                            }

                            @Override
                            public void onError(int i, String s) {
                                Log.d(LOG_TAG, "onError     "+s);
                            }
                        });
            }
        });
        // Used for the call to addCallback() within this snippet.
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//
//                    AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(MainActivity.this);
//                    String advertisingId = info.getId();
//
//                    Log.d(LOG_TAG, "advertisingId     "+advertisingId);
//                    //do sth with the id
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.d(LOG_TAG, "advertisingId     "+e.getLocalizedMessage());
//
//                }
//            }
//        }).start();


    }
}