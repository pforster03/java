import java.io.*;
import java.util.*;

public class DoubleLetters{
  public static void main(String[] args) {
    //scan STDIN
    Scanner s = new Scanner(System.in);
    //print prompt
    System.out.print("Enter text to duplicate > ");
    //grab a line
    String line = s.nextLine();
    s.close();

    String finalString = "";
    //loop through each character...
    for(int characterIdx = 0; characterIdx < line.length(); characterIdx++){
      //...and duplicate it
      finalString += line.charAt(characterIdx);
      finalString += line.charAt(characterIdx);
    }
    System.out.print(finalString);
  }
}
