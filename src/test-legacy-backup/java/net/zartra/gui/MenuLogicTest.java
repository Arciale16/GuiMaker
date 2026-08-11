package net.zartra.gui;
import org.junit.Test;
import static org.junit.Assert.*;
public class MenuLogicTest {
 @Test public void idsAreSafe() { assertTrue(MenuManager.validId("server_selector-2")); assertFalse(MenuManager.validId("../bad")); assertFalse(MenuManager.validId("bad/name")); assertFalse(MenuManager.validId("bad\\name")); }
 @Test public void rowsClamp() { assertEquals(1, MenuDefinition.validRows(0)); assertEquals(6, MenuDefinition.validRows(7)); assertEquals(3, MenuDefinition.validRows(3)); }
 @Test public void actionParsing() { assertEquals(MenuAction.Type.MESSAGE, MenuAction.parse("MESSAGE: hi").getType()); assertNull(MenuAction.parse("NOPE: foo")); assertEquals(MenuAction.Type.CLOSE, MenuAction.parse("CLOSE").getType()); }
}
