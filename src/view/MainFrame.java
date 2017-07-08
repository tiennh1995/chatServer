package view;

import java.awt.event.*;
import javax.swing.*;

public class MainFrame {
  private JFrame mainFrame;
  private JPanel controlPanel;
  private JTextArea textArea;

  public MainFrame(){
    prepareGUI();
  }
 
  private void prepareGUI(){
    mainFrame = new JFrame("Server");
    mainFrame.setSize(400,400);
    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent){
        System.exit(0);
      }        
    });    
         
    controlPanel = new JPanel();

    mainFrame.add(controlPanel);
    mainFrame.setVisible(true);  
  }

  public void showJPanel(){
    JPanel panel = new JPanel();
    panel.setSize(mainFrame.getWidth(), mainFrame.getHeight());
    textArea = new JTextArea();
    textArea.setSize(mainFrame.getWidth(), mainFrame.getHeight());
    panel.add(textArea);
    controlPanel.add(panel);        
    mainFrame.setVisible(true);      
  }

  public JFrame getMainFrame() {
    return mainFrame;
  }

  public JPanel getControlPanel() {
    return controlPanel;
  }

  public JTextArea getTextArea() {
    return textArea;
  }
}
