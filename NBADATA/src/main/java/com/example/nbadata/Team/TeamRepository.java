package com.example.nbadata.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
    void deleteByfullName(String fullName);
    Optional<Team> findByfullName(String fullName);
}
