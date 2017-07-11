import java.util.*;

public class SortCompare{
   public static void main(String[] args){
      int[] a={5,0,8,7,2,6,4,3,9,1};
      int[] b=new int[a.length];
      System.arraycopy(a,0,b,0,10);
      System.out.println(Arrays.toString(a));
      System.out.println(Arrays.toString(b));
      int c;

      long t=System.nanoTime();
      for (int i=0;i<b.length-1; i++){
	for (int j=0; j<(b.length-i-1); j++){
	   if (b[j]>b[j+1]){
	      c=b[j];
	      b[j]=b[j+1];
	      b[j+1]=c;
	   }
	}
      }
      System.out.println("Метод пузырька");
      System.out.println(Arrays.toString(b));
      System.out.println("Время сортировки составило "+(System.nanoTime()-t)/1000+" мкс\n\n");


      System.arraycopy(a,0,b,0,10);
      System.out.println(Arrays.toString(b));
      t=System.nanoTime();
      Arrays.sort(b);
      System.out.println("Arrays.sort");
      System.out.println(Arrays.toString(b));
      System.out.println("Время сортировки составило "+(System.nanoTime()-t)/1000+" мкс\n\n");

      System.arraycopy(a,0,b,0,10);
      System.out.println(Arrays.toString(b));
      t=System.nanoTime();
      myQuickSort(b);
      System.out.println("My quick sort");
      System.out.println(Arrays.toString(b));
      System.out.println("Время сортировки составило "+(System.nanoTime()-t)/1000+" мкс\n\n");

   }

   static void myQuickSort(int[] a){
      int i=0;
      int j=a.length-1;
      int mid=a[(int)Math.round(Math.random()*j)];
      int c;
      System.out.println("Опорный элемент "+mid);
      do{
         while((i<a.length)&&(a[i]<mid)) i++;
         while((j>0)&&(a[j]>mid)) j--;
         if (i<=j) {
	   c=a[i];
	   a[i]=a[j];
	   a[j]=c;
	   i++;
	   j--;
         }
      }while(i<=j);
   }

}
