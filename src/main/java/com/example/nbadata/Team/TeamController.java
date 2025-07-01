package com.example.nbadata.Team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/team")
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams(
            @RequestParam(required=false) String full_name,
            @RequestParam(required = false)String id,
            @RequestParam(required = false)String nickName,
            @RequestParam(required = false)String abbreviation,
            @RequestParam(required = false)String city,
            @RequestParam(required = false)String state,
            @RequestParam(required = false)String year_founded) {
        if(full_name != null){
            return teamService.getTeamByName(full_name);
        }
        if(nickName != null){
            return teamService.getTeamByNickname(nickName);
        }
        if(abbreviation != null){
            return teamService.getTeamByAbbreviation(abbreviation);
        }
        if(city != null){
            return teamService.getTeamByCity(city);
        }
        if(state != null){
            return teamService.getTeamByState(state);
        }
        return teamService.getTeams();
    }
//    @PostMapping
//    public ResponseEntity<Team> createTeam()
}
