package com.inspiron.trophyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inspiron.trophyapp.structures.Exercise;
import com.inspiron.trophyapp.structures.UserData;

import java.util.ArrayList;
import java.util.List;

public class ActualActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {


    private List<Exercise> exercises = new ArrayList<>();
    private int currentExercise = 0;
    private GoogleSignInAccount account;
    private DatabaseReference mDatabase;
    private UserData userData;
    private String selectedWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual);
        selectedWorkout = getIntent().getStringExtra("SELECTED_WORKOUT");
        userData = (UserData) getIntent().getSerializableExtra("USER");

        TextView topText = findViewById(R.id.topText);
        topText.setText("You selected " + selectedWorkout);

        selectExercise();

        Button nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Update user record to say user finished exercise
                userData.addOrUpdateLifeTimeExerciseStats(exercises.get(currentExercise).getName(), exercises.get(currentExercise).getAmount());
                userData.addOrUpdateTodaysExerciseStats(exercises.get(currentExercise).getName(), exercises.get(currentExercise).getAmount());
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("users").child(userData.getId()).setValue(userData);
                currentExercise++;
                if (currentExercise < exercises.size()) {
                    selectExercise();
                } else {
                    TextView exerciseName = findViewById(R.id.textView);
                    exerciseName.setText("");
                    TextView topText = findViewById(R.id.topText);
                    topText.setText("Congratulations!! You have completed the full course!!");
                    topText.setTextSize(30);
                }
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void selectExercise() {
        if (exercises.isEmpty()) {
            exercises = populateExercises();
        }
        Exercise selectedExercise = exercises.get(currentExercise);
        TextView exerciseName = findViewById(R.id.textView);
        exerciseName.setText(selectedExercise.getName() + " " +
                selectedExercise.getAmount() + " " + selectedExercise.getUnitOfMeasure());
    }

    private List<Exercise> populateExercises() {
        List<Exercise> returnVal = new ArrayList<>();
        for (int level = 1; level < 11; level++) {
            returnVal.add(createExercise("walk", 50 * level, "steps"));
            returnVal.add(createExercise("run", 50 * level, "steps"));
            returnVal.add(createExercise("Jumping Jacks", 10 * level, "jumps"));
            returnVal.add(createExercise("Push ups", 2 * level, "Push ups"));
            returnVal.add(createExercise("Jogging", 50 * level, "Steps"));
            returnVal.add(createExercise("Squat", 5 * level, "squats"));
        }
        return returnVal;
    }

    private Exercise createExercise(String name, double amount, String unitOfMeasure) {
        Exercise exercise = new Exercise();
        exercise.setName(name);
        exercise.setAmount(amount);
        exercise.setUnitOfMeasure(unitOfMeasure);
        return exercise;
    }
}
