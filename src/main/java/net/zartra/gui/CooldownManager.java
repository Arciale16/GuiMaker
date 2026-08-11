package net.zartra.gui;
import java.util.*;
final class CooldownManager { private final Map<String,Long> seen=new HashMap<String,Long>(); synchronized boolean ready(UUID player,String key,long ticks){if(ticks<=0)return true;String id=player.toString()+":"+key;long now=System.currentTimeMillis(),until=seen.containsKey(id)?seen.get(id):0;if(now<until)return false;seen.put(id,now+ticks*50L);return true;} }
