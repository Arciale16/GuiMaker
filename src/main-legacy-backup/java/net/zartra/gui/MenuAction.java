package net.zartra.gui;

public final class MenuAction {
    public enum Type { PLAYER_COMMAND, CONSOLE_COMMAND, MESSAGE, OPEN_MENU, CLOSE }
    private final Type type; private final String value;
    public MenuAction(Type type, String value) { this.type=type; this.value=value==null?"":value; }
    public Type getType(){return type;} public String getValue(){return value;}
    public static MenuAction parse(String raw) {
        if(raw==null) return null; String[] p=raw.split(":",2);
        try { Type t=Type.valueOf(p[0].trim().toUpperCase()); return new MenuAction(t,p.length==2?p[1].trim():""); }
        catch(IllegalArgumentException e){return null;}
    }
    public String serialize(){return type.name()+(value.isEmpty()?"":": "+value);}
}
