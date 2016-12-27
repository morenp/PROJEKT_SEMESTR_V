package mainClasses;


public class Datagram {

	private String data = "";

	private  String getData()
	{
		return data;
	}
	
	public void create(String data)
	{
		this.data = "START"+data+"END";
	}
	public String unpack(String d)
	{
	
		String x = d;
		x = x.substring(5, x.length()-3);
		

		return x;
	}

	@Override
	public String toString() {
		return data;
	}
	
	
	
	/*
	public static void main(String[] args) {
	
		Datagram d = new Datagram("HELLO");
		System.out.println(d.unpack(d));
	}*/
}
