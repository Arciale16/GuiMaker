package net.zartra.gui;
import java.util.*;
final class ConditionRegistry {
 static final class Definition {final ConditionEntry.Type type;final String display,description;final boolean valueRequired,optional;Definition(ConditionEntry.Type t,String d,String x,boolean v,boolean o){type=t;display=d;description=x;valueRequired=v;optional=o;}}
 private final Map<ConditionEntry.Type,Definition> definitions=new EnumMap<ConditionEntry.Type,Definition>(ConditionEntry.Type.class);
 ConditionRegistry(){for(ConditionEntry.Type t:ConditionEntry.Type.values())register(t,t.name().replace('_',' '),description(t),needsValue(t),t==ConditionEntry.Type.HAS_MONEY);}
 private void register(ConditionEntry.Type t,String d,String x,boolean v,boolean o){definitions.put(t,new Definition(t,d,x,v,o));}
 Definition get(ConditionEntry.Type t){return definitions.get(t);}Collection<Definition> all(){return Collections.unmodifiableCollection(definitions.values());}
 boolean valid(ConditionEntry c){if(c==null||get(c.type)==null)return false;if(!get(c.type).valueRequired)return true;String v=c.value==null?"":c.value.trim();if(v.length()==0||v.length()>256)return false;if(c.type==ConditionEntry.Type.CHANCE)try{double n=Double.parseDouble(v);return ActionValidator.chance(n);}catch(Exception e){return false;}if(c.type==ConditionEntry.Type.TIME_RANGE)return v.matches("[0-9]{1,5}-[0-9]{1,5}");return true;}
 private static boolean needsValue(ConditionEntry.Type t){return t!=ConditionEntry.Type.IS_OP&&t!=ConditionEntry.Type.IS_NOT_OP&&t!=ConditionEntry.Type.IS_SNEAKING&&t!=ConditionEntry.Type.IS_FLYING&&t!=ConditionEntry.Type.COOLDOWN_READY;}
 private static String description(ConditionEntry.Type t){return "Condition: "+t.name().replace('_',' ').toLowerCase();}
}