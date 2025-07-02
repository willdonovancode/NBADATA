package com.example.nbadata.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/player")
public class PlayerController {
    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String first_name,
        @RequestParam(required = false) String last_name) {
        if (name != null) {
            return playerService.getPlayerByName(name);
        }
        if (id != null) {
            return playerService.getPlayerById(id);
        }
        return playerService.getPlayer();
        }
        @PostMapping
        public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player created = playerService.addPLayer(player);
        return new  ResponseEntity<>(created, HttpStatus.CREATED);
        }
        @PutMapping
        public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updated= playerService.updatePLayer(player);
        if (updated != null) {
            return new  ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}
