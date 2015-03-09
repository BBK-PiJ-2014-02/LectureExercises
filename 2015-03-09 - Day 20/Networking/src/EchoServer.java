

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EchoServer extends UnicastRemoteObject implements EchoService {
	/**
	 * The serial version.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @throws RemoteException
	 */
	public EchoServer() throws RemoteException {
		// nothing to initialise for this server
	}
	
	/**
	 * The echo method.
	 */
	@Override
	public String echo(String s) {
		// This println is not necessary, but helps verifying whether
		// the server has received the call or not on the remote machine
		System.out.println("Replied to some client saying '" + s + "'");
		return s;
	}

}
