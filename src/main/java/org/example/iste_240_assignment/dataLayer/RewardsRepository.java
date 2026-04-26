package org.example.iste_240_assignment.dataLayer;

import org.example.iste_240_assignment.model.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RewardsRepository extends JpaRepository<Rewards, Integer> {

    Optional<Rewards> findByPlayerId(int playerId);

    List<Rewards> findByGameId(int gameId);

    List<Rewards> findByBadges(int badges);

    @Query("SELECT r FROM Rewards r WHERE r.badgeAwarded = true")
    List<Rewards> findAwardedBadges();

    boolean existsByPlayerId(int playerId);

    long countByBadgeAwarded(boolean badgeAwarded);

    long deleteByPlayerId(int playerId);

    @Modifying
    @Query("UPDATE Rewards r SET r.bonus = :bonus WHERE r.rewardId = :id")
    int updateBonus(int id, int bonus);

}