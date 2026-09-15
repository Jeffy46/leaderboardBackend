package com.leaderboard.backend.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//example 
@Entity(name = "leaderboard")
public class LeaderboardEntity {
    @Id
    @JsonProperty("UUID")
    private UUID uuid;
    @Column(name = "name")
    @JsonProperty("name")
    private String name;
    @Column(name = "points")
    @JsonProperty("points")
    private double points;

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
