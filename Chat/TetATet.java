import java.util.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class TetATet{

   private static final Logger logger=Logger.getLogger(TetATet.class.getName());

   public static void main(String[] args){
     System.out.println("Server starts");
//     long time=System.currentTimeMillis();
     List<String> dialog=new ArrayList<>();
     Collections.synchronizedList(dialog);

     Map<String, String> logins=new HashMap<>();
     logins.put("Qwerty","qwerty");
     logins.put("Ivan", "ivan");
     logins.put("Marina", "marina");
     logins.put("Poiuyt", "poiuyt");

     final int maxCounter=2;
     Semaphore semaphore=new Semaphore(maxCounter);

     try(ServerSocket server=new ServerSocket(1234)){
	logger.setUseParentHandlers(false);
	Handler handler=new FileHandler("log.txt");
	handler.setFormatter(new SimpleFormatter());
	logger.addHandler(handler);
	logger.info("Server starts");
	while(true){
	   Socket socket=server.accept();
	   if (semaphore.availablePermits()==0) socket.close();
	   else new UserSocketIn(socket, dialog,logins, semaphore, logger);
//	   if((System.currentTimeMillis()-time)>30000) break;
	}
      }catch(Exception e){e.printStackTrace();System.out.println(1);}

      System.out.println("Server finishes");
      System.out.println(dialog);
   }
}
//________________________________________________________________________________
class UserSocketIn implements Runnable{
   Thread thr=null;
   private Socket socket=null;
   private List<String> dialog=null;
   private String name=null;
   private String password=null;
   private Map<String, String> logins;
   private Semaphore semaphore;
   private Logger logger;


   UserSocketIn(Socket socket, List<String> dialog, Map<String, String> logins, Semaphore semaphore, Logger logger){
      thr=new Thread(this);
      this.socket=socket;
      this.dialog=dialog;
      this.logins=logins;
      this.semaphore=semaphore;
      this.logger=logger;
      thr.start();
   }


   public void run(){
      try{
	semaphore.acquire();
         try(DataInputStream is=new DataInputStream(socket.getInputStream())){
	   // прочитать имя гостя
           name=is.readUTF();
	   password=is.readUTF();
	   if (!logins.get(name).equals(password)){
	      is.close();
	      socket.close();
	      return;
	   }
	   logger.info(name+" enters the room");
	   new UserSocketOut(socket, dialog, name);
           System.out.println("Yo! "+name + " in da house!");
	   dialog.add("Yo! "+name+" in da house!");
	   while(true){
              String msg=is.readUTF();
	      dialog.add(name+": "+msg);
              System.out.println(name+": "+msg);
	   }
         }catch(Exception e){dialog.add(name+" leaves the chat"); System.out.println(name+" leaves the chat"); logger.info(name+" leaves the room");}
//      catch(Exception e){e.printStackTrace();System.out.println(2);}
      }catch (InterruptedException ie) {ie.printStackTrace();}
      finally{
	semaphore.release();
	if (semaphore.availablePermits()==2) {
	   logger.info(dialog.toString());
	   dialog.clear();
	}
      }
   }
   public void finalize(){
      System.out.println("GC");
   }
}
//____________________________________________________________
class UserSocketOut implements Runnable{
   Thread thr=null;
   private Socket socket=null;
   private List<String> dialog=null;
   private int lineCounter=0;
   private int lastMsg=0;
   private String name;

   UserSocketOut(Socket socket, List<String> dialog, String name){
      thr=new Thread(this);
      this.socket=socket;
      this.dialog=dialog;
      this.name=name;
      thr.start();
   }


   public void run(){
      try(DataOutputStream os=new DataOutputStream(socket.getOutputStream())){
        while(true){
           // выслать ему последние сообщения из чата
           if((dialog.size()-lastMsg)>=10) {lineCounter=10;lastMsg=dialog.size();}
           else {lineCounter=dialog.size()-lastMsg; lastMsg=dialog.size();}
           os.write(lineCounter);
           os.flush();
	   for (int i=lineCounter; i>0; i--){
	      os.writeUTF(dialog.get(dialog.size()-i));
	      os.flush();
           }
        }
      }catch(Exception e){System.out.println(name+" finishes");}
   }
   public void finalize(){
      System.out.println("GC");
   }
}

