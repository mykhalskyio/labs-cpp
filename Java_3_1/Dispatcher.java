package Lab3_1;

import java.net.*;
import java.io.*;

public class Dispatcher
{
	public static void main(String args[])throws Exception
	{
		Socket socket = new Socket("localhost",1234);
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Client Onboard!!! Socket - 1234");

		String stringIn = "";
		String stringGet = "";

		while(!stringIn.equals("stop") || !stringIn.equals("Stop"))
		{
			stringIn = bufferedReader.readLine();
			dataOutputStream.writeUTF(stringIn);
			dataOutputStream.flush();
			stringGet = dataInputStream.readUTF();
			System.out.println("Server Returns Result: " + stringGet);
		}

		dataOutputStream.close();
		socket.close();
	}
}