package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MathClient {

    private Socket soc;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

    MathClient(Socket soc){
        try {
			this.soc = soc;
			this.bufferedReader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
		} catch (Exception e) {
			closeServer(soc, bufferedReader, bufferedWriter);
		}
    }

    public void sendMessage(){
		try {
			Scanner scanner = new Scanner(System.in);
			while (soc.isConnected()){
				String messageToSend = scanner.nextLine();
				bufferedWriter.write(messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
			scanner.close();
		} catch (Exception e) {
			closeServer(soc, bufferedReader, bufferedWriter);
		}
	}

    void closeServer(Socket soc, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try {
			if (bufferedReader != null){
				bufferedReader.close();
			}
			if (bufferedWriter != null){
				bufferedWriter.close();
			}
			if (soc != null){
				soc.close();
			}
		} catch (Exception e) {
			// e.printStackTrace();
            System.out.println("error in closer server method of math calculator");
		}
    }


	public void listenForMessage(){
		new Thread(new Runnable() {
			public void run(){
				String messageFromGroupChat;
				while (soc.isConnected()){
					try {
						messageFromGroupChat = bufferedReader.readLine();
						System.out.println(messageFromGroupChat);
					} catch (IOException e) {
						closeServer(soc, bufferedReader, bufferedWriter);
					}
				}
			}
		}).start();
	}

    public static void main(String[] args) {
        Socket soc;
        try {
            soc = new Socket("localhost",9806);
            MathClient client = new MathClient(soc);
            client.listenForMessage();
            client.sendMessage();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
