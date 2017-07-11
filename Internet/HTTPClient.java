import java.io.*;
import java.net.*;
public class HTTPClient {
   public static void main(String[] args) {
      try {
	if ((args.length != 1) && (args.length != 2)) throw new IllegalArgumentException("Неправильное число аргументов");
	OutputStream to_file;
	if (args.length == 2) to_file = new FileOutputStream(args[1]);
	else to_file = System.out;
	URL url = new URL(args[0]);
	String protocol = url.getProtocol();
	if (!protocol.equals("http")) throw new IllegalArgumentException("Должен использоваться протокол HTTP ");
	String host = url.getHost();
	int port = url.getPort();
	if (port == -1) port = 80; // Если порт не задан, используем
	String filename = url.getFile();
	Socket socket = new Socket(host, port);
	InputStream from_server = socket.getInputStream();
	PrintWriter to_server = new PrintWriter(socket.getOutputStream());
	to_server.print("GET " + filename + "\n\n");
	to_server.flush(); // Отправляем немедленно!
	byte[] buffer = new byte[4096];
	int bytes_read;
	while((bytes_read = from_server.read(buffer)) != 1) to_file.write(buffer, 0, bytes_read);
	socket.close();
	to_file.close();
     } catch (Exception e) { // сообщаем о произошедших ошибках
	System.err.println(e);
       }
   }
}
