package me.indian.wymiana;

import me.indian.wymiana.command.WymianaCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Wymiana extends JavaPlugin {

    private static Wymiana instance;

    public static Wymiana getInstance(){
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
       final PluginManager pm = this.getServer().getPluginManager();
       this.getCommand("wymiana").setExecutor(new WymianaCommand(this));



    }
}
