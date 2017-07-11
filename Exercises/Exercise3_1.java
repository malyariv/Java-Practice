import java.io.*;
import java.util.*;

public class Exercise3_1{
   public static void main(String[] args){
      String filename=null;
      Scanner sc=new Scanner(System.in);
      for(;;){
	 System.out.print("Введите название интересующего вас файла: ");
	 filename=sc.nextLine();
	 if (filename.equals("exit")) break;
	 try(Scanner fileScanner=new Scanner(new FileReader(filename))){
	    int lineCounter=0;
	    while((fileScanner.hasNext())&&(lineCounter<10)){
		System.out.println(fileScanner.nextLine());
		lineCounter++;
	    }
	 } catch(Exception e) {e.printStackTrace();}
      }
   }

}
