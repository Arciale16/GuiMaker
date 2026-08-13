package net.zartra.gui;
import java.util.*;
import org.bukkit.*;import org.bukkit.event.inventory.InventoryType;import org.bukkit.inventory.*;
/** Cached, legacy-safe inventory capability registry. Modern enum names are resolved only at runtime. */
final class InventoryCompat {
 enum Capability {AVAILABLE_CUSTOM_GUI,AVAILABLE_SPECIAL_ADAPTER,UNSAFE_OR_SERVER_MANAGED,UNAVAILABLE_ON_VERSION}
 static final class TypeInfo {final String id;final Capability capability;final int size;final String reason;TypeInfo(String id,Capability capability,int size,String reason){this.id=id;this.capability=capability;this.size=size;this.reason=reason;}}
 private static final Set<String> SAFE=new HashSet<String>(Arrays.asList("CHEST","DISPENSER","DROPPER","FURNACE","WORKBENCH","ENCHANTING","BREWING","HOPPER"));
 private InventoryCompat(){}
 static int chestSlots(int slots){if(slots<9)return 9;if(slots>54)return 54;return ((slots+8)/9)*9;}
 static List<TypeInfo> types(){List<TypeInfo> out=new ArrayList<TypeInfo>();for(InventoryType type:InventoryType.values()){String id=type.name();int size=type.getDefaultSize();if(SAFE.contains(id))out.add(new TypeInfo(id,"CHEST".equals(id)?Capability.AVAILABLE_CUSTOM_GUI:Capability.AVAILABLE_SPECIAL_ADAPTER,size,"Protected custom container"));else out.add(new TypeInfo(id,Capability.UNSAFE_OR_SERVER_MANAGED,size,"Server-managed container; native processing cannot be safely disabled"));}return out;}
 static TypeInfo info(String id){if(id!=null)for(TypeInfo info:types())if(info.id.equalsIgnoreCase(id))return info;return new TypeInfo(id==null?"CHEST":id,Capability.UNAVAILABLE_ON_VERSION,0,"Unknown on this server; using CHEST fallback without changing stored ID");}
 static boolean supportedType(String type){Capability c=info(type).capability;return c==Capability.AVAILABLE_CUSTOM_GUI||c==Capability.AVAILABLE_SPECIAL_ADAPTER;}
 static String safeType(String type){return type==null||type.trim().length()==0?"CHEST":type.toUpperCase(Locale.ENGLISH);}
 static boolean flexible(String type){return "CHEST".equalsIgnoreCase(type);}
 static int capacity(MenuDefinition menu){TypeInfo info=info(menu.inventoryType);return flexible(menu.inventoryType)?chestSlots(menu.rows*9):(info.size>0?info.size:chestSlots(menu.rows*9));}
 static Inventory create(MenuManager.Holder holder,MenuDefinition menu,String title){TypeInfo info=info(menu.inventoryType);try{if(info.capability==Capability.AVAILABLE_SPECIAL_ADAPTER){InventoryType type=InventoryType.valueOf(info.id);return Bukkit.createInventory(holder,type,title==null?"":title);}}catch(Throwable ignored){}return Bukkit.createInventory(holder,chestSlots(menu.rows*9),title==null?"":title);}
 static String title(String title){String raw=title==null?"":title;return raw.length()>32?raw.substring(0,32):raw;}
}