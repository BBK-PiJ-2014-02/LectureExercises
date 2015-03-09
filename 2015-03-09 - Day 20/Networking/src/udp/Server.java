package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
	public static void main(String []args) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9870);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("Server waiting for reply");
			serverSocket.receive(receivePacket);
			
			String sentence = new String(receivePacket.getData());
			System.out.println("Received: " + sentence);
			
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getAddress();
			
			
		}
	}

}
