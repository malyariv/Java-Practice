public class Exercise1_3{
   public static void main(String[] args){
	int start=Integer.parseInt(args[1]);
	int length=Integer.parseInt(args[2])+start;
	System.out.println(args[0].substring(start, length));

	StringBuffer sb=new StringBuffer();
	for (int i=start; i<length;i++) sb.append(args[0].charAt(i));
	System.out.println(sb);
   }
}
