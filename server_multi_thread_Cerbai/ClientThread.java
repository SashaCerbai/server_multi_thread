package it.gabriele;

import java.net.*;
import java.io.*;

public class ClientThread extends Thread{
    Socket socket = null;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            chiudi();
        }catch(Exception e){
            System.out.println("10 Server chiuso da un altro Thread");
        }
    }

    public void chiudi(){
        for(;;){
            try {
                Thread.sleep(2000);
                //System.out.println("is CLOSED " +socket.isClosed());
                if (socket.isClosed()) {
                    System.exit(0);
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
