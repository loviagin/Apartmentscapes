package com.louagin.apartmentscapes;

import static com.louagin.apartmentscapes.auth.Credential.currentUser;

import android.app.Application;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.louagin.apartmentscapes.auth.Credential;

public class App extends Application {

    private static final String TAG = "App_Application";

    @Override
    public void onCreate() {
        super.onCreate();

        Credential.mAuth = FirebaseAuth.getInstance();
        Log.d(TAG, "mAuth is set");
        Credential.db = FirebaseFirestore.getInstance();
        Log.d(TAG, "Db is set");
        currentUser = Credential.mAuth.getCurrentUser();
        Log.d(TAG, "CurrentUser is set" + currentUser);

//        Credential.storage = FirebaseStorage.getInstance();
//        Log.d(TAG, "Storage is set");

//        if (currentUser != null) {
//            uId = preferences.getString(UID0_FIELD, null);
//            Log.d(TAG, "idToken is " + uId);
//        }

        Log.i(TAG, "App_Application is finish working");
    }


}
