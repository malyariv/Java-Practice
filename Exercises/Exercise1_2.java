public class Exercise1_2{
   public static long fibonachi(int n){
	if ((n==3)||(n==2)||(n==1)) return (long)1;
	return (long) fibonachi(n-1)+fibonachi(n-2)+fibonachi(n-3);
   }

   public static void main (String[] args){
	for (int i=1; i<21; i++) System.out.print(fibonachi(i)+" ");
   }
}
