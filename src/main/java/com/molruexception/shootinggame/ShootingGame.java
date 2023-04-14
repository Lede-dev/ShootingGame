package com.molruexception.shootinggame;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShootingGame extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register Command
        final PluginCommand shootCommand = getCommand("shoot");
        if (shootCommand != null) {
            GameCommand command = new GameCommand();
            shootCommand.setExecutor(command);
            shootCommand.setTabCompleter(command);
        }

        // Register Listener
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new GameListener(), this);
    }

}
