package com.leaderboard.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leaderboard.backend.model.LeaderboardEntity;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderboardEntity, UUID> {
    List<LeaderboardEntity> findTop3ByOrderByPointsDesc();

    @Query(value = "SELECT * FROM students ORDER BY points DESC LIMIT :limit OFFSET :offset", nativeQuery = true)
    public List<LeaderboardEntity> getPlaces(@Param("offset") int offset, @Param("limit") int limit);

}
