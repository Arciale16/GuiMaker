package net.zartra.gui;
import java.lang.reflect.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
/** Optional integrations; all provider types remain reflection-only. */
final class OptionalIntegrations {
 static boolean present(String name){try{return Bukkit.getPluginManager()!=null&&Bukkit.getPluginManager().getPlugin(name)!=null;}catch(LinkageError e){return false;}}
 static boolean multiverseTeleport(Player player,String world){if(player==null||world==null)return false;try{Object plugin=Bukkit.getPluginManager().getPlugin("Multiverse-Core");if(plugin==null)return false;Object manager=plugin.getClass().getMethod("getMVWorldManager").invoke(plugin);Object mv=manager.getClass().getMethod("getMVWorld",String.class).invoke(manager,world);if(mv==null)return false;Object bukkit=invokeFirst(mv,"getCBWorld","getWorld");return bukkit instanceof World&&player.teleport(((World)bukkit).getSpawnLocation());}catch(Throwable e){return false;}}
 static boolean giveHead(Player player,String id){if(player==null||id==null)return false;try{Class<?> api=Class.forName("me.arcaniax.hdb.api.HeadDatabaseAPI");Object service=api.newInstance();Object value=api.getMethod("getItemHead",String.class).invoke(service,id);if(!(value instanceof ItemStack))return false;Map<Integer,ItemStack> overflow=player.getInventory().addItem((ItemStack)value);return overflow.isEmpty();}catch(Throwable e){return false;}}
 static boolean points(Player player,int amount,boolean add){if(player==null||amount<0)return false;try{Object plugin=Bukkit.getPluginManager().getPlugin("PlayerPoints");if(plugin==null)return false;Object api=invokeFirst(plugin,"getAPI");if(api==null)return false;Method method=find(api.getClass(),add?"give":"take",UUID.class,int.class);if(method==null)return false;Object result=method.invoke(api,player.getUniqueId(),Integer.valueOf(amount));return !(result instanceof Boolean)||((Boolean)result).booleanValue();}catch(Throwable e){return false;}}
 static int points(Player player){if(player==null)return -1;try{Object plugin=Bukkit.getPluginManager().getPlugin("PlayerPoints");Object api=plugin==null?null:invokeFirst(plugin,"getAPI");Method method=api==null?null:find(api.getClass(),"look",UUID.class);Object result=method==null?null:method.invoke(api,player.getUniqueId());return result instanceof Number?((Number)result).intValue():-1;}catch(Throwable e){return -1;}}
 private static Object invokeFirst(Object target,String... names)throws Exception{for(String name:names)try{return target.getClass().getMethod(name).invoke(target);}catch(NoSuchMethodException ignored){}return null;}
 private static Method find(Class<?> type,String name,Class<?>... types){try{return type.getMethod(name,types);}catch(Exception e){return null;}}
}