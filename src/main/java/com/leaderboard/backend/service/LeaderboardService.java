package com.leaderboard.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.leaderboard.backend.model.LeaderboardEntity;
import com.leaderboard.backend.repository.LeaderboardRepository;

import jakarta.transaction.Transactional;

@Service
public class LeaderboardService {
    private final LeaderboardRepository leaderboardRepository;

    public LeaderboardService(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    // returns top three
    public List<LeaderboardEntity> getTopThree() {
        return leaderboardRepository.findTop3ByOrderByPointsDesc();
    }

    // offset skips first offset places, limit returns limit amount of places after
    // the offset
    public List<LeaderboardEntity> getPlaces(int offset, int limit) {
        return leaderboardRepository.getPlaces(offset, limit);
    }

    // adds users/ updates points of users
    @Transactional
    public LeaderboardEntity save(LeaderboardEntity e) {
        Optional<LeaderboardEntity> optionalEntity = leaderboardRepository.findById(e.getUuid());

        if (optionalEntity.isPresent()) {
            LeaderboardEntity entity = optionalEntity.get(); // Now you have the raw Student
            entity.setPoints(entity.getPoints() + e.getPoints());
            return leaderboardRepository.save(entity);
        } else {
            return leaderboardRepository.save(e);
        }
    }

}
