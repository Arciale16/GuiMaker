package net.zartra.gui;
import java.util.*;
final class ConditionSet {
 enum Mode { AND, OR }
 Mode mode=Mode.AND; final List<ConditionEntry> entries=new ArrayList<ConditionEntry>(); boolean hideWhenFail; boolean disableClick=true; boolean stopChain=true; String failureMessage=""; String replacementMaterial=""; final List<ActionEntry> successActions=new ArrayList<ActionEntry>(); final List<ActionEntry> failureActions=new ArrayList<ActionEntry>();
 List<ConditionEntry> ordered(){Collections.sort(entries,new Comparator<ConditionEntry>(){public int compare(ConditionEntry a,ConditionEntry b){return a.order-b.order;}});return entries;}
 ConditionSet copy(){ConditionSet x=new ConditionSet();x.mode=mode;x.hideWhenFail=hideWhenFail;x.disableClick=disableClick;x.stopChain=stopChain;x.failureMessage=failureMessage;x.replacementMaterial=replacementMaterial;for(ConditionEntry c:entries)x.entries.add(c.copy());for(ActionEntry a:successActions)x.successActions.add(a.copy());for(ActionEntry a:failureActions)x.failureActions.add(a.copy());return x;}
}