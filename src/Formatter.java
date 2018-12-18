import java.io.*;
import java.util.*;

public class Formatter{
  public static void main(String[] args) {
    //scan STDIN
    Scanner s = new Scanner(System.in);
    //print prompt
    System.out.print("Enter nummber of words to display per line > ");
    //grab a line
    int numPerLine = s.nextInt();
    String str = "";

    int count = 0;

    while(true){
      String line = s.nextLine();
      System.out.print(">");
      if(line.length() == 0){
        if(count == 1){
          break;
        }else{
          count = 1;
        }
      }else{
        count = 1;
      }
      str += line + "\n";
    }

    String[] arr = str.replaceAll("\r", "").replaceAll("\n", " ").replaceAll("\t", "").split(" ");

    ArrayList<String> output = new ArrayList<String>();

    int idx = 0;
    int wordsStored = 0;

    for(String word : arr){
      if(wordsStored == numPerLine){
        wordsStored = 0;
        idx ++;
      }else{
        if(output.size() <= idx){
          output.add("");
        }
        output.set(idx, output.get(idx) + " " + word);
        // System.out.println("the value is " + output.get(idx) + " now");
        wordsStored ++;
      }
    }

    System.out.println("Output:");
    System.out.println("\b" + String.join("\n", output));

    s.close();
  }
}
