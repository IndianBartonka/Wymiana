package me.indian.wymiana.command;

import java.util.HashMap;
import java.util.Map;
import me.indian.wymiana.Wymiana;
import me.indian.wymiana.util.ColorUtil;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WymianaCommand implements CommandExecutor {

    private final Wymiana plugin;
    public static Map<Material, Material> blockMap = new HashMap<>();

    public WymianaCommand(Wymiana plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof final Player player) {

            Inventory inventory = player.getInventory();

            blockMap.put(Material.GOLD_INGOT, Material.GOLD_BLOCK);
            blockMap.put(Material.IRON_INGOT, Material.IRON_BLOCK);
            blockMap.put(Material.EMERALD, Material.EMERALD_BLOCK);
            blockMap.put(Material.DIAMOND, Material.DIAMOND_BLOCK);
            blockMap.put(Material.NETHERITE_SCRAP, Material.NETHERITE_BLOCK);


            for (int i = 0; i < 36; i++) {
                ItemStack item = inventory.getItem(i);
                if (item != null) {
                    Material material = item.getType();
                    if (blockMap.containsKey(material)) {
                        init(player, material, blockMap.get(material));
                    }
                }
            }
        } else {
            sender.sendMessage(ColorUtil.replaceColorCode("&4Musisz być graczem!"));
        }
        return false;
    }

    private void init(Player player, Material ore, Material block) {
        final Inventory inventory = player.getInventory();

        for (int i = 0; i < 36; i++) {
            ItemStack itemRemove = inventory.getItem(i);
            if (itemRemove != null) {
                if (itemRemove.getType() == ore && itemRemove.getAmount() >= 9) {
                    ItemStack item = player.getInventory().getItem(i);
                    item.setAmount(item.getAmount() - 9);
                    if (block != null) {
                        final ItemStack itemGive = new ItemStack(block);
                        inventory.addItem(itemGive);
                        player.sendMessage(getInventoryItemCount(inventory) + "");
                    }
                    break;
                }
            }
        }
    }

    private int getInventoryItemCount(Inventory inventory) {
        int slots = 0;

        for (int i = 0; i < 37; i++) {
            if (inventory.getItem(i) != null) {
                ++slots;
            }
        }
        return slots;
    }
}
