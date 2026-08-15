package net.zartra.gui;
import static org.junit.Assert.*;import java.io.*;import java.nio.charset.*;import java.nio.file.*;import java.util.zip.*;import org.junit.Test;
public class ApiVersionPackagingTest {
 private String text(String file)throws Exception{return new String(Files.readAllBytes(Paths.get(file)),StandardCharsets.UTF_8);}
 private String descriptor(String jar)throws Exception{ZipFile zip=new ZipFile(jar);try{InputStream in=zip.getInputStream(zip.getEntry("plugin.yml"));ByteArrayOutputStream out=new ByteArrayOutputStream();byte[] b=new byte[1024];for(int n;(n=in.read(b))>=0;)out.write(b,0,n);return new String(out.toByteArray(),"UTF-8");}finally{zip.close();}}
 @Test public void sourceDescriptorDeclaresModernApi()throws Exception{assertTrue(text("src/main/resources/plugin.yml").contains("api-version: '1.13'"));}
 @Test public void targetArtifactDeclaresModernApi()throws Exception{assertTrue(descriptor("target/ZartraGUI.jar").contains("api-version: '1.13'"));}
 @Test public void distributionArtifactDeclaresModernApi()throws Exception{assertTrue(descriptor("dist/ZartraGUI.jar").contains("api-version: '1.13'"));}
}