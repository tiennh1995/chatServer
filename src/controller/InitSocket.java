package controller;

import modal.*;
import java.net.ServerSocket;
import java.net.Socket;

public class InitSocket implements Runnable{
  private ServerSocket serverSock;

  @Override
  public void run() {
    try {
      serverSock = new ServerSocket(Constant.DEFAULT_PORT);
      while(true) {
        Socket socket = serverSock.accept();
        Thread dataController = new Thread(new DataController(socket));
        dataController.start();
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
