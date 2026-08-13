package net.zartra.gui;
import static org.junit.Assert.*;
import org.junit.Test;
public class InventoryConfigurationCompatTest {
 @Test public void chestCapacityIsClampedToLegacySafeMultiples(){assertEquals(9,InventoryCompat.chestSlots(1));assertEquals(18,InventoryCompat.chestSlots(10));assertEquals(54,InventoryCompat.chestSlots(99));}
 @Test public void safeRuntimeTypesAreAdvertisedWithoutLosingUnknownIds(){assertTrue(InventoryCompat.supportedType("CHEST"));assertTrue(InventoryCompat.supportedType("HOPPER"));assertEquals("FUTURE",InventoryCompat.safeType("FUTURE"));}
 @Test public void worldPolicyIsDeterministic(){MenuDefinition d=new MenuDefinition("m","M",3);d.worldAccess=MenuDefinition.WorldAccess.WHITELIST;d.worlds.add("world");assertTrue(d.worldAllowed("world"));assertFalse(d.worldAllowed("nether"));d.worldAccess=MenuDefinition.WorldAccess.BLACKLIST;assertFalse(d.worldAllowed("world"));assertTrue(d.worldAllowed("nether"));}
}