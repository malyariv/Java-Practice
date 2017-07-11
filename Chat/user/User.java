import java.util.*;
import java.net.*;
import java.io.*;

public class User{
   public static void main(String[] args){
      String name=null;
      QuitCheck q=new QuitCheck();
      String password=null;
      InetAddress addr=null;
      if(args.length<3) {
	System.out.println("Enter your login, password and IP");
	System.exit(0);
      }
      else {
	name=args[0];
	password=args[1];
	try{
	   addr = InetAddress.getByName(args[2]);
	}catch(Exception e){e.printStackTrace();}
      }

      try (Socket socket=new Socket(addr, 1234)){
	try (DataOutputStream os=new DataOutputStream(socket.getOutputStream())){
	   //отправили имя и пароль
	   os.writeUTF(name);
	   os.flush();
	   os.writeUTF(password);
	   os.flush();
	   new UserReader(socket, q, name);

	   Scanner sc=new Scanner(System.in);
	   while(!q.yes()){
	      String s=sc.nextLine();
	      if (s.equals("quit")) {q.set();break;}
	      os.writeUTF(s);
	      os.flush();
	   }
	}catch(Exception e){System.out.println("Alles!"); q.set();}
      }catch(Exception e){e.printStackTrace();}
      System.out.println(name+" finishes");
   }
}

//__________________________________________________
class UserReader implements Runnable{
   Thread thr=null;
   private Socket socket=null;
   private String name=null;
   private QuitCheck q;

   UserReader(Socket socket, QuitCheck q, String name){
      thr=new Thread(this);
      this.socket=socket;
      this.q=q;
      this.name=name;
      thr.start();
   }


   public void run(){
      String msg="UserReader Alles!";
      try(DataInputStream is=new DataInputStream(socket.getInputStream())){
	while(!q.yes()){
            int lineCounter=is.read();
	    if (lineCounter==-1) {
	      msg="Wrong login/password pair!";
	      q.set();
	      break;
	    }
            for (int i=0; i<lineCounter; i++){
	      String s=is.readUTF();
	      if(s.indexOf(name)!=0)
		System.out.println("\t\t\t\t"+s);
	    }
	}
      }catch(Exception e){System.out.println(msg);}

      System.out.println(msg);
   }
}
//__________________________________________________________________________
class QuitCheck{
   volatile private boolean q=false;

   public boolean yes(){ 
	return q;
   }

   public void set(){
	q=true;
   }

}
