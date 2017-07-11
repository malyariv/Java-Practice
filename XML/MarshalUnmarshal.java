import java.io.*;
import java.util.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

public class MarshalUnmarshal{
	public static void main(String[] args){
/*		try {
			JAXBContext context=JAXBContext.newInstance(PersonList.class);
			Marshaller m=context.createMarshaller();
			PersonList pl= new PersonList(){
			{Person p=new Person("John", "Snow", 25, "single");
			this.add(p);
			p=new Person("Homer", "Simpson", 45, "married");
			this.add(p);}
			};
			m.marshal(pl, new FileOutputStream("person_marsh.xml"));
			m.marshal(pl,System.out);
		}catch(Exception e){e.printStackTrace();}*/

		try{
			JAXBContext jc=JAXBContext.newInstance(PersonList.class);
			Unmarshaller u=jc.createUnmarshaller();
			FileReader reader=new FileReader("person_marsh.xml");
			PersonList pl=(PersonList) u.unmarshal(reader);
			System.out.println("\n"+pl);
		}catch (Exception e){e.printStackTrace();}
	}

}

//_________________________

@XmlRootElement
class Person{
	@XmlAttribute
	private String att;
	@XmlElement
	private String name;
	@XmlElement
	private String surname;
	@XmlElement
	private int age;

	Person(){
		super();
	}

	Person (String name, String surname, int age, String att){
		this.name=name;
		this.surname=surname;
		this.age=age;
		this.att=att;
	}

	public void show(){
		System.out.println("Имя: "+name);
		System.out.println("Фамилия: "+surname);
		System.out.println("Возраст: "+age);
	}

	public String toString(){
		return "\nИмя: "+name+"\nФамилия: "+surname+"\nВозраст: "+age+"\nПоложение: "+att;
	}
}

//_____________________________________
@XmlRootElement
class PersonList{
	@XmlElement (name="person")
	private List<Person> list=new ArrayList<Person>();

	PersonList(){
	   //super();
	}

	public void setList(ArrayList<Person> list){
	  this.list=list;
	}

	public boolean add(Person p){
	   return list.add(p);
	}

	public String toString(){
		return list.toString();
	}

}
