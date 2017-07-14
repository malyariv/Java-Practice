import java.util.*;
public class BubbleSort{
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
      int l1=length-1;
      for (int i=0; i<l1; i++){
	int l2=l1-i;
	for (int j=0; j<l2;j++){
	   if(ia[j]>ia[j+1]){
	      chInt=ia[j];
	      ia[j]=ia[j+1];
	      ia[j+1]=chInt;
	   }
	}
      }
      l1=length-1;
      for (int i=0; i<l1; i++){
	int l2=l1-i;
        for (int j=0; j<l2;j++){
           if(da[j]>da[j+1]){
              chDoub=da[j];
              da[j]=da[j+1];
              da[j+1]=chDoub;
           }
        }
      }
      long timeFinish=System.currentTimeMillis();

      System.out.println(Arrays.toString(ia));
//      System.out.println(Arrays.toString(da));
      System.out.println("Время выполнения "+(timeFinish-timeStart)+" мс");
   }



}
