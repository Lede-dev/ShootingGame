package com.molruexception.shootinggame;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShootingGame extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Register Command
        PluginCommand shootCommand = getCommand("shoot");
        if (shootCommand != null) {
            GameCommand command = new GameCommand();
            shootCommand.setExecutor(command);
            shootCommand.setTabCompleter(command);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
