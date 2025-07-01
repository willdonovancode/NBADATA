package com.example.nbadata.Player;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="player")


public class Player {
    @Id
    @Column(name="id",unique = true)
    private String id;
    private String name;
    private String first_name;
    private String last_name;
    private boolean is_active;

    public Player() {}
    public Player(String id, String name, String first_name, String last_name, boolean active) {
        this.id = id;
        this.name   = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.is_active = active;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public boolean isActive() {
        return is_active;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setActive(boolean active) {
        this.is_active = active;
    }
}
