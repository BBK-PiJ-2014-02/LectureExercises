package networkingNotesExample;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class EchoClient {
	private void launch() {
		// 1. If there is no security manager, start on
		if ( System.getSecurityManager() == null ) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			Remote service = Naming.lookup("//127.0.0.1:1099/echo");
			EchoService echoService = (EchoService) service;
			String receivedEcho = echoService.echo("Hello!");
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		} catch (NotBoundException ex) {
			ex.printStackTrace();
		}
	}
}
