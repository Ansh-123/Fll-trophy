package com.inspiron.trophyapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inspiron.trophyapp.structures.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.R.layout.simple_list_item_1;

public class ScorecardActivity extends AppCompatActivity {

    private GoogleSignInAccount account;
    private UserData userData;
    private List<String> todaysValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);
        userData = (UserData) getIntent().getSerializableExtra("USER");


        // We need to query user data

        // Display the data
        account = GoogleSignIn.getLastSignedInAccount(this);
        List<String> exercises = new ArrayList<String>();
        exercises.addAll(userData.getLifeTimeExerciseStats().keySet());
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                simple_list_item_1, exercises);
        ListView todaysList = (ListView) findViewById(R.id.scorecardId);
        todaysList.setAdapter(adapter);

    }


}
