package com.molruexception.shootinggame;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class GameController {

    private static class GameControllerHolder {
        private static final GameController INSTANCE = new GameController();
    }

    public static GameController getInstance() {
        return GameControllerHolder.INSTANCE;
    }

    private boolean isPlaying = false;
    private Map<String, Integer> scores = Maps.newHashMap();

    private GameController() {}

    public void startGame() {
        if (!isPlaying) {
            isPlaying = true;
            scores = Maps.newHashMap();
        }
    }

    public void stopGame() {
        if (isPlaying) {
            isPlaying = false;
        }
    }

    public void setScore(@NotNull Player player, int score) {
        if (isPlaying) {
            final String uuid = player.getUniqueId().toString();
            scores.put(uuid, score);
        }
    }

    public int getScore(@NotNull Player player) {
        final String uuid = player.getUniqueId().toString();
        return scores.getOrDefault(uuid, 0);
    }

    public Map<String, Integer> getScores() {
        return Maps.newHashMap(scores);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

}
