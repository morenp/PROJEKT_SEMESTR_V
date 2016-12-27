package model;

import org.apache.commons.validator.routines.EmailValidator;

import controler.UserPanelController;
import mainClasses.AppUser;
import validation.PasswordHash;

public class Registration extends Model {

	
	AppUser appUser; 
	
	
	
	public Registration() {
		
		super();
		appUser =new AppUser();
		
	}
	
	public boolean register()
	{
		
		System.out.println(appUser);
		System.out.println(appUser.getPhoneNumber());
		
		String resp = Main.getClient().executeUserInsert(appUser);
		System.out.println("RESP : " + resp);
		if(resp.equals("create_complited"))
			return true;
		else
			return false;
	}
	public int setName(String name)
	{	
		if(name.length()==0)
		{
			return -1;
		}
		else
		{
			appUser.setName(name);
			return 1;
		}
	}
	
	public int setLastName(String lastName)
	{		
		if(lastName.length()==0)
		{
			return -1;
		}
		else
		{
			appUser.setSecondName(lastName);
			return 1;
		}
	}
	
	public int setEmail(String email)
	{
		EmailValidator ev = EmailValidator.getInstance();
		if(ev.isValid(email))
		{
			if(!Main.getClient().isEmailExisting(email))
			{
				appUser.setEmail(email);
				return 1;
			}
			else
			{
				return -2;			
			}
		}
		else
		{
			return -1;
		}
		

			
			
	}

	public int setPassword(String password1, String password2)
	{
		int out=0;
		
		//SPRAWDZENIE CZY PODANE HASLA SA IDENTYCZNE
		if(password1.equals(password2))
		{
			
			if(password1.length()>0 && password1.length()<30)
			{
				String passwordHash="";
					try {
						passwordHash = PasswordHash.getSaltedHash(password1);
						System.out.println(passwordHash);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					appUser.setPassword(passwordHash);	
					out=1;
			}
			else
			{
				out=-2;
			}	
		}
		else
		{
			out=-1;
		}	
		return out;
	}
	
	public int setAddress(String address)	
	{	
		if(address.length()==0)
		{
			return -1;
		}
		else
		{
			appUser.setAddress(address);
			return 1;
		}
	}
	
	public int setPhoneNumber(String phoneNumber)	
	{	
		if(phoneNumber.length()==0)
		{
			return -1;
		}
		else
		{
			appUser.setPhoneNumber(phoneNumber);
			return 1;
		}
	}

	public AppUser getAppUser() {
		return appUser;
	}
	
	
}
