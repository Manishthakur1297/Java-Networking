import java.io.*;
import java.net.*;

public class TCPServer
{

	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(1331);
			System.out.println("Server Started....");
			Socket s = ss.accept();
			System.out.println("Connected to : "+s);
			BufferedReader br  = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line = null;
			do
			{
				line = br.readLine();
				System.out.println(line);
				//out.println(line);
				//out.flush();
			}while(!line.equals("stop"));
			//out.close();
			br.close();
			s.close();


		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	
	}

}