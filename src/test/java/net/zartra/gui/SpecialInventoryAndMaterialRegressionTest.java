package net.zartra.gui;
import static org.junit.Assert.*;import org.junit.Test;import org.bukkit.Material;import org.bukkit.inventory.ItemStack;
public class SpecialInventoryAndMaterialRegressionTest {
 @Test public void materialResolverDoesNotTreatUnknownAsStone(){assertNull(CompatMaterial.findOrNull("NOT_A_REAL_MATERIAL"));assertEquals(Material.STONE,CompatMaterial.find("NOT_A_REAL_MATERIAL"));}
 @Test public void menuItemCopyPreservesKnownMaterialAndRuntimeFields(){MenuItem item=new MenuItem(new ItemStack(Material.DIRT,7,(short)2),null);item.name="name";item.lore.add("one");item.customModelData=5;MenuItem copy=item.copy();assertEquals("DIRT",copy.material);assertEquals(7,copy.amount);assertEquals(2,copy.data);assertEquals("name",copy.name);assertEquals("one",copy.lore.get(0));assertEquals(5,copy.customModelData);}
 @Test public void specialLayoutsHaveRealAdapterClassification(){String[] ids={"HOPPER","DISPENSER","DROPPER","FURNACE","BREWING","WORKBENCH","ENCHANTING","ANVIL","SMITHING","BEACON"};for(String id:ids){InventoryCompat.TypeInfo type=InventoryCompat.info(id);if(type.capability!=InventoryCompat.Capability.UNAVAILABLE_ON_VERSION)assertTrue(InventoryCompat.supportedType(id));}}
 @Test public void builtinGuiCommandCannotBecomeDynamicAlias(){assertFalse("gui".matches("(?i)zgui|zartragui|guimaker"));assertEquals("gui","gui");}
}