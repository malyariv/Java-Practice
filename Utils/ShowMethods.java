import java.lang.reflect.*;
import java.util.*;

public class ShowMethods{
   public static void main(String[] args) throws Exception{
	System.out.println("Введите интересующий вас класс");
	Scanner sc=new Scanner(System.in);
	String className=sc.nextLine();
	Class c=Class.forName(className);
	for (Method m: c.getMethods()) System.out.println(m);
   }

}
