import java.util.*;
import java.io.*;

public class Exercise3_3{
   public static void main(String[] args){
      String filename=null;
      Scanner sc=new Scanner(System.in);
      for(;;){
	System.out.print("Введите название интересующего файла: ");
	filename=sc.next();
	if (filename.equals("exit")) break;

	int lineCounter=0, wordCounter=0, symbolCounter=0;
	try(Scanner sf=new Scanner(new FileReader(filename))){
	  while(sf.hasNext()) {
	    String s=sf.nextLine();
            System.out.println(s);
	    symbolCounter+=s.length();
	    lineCounter++;
	  }
	}catch(Exception e){e.printStackTrace();}

        try(Scanner sf=new Scanner(new FileReader(filename))){
          while(sf.hasNext()) {
            sf.next();
            wordCounter++;
          }
        }catch(Exception e){e.printStackTrace();}

	System.out.println("Число строк - "+lineCounter+"\nЧисло слов - "+wordCounter+"\nЧисло символов - "+symbolCounter);

      }

   }

}
