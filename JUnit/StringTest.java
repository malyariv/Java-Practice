import org.junit.*;
import static org.junit.Assert.*;

public class StringTest{
   @Test
   public void testSubstring(){
      assertEquals("lo", "Hello".substring(3));
   }



}
