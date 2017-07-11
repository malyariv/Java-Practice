import java.io.*;
import java.util.*;

public class Copy{
   public static void main(String[] args){
      String filename="test.txt";
      StringBuilder sb=new StringBuilder();


      try(Scanner sc=new Scanner(new FileReader(filename))){
	while(sc.hasNext()) {sb.append(sc.nextLine()); sb.append("\n");}
      }catch (Exception e) {System.err.println(e);}


      System.out.println(sb.toString());
      System.out.flush();



      try(FileWriter fw=new FileWriter("output.txt")){
	fw.write(sb.toString());
      }catch(Exception e) {e.printStackTrace();}
   }



}
