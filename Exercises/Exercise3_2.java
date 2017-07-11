import java.io.*;
import java.util.*;

public class Exercise3_2{
   public static void main(String[] args){
      String filename=null;
      Scanner sc=new Scanner(System.in);
      for(;;){
	 System.out.print("Введите название интересующего вас файла: ");
	 filename=sc.nextLine();
	 if (filename.equals("exit")) break;

	 int lineCounter=0;
	 try(Scanner fileScanner=new Scanner(new FileReader(filename))){
	    while(fileScanner.hasNext()) {
		fileScanner.nextLine();
		lineCounter++;
	    }
	 } catch(Exception e) {e.printStackTrace();}
	 System.out.println("Число строк в файле "+lineCounter);
	 try(Scanner fileScanner2=new Scanner(new FileReader(filename))){
	    if(lineCounter<10) for(;lineCounter>0;lineCounter--) System.out.println(fileScanner2.nextLine());
	    for(;lineCounter>10; lineCounter--) fileScanner2.nextLine();
	    for(;lineCounter>0; lineCounter--) System.out.println(fileScanner2.nextLine());
	 } catch(Exception e) {e.printStackTrace();}
      }
   }

}
