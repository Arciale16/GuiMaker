package net.zartra.gui;
import static org.junit.Assert.*;import org.junit.Test;
public class NavigationAliasInventoryTest {
 @Test public void unknownPersistedInventoryTypeIsPreservedForForwardCompatibility(){assertEquals("FUTURE_CONTAINER",InventoryCompat.safeType("future_container"));assertEquals(InventoryCompat.Capability.UNAVAILABLE_ON_VERSION,InventoryCompat.info("FUTURE_CONTAINER").capability);}
 @Test public void allRuntimeTypesAreClassifiedAndSelectableTypesHaveAdapters(){for(InventoryCompat.TypeInfo type:InventoryCompat.types()){assertNotNull(type.capability);if(InventoryCompat.supportedType(type.id))assertTrue(type.capability==InventoryCompat.Capability.AVAILABLE_CUSTOM_GUI||type.capability==InventoryCompat.Capability.AVAILABLE_SPECIAL_ADAPTER);}}
 @Test public void capacityRulesPreserveChestAndFixedLayouts(){MenuDefinition menu=new MenuDefinition("m","M",3);menu.inventoryType="CHEST";assertEquals(27,InventoryCompat.capacity(menu));menu.inventoryType="HOPPER";assertTrue(InventoryCompat.capacity(menu)>0);assertFalse(InventoryCompat.flexible("HOPPER"));}
 @Test public void commandTargetsRemainIndependentFromAliasPersistence(){MenuDefinition menu=new MenuDefinition("m","M",3);menu.commandAliases.add("shop");menu.commandTarget=MenuDefinition.CommandTarget.DISABLED;assertEquals("shop",menu.commandAliases.get(0));}
}