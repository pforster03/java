package opoly;
import java.io.*;
import java.util.*;


public class Opoly{
  int length;
  int position;
  public Opoly(int length) {
    System.out.print("Hello, World!");
    this.length = length;
    this.position = 0;
  }

  public void playGame(){
    String list = "";
    for(int i = 0; i < length; i++){
      if(position == i){
        list += 'o';
      }else{
        list += "*";
      }
    }
    System.out.println(list);
  }
}
