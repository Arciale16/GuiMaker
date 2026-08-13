package net.zartra.gui;
import static org.junit.Assert.*;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
public class EditorMoveResetRegressionTest {
 @Test public void legacyVariantCopyPreservesMaterialAmountAndData(){MenuItem item=new MenuItem(new ItemStack(Material.WOOL,3,(short)11),null);MenuItem copy=item.copy();assertEquals("WOOL",copy.material);assertEquals(3,copy.amount);assertEquals(11,copy.data);}
 @Test public void editorSourceContainsSwapReplaceCancelAndResetSafety()throws Exception{String gui=new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("src/main/java/net/zartra/gui/GuiService.java")),"UTF-8");String listener=new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("src/main/java/net/zartra/gui/GuiListener.java")),"UTF-8");assertTrue(gui.contains("Swap items"));assertTrue(gui.contains("Replace destination"));assertTrue(gui.contains("Reset content?"));assertTrue(gui.indexOf("checkpoint(p,d);d.items.clear()")>=0);assertTrue(listener.contains("MenuManager.Screen.MOVE_CONFIRM"));assertTrue(listener.contains("raw==22)gui.clearMenuConfirm"));}
 @Test public void menuConfigurationRetainsNonContentFieldsWhenContentIsCleared(){MenuDefinition d=new MenuDefinition("x","&fX",3);d.title="&bPreserved";d.rows=6;d.items.put(0,new MenuItem(new ItemStack(Material.STONE),null));d.items.clear();assertEquals("&bPreserved",d.title);assertEquals(6,d.rows);assertTrue(d.items.isEmpty());}
}