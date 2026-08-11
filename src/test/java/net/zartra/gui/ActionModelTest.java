package net.zartra.gui;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
import static org.junit.Assert.*;
public class ActionModelTest {
 @Test public void legacyActionMigratesToLeft(){MenuItem item=new MenuItem(new ItemStack(Material.STONE),MenuAction.parse("MESSAGE: hello"));item.migrateLegacy();assertNull(item.action);assertEquals(1,item.actions(MenuClickType.LEFT).size());assertEquals("MESSAGE",item.actions(MenuClickType.LEFT).get(0).type);}
 @Test public void actionsSortByStoredOrder(){MenuItem item=new MenuItem(new ItemStack(Material.STONE),null);ActionEntry second=new ActionEntry();second.order=2;ActionEntry first=new ActionEntry();first.order=0;item.actions(MenuClickType.RIGHT).add(second);item.actions(MenuClickType.RIGHT).add(first);assertSame(first,item.actions(MenuClickType.RIGHT).get(0));}
 @Test public void safetyValidationRejectsBadValues(){assertTrue(ActionValidator.chance(0));assertTrue(ActionValidator.chance(100));assertFalse(ActionValidator.chance(101));assertFalse(ActionValidator.serverName("lobby;stop"));assertTrue(ActionValidator.serverName("survival_2"));}
}
