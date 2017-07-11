import java.io.*;

public class Exercise3_7{
   public static void main(String[] args){
      try (TeeOutputStream tos=new TeeOutputStream(System.out, new FileOutputStream("testingTeeOutputStream.txt"))){
	int bytes_read;
	byte[] buffer=new byte[512];
	while((bytes_read=System.in.read(buffer))!=-1){
	   if (((char)buffer[0]=='e')&&((char)buffer[1]=='x')&&((char)buffer[2]=='i')&&((char)buffer[3]=='t')) System.exit(0);
	   tos.write(buffer,0,bytes_read);
	}
      }catch(Exception e){e.printStackTrace();}
   }

}
//_______________________________________________

class TeeOutputStream extends OutputStream{
   OutputStream s1;
   OutputStream s2;
   TeeOutputStream (OutputStream s1, OutputStream s2){
      this.s1=s1;
      this.s2=s2;
   }
   @Override
   public void write(byte[] buffer, int s,int l) throws IOException{
      s1.write(buffer, s, l);
      s2.write(buffer, s, l);
   }
   @Override
   public void write(byte[] buffer) throws IOException{
      s1.write(buffer);
      s2.write(buffer);
   }
   @Override
   public void write(int i) throws IOException{
      System.out.print(i+" ");
   }


   @Override
   public void close() throws IOException{
      s1.close();
      s2.close();
   }


}
