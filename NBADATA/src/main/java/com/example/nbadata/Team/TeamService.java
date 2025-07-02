package com.example.nbadata.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
    public List<Team> getTeamByName(String name) {
        return teamRepository.findAll().stream()
                .filter(Team->Team.getFullName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Team> getTeamByCity(String city) {
        return  teamRepository.findAll().stream()
                .filter(Team->Team.getCity().toLowerCase().contains(city.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Team> getTeamByState(String state) {
        return teamRepository.findAll().stream()
                .filter(Team->Team.getState().toLowerCase().contains(state.toLowerCase()))
                .collect(Collectors.toList());

    }
    public List<Team> getTeamByAbbreviation(String abbreviation) {
        return teamRepository.findAll().stream()
                .filter(Team->Team.getAbbreviation().toLowerCase().contains(abbreviation.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Team> getTeamByNickname(String nickName) {
        return  teamRepository.findAll().stream()
                .filter(Team->Team.getNickname().toLowerCase().contains(nickName.toLowerCase()))
                 .collect(Collectors.toList());
    }
}
