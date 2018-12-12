package opoly;
import java.io.*;
import java.util.*;


public class Opoly{
  int length;
  int position;
  int score;
  public Opoly(int length) {
    this.length = length;
    this.position = 0;
    this.score = 0;
  }

  public void playGame(){
    render();
  }

  private void render(){
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

  private int spin(){
    return (int) (Math.random() * 0.5);
  }

  private void updateIdx(){
    int newPos = this.position + spin();
    newPos = newPos % position;
    if(newPos == position - 1){
      newPos -= 2;
    }
    // implement other bullets
  }
}
