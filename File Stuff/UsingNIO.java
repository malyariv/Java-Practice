import java.nio.file.*;
import java.util.*;
import java.io.*;
public class UsingNIO{
   public static void main(String[] args){
      Path path=Paths.get(System.getProperty("user.dir"));
      try (DirectoryStream<Path> ds=Files.newDirectoryStream(path)){
	for (Path child:ds) System.out.println(child.getName(child.getNameCount()-1));
//	Files.createDirectory(Paths.get("New"));
	Files.copy(Paths.get("test.txt"), Paths.get("New"+File.separator+"test.txt"));
      }catch(Exception e){e.printStackTrace();}

   }

}
