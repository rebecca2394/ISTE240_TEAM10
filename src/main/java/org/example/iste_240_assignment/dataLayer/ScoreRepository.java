package org.example.iste_240_assignment.dataLayer;

import org.example.iste_240_assignment.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

    // Category: Find - Custom JPQL Query [cite: 131]
    @Query("SELECT s FROM Score s WHERE s.points > :minPoints")
    List<Score> findHighScores(int minPoints);

    List<Score> findByPlayer_PlayerId(int playerId);

    // Category: Update - Using @Modifying + @Query [cite: 131]
    @Modifying
    @Query("UPDATE Score s SET s.points = :newPoints WHERE s.scoreId = :id")
    int updatePointsById(int id, int newPoints);

    // Category: Delete [cite: 131]
    void deleteByScoreId(int id);
}