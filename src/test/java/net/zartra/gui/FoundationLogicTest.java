package net.zartra.gui;
import org.junit.Test;
import static org.junit.Assert.*;
public class FoundationLogicTest {
 @Test public void paginationProtectsEmptyMenus(){assertEquals(1,Pagination.pages(0,45));assertEquals(45,Pagination.offset(2,50,45));assertEquals(0,Pagination.offset(9,0,45));}
 @Test public void variablesAreScoped(){VariableStore store=new VariableStore();java.util.UUID first=java.util.UUID.randomUUID(),second=java.util.UUID.randomUUID();store.setGlobal("mode","on");store.setPlayer(first,"mode","personal");assertEquals("on",store.global("mode"));assertEquals("personal",store.player(first,"mode"));assertNull(store.player(second,"mode"));}
}
