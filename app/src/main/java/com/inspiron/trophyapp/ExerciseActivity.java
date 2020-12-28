package com.inspiron.trophyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.inspiron.trophyapp.R;

public class ExerciseActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;


    Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        radioGroup = findViewById(R.id.radioGroup);
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                startBtn = findViewById(R.id.startBtn);
                Intent intent = new Intent(ExerciseActivity.this, ActualActivity.class);
                intent.putExtra("SELECTED_WORKOUT", radioButton.getText());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

}
