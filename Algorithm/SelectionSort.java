import java.util.*;
public class SelectionSort{
   public static void main(String[] args){
      final int length=10000;
      RandomArray ra=new RandomArray(length);
      int[] ia=ra.getInt();
      double[] da=ra.getDouble();
      int chInt=0;
      double chDoub=0.0;
//      System.out.println(Arrays.toString(ia));
//      System.out.println(Arrays.toString(da));
//      System.out.println();
      long timeStart=System.currentTimeMillis();
      for (int i=1; i<length; i++){
	for (int j=0; j<i;j++){
	   if(ia[j]>ia[i]){
	      chInt=ia[i];
	      ia[i]=ia[j];
	      ia[j]=chInt;
	   }
	}
      }
      for (int i=1; i<length; i++){
        for (int j=0; j<i;j++){
           if(da[j]>da[i]){
              chDoub=da[i];
              da[i]=da[j];
              da[j]=chDoub;
           }
        }
      }
      long timeFinish=System.currentTimeMillis();

      System.out.println(Arrays.toString(ia));
//      System.out.println(Arrays.toString(da));
      System.out.println("Время выполнения "+(timeFinish-timeStart)+" мс");
   }



}
