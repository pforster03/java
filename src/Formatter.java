//import required libraries
import java.io.*;
import java.util.*;

public class Formatter{
  public static void main(String[] args) {
    //scan STDIN
    Scanner s = new Scanner(System.in);
    //print prompt
    System.out.print("Enter number of words to display per line > ");
    //grab a line
    int numPerLine = s.nextInt();
    
    //variables for use in upcoming loop
    String str = "";
    int count = 0;
    
    //Loop used to "physically" make the formatted string
    while(true){
      //get input
      String line = s.nextLine();
      System.out.print(">");
      //check to see if the line is empty
      if(line.length() == 0){
        //check to see if count has been set to 1, and if it has been exit the loop
        if(count == 1){
          break;
        //otherwise set count to 1
        }else{
          count = 1;
        }
      //ditto
      }else{
        count = 1;
      }
      //add the line to the final string
      str += line + "\n";
    }

    //splits string by spaces after removing all white space
    String[] arr = str.replaceAll("\r", "").replaceAll("\n", " ").replaceAll("\t", "").split(" ");

    //makes an empty arraylist to hold output
    ArrayList<String> output = new ArrayList<String>();

    //more values to be used in another upcoming loop
    int idx = 0;
    int wordsStored = 0;

    //loop through every word and either adds them onto a new line or makes a new line.
    for(String word : arr){
      //checks if 
      if(wordsStored == numPerLine){
        wordsStored = 0;
        idx ++;
      }else{
        //checks to see if the 
        if(output.size() <= idx){
          output.add("");
        }
        //set the index position of output to 1
        output.set(idx, output.get(idx) + " " + word);
        // System.out.println("the value is " + output.get(idx) + " now");
        //update wordsStored value
        wordsStored ++;
      }
    }

    //print results
    System.out.println("Output:");
    System.out.println("\b" + String.join("\n", output));
    
    
    s.close();
  }
}
