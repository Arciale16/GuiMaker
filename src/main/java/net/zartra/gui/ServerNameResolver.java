package net.zartra.gui;
import java.lang.reflect.*;
final class ServerNameResolver {
 private static volatile String cached;private static volatile String configured;
 private ServerNameResolver(){}
 static String resolve(){String value=cached;if(value!=null)return value; synchronized(ServerNameResolver.class){if(cached!=null)return cached;cached=firstNonBlank(configured,System.getProperty("zartragui.server-name"),reflectServerName("getServerName"),reflectServerName("getName"),"server");return cached;}}
 static void configure(String value){configured=value;cached=null;}static void clearForTests(){cached=null;}
 private static String reflectServerName(String method){try{Class<?> bukkit=Class.forName("org.bukkit.Bukkit");Object server=bukkit.getMethod("getServer").invoke(null);if(server==null)return null;Object value=server.getClass().getMethod(method).invoke(server);return value==null?null:String.valueOf(value);}catch(Throwable ignored){return null;}}
 private static String firstNonBlank(String... values){for(String value:values)if(value!=null&&!value.trim().isEmpty())return value.trim();return "server";}
}