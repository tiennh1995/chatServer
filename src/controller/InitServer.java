package controller;

public class InitServer {  
  public void runServer() {
    Thread listen = new Thread(new InitSocket());
    listen.start();
  }
}
