package com.rishav.gloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class ExerciseActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    TextView textView;
    private static final int RC_SIGN_IN = 1;
    Button startBtn;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startBtn = findViewById(R.id.startBtn);
                Intent intent = new Intent(ExerciseActivity.this, ActualActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
