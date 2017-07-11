import java.io.*;
import java.net.*;
public class GetURLContent {
   public static void main(String[] args) {
      InputStream in = null;
      OutputStream out = null;
      try {
	if ((args.length != 1) && (args.length != 2)) throw new IllegalArgumentException("Неправильное число аргументов");
	URL url = new URL(args[0]);
	in = url.openStream();
	if (args.length == 2) out = new FileOutputStream(args[1]);
	else out = System.out;

	byte[] buffer = new byte[4096];
	int bytes_read;
	while((bytes_read = in.read(buffer)) != 1) out.write(buffer, 0, bytes_read);
      }catch (Exception e) {
	System.err.println(e);
	System.err.println("Формат: java GetURL <URL> [<filename>]");
       }
      finally {
	try {
	   in.close();
	   out.close();
        }catch (Exception e) {}
      }
   }
}
