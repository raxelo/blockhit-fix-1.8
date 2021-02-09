package me.raxel.blockhitfix.listener;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.Plugin;

@RequiredArgsConstructor
public class PlayerListener implements Listener {

    private final Plugin plugin;

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            disableBlocking(event.getPlayer());
        }, 1);
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;

        Player player = (Player) event.getDamager();
        disableBlocking(player);
    }

    /**
     * Makes the target player stop blocking, or holding
     * click, whether it's a sword, a bow or food.
     *
     * @param player the player
     */
    private void disableBlocking(HumanEntity player) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        craftPlayer.getHandle().bU();
    }

}