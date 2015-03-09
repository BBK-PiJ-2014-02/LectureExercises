package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws Exception {
    	DatagramSocket clientSocket = new DatagramSocket();
    	InetAddress IPAddress = InetAddress.getByName("localhost");
    	byte[] sendData;
    	byte[] receiveData = new byte[1024];
    	String sentence = "";
    	
    	try (Scanner sc = new Scanner(System.in)) {
    		while(!"Exit",equals(sentence)) {
    			System.out.print("prompt: ");
    			sentence = sc.nextLine();
    			sendData = sentence.getBytes();
    			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9870);
    			System.out.println("Sending: " + sentence);
    			clientSocket.send(sendPacket);
    			
    			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    			
    		
    		}
    	}
    }
}
