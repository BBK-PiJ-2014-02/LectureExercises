package web;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Date;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.spi.http.HttpExchange;

public class Test {
    public static void main(String[] args) throws Exception {
    	HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    	server.createContect("/test", new MyHandler());
    	server.setExecutor(null); // creates a default executer
    	server.start();
    }
    
	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "Some data that is very important" + new Date();
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}
