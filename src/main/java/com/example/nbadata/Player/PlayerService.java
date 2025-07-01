package com.example.nbadata.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//this clas is managed by spring container
@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayer (){
        return playerRepository.findAll();
    }
//    public List<Player> getPlayerFromTeam(String team) {
//        return playerRepository.findAll().stream()
//                .filter(player ->team.equals(player.getTeam()))
//                .collect(Collectors.toList())
//    }
    public List<Player> getPlayerByName(String search) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayerById(String id) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getId().contains(id))
                .collect(Collectors.toList());
    }
    public Player addPLayer(Player player){
        playerRepository.save(player);
        return player;
    }
    public Player updatePLayer(Player updated_player){
        Optional<Player> existingPlayer = playerRepository.findById(updated_player.getId());
        if (existingPlayer.isPresent()) {
            Player player_to_update = existingPlayer.get();
            player_to_update.setName(updated_player.getName());
            player_to_update.setId(updated_player.getId());
            player_to_update.setFirst_name(updated_player.getFirst_name());
            player_to_update.setLast_name(updated_player.getLast_name());
            playerRepository.save(player_to_update);
            return player_to_update;
        }
        return null;
    }

}
