import java.util.*;
public class GnomeSort{
   public static void main(String[] args){
      final int length=10;
      RandomArray ra=new RandomArray(length);
      int[] ia=ra.getInt();
      double[] da=ra.getDouble();
      int chInt=0;
      double chDoub=0.0;
//      System.out.println(Arrays.toString(ia));
//      System.out.println(Arrays.toString(da));
      System.out.println();
      long timeStart=System.currentTimeMillis();
      int i=1;
      while (i<length){
	if (i==0||ia[i-1]<ia[i]) i++;
	else {
           chInt=ia[i-1];
           ia[i-1]=ia[i];
           ia[i]=chInt;
	   i--;
	}
      }

      i=1;
      while (i<length){
        if (i==0||da[i-1]<da[i]) i++;
        else {
           chDoub=da[i-1];
           da[i-1]=da[i];
           da[i]=chDoub;
           i--;
        }
      }

      long timeFinish=System.currentTimeMillis();

      System.out.println(Arrays.toString(ia));
//      System.out.println(Arrays.toString(da));
      System.out.println("Время выполнения "+(timeFinish-timeStart)+" мс");
   }



}
