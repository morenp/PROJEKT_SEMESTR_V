package mainClasses;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;


public class Person {

	private String name;
	private String secondName;
	private String address;
	private String phoneNumber;
	
	public Person()
	{}
	
	public Person(String name, String secondName, String address, String phoneNumber) {
		super();
		this.name = name;
		this.secondName = secondName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	/*public Person(String fileName) throws ValidityException, ParsingException, IOException
	{
		Document doc = new Builder().build(fileName);
		Element element =  doc.getRootElement();
		Person person = new Person(element);
		
		for(int i=0;i<elements.size();i++)
		add(new Person(elements.get(0)));
		
		
		
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	public Element getXML()
	{
		Element person = new Element("person");
		
		Element name = new Element("name");
		name.appendChild(this.getName());
		
		Element secondName = new Element("secondName");
		secondName.appendChild(this.getSecondName()); 
		
		Element phoneNumber = new Element("phoneNumber");
		phoneNumber.appendChild(this.getPhoneNumber());
		
		Element address = new Element("address");
		address.appendChild(this.getAddress());

		
		person.appendChild(name);	
		person.appendChild(secondName);
		person.appendChild(phoneNumber);
		person.appendChild(address);

		return person;
	}
	
	public void format(OutputStream os, Document doc) throws IOException 
	{
		Serializer serializer = new Serializer(os,"Windows-1250");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
			
	}
	
	public String toXML() throws IOException
	{
		Element root = new Element("person");
		root.appendChild(this.getXML());
		Document doc = new Document(root);
		format(System.out, doc);
		format(new BufferedOutputStream(new FileOutputStream("Person.xml")),doc);
		System.out.println("ZAPISA£EM ");
		return doc.toString();
	}
	
	
	
	
	
	
}
