import java.io.*;
import java.util.zip.*;

public class Compress{
   public static void gzipFile(String from, String to) throws IOException{
      FileInputStream in=new FileInputStream(from);
      GZIPOutputStream out=new GZIPOutputStream(new FileOutputStream(to));
      byte[] buffer=new byte[4096];
      int bytes_read;
      while ((bytes_read=in.read(buffer))!=-1) out.write(buffer,0,bytes_read);
      in.close();
      out.close();
   }

   public static void zipFile(String from, String to) throws IOException{
      FileInputStream in=new FileInputStream(from);
      ZipOutputStream out=new ZipOutputStream(new FileOutputStream(to));
      ZipEntry entry = new ZipEntry(from);
      out.putNextEntry(entry);
      byte[] buffer=new byte[4096];
      int bytes_read;
      while ((bytes_read=in.read(buffer))!=-1) out.write(buffer,0,bytes_read);
      in.close();
      out.close();
   }


   public static void zipDirectory(String dir, String zipfile) throws IOException, IllegalArgumentException {
      File d = new File(dir);
      if (!d.isDirectory()) throw new IllegalArgumentException("Compress: не каталог:" + dir);
      String[] entries = d.list();
      byte[] buffer = new byte[4096];
      int bytes_read;
      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
      for(int i = 0; i < entries.length; i++) {
	File f = new File(d, entries[i]);
	if (f.isDirectory()) continue;
	FileInputStream in = new FileInputStream(f);
	ZipEntry entry = new ZipEntry(f.getPath());
	out.putNextEntry(entry);
	while((bytes_read = in.read(buffer)) != 1) out.write(buffer, 0, bytes_read);
	in.close();
      }
      out.close();
   }


   public static void main(String[] args){
      try{
	gzipFile("test.txt","test2.txt.gz");
	zipFile("test.txt","test2.zip");
      }catch(Exception e){e.printStackTrace();}
   }

}
