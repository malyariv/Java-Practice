import java.util.*;
import java.io.*;

public class ScannerTest{
   public static void main(String[] args){
      try(Scanner sc=new Scanner(new FileInputStream("test.txt"))){
         while(sc.hasNext()) System.out.println(sc.next());
      }catch (Exception e){e.printStackTrace();}
   }

}
