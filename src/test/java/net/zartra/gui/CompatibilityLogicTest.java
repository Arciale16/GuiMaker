package net.zartra.gui;
import org.junit.Test;
import static org.junit.Assert.*;
public class CompatibilityLogicTest {
 @Test public void safeIdsRejectTraversal(){assertTrue(MenuManager.validId("server_selector-2"));assertFalse(MenuManager.validId("../menu"));assertFalse(MenuManager.validId("menu/name"));assertFalse(MenuManager.validId("menu\\name"));assertFalse(MenuManager.validId("UPPER"));}
 @Test public void rowsAreBounded(){assertEquals(1,MenuDefinition.validRows(0));assertEquals(6,MenuDefinition.validRows(7));assertEquals(3,MenuDefinition.validRows(3));}
 @Test public void actionsAreStrict(){assertEquals(MenuAction.Type.MESSAGE,MenuAction.parse("MESSAGE: hello").type);assertEquals(MenuAction.Type.CLOSE_MENU,MenuAction.parse("CLOSE").type);assertNull(MenuAction.parse("INVALID: value"));}
 @Test public void materialFallbackIsSafe(){assertNotNull(CompatMaterial.find("STONE"));assertNotNull(CompatMaterial.find("PLAYER_HEAD"));assertNotNull(CompatMaterial.find("made_up_material"));}
}
