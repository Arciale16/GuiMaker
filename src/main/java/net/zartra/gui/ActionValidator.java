package net.zartra.gui;
final class ActionValidator { private ActionValidator(){} static boolean serverName(String s){return s!=null&&s.matches("[A-Za-z0-9_-]{1,48}");} static boolean chance(double n){return n>=0D&&n<=100D&&!Double.isNaN(n);} static boolean delay(long n){return n>=0&&n<=72000;} }
