 package com.inspiron.trophyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.inspiron.trophyapp.R;
import com.inspiron.trophyapp.structures.Exercise;

import java.util.ArrayList;
import java.util.List;

 public class ActualActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private static final int RC_SIGN_IN = 1;
    List<Exercise> exercises = new ArrayList<>();
    int currentExercise = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual);
        selectExercise();

        Button nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentExercise++;
                if (currentExercise < exercises.size()) {
                    selectExercise();
                }
                else {
                    TextView exerciseName = findViewById(R.id.textView);
                    exerciseName.setText("");
                    TextView topText = findViewById(R.id.topText);
                    topText.setText("Congratulations!! You have complete full course!!");
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
        exerciseName.setText(selectedExercise.getName() +  " " +
                selectedExercise.getAmount() + " " + selectedExercise.getUnitOfMeasure());
    }
    private List<Exercise> populateExercises() {
        List<Exercise> returnVal = new ArrayList<>();
        for (int level = 1; level < 11; level++) {
            returnVal.add(createExercise("walk", 50*level, "steps"));
            returnVal.add(createExercise("run", 50*level, "steps"));
            returnVal.add(createExercise("Jumping Jacks", 10*level, "jumps"));
            returnVal.add(createExercise("Push ups", 2*level, "Push ups"));
            returnVal.add(createExercise("Jogging", 50*level, "Steps"));
            returnVal.add(createExercise("Squat", 5*level, "squats"));
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
