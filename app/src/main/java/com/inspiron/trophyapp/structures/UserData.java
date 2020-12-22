package com.inspiron.trophyapp.structures;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private String id;
    private Map<String, Double> lifeTimeExerciseStats = new HashMap<>();
    private Map<String, Double> todaysExerciseStats = new HashMap<>();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Map<String, Double> getLifeTimeExerciseStats() {
        return lifeTimeExerciseStats;
    }

    public void setLifeTimeExerciseStats(Map<String, Double> lifeTimeExerciseStats) {
        this.lifeTimeExerciseStats = lifeTimeExerciseStats;
    }

    public void setTodaysExerciseStats(Map<String, Double> todaysExerciseStats) {
        this.todaysExerciseStats = todaysExerciseStats;
    }

    public Map<String, Double> getTodaysExerciseStats() {
        return todaysExerciseStats;
    }

    public void addOrUpdateTodaysExerciseStats(String exercise, double value) {
        if (todaysExerciseStats.containsKey(exercise)) {
            todaysExerciseStats.put(exercise, new Double(value + todaysExerciseStats.get(exercise)));
        }
        else {
            todaysExerciseStats.put(exercise, new Double(value));
        }
    }

    public void addOrUpdateLifeTimeExerciseStats(String exercise, double value) {
        if (lifeTimeExerciseStats.containsKey(exercise)) {
            lifeTimeExerciseStats.put(exercise, new Double(value + lifeTimeExerciseStats.get(exercise)));
        }
        else {
            lifeTimeExerciseStats.put(exercise, new Double(value));
        }
    }
}
