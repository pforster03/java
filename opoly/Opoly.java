package opoly;
import java.io.*;
import java.util.*;


public class Opoly{
  int length;
  int position;
  int score;
  int moves;
  public Opoly(int length) {
    this.length = length;
    this.position = 0;
    this.score = 100;
    this.moves = 0;
  }

  public void playGame(){
    while(score < 1000){
      updateIdx();
      render();
    }
    System.out.println("You win!" + this.position);
    System.out.println("Rounds: " + moves);
    System.out.println("Final score: " + this.score);
  }

  private void render(){
    String list = "";
    for(int i = 0; i < length; i++){
      if(this.position == i){
        list += 'o';
      }else{
        list += "*";
      }
    }
    System.out.println(list);
  }

  private int spin(){
    return ((int) (Math.random() * 5)) + 1;
  }

  private void updateIdx(){
    int newPos = this.position + spin();
    newPos = newPos % this.length;
    if(moves % 10 == 9){
      score -= 50;
    }
    moves ++;

    if(newPos % 7 == 0){
      score += 100;
    }
    if(newPos == position - 1){
      newPos -= 2;
    }

    this.position = newPos;
  }
}
