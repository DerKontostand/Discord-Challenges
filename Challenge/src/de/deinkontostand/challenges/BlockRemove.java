package de.deinkontostand.challenges;

import de.deinkontostand.listeners.SettingsListener;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class BlockRemove implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(SettingsListener.booleans.get(2)) {
            removeAllBlocksFromChunk(event.getBlockAgainst().getChunk(), event.getBlockAgainst().getType(), event.getBlock().getLocation(), event.getItemInHand());
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(SettingsListener.booleans.get(2)) {
            removeAllBlocksFromChunk(event.getBlock().getChunk(), event.getBlock().getType(), event.getBlock().getLocation(), event.getPlayer().getItemInHand());
        }
    }

    private void removeAllBlocksFromChunk(Chunk c, Material m, Location l, ItemStack item) {
        item.setDurability((short) (item.getDurability()-1));

        ArrayList<Collection<ItemStack>> collections = new ArrayList<>();

        if (m != Material.BEDROCK) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    for (int y = 0; y <= c.getWorld().getHighestBlockYAt(c.getBlock(x, 0, z).getLocation()); y++) {
                        if (m == c.getBlock(x, y, z).getType()) {
                            collections.add(c.getBlock(x, y, z).getDrops());
                            c.getBlock(x, y, z).setType(Material.AIR);
                        }
                    }
                }
            }
        }

        HashMap<Material, Integer> drops = new HashMap<>();

        collections.forEach(collection -> {
            collection.forEach(drop -> {
                if (drops.containsKey(drop.getType())) {
                    drops.put(drop.getType(), drops.get(drop.getType()) + drop.getAmount());
                } else {
                    drops.put(drop.getType(), drop.getAmount());
                }
            });
        });

        if (l.getWorld() != null) {
            drops.forEach((material, amount) -> l.getWorld().dropItem(l, new ItemStack(material, amount)));
        }
    }

}
