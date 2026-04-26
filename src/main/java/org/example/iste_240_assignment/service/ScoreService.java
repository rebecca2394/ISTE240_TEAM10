package org.example.iste_240_assignment.service;

import jakarta.transaction.Transactional;
import org.example.iste_240_assignment.model.Score;
import org.example.iste_240_assignment.model.Player;
import org.example.iste_240_assignment.model.Game;
import org.example.iste_240_assignment.dataLayer.ScoreRepository;
import org.example.iste_240_assignment.dataLayer.PlayerRepository;
import org.example.iste_240_assignment.dataLayer.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    public Score saveScore(Score score) {

        int playerId = score.getPlayer().getId();
        int gameId = score.getGame().getId();

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));

        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found with id: " + gameId));

        score.setPlayer(player);
        score.setGame(game);

        return scoreRepository.save(score);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScoreById(int id) {
        return scoreRepository.findById(id);
    }

    public List<Score> getScoresByPlayer(int playerId) {
        return scoreRepository.findByPlayer_PlayerId(playerId);
    }

    public int updateScorePoints(int id, int points) {
        return scoreRepository.updatePointsById(id, points);
    }

    public void deleteScore(int id) {
        scoreRepository.deleteById(id);
    }
}