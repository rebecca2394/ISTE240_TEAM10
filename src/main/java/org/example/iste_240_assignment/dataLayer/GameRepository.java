package org.example.iste_240_assignment.dataLayer;
import org.example.iste_240_assignment.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Optional<Game> findByName(String name);
    List<Game> findBySubject(String subject);
    List<Game> findByDifficulty(int difficulty);
    @Query("SELECT game FROM Game game WHERE game.available = true")
    List<Game> findAvailableGames();
    boolean existsByName(String name);
    long countByAvailable(boolean available);
    long deleteByName(String name);
    @Modifying
    @Query("UPDATE Game game SET game.available = :status WHERE game.gameId = :id")
    int updateGameAvailability(int id, boolean status);


}
