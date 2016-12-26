package model;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import controler.UserPanelController;
import mainClasses.AppUser;

public class User extends Model {

	UserPanelController userPanelController;
	AppUser appUser;
	String resp; // XML z bazy danych

	public User(UserPanelController controller) {
		addObserver(controller);
		userPanelController = controller;
	}

	public void createAppUser(String resp) {
		appUser = createXML(resp);
		System.out.println("appUSER : " + appUser);
		super.informObservers(); // POINFORMOWANIE OBSERWATOROW
	}
	
	public void createAppUser(AppUser appUser) {
		this.appUser = appUser;
		super.informObservers(); // POINFORMOWANIE OBSERWATOROW
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void generateXML() {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(AppUser.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(appUser, System.out);
			jaxbMarshaller.marshal(appUser, new File("C:\\Users\\Marcin\\workspace\\SprzedazBiletowFx\\sb.xml"));
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AppUser createXML(String name) {
		AppUser appUser2 = null;
		name = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><AppUser>" + name + "</AppUser>";

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(AppUser.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(name);
			appUser2 = (AppUser) unmarshaller.unmarshal(reader);
			System.out.println(appUser2);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return appUser2;
	}

	public String getResp() {
		return resp;
	}
}