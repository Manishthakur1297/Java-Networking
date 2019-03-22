import java.io.*;
import java.net.*;

 class UDPSender1 extends Thread
{

	public void run()
	{
		try
		{
			byte[] data = new byte[1024];
			InetAddress ia = InetAddress.getLocalHost();
			//InetAddress ia = InetAddress.getByName("10.249.34.146");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			DatagramSocket ds = new DatagramSocket(1095);
			DatagramPacket dp = null;
			System.out.print("Enter Name : ");
			String name = br.readLine();
			String line = null;
			do
			{
				line =  "\t" + name + " : " + br.readLine();
				data = line.getBytes();
				dp = new DatagramPacket(data,data.length,ia,1096);
				ds.send(dp);

			}while(!line.equals("quit"));

			ds.close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	
	}

}

class UDPReceiver2 extends Thread
{

	public void run()
	{
		try
		{
			byte[] data = new byte[1024];
			InetAddress ia = InetAddress.getLocalHost();
			DatagramSocket ds = new DatagramSocket(1098);
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

public class ChatA
{

	public static void main(String args[])
	{
		UDPSender1 s1 = new UDPSender1();
		UDPReceiver2 r2 = new UDPReceiver2();

		s1.start();
		r2.start();

	}

}

