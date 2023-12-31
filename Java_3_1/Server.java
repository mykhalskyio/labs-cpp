package Lab3_1;

import java.net.*;
import java.io.*;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket serverSocket = new ServerSocket(1234);
		Socket socket = serverSocket.accept();
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Server On!!! ServerSocket - 1234");

		String stringIn = "";
		String stringOut = "";

		while(!stringIn.equals("stop") || !stringIn.equals("Stop"))
		{
			stringIn = dataInputStream.readUTF();
			System.out.println("Client Requests: " + stringIn);

	        char[] stringInArray = stringIn.toCharArray();
	        String result = "";

	        for (char letter : stringInArray)
	        {
	        	if(Character.isLowerCase(letter)) {
		        	result += letter;
	        	}
	        }

			stringOut = "" + result;
			dataOutputStream.writeUTF(stringOut);
			dataOutputStream.flush();
		}

		dataInputStream.close();
		socket.close();
		serverSocket.close();
	}
}