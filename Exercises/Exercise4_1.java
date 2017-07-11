import java.util.*;
import java.io.*;

public class Exercise4_1{
   public static void main(String[] args){
      long t=System.currentTimeMillis();
      for (String s:args) System.out.println("Файл "+s+" содержит "+lineCounter(s)+" строк");
/*      LineCounter[] lc=new LineCounter[args.length];
      int c=0;
      for (String s:args) {lc[c]=new LineCounter(s);c++;}
      try{
	for (c=0;c<args.length;c++) lc[c].t.join();
      }catch (Exception e) {e.printStackTrace();}*/
      System.out.println("Затраченное время "+(System.currentTimeMillis()-t)+" мс");
   }

   public static int lineCounter(String filename){
      int counter=0;
      try(Scanner sc=new Scanner(new FileReader(filename))){
        while (sc.hasNext()) {counter++;sc.nextLine();}
      }catch(IOException e) {e.printStackTrace();}
      return counter;
   }


   static class LineCounter implements Runnable{
      Thread t=null;
      private String filename=null;
      LineCounter(String filename){
        this.filename=filename;
	t=new Thread(this);
	t.start();
      }
      @Override
      public void run(){
	System.out.println("Файл "+filename+" содержит "+lineCounter(filename)+" строк");
     }
   }
}
