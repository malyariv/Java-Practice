import java.util.*;
import java.io.*;

public class Exercise3_4{
   public static void main(String[] args){
      String filename=null;
      Scanner sc=new Scanner(System.in);
      for(;;){
	System.out.print("Введите название интересующей папки: ");
	filename=sc.next();
	if (filename.equals("exit")) break;
	System.out.println("\nСуммарный размер всех файлов - "+vol(filename)+" байт");
      }
   }

   public static long vol(String filename){
      long total=0;
      File dir=new File(filename);
//	if (dir.isDirectory()) System.out.println("это папка!");
      String[] l=dir.list();
      for (String s:l) {
	File f=new File(filename+"/"+s);
	if (f.isFile()) {
	   System.out.println(s+"    "+f.length());
	   total+=f.length();
	}
	else total+=vol(f.getPath());
      }
      return total;
   }
}
