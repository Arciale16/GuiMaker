package net.zartra.gui;
import java.io.File;
import java.util.Map;
import java.util.logging.Logger;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
import static org.junit.Assert.*;
public class MenuStorageActionTest {
 @Test public void orderedActionsRoundTrip() throws Exception {
  File dir=new File(System.getProperty("java.io.tmpdir"),"zgui-test-"+System.nanoTime());
  MenuStorage storage=new MenuStorage(dir,Logger.getLogger("test")); MenuDefinition menu=new MenuDefinition("test","Test",3);
  MenuItem item=new MenuItem(new ItemStack(Material.STONE),null);
  for(MenuClickType type:MenuClickType.values()){ActionEntry a=new ActionEntry();a.type="MESSAGE";a.value=type.name();a.order=0;item.actions(type).add(a);} menu.items.put(10,item); storage.save(menu);
  Map<String,MenuDefinition> loaded=storage.load(); MenuItem restored=loaded.get("test").items.get(10);
  for(MenuClickType type:MenuClickType.values())assertEquals(type.name(),restored.actions(type).get(0).value);
 }
}
