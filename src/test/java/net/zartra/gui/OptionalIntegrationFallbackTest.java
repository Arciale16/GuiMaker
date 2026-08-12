package net.zartra.gui;
import static org.junit.Assert.*;
import org.junit.Test;
public class OptionalIntegrationFallbackTest {
 @Test public void persistedOptionalActionNamesParseWithoutOptionalJars(){assertEquals(MenuAction.Type.GIVE_HEAD,MenuAction.parse("GIVE_HEAD: 123").type);assertEquals(MenuAction.Type.GIVE_POINTS,MenuAction.parse("GIVE_POINTS: 5").type);assertEquals(MenuAction.Type.TELEPORT_MULTIVERSE,MenuAction.parse("TELEPORT_MULTIVERSE: lobby").type);}
 @Test public void commandTargetStatesRemainExplicit(){assertEquals(MenuDefinition.CommandTarget.OPTIONAL,MenuDefinition.CommandTarget.valueOf("OPTIONAL"));assertEquals(MenuDefinition.CommandTarget.REQUIRED,MenuDefinition.CommandTarget.valueOf("REQUIRED"));assertEquals(MenuDefinition.CommandTarget.DISABLED,MenuDefinition.CommandTarget.valueOf("DISABLED"));}
}