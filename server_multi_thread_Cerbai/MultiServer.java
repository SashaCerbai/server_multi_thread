package it.gabriele;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiServer {

    List<ServerThread> threadList = new ArrayList<>();
    ServerSocket serverSocket = null;

    public void start(){
        try{
            serverSocket = new ServerSocket(6789);
            for(;;){
                System.out.println("1 Server in attesa...");
                Socket socket = serverSocket.accept(); //In ATTESA di comunicazione
                System.out.println("3 Server socket " + socket);
                ServerThread serverThread = new ServerThread(socket, this); //Apro il THREAD per il client
                serverThread.start();

                threadList.add(serverThread);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server!");
            System.exit(1);
        }
    }

    public void stop(){

        for(int i = 0; i < threadList.size(); i++){
            try {
                threadList.get(i).close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


}
