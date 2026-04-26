package org.example.iste_240_assignment.service;

import jakarta.transaction.Transactional;
import org.example.iste_240_assignment.model.Game;
import org.example.iste_240_assignment.dataLayer.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GamesService {

    @Autowired
    GameRepository gameRepository;

    public Game saveGame(Game gameToSave){
        if(gameToSave.getName() == null || gameToSave.getName().isEmpty())
            throw new IllegalArgumentException("Name must not be empty");

        if(gameRepository.existsByName(gameToSave.getName()))
            throw new RuntimeException("Game already exists: " + gameToSave.getName());

        return gameRepository.save(gameToSave);
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Integer id){
        return gameRepository.findById(id);
    }

    public Optional<Game> getGameByName(String name){
        return gameRepository.findByName(name);
    }

    public List<Game> getGameBySubject(String subject) {
        return gameRepository.findBySubject(subject);
    }

    public List<Game> getGameByDifficulty(int difficulty){
        return gameRepository.findByDifficulty(difficulty);
    }

    public List<Game> getAvailableGames() {
        return gameRepository.findAvailableGames();
    }

    public int updateGameAvailability(int id, boolean status) {
        return gameRepository.updateGameAvailability(id, status);
    }

    public long getCountByAvailable(boolean available){
        return gameRepository.countByAvailable(available);
    }

    public void deleteGameById(Integer id){
        gameRepository.deleteById(id);
    }

    public long deleteGameByName(String name){
        return gameRepository.deleteByName(name);
    }

    public Game updateGame(Game gameToUpdate){
        Optional<Game> existingGame = gameRepository.findById(gameToUpdate.getId());

        if(existingGame.isEmpty()){
            throw new RuntimeException("GameID not found: " + gameToUpdate.getId());
        }
        Game game = existingGame.get();
        game.setName(gameToUpdate.getName());
        game.setSubject(gameToUpdate.getSubject());
        game.setTopic(gameToUpdate.getTopic());
        game.setDifficulty(gameToUpdate.getDifficulty());
        game.setLevels(gameToUpdate.getLevels());
        game.setRounds(gameToUpdate.getRounds());
        game.setMaxFails(gameToUpdate.getMaxFails());
        game.setAvailable(gameToUpdate.isAvailable());

        return gameRepository.save(game);

    }


}