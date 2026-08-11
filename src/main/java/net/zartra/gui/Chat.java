package net.zartra.gui;
import org.bukkit.ChatColor;
final class Chat { private Chat() {} static String c(String value) { return ChatColor.translateAlternateColorCodes('&', value == null ? "" : value); } }
