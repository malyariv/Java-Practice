public class RandomArray{
   int[] arrInt;
   double[] arrDouble;
   int length;
   public RandomArray(int length){
      this.length=length;
      arrInt=new int[length];
      arrDouble=new double[length];
   }

   public int[] getInt(){
      for (int i=0; i<length;i++) arrInt[i]=(int) (Math.random()*100);
   return arrInt;
   }
   public double[] getDouble(){
      for (int i=0; i<length;i++) arrDouble[i]=Math.random()*10;
   return arrDouble;
   }

}
