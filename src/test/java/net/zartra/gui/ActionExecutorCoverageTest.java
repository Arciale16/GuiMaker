package net.zartra.gui;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;
import static org.junit.Assert.*;
public class ActionExecutorCoverageTest {
 @Test public void everySelectableActionHasExecutorBranch() throws Exception {
  String source=new String(Files.readAllBytes(Paths.get("src/main/java/net/zartra/gui/ActionExecutor.java")), "UTF-8");
  for(MenuAction.Type type:MenuAction.Type.values()) assertTrue(type.name(), source.contains("\""+type.name()+"\""));
 }
}
