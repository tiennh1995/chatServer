package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import modal.Message;

public class DataController implements Runnable {
  Socket socket;
  InputStream is;
  OutputStream os;
  ObjectOutputStream oos;
  ObjectInputStream ois;  
  int port;

  public DataController(Socket s) {
    try {
      socket = s;
      port = socket.getPort();
      System.out.println(port);
      os = socket.getOutputStream();
      oos = new ObjectOutputStream(os);      
      is = socket.getInputStream();
      ois = new ObjectInputStream(is);
    } catch (IOException ex) {
      Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void run() {
    try {
      Message message = null;
      while((message = Message.receiveMessage(ois)) != null) {
        excuteRequest(message);
      }
    } catch(Exception ex) {
      System.exit(0);
    }
  }
  
  private void excuteRequest(Message message) {
    switch(message.getType()) {
      case "TXT": 
        Message.sendMessage(oos, message);
        break;
      case "IMG":
        break;
    }
  }
}
