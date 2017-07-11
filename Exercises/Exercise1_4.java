import java.util.*;
public class Exercise1_4{
   public static void main(String[] args){
	System.out.println("Начинайте вводить строки");
	Scanner sc=new Scanner (System.in);
	for(;;){
	   String s=sc.nextLine();
	   if (s.equals("tiuq")) break;
	   int length=s.length()-1;
	   for(int i=length; i>=0;i--) System.out.print(s.charAt(i));
	   System.out.println();
	}

   }
}
