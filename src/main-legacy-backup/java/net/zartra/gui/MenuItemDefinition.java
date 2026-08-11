package net.zartra.gui;

import org.bukkit.Material; import org.bukkit.configuration.ConfigurationSection; import org.bukkit.inventory.ItemStack; import org.bukkit.inventory.meta.ItemMeta; import java.util.*;
public final class MenuItemDefinition {
    private final ItemStack item; private MenuAction action;
    public MenuItemDefinition(ItemStack item, MenuAction action){this.item=item.clone();this.action=action;}
    public ItemStack item(){return item.clone();} public MenuAction action(){return action;} public void action(MenuAction a){action=a;}
    public void save(ConfigurationSection s){s.set("item",item); if(action!=null)s.set("action",action.serialize());}
    public static MenuItemDefinition load(ConfigurationSection s){ItemStack i=s.getItemStack("item"); return i==null?null:new MenuItemDefinition(i,MenuAction.parse(s.getString("action")));}
    public static ItemStack named(Material m,String name){ItemStack i=new ItemStack(m); ItemMeta meta=i.getItemMeta();meta.setDisplayName(name);i.setItemMeta(meta);return i;}
}
