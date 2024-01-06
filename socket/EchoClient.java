package socket;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
		try {
			System.out.println("Client started");
			Socket soc = new Socket("localhost", 9806);
			Scanner in = new Scanner(System.in);

			System.out.print("Enter your Name : ");
			String name = in.nextLine();

			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			out.println(name);

			Scanner get = new Scanner(soc.getInputStream());
			String temp = get.nextLine();
			System.out.println(temp);


			in.close();
			soc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
