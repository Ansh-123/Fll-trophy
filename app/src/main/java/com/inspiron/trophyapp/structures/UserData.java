package com.inspiron.trophyapp.structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserData implements Serializable {
    private String id;
    private int todayXp;
    private int lifetimeXp;
    private int todayUpdatedDate;

    private Map<String, NameAndAmount> lifeTimeExerciseStats = new HashMap<>();
    private Map<String, NameAndAmount> todaysExerciseStats = new HashMap<>();

    private Map<String, NameAndAmount> lifeTimeWorkoutStats = new HashMap<>();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Map<String, NameAndAmount> getLifeTimeExerciseStats() {
        return lifeTimeExerciseStats;
    }

    public void setLifeTimeExerciseStats(Map<String, NameAndAmount> lifeTimeExerciseStats) {
        this.lifeTimeExerciseStats = lifeTimeExerciseStats;
    }

    public void setTodaysExerciseStats(Map<String, NameAndAmount> todaysExerciseStats) {
        this.todaysExerciseStats = todaysExerciseStats;
    }

    public Map<String, NameAndAmount> getTodaysExerciseStats() {
        return todaysExerciseStats;
    }

    public void addOrUpdateTodaysExerciseStats(String exercise, int value) {
        if (todaysExerciseStats.containsKey(exercise)) {
            NameAndAmount nameAndAmount = todaysExerciseStats.get(exercise);
            nameAndAmount.setAmount(nameAndAmount.getAmount() + value);
            todaysExerciseStats.put(exercise, nameAndAmount);
        }
        else {
            NameAndAmount nameAndAmount = new NameAndAmount();
            nameAndAmount.setName(exercise);
            nameAndAmount.setAmount(value);
            todaysExerciseStats.put(exercise, nameAndAmount);
        }
    }

    public void addOrUpdateLifeTimeExerciseStats(String exercise, int value) {
        if (lifeTimeExerciseStats.containsKey(exercise)) {
            NameAndAmount nameAndAmount = lifeTimeExerciseStats.get(exercise);
            nameAndAmount.setAmount(nameAndAmount.getAmount() + value);
            lifeTimeExerciseStats.put(exercise, nameAndAmount);
        }
        else {
            NameAndAmount nameAndAmount = new NameAndAmount();
            nameAndAmount.setName(exercise);
            nameAndAmount.setAmount(value);
            lifeTimeExerciseStats.put(exercise, nameAndAmount);
        }
    }

    public int getTodayXp() {
        return todayXp;
    }

    public void setTodayXp(int todayXp) {
        this.todayXp = todayXp;
    }

    public int getLifetimeXp() {
        return lifetimeXp;
    }

    public void setLifetimeXp(int lifetimeXp) {
        this.lifetimeXp = lifetimeXp;
    }

    public int getTodayUpdatedDate() {
        return todayUpdatedDate;
    }

    public void setTodayUpdatedDate(int todayUpdatedDate) {
        this.todayUpdatedDate = todayUpdatedDate;
    }

    public Map<String, NameAndAmount> getLifeTimeWorkoutStats() {
        return lifeTimeWorkoutStats;
    }

    public void setLifeTimeWorkoutStats(Map<String, NameAndAmount> lifeTimeWorkoutStats) {
        this.lifeTimeWorkoutStats = lifeTimeWorkoutStats;
    }

    public void addOrUpdateLifeTimeWorkoutStats(String exercise, int value) {
        if (lifeTimeWorkoutStats.containsKey(exercise)) {
            NameAndAmount nameAndAmount = lifeTimeWorkoutStats.get(exercise);
            nameAndAmount.setAmount(nameAndAmount.getAmount() + value);
            lifeTimeWorkoutStats.put(exercise, nameAndAmount);
        }
        else {
            NameAndAmount nameAndAmount = new NameAndAmount();
            nameAndAmount.setName(exercise);
            nameAndAmount.setAmount(value);
            lifeTimeWorkoutStats.put(exercise, nameAndAmount);
        }
    }

}
