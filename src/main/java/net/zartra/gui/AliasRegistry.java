package net.zartra.gui;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
/** Dynamic menu aliases isolated behind the stable Bukkit CommandMap API. */
final class AliasRegistry {
 private final ZartraGUIPlugin plugin; private final MenuManager menus; private final Map<String,Command> registered=new LinkedHashMap<String,Command>();
 AliasRegistry(ZartraGUIPlugin plugin,MenuManager menus){this.plugin=plugin;this.menus=menus;}
 synchronized void refresh(){clear(); CommandMap map=map(); if(map==null){plugin.getLogger().warning("Dynamic menu aliases are unavailable: server command map could not be resolved.");return;} Set<String> wanted=new LinkedHashSet<String>(); for(MenuDefinition menu:menus.all()){if(menu.commandTarget==MenuDefinition.CommandTarget.DISABLED)continue;for(String raw:menu.commandAliases){String alias=PlayerCommand.normalize(raw);if(alias==null||!alias.matches("[A-Za-z0-9_.-]{1,64}")){plugin.getLogger().warning("Ignoring invalid alias in "+menu.id+": "+raw);continue;}alias=alias.toLowerCase(Locale.ENGLISH);if(!wanted.add(alias)){plugin.getLogger().warning("Ignoring duplicate menu alias: /"+alias);continue;}Command prior=map.getCommand(alias);if(prior!=null){plugin.getLogger().warning("Alias /"+alias+" for "+menu.id+" conflicts with an existing command and was not registered.");continue;}Command command=new MenuAliasCommand(alias,menu.id);if(map.register(plugin.getDescription().getName().toLowerCase(Locale.ENGLISH),command))registered.put(alias,command);else plugin.getLogger().warning("Server rejected alias /"+alias+" for "+menu.id);}}}
 synchronized void clear(){CommandMap map=map();if(map!=null)for(Command command:registered.values())try{command.unregister(map);}catch(LinkageError e){plugin.getLogger().warning("Unable to unregister menu alias: "+e.getMessage());}registered.clear();}
 private CommandMap map(){try{java.lang.reflect.Method m=plugin.getServer().getClass().getMethod("getCommandMap");Object result=m.invoke(plugin.getServer());return result instanceof CommandMap?(CommandMap)result:null;}catch(Throwable ignored){}try{java.lang.reflect.Field f=plugin.getServer().getClass().getDeclaredField("commandMap");f.setAccessible(true);Object result=f.get(plugin.getServer());return result instanceof CommandMap?(CommandMap)result:null;}catch(Throwable ignored){return null;}}
 private final class MenuAliasCommand extends Command {
  private final String menuId; MenuAliasCommand(String alias,String menuId){super(alias);this.menuId=menuId;setDescription("Open ZartraGUI menu "+menuId);}
  public boolean execute(CommandSender sender,String label,String[] args){MenuDefinition menu=menus.get(menuId);if(menu==null){sender.sendMessage(Chat.c("&cThis menu no longer exists."));return true;}if(!(sender instanceof Player)){sender.sendMessage(Chat.c("&cThis menu command must be used by a player."));return true;}menus.open((Player)sender,menu);return true;}
  public List<String> tabComplete(CommandSender sender,String alias,String[] args){return Collections.emptyList();}
 }
}