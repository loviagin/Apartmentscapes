package com.louagin.apartmentscapes.auth;

import static com.louagin.apartmentscapes.activities.MainActivity.dbHelper;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.games.AuthenticationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.louagin.apartmentscapes.services.DBHelper;

import java.util.List;

public class Credential {
//    public static String uId;
//    public static String name;
//    public static String email;
//    public static FirebaseAuth mAuth;
//    public static FirebaseUser currentUser;
//    public static AuthenticationResult result;
//    public static FirebaseFirestore db;
//    public static FirebaseStorage storage;
    public static SharedPreferences preferences;
    public static boolean is_new;
    public static int money;
    public static List<Integer> rooms;

    public static void clear(){
//        uId = null;
//        name = null;
//        email = null;
//        preferences.edit().putInt("money", 1000).apply();
//        money = 1000;
//        rooms.set(0, 1);
//        for (int i = 1; i <=7; i++){
//            rooms.set(i, 0);
//        }
//
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        database.delete(DBHelper.TABLE_NAME, null, null);

//        db = FirebaseFirestore.getInstance();
//        storage = FirebaseStorage.getInstance();
    }
}
