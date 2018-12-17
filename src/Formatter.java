import java.io.*;
import java.util.*;

public class Formatter{
  public static void main(String[] args) {
    //scan STDIN
    Scanner s = new Scanner(System.in);
    //print prompt
    System.out.print("Enter nummber of words to display per line > ");
    //grab a line
    int num = s.nextInt();
    String str = "";

    int count = 0;

    while(true){
      String line = s.nextLine();
      if(line.length() == 0){
        if(count == 1){
          break;
        }else{
          count = 1;
        }
      }else{
        count = 1;
      }
      str += line;
    }

    str = str.replaceAll("\n", "").replaceAll("\t", "");

    System.out.println(str);

    s.close();
  }
}
