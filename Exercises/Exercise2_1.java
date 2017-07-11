import java.util.*;

public class Exercise2_1{

   public static class Circle{
	private int x,y,r;
	Circle(int x, int y, int r){
	   this.x=x;
	   this.y=y;
	   this.r=r;
	}

	public String toString(){
	   return "It's a Circle! Center x="+x+", y="+y+". Radius r="+r;
	}

	public void move(int deltaX, int deltaY){
	   x+=deltaX;
	   y+=deltaY;
	}

	public boolean isInside(int x, int y){
	   double distance=(x-this.x)*(x-this.x)+(y-this.y)*(y-this.y);
	   distance=Math.sqrt(distance);
	   //System.out.println(distance);
	   if (distance<=r) return true;
	   return false;
	}

	public Rect boundingBox(){
	   return new Rect(x-r, y-r, x+r, y+r);
	}
   }
   public static class Rect{
	int x1,x2,y1,y2;
	Rect(int x1,int y1,int x2,int y2){
	   this.x1=x1;
	   this.y1=y1;
	   this.x2=x2;
	   this.y2=y2;
	}

	public String toString(){
	   return "It,s a Rectangular. X1="+x1+", Y1="+y1+", X2="+x2+", Y2="+y2;
	}
   }


   public static void main (String[] args){
	Circle c=new Circle(100, 100, 50);
	System.out.println (c);
	Scanner sc=new Scanner(System.in);
	System.out.print("X=");
	int x=sc.nextInt();
	System.out.print("Y=");
	int y=sc.nextInt();
	System.out.println("Inside? "+c.isInside(x, y));
	Rect r=c.boundingBox();
	System.out.println(r);
   }

}
