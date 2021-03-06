import java.util.*;

public class WordLines{
  static int numChars = 0;

  public static void main(String[] args) {
    // make a prompt
    Scanner scan = new Scanner(System.in);
    // set prompt
    System.out.print("> ");
    //get a line
    System.out.print(spaceToLine(scan.nextLine()));
    System.out.println("Your input has " + numChars + " non-blank characters.");
  }

  private static String spaceToLine(String string){
    String ret = "";
    // split the string into an array of spaces
    String[] split = string.split(" ");
    numChars = 0;
    for(String s : split){
      //exclude empty strings
      if(s.length() > 0){
        numChars += s.length();
        // CRLF on Windows, LF on *nix
        ret += s + System.getProperty("line.separator");
      }
    }
    return ret;
  }
}
