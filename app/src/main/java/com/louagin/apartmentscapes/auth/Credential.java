package com.louagin.apartmentscapes.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Credential {
    public static String uId;
    public static String name;
    public static String email;

    public static FirebaseAuth mAuth;
    public static FirebaseUser currentUser;
    public static FirebaseFirestore db;
//    public static FirebaseStorage storage;

//    public static SharedPreferences preferences;

    public static void clear(){
        uId = null;
        name = null;
        email = null;

        db = FirebaseFirestore.getInstance();
//        storage = FirebaseStorage.getInstance();
    }
}
