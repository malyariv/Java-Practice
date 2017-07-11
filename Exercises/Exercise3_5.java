import java.util.*;
import java.io.*;
public class Exercise3_5{
   public static void main(String[] args){
      String filename=null;
      Scanner sc=new Scanner(System.in);
      for(;;){
	System.out.print("Введите название интересующей папки: ");
	filename=sc.nextLine();
	if (filename.equals("exit")) break;
	String[] cmd=filename.split(" ");
	if (cmd.length==1) content(filename, 0);
	else{
	      if(cmd[1].equals("-s")) content(cmd[0], 1);
	      if(cmd[1].equals("-d")) content(cmd[0], 2);
	}
      }
   }

   public static long vol(String filename){
      long total=0;
      File dir=new File(filename);
      if (dir.isFile()) return dir.length();
      String[] l=dir.list();
      for (String s:l) {
	File f=new File(filename+"/"+s);
	if (f.isFile()) {
	   total+=f.length();
	}
	else total+=vol(f.getPath());
      }
      return total;
   }
//_______________________________________________
   public static void content(String filename, int att){
      File dir=new File(filename);
      if (dir.isFile()) {System.out.println("Это файл!"); return;}
      String[] l=dir.list();
      Arrays.sort(l);
      long[][] cont=new long[l.length][3];
      System.out.printf("%-20s%-15s%-15s\n", "Имя","Размер,байт", "Дата");
      int counter=0;
      for (String s:l){
	String path=filename+"/"+s;
	File file=new File(path);
	cont[counter][0]=counter;
	cont[counter][1]=vol(path);
	cont[counter++][2]=file.lastModified();
     }
      counter--;
//      System.out.println(counter);
      sort(cont, att);
      for (int i=0; i<cont.length; i++) 
	System.out.printf("%-20.15s"+"%-15d"+new Date(cont[i][2])+"\n", l[(int)cont[i][0]], cont[i][1]);

   }
//__________________
   public static void sort(long[][] ar, int param){
      for (int i=0; i<ar.length; i++){
//	long min=ar[i][param];
	long change=0;
	for (int j=0; j<(ar.length-i-1); j++){
	   if (ar[j][param]>ar[j+1][param]) {
	      for(int k=0;k<3; k++){
		change=ar[j][k];
		ar[j][k]=ar[j+1][k];
		ar[j+1][k]=change;
	      }
	   }
	}

      }
   }


//_______конец класса________
}
