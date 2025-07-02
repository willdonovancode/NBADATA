package com.example.nbadata.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="team")
public class Team {
    @Id
    @Column(name="id",unique = true)
    private String id;
    private String fullName;
    private String abbreviation;
    private String nickname;
    private String city;
    private String state;
    private String year_founded;

    public Team() {

    }

    public Team(String year_founded, String state, String city, String nickname, String abbreviation, String fullName, String id) {
        this.year_founded = year_founded;
        this.state = state;
        this.city = city;
        this.nickname = nickname;
        this.abbreviation = abbreviation;
        this.fullName = fullName;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYear_founded() {
        return year_founded;
    }

    public void setYear_founded(String year_founded) {
        this.year_founded = year_founded;
    }
}
