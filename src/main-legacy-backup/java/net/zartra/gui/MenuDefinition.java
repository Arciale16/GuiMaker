package net.zartra.gui;
import java.util.*;
public final class MenuDefinition {
    private final String id; private String title; private int rows; private String openingCommand=""; private final Map<Integer,MenuItemDefinition> items=new HashMap<Integer,MenuItemDefinition>();
    public MenuDefinition(String id,String title,int rows){this.id=id;this.title=title;this.rows=validRows(rows);}
    public static int validRows(int r){return Math.max(1,Math.min(6,r));}
    public String id(){return id;} public String title(){return title;} public void title(String v){title=v;} public int rows(){return rows;} public void rows(int v){rows=validRows(v);} public String command(){return openingCommand;} public void command(String v){openingCommand=v==null?"":v;} public Map<Integer,MenuItemDefinition> items(){return items;}
}
