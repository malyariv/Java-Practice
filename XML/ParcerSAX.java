import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class ParcerSAX{
	public static void main(String[] args){
		try{
		   XMLReader reader=XMLReaderFactory.createXMLReader();
		   reader.setContentHandler(new PersonHandler());
		   reader.parse("person_marsh.xml");
		} catch(Exception e) {e.printStackTrace();}
	}
}

//__________________________

class PersonHandler extends DefaultHandler{
	//@Override
	public void startDocument(){System.out.println("Начало");}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs){
		String s=qName;
		for (int i=0; i<attrs.getLength(); i++) s+=" "+attrs.getLocalName(i)+"="+attrs.getValue(i);
		System.out.println(s.trim());
	}

	@Override
	public void characters(char[] ch, int start, int length){
		String info=new String(ch, start,length);
		System.out.println(info.trim());
	}

	public void endElement(String uri, String localName, String qName){
		System.out.println(qName.trim());
	}

	public void endDocument(){System.out.println("Конец");}
}

