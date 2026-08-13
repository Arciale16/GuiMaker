package net.zartra.gui;
import org.bukkit.Material;
final class CompatMaterial {
 private CompatMaterial() {}
 static Material find(String name){Material material=findOrNull(name);return material==null?Material.STONE:material;}
 static Material findOrNull(String name){if(name==null||name.trim().length()==0)return null;try{Material material=Material.matchMaterial(name.trim());if(material!=null)return material;}catch(Throwable ignored){}try{return Material.valueOf(name.trim().toUpperCase(java.util.Locale.ENGLISH));}catch(Throwable ignored){}if("PLAYER_HEAD".equalsIgnoreCase(name))return byName("SKULL_ITEM");if("SKULL_ITEM".equalsIgnoreCase(name))return byName("PLAYER_HEAD");if("RED_STAINED_GLASS_PANE".equalsIgnoreCase(name))return byName("STAINED_GLASS_PANE");if("STAINED_GLASS_PANE".equalsIgnoreCase(name))return byName("RED_STAINED_GLASS_PANE");return null;}
 private static Material byName(String name){try{return Material.valueOf(name);}catch(Throwable ignored){return null;}}
 static String name(Material material){return material==null?"":material.name();}
}