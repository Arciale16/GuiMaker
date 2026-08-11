package net.zartra.gui;
import java.util.*;
final class ConditionEntry {
 enum Type { HAS_PERMISSION, NOT_HAS_PERMISSION, HAS_MONEY, HAS_ITEM, HAS_EXACT_ITEM, HAS_LEVEL, MIN_LEVEL, MAX_LEVEL, IS_OP, IS_NOT_OP, GAMEMODE, WORLD, SERVER, PLAYER_NAME, PLACEHOLDER_EQUALS, PLACEHOLDER_CONTAINS, PLACEHOLDER_NUMBER, VARIABLE_EQUALS, COOLDOWN_READY, IS_SNEAKING, IS_FLYING, TIME_RANGE, CHANCE }
 String id=UUID.randomUUID().toString(); Type type; String value=""; int order; boolean enabled=true; boolean inverted; String failureMessage="";
 ConditionEntry(Type type,String value){this.type=type;this.value=value==null?"":value;}
 ConditionEntry copy(){ConditionEntry c=new ConditionEntry(type,value);c.id=id;c.order=order;c.enabled=enabled;c.inverted=inverted;c.failureMessage=failureMessage;return c;}
 ConditionEntry duplicate(){ConditionEntry c=copy();c.id=UUID.randomUUID().toString();return c;}
}