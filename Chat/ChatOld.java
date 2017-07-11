import java.util.*;
import java.io.*;

class ChatOld{
   public static void main(String[] args){
   Conversation c=new Conversation();
   Bot b1=new Bot(c);   
   Bot b2=new Bot(c);
   Bot b3=new Bot(c);
   Scanner scanner=new Scanner(System.in);
   if (scanner.nextLine().equals("quit")) c.quit();

   try{
        b1.thrd.join();
        b2.thrd.join();
        b3.thrd.join();
     } catch(Exception e) {e.printStackTrace();}
   c.intoFile("Output.txt");
   System.out.println("Chat is over!");
   System.out.println("User "+b1.getName()+" wrote "+b1.getMsgCounter()+" messages");
   System.out.println("User "+b2.getName()+" wrote "+b1.getMsgCounter()+" messages");
   System.out.println("User "+b3.getName()+" wrote "+b1.getMsgCounter()+" messages");
  }
}

//____________________
class Bot implements Runnable{
  private static int counter=1;
  private final int id=counter++;
  private String name=Gen.wordGen(1).toUpperCase();
  Thread thrd;
  private Conversation conv;
  private int msgCounter=1; 

  Bot(Conversation c){
    conv=c;
    System.out.println(name + " in da house! (Thread "+id+" )\n");
    thrd=new Thread(this, name);
    thrd.start();
  }
  @Override
  public void run(){
    int lineCounter=-1;
    int delay;
    while ((msgCounter<100)&&(!conv.isOver())) {  
         if (lineCounter!=conv.last()) {
             String phrase=name+": "+conv.talk();
             conv.writeMsg(phrase);
             lineCounter=conv.last();
             msgCounter++;
             delay=(int) Math.round(Math.random()*5000);
             try{this.thrd.sleep(delay);}catch(Exception e) {e.printStackTrace();}
         }
    }
    } 
    public int getMsgCounter(){
       return msgCounter;}
   
    public String getName(){
       return name;}
}

//___________________________________________
class Conversation{
  private List<String> dialog=new ArrayList<>();
  private volatile boolean q=false;

  public void quit(){
     q=true;
  }

  public boolean isOver(){
     if (q) return q;
     return q;
  }

  public synchronized int last(){
     return dialog.size();
  }

   public String speaker(String s){
      String[] str=s.split(":");
      return str[0];
   }

   public String talk(){
      return Gen.phraseGen();
   }

   public synchronized void writeMsg(String phrase){
     System.out.println(phrase);
     dialog.add(phrase);
   }

   public void intoFile(String filename){
       try(FileWriter fw=new FileWriter(filename);){
          for (String s: dialog) fw.write(s+"\n"); 
       }catch(Exception e) {e.printStackTrace();}
   }

}

//_________________________________________________
class Gen{

  public static String wordGen(int j){
     Random rand=new Random();
     int length=rand.nextInt(7)+1;
     StringBuffer sb=new StringBuffer();
     for (int i=0; i<length;i++) 
        { int letter;
           if ((i==0)&&(j==1)) letter=rand.nextInt(26)+65;
           else letter=rand.nextInt(26)+97;
           char c=(char) letter;
           sb.append(c);
        }
     return sb.toString();
  }

  public static String phraseGen(){
     Random rand=new Random();
     int length=rand.nextInt(7)+1;
     StringBuffer sb=new StringBuffer();
     for (int i=1; i<=length;i++) {sb.append(wordGen(i)); sb.append(" ");}
     int dot=rand.nextInt(3)+1;
     String s=sb.toString().trim();
     switch (dot){
        case 1: s=s+"."; break;
        case 2: s=s+"?"; break;
        case 3: s=s+"!";
    }
     return s;
 }


}
