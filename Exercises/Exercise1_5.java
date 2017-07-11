import java.util.*;
public class Exercise1_5{
   public static void main(String[] args){
	int[] ar=new int[16];
	for (int i=0;i<16;i++) ar[i]=(int)(Math.random()*100);
	System.out.println(Arrays.toString(ar));
	quickSort(ar,0, ar.length-1);
	System.out.println("Моя сортировка\n"+Arrays.toString(ar));
	Arrays.sort(ar);
	System.out.println("Проверка\n"+Arrays.toString(ar));
	System.out.print("Введите интересующее число из массива: ");
	Scanner sc=new Scanner(System.in);
	int intr=sc.nextInt();
	neighbors(ar, intr);

   }
   static void quickSort(int[] a, int left, int right){
	int i=left,j=right, change;
	int center=(int) (left+right)/2;
	int base=a[center];
//	System.out.println("Center is "+center+", основание -"+base);
	do{
	   while((a[i]<base)&&(i<=j)) i++;
	   while((a[j]>base)&&(j>=i)) j--;
	   if (i<=j) {change=a[i]; a[i]=a[j]; a[j]=change; i++; j--;}
	} while (i<=j);

	if (left<j) quickSort(a, left, j);
	if (i<right) quickSort(a, i, right);
   }

   static void neighbors(int[] a, int intr){
	int left=0, right=a.length-1;
	int c=(left+right)/2;
	while ((right-left)>1){
	   if (a[c]==intr) break;
	   if (a[c]<intr) left=c;
	   else right=c;
	   c=(left+right)/2;

	}
	if ((c>0)&&(c<a.length-1)) System.out.println("Предыдущий элемент - " + a[c-1]+"\nСледующий элемент: "+a[c+1]);
   }
}
