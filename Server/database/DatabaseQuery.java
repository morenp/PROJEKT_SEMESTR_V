package database;


public class DatabaseQuery {


	
	public String getUserQuery(String email, String password, String parametr)
	{
		String q="";
		
		if(parametr.equals("1"))
		 q= "SELECT XMLELEMENT(\"name\",name)"
				+ "||XMLELEMENT(\"secondName\",last_name)"
				+ "|| XMLELEMENT(\"address\",address) "
				+ "|| XMLELEMENT(\"phoneNumber\",phone_number) "
				+ "|| XMLELEMENT(\"userID\",user_ID) "
				+ "|| XMLELEMENT(\"email\",email) "
				+ "|| XMLELEMENT(\"password\",password) "
				+ "|| XMLELEMENT(\"dateOfRegistration\",date_of_registration) "
				+ "as xml_users from users "				
				+ "u where u.email = "+"\'"+email+"\'";
		else if(parametr.equals("2"))
		{
			q="SELECT address from users u where u.email = "+"\'"+email+"\'"+" AND u.password = "+ "\'"+password+"\'";
		}
		return q;
	}
	
	public String getUserUpdateQuery()
	{	
		
		String query="";
			query ="{CALL UPDATE_PROFILE(?,?,?,?,?)}";
		return query;		
	}

	public String getUserInsertQuery()
	{
		return "{call create_user(?,?,?,?,?,?)}";
	}
	
	public String getEmailExistingQuery(String email) {
		
		return "SELECT u.email from users u where u.email = " + "\'" + email + "\'";
	}
}
