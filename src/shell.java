import java.io.*;

public class shell{
  public static void main(String args[]){
    try{
      Runtime rt = Runtime.getRuntime();
      String[] commands = {"cmd.exe","/k","echo hi"};
      Process proc = rt.exec(commands);

      BufferedReader stdInput = new BufferedReader(new
         InputStreamReader(proc.getInputStream()));

      BufferedReader stdError = new BufferedReader(new
         InputStreamReader(proc.getErrorStream()));

      // read the output from the command
      System.out.println("Here is the standard output of the command:\n");
      String s = null;
      while ((s = stdInput.readLine()) != null) {
        System.out.println(s);
      }

      // read any errors from the attempted command
      System.out.println("Here is the standard error of the command (if any):\n");
      while ((s = stdError.readLine()) != null) {
        System.out.println(s);
      }
    }catch(IOException e){
      System.out.println(e);
    }
  }
}
