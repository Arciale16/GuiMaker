package net.zartra.gui;
import java.util.*;
/** Deterministic, Java-8-safe colour math used by the chat picker. */
final class ChatColorPalette {
 private ChatColorPalette(){}
 static int clamp(int v){return v<0?0:v>255?255:v;}
 static int[] hsv(float h,float s,float v){h=((h%360)+360)%360;s=Math.max(0,Math.min(1,s));v=Math.max(0,Math.min(1,v));float c=v*s,x=c*(1-Math.abs((h/60)%2-1)),m=v-c;float r=0,g=0,b=0;if(h<60){r=c;g=x;}else if(h<120){r=x;g=c;}else if(h<180){g=c;b=x;}else if(h<240){g=x;b=c;}else if(h<300){r=x;b=c;}else{r=c;b=x;}return new int[]{clamp(Math.round((r+m)*255)),clamp(Math.round((g+m)*255)),clamp(Math.round((b+m)*255))};}
 static String rgb(int[] c){return clamp(c[0])+","+clamp(c[1])+","+clamp(c[2]);}
 static String hex(int[] c){return String.format("#%02X%02X%02X",clamp(c[0]),clamp(c[1]),clamp(c[2]));}
 static int[][] hues(){int[][] out=new int[30][];for(int i=0;i<30;i++)out[i]=hsv(i*360f/30f,1,1);return out;}
 static int[][] shades(int hue){int[][] out=new int[64][];for(int row=0;row<8;row++)for(int col=0;col<8;col++){float saturation=col/7f;float value=.18f+(.82f*(7-row)/7f);out[row*8+col]=hsv(hue*12f,saturation,value);}return out;}
 static String legacy(int[] c){int[][] q={{0,0,0},{0,0,170},{0,170,0},{0,170,170},{170,0,0},{170,0,170},{255,170,0},{170,170,170},{85,85,85},{85,85,255},{85,255,85},{85,255,255},{255,85,85},{255,85,255},{255,255,85},{255,255,255}};String[] n={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};int best=0,dist=Integer.MAX_VALUE;for(int i=0;i<q.length;i++){int dr=c[0]-q[i][0],dg=c[1]-q[i][1],db=c[2]-q[i][2],d=dr*dr+dg*dg+db*db;if(d<dist){best=i;dist=d;}}return n[best];}
 static String hover(int[] c,String extra){return "HEX: "+hex(c)+"\nRGB: "+rgb(c)+"\n"+extra;}
}