package model;

import org.apache.commons.validator.routines.EmailValidator;

import mainClasses.AppUser;

public class Login extends Model{

	private User user;
	
	
	
	private String resp;
	
	public Login()
	{
		super();
		user = new User();
	}
	
	public int login(String email, String password)
	{
		// WALIDATOR ADRESU EMAIL 
    	EmailValidator ev = EmailValidator.getInstance();
  	
			if(ev.isValid(email) && !password.equals(""))
			{
			
				//Login's data send to the server and receive data from server 
				this.resp = Main.getClient().login(email, password);
				
				user.createAppUser(this.resp);
				

			    if(!this.resp.equals("wrong_password"))
			    {
			    	if(this.resp.equals("not_exist"))
			    	{
			    		// Email address does not exist
			    		return -1;
			    	}
			    	else		
			    	{
			    		//Login Success

			    		return 1;
			    	}
				}
				else
				{
					//Wrong password
					return -3;
				}
			}
			else
			{
				if(!ev.isValid(email))
				{
					//Wrong email
					return -2;
				}
				else
					if(password.equals(""))
					{
						//Missing password
						return -4;
					}				
			}
			return 0;		
	}

	public String getResp() {
		return resp;
	}

	public User getUser() {
		return user;
	}


	
	
}
