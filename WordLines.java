import java.util.*;

public class WordLines{
  static int numChars = 0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("> ");
    System.out.print(spaceToLine(scan.nextLine()));
    System.out.println("Your input has " + numChars + " non-blank characters.");
  }

  private static String spaceToLine(String string){
    String ret = "";
    String[] split = string.split(" ");
    numChars = 0;
    for(String s : split){
      if(s.length() > 0){
        numChars += s.length();
        ret += s + System.getProperty("line.separator");
      }
    }
    return ret;
  }
}
