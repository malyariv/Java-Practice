import java.net.*;
import java.io.*;
import java.util.*;
public class GetURLInfo {
   public static void printinfo(URL url) throws IOException {
      URLConnection c = url.openConnection(); // Получаем объект URLConnection
      c.connect();
      System.out.println(" Тип содержимого: " + c.getContentType());
      System.out.println(" Кодировка содержимого: " + c.getContentEncoding());
      System.out.println(" Размер содержимого: " + c.getContentLength());
      System.out.println(" Дата: " + new Date(c.getDate()));
      System.out.println(" Последняя модификация: " + new Date(c.getLastModified()));
      System.out.println(" Срок годности: " + new Date(c.getExpiration()));
      if (c instanceof HttpURLConnection) {
	HttpURLConnection h = (HttpURLConnection) c;
	System.out.println(" Метод запроса: " + h.getRequestMethod());
	System.out.println(" Сообщение ответа: " +h.getResponseMessage());
	System.out.println(" Код ответа: " + h.getResponseCode());
      }
   }

   public static void main(String[] args) {
      try { printinfo(new URL(args[0])); }
      catch (Exception e) {
	System.err.println(e);
      }
   }
}
