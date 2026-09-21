package com.leaderboard.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.leaderboard.backend.model.LeaderboardEntity;
import com.leaderboard.backend.service.LeaderboardService;

@RestController
@CrossOrigin(origins = "${allowedEndpoint}")
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/topThree")
    public List<LeaderboardEntity> topThree() {
        return leaderboardService.getTopThree();
    }

    @GetMapping("/{offset}/{limit}")
    public List<LeaderboardEntity> getPlaces(@PathVariable("offset") int offset, @PathVariable("limit") int limit) {
        return leaderboardService.getPlaces(offset, limit);
    }
}
