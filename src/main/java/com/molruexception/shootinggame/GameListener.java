package com.molruexception.shootinggame;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class GameListener implements Listener {

    private static final int ARROW_HIT_SCORE = 5;
    private static final int PLAYER_KILL_SCORE = 20;

    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        if (!(event.getHitEntity() instanceof Player)) {
            return;
        }

        if (!(event.getEntity() instanceof Arrow arrow)) {
            return;
        }

        if (!(arrow.getShooter() instanceof Player shooter)) {
            return;
        }

        final GameController controller = GameController.getInstance();
        final int score = controller.getScore(shooter) + ARROW_HIT_SCORE;
        controller.setScore(shooter, score);

        shooter.sendMessage(Component.text(String.format(
                "적을 공격하여 %d 포인트를 획득하였습니다. 현재 스코어: %d",
                ARROW_HIT_SCORE, score
        )));
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if (!(event.getEntity() instanceof Player victim)) {
            return;
        }

        final Player killer = victim.getKiller();
        if (killer != null) {
            final GameController controller = GameController.getInstance();
            final int score = controller.getScore(killer) + PLAYER_KILL_SCORE;
            controller.setScore(killer, score);

            killer.sendMessage(Component.text(String.format(
                    "적을 처치하여 %d 포인트를 획득하였습니다. 현재 스코어: %d",
                    PLAYER_KILL_SCORE, score
            )));
        }
    }

}
