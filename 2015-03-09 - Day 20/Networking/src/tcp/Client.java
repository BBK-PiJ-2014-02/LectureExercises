package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String arg[]) {
		try (Socket skt = new Socket("localhost", 8801)) {
			BufferedReader input = new BufferedReader(new InputStreamReader(skt.getInputStream())) {
				System.out.print("Received string: ");
			}
		}
	}

}
