
import java.util.*;
import java.io.*;
public class CommandLine{
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      System.out.println("\n\n\n");
      System.out.println("Это аналог командной строки. Ниже приведены команды, которые можно использовать");
      System.out.println("clear - очистка экрана");
      System.out.println("cat filepath - вывести содержимое файла на экран");
      System.out.println("rmv filepath/path - удаление файла/папки");
      System.out.println("ls path att - вывод на экран только папок (без атрибута). Атрибут files - вывод только файлов, all - вывод и папок и файлов");
      System.out.println("exit - выход из программы \n");

      for(;;) {
	System.out.print(">");
	String s=sc.nextLine();
	if (s.equals("exit")) break;
	CommandParcer cp=new CommandParcer();
	cp.execute(s);
      }

   }


}
//_________________________
class CommandParcer{
   private String filename;
   private String path=null;
   private int command;

   public int getCommand(String s){
      String[] str=s.split(" ");
      if (str.length>1) filename=str[1];
      if (str.length>2) path=str[2];
      switch (str[0]){
	case "rmv": return 1;
	case "mv": return 2;
	case "ls": return 3;
	case "cp": return 4;
	case "cat": return 5;
	case "clear": return 6;
	default: return -1;
      }
   }


   public void execute(String s){
     command=getCommand(s);
     if (command==6) System.out.println("\u001b[2J");
     else {
	File file=new File(filename);
//	System.out.println("File "+file);

	if ((command==3)&&(file.isDirectory())) {
	   if (path==null) showDirectories(file);
	   else {
		  if (path.equals("files")) showFiles(file);
		  if (path.equals("all")) {showDirectories(file); showFiles(file);}
	        }
        }

	if ((command==5)&&(file.isFile())) showText(file);
	if (command==1) delete(file);

     }
   }

   public void showDirectories(File f){
     for (String str:f.list())
        if (!str.contains(".")) {
	   System.out.print("Directory    ");
           System.out.println(str);
        }
   }

   public void showFiles(File f){
     for (String str:f.list())
        if (str.contains(".")) {
           System.out.print("File    ");
           System.out.println(str);
        }
   }

   public void showText(File f){
      try (Scanner scanner=new Scanner(new FileReader(f))){
	while (scanner.hasNext()) System.out.println(scanner.nextLine());
      }catch(Exception e){e.printStackTrace();}
   }

   public void delete(File f){
      if (!f.exists()) {System.out.println("Указанный каталог или файл не существует!"); return;}
      if (f.isDirectory()){
	String[] s=f.list();
	if (s.length>0) {System.out.println("Папка не пустая и не может быть удалена!"); return;}
      }
      if (f.delete()) System.out.println("Удаление прошло успешно");
   }


}
