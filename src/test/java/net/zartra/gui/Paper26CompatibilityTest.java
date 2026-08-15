package net.zartra.gui;
import static org.junit.Assert.*;import java.nio.file.*;import org.junit.Test;
public class Paper26CompatibilityTest {
 private String source(String name)throws Exception{return new String(Files.readAllBytes(Paths.get("src/main/java/net/zartra/gui/"+name)),"UTF-8");}
 @Test public void runtimeProbeUsesBukkitCommandRoutingOnlyWhenExplicitlyEnabled()throws Exception{String plugin=source("ZartraGUIPlugin.java");assertTrue(plugin.contains("Boolean.getBoolean(\"zartragui.runtime-probe\")"));assertTrue(plugin.contains("Bukkit.dispatchCommand(Bukkit.getConsoleSender(),\"zgui version\")"));assertTrue(plugin.contains("Bukkit.dispatchCommand(Bukkit.getConsoleSender(),\"zgui reload\")"));}
 @Test public void productionDoesNotAssumeOneDotVersionScheme()throws Exception{for(Path p:(Iterable<Path>)Files.walk(Paths.get("src/main/java")).filter(x->x.toString().endsWith(".java"))::iterator)assertFalse(p.toString(),new String(Files.readAllBytes(p),"UTF-8").contains("startsWith(\"1.\")"));}
}