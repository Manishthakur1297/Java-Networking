import java.io.*;
import java.net.*;

public class TCPClient
{

	public static void main(String[] args)
	{
		try
		{
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

			InetAddress ip = InetAddress.getLocalHost();
			Socket s = new Socket(ip,1331);
			
			PrintWriter out = new PrintWriter(s.getOutputStream());
			String line=null;
			System.out.println("Enter data to send");
			do
			{
				line = br.readLine();
				//out.write(line);
				out.println(line);
				out.flush();
				

			}while(!line.equals("stop"));
			out.close();
			br.close();
			s.close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	
	}

}