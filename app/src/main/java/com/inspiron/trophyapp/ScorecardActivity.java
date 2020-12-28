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
    private DatabaseReference mDatabase;
    private UserData userData;
    private List<String> todaysValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);

        // We need to query user data

        // Display the data
        account = GoogleSignIn.getLastSignedInAccount(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users");
        mDatabase.child(account.getId());
        mDatabase.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            userData = dataSnapshot.getValue(UserData.class);
                            todaysValues = new ArrayList<>();
                            for (Map.Entry<String, Double> exercise : userData.getTodaysExerciseStats().entrySet()) {
                                todaysValues.add(exercise.getKey() + ":" + exercise.getValue());
                            }
                            refreshList();
                        } else {
                            //Username does not exist, let's create a new record
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }

    public void refreshList() {
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                simple_list_item_1, todaysValues);
        ListView todaysList = (ListView) findViewById(R.id.scorecardId);
        todaysList.setAdapter(adapter);
    }

    }
