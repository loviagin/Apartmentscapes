package com.louagin.apartmentscapes.activities;

import static com.louagin.apartmentscapes.auth.Credential.database;
import static com.louagin.apartmentscapes.auth.Credential.dbHelper;
import static com.louagin.apartmentscapes.auth.Credential.is_new;
import static com.louagin.apartmentscapes.auth.Credential.rooms;
import static com.louagin.apartmentscapes.auth.Credential.values;
import static com.louagin.apartmentscapes.services.DBHelper.ID_ROOM;
import static com.louagin.apartmentscapes.services.DBHelper.IS_OPEN;
import static com.louagin.apartmentscapes.services.DBHelper.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.louagin.apartmentscapes.R;
import com.louagin.apartmentscapes.auth.Credential;
import com.louagin.apartmentscapes.services.DBHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

//    private static final int RC_SIGN_IN = 543;
//    private GoogleSignInClient mGoogleSignInClient;
//    private GamesSignInClient gamesSignInClient;
//
//    private Intent signInIntent;
//    private String playerId;

    public MainActivity() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Вставка данных
        loadData(is_new, this);

//        else {
//            Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
//            if (cursor.moveToFirst()) {
//                int is_open = cursor.getColumnIndex(IS_OPEN);
//                rooms.set(0, cursor.getInt(is_open));
////                do {
//////                    Log.e(TAG, cursor.getString(name));
////                } while (cursor.moveToNext());
//            } else {
//                Log.d(TAG, "Error");
//            }
//            cursor.close();
//        }
        startActivity(new Intent(this, HomeActivity.class));
//        GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(this);
//
//        gamesSignInClient.isAuthenticated().addOnCompleteListener(isAuthenticatedTask -> {
//            boolean isAuthenticated =
//                    (isAuthenticatedTask.isSuccessful() &&
//                            isAuthenticatedTask.getResult().isAuthenticated());
//
//            if (isAuthenticated) {
//                // Continue with Play Games Services
//            } else {
////                GamesSignInClient.signIn();
//                PlayGames.getPlayersClient(this).getCurrentPlayer().addOnCompleteListener(mTask -> {
//                            playerId = mTask.getResult().getPlayerId();
//                        }
//                );
//                Log.d(TAG, playerId);
//            }
//        });
    }

    protected static void loadData(boolean isNew, Context context) {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        values = new ContentValues();
        if (isNew) {
            database.delete(TABLE_NAME, null, null);
            for (int f = 1; f <= 7; f++) {
                values.put(ID_ROOM, f);
                if (f == 1) {
                    values.put(IS_OPEN, 1);
                } else {
                    values.put(IS_OPEN, 0);
                }
                database.insert(DBHelper.TABLE_NAME, null, values);
            }
        }
    }
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
//                .requestServerAuthCode(getString(R.string.default_web_client_id))
//                .build();
//
//        gamesSignInClient = PlayGames.getGamesSignInClient(this);
//        Log.d(TAG, " starting");
//
////        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//
////        signIn();
//        gamesSignInClient.isAuthenticated().addOnCompleteListener(isAuthenticatedTask -> {
//            boolean isAuthenticated =
//                    (isAuthenticatedTask.isSuccessful() &&
//                            isAuthenticatedTask.getResult().isAuthenticated());
//
//            if (isAuthenticated) {
//                startActivity(new Intent(this, HomeActivity.class));
//                Log.d(TAG, " " + currentUser);
//                PlayGames.getPlayersClient(this).getCurrentPlayer().addOnCompleteListener(mTask -> {
//                            mTask.getResult().getPlayerId();
//                        }
//                );
//            } else {
//                final AuthenticationResult[] result = new AuthenticationResult[1];
//                gamesSignInClient.signIn().addOnSuccessListener(new OnSuccessListener<AuthenticationResult>() {
//                    @Override
//                    public void onSuccess(AuthenticationResult authenticationResult) {
//                        result[0] = authenticationResult;
//                        Log.d(TAG, result[0] + " -h");
//                        Credential.result = authenticationResult;
//                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                    }
//                });
//
////                if (result[0] != null) {
////                Toast.makeText(this, "Let's goo" + result[0].isAuthenticated(), Toast.LENGTH_LONG).show();
////                }
////                AuthenticationResult result = gamesSignInClient.signIn().addOnCompleteListener(authenticationResult -> Log.d(TAG, authenticationResult + " -p")).getResult();
//
////                Log.d(TAG, " -h");
////                        .addOnSuccessListener(new OnSuccessListener<AuthenticationResult>() {
////                    @Override
////                    public void onSuccess(AuthenticationResult authenticationResult) {
////                        Log.d(TAG, "sor- " + authenticationResult);
////                        Toast.makeText(MainActivity.this, "HELOOOOOOOOOOOOOOOOO BITCH", Toast.LENGTH_SHORT).show();
////                        currentUser = mAuth.getCurrentUser();
////                        Log.d(TAG, " b-" + currentUser);
////                        Log.d(TAG, " f-" + gso.getAccount());
//////                        firebaseAuthWithPlayGames();
////                    }
////                });
////                Toast.makeText(this, "I'm here", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
////    private void signIn() {
////        signInIntent = mGoogleSignInClient.getSignInIntent();
////        Log.d(TAG, signInIntent.getData() + " -g");
//////        startActivityForResult(signInIntent, RC_SIGN_IN);
////    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Result returned from launching the Intent from
////        GoogleSignInApi.getSignInIntent();
//        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK) {
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                GoogleSignInAccount account = task.getResult(ApiException.class);
//                firebaseAuthWithGoogle(account);
//            } catch (ApiException e) {
//                // Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e);
//            }
//        } else {
//            Log.i(TAG, " " + resultCode + " m" + data.getData());
////            Log.i(TAG, " " + resultCode + " m" + GoogleSignIn.getSignedInAccountFromIntent(data).getResult());
//        }
//
//    }
//
//    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
//        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
//
//        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithCredential:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
////                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            Toast.makeText(MainActivity.this, "Error r", Toast.LENGTH_SHORT).show();
////                            Snackbar.make(, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
////                            updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
//    }
//
//    //    @Override
////    public void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////
////        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
////        if (requestCode == RC_SIGN_IN) {
////            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
////            try {
////                // Google Sign In was successful, authenticate with Firebase
////                GoogleSignInAccount account = task.getResult(ApiException.class);
////                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
////                firebaseAuthWithGoogle(account.getIdToken());
////            } catch (ApiException e) {
////                // Google Sign In failed, update UI appropriately
////                Log.w(TAG, "Google sign in failed", e);
////            }
////        }
////    }
//    // Call this both in the silent sign-in task's OnCompleteListener and in the
//    // Activity's onActivityResult handler.
//    private void firebaseAuthWithPlayGames(GoogleSignInAccount acct) {
//        Log.d(TAG, "firebaseAuthWithPlayGames:" + acct.getId());
//
//        final FirebaseAuth auth = FirebaseAuth.getInstance();
////        AuthCredential credential = PlayGamesAuthProvider.getCredential(acct.getServerAuthCode());
////        auth.signInWithCredential(credential)
////                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
////                    @Override
////                    public void onComplete(@NonNull Task<AuthResult> task) {
////                        if (task.isSuccessful()) {
////                            // Sign in success, update UI with the signed-in user's information
////                            Log.d(TAG, "signInWithCredential:success");
////                            FirebaseUser user = auth.getCurrentUser();
////                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
////                        } else {
////                            // If sign in fails, display a message to the user.
////                            Log.w(TAG, "signInWithCredential:failure", task.getException());
////                            Toast.makeText(MainActivity.this, "Authentication failed.",
////                                    Toast.LENGTH_SHORT).show();
////                            // User sign in error
////                        }
////
////                        // ...
////                    }
////                });
//    }
}