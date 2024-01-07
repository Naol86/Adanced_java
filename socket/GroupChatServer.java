package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GroupChatServer {

	private ServerSocket ss;

	GroupChatServer(ServerSocket ss){
		this.ss = ss;
	}

	void StartServer(){
		try {
			while (!ss.isClosed()){
				Socket soc = ss.accept();
				System.out.println("new client is connected");

				GroupChatClientHandler clientHandler = new GroupChatClientHandler(soc);

				Thread thread = new Thread(clientHandler);
				thread.start();

			}
		} catch (Exception e) {
			closeServerSocket();
		}
	}

	public void closeServerSocket(){
		try {
			if (ss != null){
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9806);
		GroupChatServer gcs = new GroupChatServer(ss);
		gcs.StartServer();
	}
}
