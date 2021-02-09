package me.raxel.blockhitfix;

import me.raxel.blockhitfix.listener.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockhitFix extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerListener playerListener = new PlayerListener(this);
        getServer().getPluginManager().registerEvents(playerListener, this);
    }

}
