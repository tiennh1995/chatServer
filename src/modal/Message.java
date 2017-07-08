package modal;

import java.io.*;

public class Message implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String type;
  private String action;
  private int respone;
  private String content;
  
  public String getType() {
    return this.type;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public int getRespone() {
    return this.respone;
  }
  
  public String getData() {
    return this.content;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public void setAction(String action) {
    this.action = action;
  }
  
  public void setRespone(int respone) {
    this.respone = respone;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public boolean isText() {
    return this.type.equals(Constant.TEXT);
  }
  
  public boolean isImg() {
    return this.type.equals(Constant.IMG);
  }  
  
  public boolean isGet() {
    return this.action.equals(Constant.METHOD_GET);
  }
  
  public boolean isPost() {
    return this.action.equals(Constant.METHOD_POST);
  }
  
  public boolean isPut() {
    return this.action.equals(Constant.METHOD_PUT);
  }
  
  public boolean isDelete() {
    return this.action.equals(Constant.METHOD_DELETE);
  }
  
  public boolean isSuccess() {
    return this.respone == 1;
  }

  public static void sendMessage(ObjectOutputStream oos, Message message) {
    try {
      oos.writeObject(message);     
    } catch (IOException e) {
      e.printStackTrace();
    }
  }  
  
  public static Message receiveMessage(ObjectInputStream ois) {
    Message message = null;
    try {
      message = (Message) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return message;    
  }
}
