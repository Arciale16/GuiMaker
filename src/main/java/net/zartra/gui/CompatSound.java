package net.zartra.gui;
import org.bukkit.*;import org.bukkit.entity.Player;
final class CompatSound {private CompatSound(){}static boolean play(Player p,String raw){if(p==null||raw==null||raw.trim().isEmpty())return true;try{p.playSound(p.getLocation(),Sound.valueOf(raw.trim().toUpperCase()),1F,1F);return true;}catch(Exception e){return false;}}}