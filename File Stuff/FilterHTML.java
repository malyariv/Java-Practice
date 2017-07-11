import java.io.*;
import java.util.*;

public class FilterHTML{
   public static void main(String[] args){
      Scanner scanner=new Scanner(System.in);
      System.out.print("Введите название файла: ");
      String filename=scanner.next();
      filter(filename);
   }

   public static void filter(String filename){
      boolean intag=false;
      try(Scanner sc=new Scanner(new FileReader(filename))){
	while(sc.hasNext()){
	   String[] str=sc.nextLine().split(" ");
	   for (String s:str) {
	      if ((s.startsWith("<"))&&(s.endsWith(">"))) continue;
	      if (s.startsWith("<")) intag=true;
	      if (!intag) System.out.print(s+" ");
	      if (s.endsWith(">")) intag=false;
	   }
           if (!str[str.length-1].endsWith(">")) System.out.println();
	}
      }catch(Exception e){e.printStackTrace();}
   }
}
