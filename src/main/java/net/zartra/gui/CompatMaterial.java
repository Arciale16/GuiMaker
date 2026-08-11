package net.zartra.gui;
import org.bukkit.Material;
final class CompatMaterial {
 private CompatMaterial() {}
 static Material find(String name) {
  if (name == null) return Material.STONE;
  try { return Material.valueOf(name.toUpperCase()); } catch (IllegalArgumentException ignored) {}
  if ("PLAYER_HEAD".equalsIgnoreCase(name)) return byName("SKULL_ITEM");
  if ("SKULL_ITEM".equalsIgnoreCase(name)) return byName("PLAYER_HEAD");
  if ("RED_STAINED_GLASS_PANE".equalsIgnoreCase(name)) return byName("STAINED_GLASS_PANE");
  if ("STAINED_GLASS_PANE".equalsIgnoreCase(name)) return byName("RED_STAINED_GLASS_PANE");
  return Material.STONE;
 }
 private static Material byName(String name) { try { return Material.valueOf(name); } catch (IllegalArgumentException ignored) { return Material.STONE; } }
 static String name(Material material) { return material == null ? "STONE" : material.name(); }
}