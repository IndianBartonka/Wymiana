package me.indian.wymiana.util;

import org.bukkit.ChatColor;

public class ColorUtil {

    public static String replaceColorCode(String msg) {
        return ChatColor.translateAlternateColorCodes('&',msg);
    }

}
