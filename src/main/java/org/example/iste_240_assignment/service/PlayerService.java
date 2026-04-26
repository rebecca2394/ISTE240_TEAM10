package org.example.iste_240_assignment.service;

import jakarta.transaction.Transactional;
import org.example.iste_240_assignment.model.Player;
import org.example.iste_240_assignment.dataLayer.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player playerToSave) {
        if (playerToSave.getUsername() == null || playerToSave.getUsername().isEmpty())
            throw new IllegalArgumentException("Username must not be empty");
        if (playerToSave.getEmail() == null || playerToSave.getEmail().isEmpty())
            throw new IllegalArgumentException("Email must not be empty");

        if (playerRepository.findByUsername(playerToSave.getUsername()).isPresent())
            throw new RuntimeException("Player already exists with username: " + playerToSave.getUsername());
        if (playerRepository.findByEmail(playerToSave.getEmail()).isPresent())
            throw new RuntimeException("Player already exists with email: " + playerToSave.getEmail());

        return playerRepository.save(playerToSave);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    public Optional<Player> getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    public Optional<Player> getPlayerByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    public List<Player> searchByUsername(String username) {
        return playerRepository.findByUsernameContainingIgnoreCase(username);
    }

    public List<Player> searchByEmail(String email) {
        return playerRepository.findByEmailContainingIgnoreCase(email);
    }

    public Player updatePlayer(Player playerToUpdate) {
        Optional<Player> existingPlayer = playerRepository.findById(playerToUpdate.getId());
        if (existingPlayer.isEmpty()) {
            throw new RuntimeException("Player ID not found: " + playerToUpdate.getId());
        }
        Player player = existingPlayer.get();
        player.setUsername(playerToUpdate.getUsername());
        player.setEmail(playerToUpdate.getEmail());
        if (playerToUpdate.getPassword() != null && !playerToUpdate.getPassword().isEmpty()) {
            player.setPassword(playerToUpdate.getPassword());
        }
        return playerRepository.save(player);
    }

    public void deletePlayerById(Integer id) {
        playerRepository.deleteById(id);
    }

    public long deletePlayerByUsername(String username) {
        return playerRepository.deleteByUsername(username);
    }
}