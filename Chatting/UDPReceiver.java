import java.io.*;
import java.net.*;

public class UDPReceiver
{

	public static void main(String[] args)
	{
		try
		{
			byte[] data = new byte[1024];
			InetAddress ia = InetAddress.getLocalHost();
			DatagramSocket ds = new DatagramSocket(1096);
			DatagramPacket dp = new DatagramPacket(data,data.length);
			
			String line = null;
			do
			{
				ds.receive(dp);
				line = new String(dp.getData(),0,dp.getLength());
				System.out.println(line);

			}while(!line.equals("quit"));
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	
	}

}