package org.example.iste_240_assignment.dataLayer;

import org.example.iste_240_assignment.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Optional<Player> findByUsername(String username);
    Optional<Player> findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    long deleteByUsername(String username);
    long deleteByEmail(String email);

    long countByEmail(String email);
    long countByUsername(String username);

    @Modifying
    @Query("UPDATE Player p SET p.password = :newPassword WHERE p.playerId = :id")
    int updatePlayerPassword(@Param("id") int id, @Param("newPassword") String newPassword);

    List<Player> findByUsernameContainingIgnoreCase(String username);
    List<Player> findByEmailContainingIgnoreCase(String email);

    List<Player> findByEmailEndingWith(String domain);
}