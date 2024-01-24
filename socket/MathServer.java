package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer{

    private ServerSocket ss;

    MathServer(ServerSocket ss){
        this.ss = ss;
    }

    void runServer(){
        try {
            while(!ss.isClosed()){
                Socket soc = ss.accept();
                System.out.println("new client is connected");
                MathCalculator calculator = new MathCalculator(soc);

                Thread thread = new Thread(calculator);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println("error in runServer method");
            closeServer(ss);
        }
    }

    void closeServer(ServerSocket ss){
        try {
            if (ss != null)
                ss.close();
        } catch (Exception e) {
            System.out.println("error in closeServer method");
        }
    }

    public static void main(String[] args) {
		try {
            ServerSocket ss = new ServerSocket(9806);
            MathServer mathServer = new MathServer(ss);
            mathServer.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}