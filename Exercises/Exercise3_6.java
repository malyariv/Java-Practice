import java.util.*;
import java.io.*;
import java.util.zip.*;

public class Exercise3_6{
   public static void CompressGZIP (String filename){
      try(FileInputStream in=new FileInputStream(filename); GZIPOutputStream out=new GZIPOutputStream (new FileOutputStream(filename+"Z.gz"))){
	byte[] buffer=new byte[4096];
	int bytes_read;
	while((bytes_read=in.read(buffer))!=-1){
	   out.write(buffer,0,bytes_read);
	}
      }catch (Exception e){e.printStackTrace();}

   }
//____________________________________________________________
   public static void UncompressGZIP (String zipfilename){
      String filename=zipfilename.substring(0,zipfilename.length()-3);
      try(FileOutputStream out=new FileOutputStream(filename); GZIPInputStream in=new GZIPInputStream (new FileInputStream(zipfilename))){
        byte[] buffer=new byte[4096];
        int bytes_read;
        while((bytes_read=in.read(buffer))!=-1){
           out.write(buffer,0,bytes_read);
        }
      }catch (Exception e){e.printStackTrace();}

   }


//_____________________________________________________________
   public static void main(String[] args){
      System.out.println("Введите название файла для архивирования (путь):");
      Scanner sc=new Scanner(System.in);
      String filename=sc.next();
      CompressGZIP(filename);
      UncompressGZIP(filename+"Z.gz");
   }



}
