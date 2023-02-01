package com.example.aftestallen;

import android.app.Application;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

public class MyApplication extends Application {

    private static final String DEV_KEY  = "REaW4oazBFH6zuBNihvAWE";
    private static final String LOG_TAG  = "Allentest";
    public void onCreate() {
        super.onCreate();
        AppsFlyerLib.getInstance().setDebugLog(true);
        AppsFlyerLib.getInstance().init(DEV_KEY, new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                Log.d(LOG_TAG, "onConversionDataSuccess");
            }

            @Override
            public void onConversionDataFail(String s) {
                Log.d(LOG_TAG, "onConversionDataFail"+s);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {
                Log.d(LOG_TAG, "onAppOpenAttribution");
            }

            @Override
            public void onAttributionFailure(String s) {
                Log.d(LOG_TAG, "onAttributionFailure"+s);
            }
        }, this);
        AppsFlyerLib.getInstance().setAppId("com.example.aftestallen");
        AppsFlyerLib.getInstance().start(this);
        AppsFlyerLib.getInstance().registerValidatorListener(this,new
                AppsFlyerInAppPurchaseValidatorListener() {
                    public void onValidateInApp() {
                        Log.d(LOG_TAG, "Purchase validated successfully");
                    }
                    public void onValidateInAppFailure(String error) {
                        Log.d(LOG_TAG, "onValidateInAppFailure called: " + error);
                    }
                });
    }
}
