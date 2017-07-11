import java.util.*;

public class Exercise4_2{
   public static void main(String[] args){
      Timer timer=new Timer(false);
      timer.schedule(new Test(), 1000,500);
      try{Thread.sleep(5000);} catch(Exception e) {}
      timer.cancel();

   }

   static class Test extends TimerTask{
      public void run(){
	System.out.println("Ура!");
      }

   }

}
