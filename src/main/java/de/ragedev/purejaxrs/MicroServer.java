package de.ragedev.purejaxrs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

import javax.ws.rs.ext.RuntimeDelegate;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class MicroServer {

	private static HttpServer server;

	public static void main(String[] args) throws IOException {
		start();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any key and return to stop the MicroServer.");
		scanner.next();

		stop();
		scanner.close();
	}

	public static void start() throws IOException {
		System.out.println("Possible endpoints are " + "\n - http://localhost:8080/helloworld and "
				+ "\n - http://localhost:8080/sayhello?name=yourname");
		final InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8080);
		server = HttpServer.create(socketAddress, 0);
		final HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new Endpoints(), HttpHandler.class);
		server.createContext("/", handler);
		server.start();
		System.out.println("MicroServer started.");
	}

	public static void stop() {
		if (server != null) {
			server.stop(0);
			System.out.println("MicroServer stopped.");
		} else
			throw new IllegalStateException("You must start the server before stopping it.");
	}

}
