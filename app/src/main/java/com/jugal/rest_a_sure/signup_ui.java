package com.jugal.rest_a_sure;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class signup_ui extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7117 ;  //ANY NUMBER YOU WANT
    List<AuthUI.IdpConfig> providers;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser fuser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__ui);


        //Init provider
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(), // Email Builder
                new AuthUI.IdpConfig.PhoneBuilder().build(), // Phone Builder

                new AuthUI.IdpConfig.GoogleBuilder().build() // Google Builder
        );

        showSignInOptions();

    }

    private void showSignInOptions() {

        AuthMethodPickerLayout customLayout = new AuthMethodPickerLayout
                .Builder(R.layout.activity_signup__ui)
                .setGoogleButtonId(R.id.google_button)
                .setEmailButtonId(R.id.email_b)
                .setPhoneButtonId(R.id.phone_b)
                .build();


        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setAuthMethodPickerLayout(customLayout)
                        .setTheme(R.style.Logintheme)
                        .build(),MY_REQUEST_CODE
        );
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                //Get User
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                //show email on toast
                Toast.makeText(this, "" + user.getEmail(), Toast.LENGTH_SHORT).show();


                final Intent succcess = new Intent(this, HomeActivity.class);
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(01);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            startActivity(succcess);
                            finish();
                        }
                    }
                };
                timer.start();

            }

        }
    }
}
