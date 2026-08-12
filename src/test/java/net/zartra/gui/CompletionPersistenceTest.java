package net.zartra.gui;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompletionPersistenceTest {
 @Test public void menuAndItemConditionSetsRoundTripWithActions() throws Exception {
  File dir=new File(System.getProperty("java.io.tmpdir"),"zgui-complete-"+System.nanoTime());
  MenuStorage storage=new MenuStorage(dir,Logger.getLogger("test")); MenuDefinition menu=new MenuDefinition("complete","Complete",3);
  menu.formatVersion=3; menu.openConditions.failureMessage="&cclosed"; menu.openConditions.replacementMaterial="BARRIER";
  ConditionEntry open=new ConditionEntry(ConditionEntry.Type.HAS_PERMISSION,"zgui.open"); open.enabled=false; open.inverted=true; open.failureMessage="no"; menu.openConditions.entries.add(open);
  ActionEntry denied=new ActionEntry(); denied.type="MESSAGE"; denied.value="denied"; menu.openConditions.failureActions.add(denied);
  MenuItem item=new MenuItem(new ItemStack(Material.STONE),null); item.closeAfterAction=true; item.conditions.replacementMaterial="WOOL"; item.conditions.failureMessage="&cfail";
  ActionEntry success=new ActionEntry(); success.type="MESSAGE"; success.value="ok"; item.conditions.successActions.add(success); menu.items.put(0,item);
  storage.save(menu); MenuDefinition restored=storage.load().get("complete");
  assertEquals(3,restored.formatVersion); assertEquals("&cclosed",restored.openConditions.failureMessage); assertEquals("BARRIER",restored.openConditions.replacementMaterial); assertEquals(1,restored.openConditions.failureActions.size());
  assertFalse(restored.openConditions.entries.get(0).enabled); assertTrue(restored.openConditions.entries.get(0).inverted); assertTrue(restored.items.get(0).closeAfterAction); assertEquals("WOOL",restored.items.get(0).conditions.replacementMaterial); assertEquals("ok",restored.items.get(0).conditions.successActions.get(0).value);
 }
 @Test public void actionCopyKeepsConditionMetadata() {
  ActionEntry action=new ActionEntry(); ConditionEntry condition=new ConditionEntry(ConditionEntry.Type.HAS_LEVEL,"12"); condition.order=3; condition.enabled=false; condition.inverted=true; condition.failureMessage="bad"; action.conditions.add(condition);
  ActionEntry copy=action.copy(); assertEquals(condition.id,copy.conditions.get(0).id); assertEquals(3,copy.conditions.get(0).order); assertFalse(copy.conditions.get(0).enabled); assertTrue(copy.conditions.get(0).inverted); assertEquals("bad",copy.conditions.get(0).failureMessage);
 }
}