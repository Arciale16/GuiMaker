package net.zartra.gui;
import org.bukkit.entity.Player; import java.util.*;
public final class ChatInputManager { public interface Callback{void accept(Player p,String text);} private final Map<UUID,Session> sessions=new HashMap<UUID,Session>(); private final long timeout;
 public ChatInputManager(long seconds){timeout=seconds*1000L;} public void begin(Player p,Callback cb){sessions.put(p.getUniqueId(),new Session(System.currentTimeMillis(),cb));p.sendMessage(Chat.color("&eType your value in chat, or &ccancel&e."));}
 public boolean handle(Player p,String text){Session s=sessions.remove(p.getUniqueId());if(s==null)return false;if(System.currentTimeMillis()-s.at>timeout){p.sendMessage(Chat.color("&cInput timed out."));return true;}if(text.equalsIgnoreCase("cancel")){p.sendMessage(Chat.color("&eCancelled."));return true;}s.cb.accept(p,text);return true;} public void remove(Player p){sessions.remove(p.getUniqueId());} public void clear(){sessions.clear();} private static final class Session{long at;Callback cb;Session(long a,Callback c){at=a;cb=c;}}
}
