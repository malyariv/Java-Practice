public class Test{
	public static void main(String[] args){
	   String s="qwerty";
	   String s2=s;

//	   System.out.println("s2 до "+s2);
	   s2=new String("poiuyt");
//	   System.out.println("s2 после "+s2);
//	   System.out.println("s после "+s2);

	   boolean b1=true;
	   boolean b2=false;
	   boolean b3=true;
	   boolean b4=false;

	   System.out.println((b1^b2)&(b3^b4)|((b1&b2)^(b3&b4)));

	}


}
