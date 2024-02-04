package socket;

import java.io.PrintWriter;
// import java.io.Read
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9806);
			System.out.println("server is waiting for client.....");
			Socket soc = ss.accept();
			System.out.println("connection is established");

			Scanner get = new Scanner(soc.getInputStream());
			String name = get.nextLine();

			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println("your name is " + name);

			get.close();
			soc.close();
			ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
