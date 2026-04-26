package org.example.iste_240_assignment.service;

import jakarta.transaction.Transactional;
import org.example.iste_240_assignment.dataLayer.GameRepository;
import org.example.iste_240_assignment.model.Game;
import org.example.iste_240_assignment.model.Rewards;
import org.example.iste_240_assignment.dataLayer.RewardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RewardsService {

    @Autowired
    RewardsRepository rewardsRepository;
    @Autowired
    private GameRepository gameRepository;

    public Rewards saveRewards(Rewards rewardsToSave){

        if(rewardsRepository.existsByPlayerId(rewardsToSave.getPlayerId()))
            throw new RuntimeException("Rewards already exist for player: " + rewardsToSave.getPlayerId());
        Game game = gameRepository.findById(rewardsToSave.getGameId())
                .orElseThrow( () -> new RuntimeException("Game not found"));

        boolean correct = true;
        int attempts = 0;
        rewardsToSave.addBonus(correct, attempts);
        rewardsToSave.addBadges(game, correct);

        return rewardsRepository.save(rewardsToSave);
    }

    public List<Rewards> getAllRewards(){
        return rewardsRepository.findAll();
    }

    public Optional<Rewards> getRewardsById(Integer id){
        return rewardsRepository.findById(id);
    }

    public Optional<Rewards> getRewardsByPlayerId(int playerId){
        return rewardsRepository.findByPlayerId(playerId);
    }

    public List<Rewards> getRewardsByGameId(int gameId){
        return rewardsRepository.findByGameId(gameId);
    }

    public List<Rewards> getRewardsByBadges(int badges){
        return rewardsRepository.findByBadges(badges);
    }

    public List<Rewards> getAwardedBadges(){
        return rewardsRepository.findAwardedBadges();
    }

    public int updateBonus(int id, int bonus){
        return rewardsRepository.updateBonus(id, bonus);
    }

    public long getCountByBadgeAwarded(boolean badgeAwarded){
        return rewardsRepository.countByBadgeAwarded(badgeAwarded);
    }

    public void deleteRewardsById(Integer id){
        rewardsRepository.deleteById(id);
    }

    public long deleteRewardsByPlayerId(int playerId){
        return rewardsRepository.deleteByPlayerId(playerId);
    }

    public Rewards updateRewards(Rewards rewardsToUpdate){

        Optional<Rewards> existingRewards = rewardsRepository.findById(rewardsToUpdate.getId());

        if(existingRewards.isEmpty()){
            throw new RuntimeException("RewardID not found: " + rewardsToUpdate.getId());
        }

        Rewards rewards = existingRewards.get();

        rewards.setPlayerId(rewardsToUpdate.getPlayerId());
        rewards.setGameId(rewardsToUpdate.getGameId());
        rewards.setBadges(rewardsToUpdate.getBadges());
        rewards.setBonus(rewardsToUpdate.getBonus());
        rewards.setMaxDifficulty(rewardsToUpdate.getMaxDifficulty());
        rewards.setBadgeAwarded(rewardsToUpdate.isBadgeAwarded());

        return rewardsRepository.save(rewards);
    }
}