//import java.util.*;
import java.io.*;

public class Test{
   public static void main(String[] args){
      try(FileWriter fw=new FileWriter("output.txt", true)){
         for (int i=20; i<25; i++) fw.write("Hello "+i+"\n");
      }catch (Exception e){e.printStackTrace();}
   }

}
