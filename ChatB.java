import java.io.*;
import java.net.*;

public class ChatB //UDPReceiver
{

	public static void main(String[] args)
	{
		try
		{
			byte[] data = new byte[1024];
			InetAddress ia = InetAddress.getLocalHost();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			DatagramSocket ds = new DatagramSocket(1096);
			DatagramPacket dpS = null;
			DatagramPacket dpR = new DatagramPacket(data,data.length);
			System.out.println("Enter Name : ");
			String name = br.readLine();
			String line = null;
			do
			{
				ds.receive(dpR);
				line = new String(dpR.getData(),0,dpR.getLength());
				System.out.println(line);

				line = name + " : " + br.readLine();
				data = line.getBytes();
				dpS = new DatagramPacket(data,data.length,ia,1095);
				ds.send(dpS);


			}while(!line.equals("quit"));
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	
	}

}