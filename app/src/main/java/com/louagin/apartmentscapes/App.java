package com.louagin.apartmentscapes;

import static com.louagin.apartmentscapes.auth.Credential.is_new;
import static com.louagin.apartmentscapes.auth.Credential.money;
import static com.louagin.apartmentscapes.auth.Credential.preferences;
import static com.louagin.apartmentscapes.auth.Credential.rooms;

import android.app.Application;
import android.preference.PreferenceManager;
import android.util.Log;

import com.louagin.apartmentscapes.auth.Credential;

import java.util.ArrayList;

public class App extends Application {
    private static final String TAG = "App_Application";
    @Override
    public void onCreate() {
        super.onCreate();

//        mAuth = FirebaseAuth.getInstance();
//        Log.d(TAG, "mAuth is set");
//        Credential.db = FirebaseFirestore.getInstance();
//        Log.d(TAG, "Db is set");
//        currentUser = mAuth.getCurrentUser();
//        Log.d(TAG, "CurrentUser is set" + currentUser);
        rooms = new ArrayList<>(7);
        Log.d(TAG, "Rooms is set");
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Log.d(TAG, "Preferences is set");
        if (preferences.getBoolean("is_new", true)){
            is_new = true;
        } else {
            money = preferences.getInt("money", 0);
        }
        Log.d(TAG, "is_new - " + is_new);

//        PlayGamesSdk.initialize(this);
//        Credential.storage = FirebaseStorage.getInstance();
//        Log.d(TAG, "Storage is set");

//        if (currentUser != null) {
//            uId = preferences.getString(UID0_FIELD, null);
//            Log.d(TAG, "idToken is " + uId);
//        }
        Log.i(TAG, "App_Application is finish working");
    }


}
