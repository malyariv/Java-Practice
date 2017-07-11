public class Exercise2_2{

   static class PersonData{
	private String name, surname, street, town;
	private int b, ap, index;

	PersonData(String name, String surname, int index, String town, String street, int b, int ap){
	   this.name=name;
	   this.surname=surname;
	   this.index=index;
	   this.town=town;
	   this.street=street;
	   this.b=b;
	   this.ap=ap;
	}

	public void getName(String name){
	  this.name=name;
	}

	public String toString(){
	   return "\nИмя Фамилия:\n"+name+" "+surname+"\nАдрес:\n"+index+" "+town+"\nул. "+street+", д. "+b+", кв. "+ap+"\n";
	}

   }

   public static void main(String[] args){
	PersonData pd=new PersonData("Ivan", "Malyar", 410028, "Saratov", "Rabochaya", 12, 48);
	System.out.println(pd);
   }

}
