package controller;

import view.MainFrame;

public class MainController {
  public static void main(String args[]) {
    InitServer initServer = new InitServer();
    initServer.runServer();
    MainFrame mainFrame = new MainFrame();  
    mainFrame.showJPanel();    
    mainFrame.getTextArea().setText("Server in running...");  
  }
}
