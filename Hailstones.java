import java.util.*;
import java.math.*;
import java.io.*;
import java.nio.*;
import java.io.File;


public class Hailstones{
  static BigInteger thisNum;
  static BigInteger biggest;
  static BigInteger count;

  public static void main(String[] args) {
    if(Arrays.stream(args).anyMatch("--help"::equals)){
      System.out.println(String.join(
        System.getProperty("line.separator"),
        "Usage",
        "Hailstones -|infile -|outfile|null",
        "Computes the hailstones of a number. Pass it with arguments to read the number from a file and write it to the outfile. Use - to prompt for a number, and - to display the numbers to the terminal.",
        "While it is running, press Enter to show progress. Using null as an outfile removes most output."
      ));
      return;
    }

    Scanner scan = null;
    String string = null;
    if(args.length > 0 && !args[0].equals("-")){
      System.err.println("Loading number from file " + args[0]);
      File file = new File(args[0]);
      try {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        string = new String(data, "UTF-8").trim();
        System.err.println("Loaded number from file " + args[0]);
      } catch(IOException e) {
        System.err.println("Could not load file " + args[0]);
        System.exit(1);
      }
    }else{
      scan = new Scanner(System.in);
      System.err.print("Enter a positive hailstone starting value > ");
      string = scan.nextLine();
    }

    File fout = null;
    FileWriter fos = null;


    if(args.length > 1 && !args[1].equals("-") && !args[1].equals("null")){
      fout = new File(args[1]);
      try{
        fos = new FileWriter(fout);
      } catch(IOException e) {
        System.err.println("Could not load file " + args[1]);
        System.exit(1);
      }

      System.err.println("Writing output to file " + args[1]);
    }

    final BigInteger startingNum = new BigInteger(string);
    final BigInteger zero = BigInteger.valueOf(0);
    final BigInteger one = BigInteger.valueOf(1);
    final BigInteger two = BigInteger.valueOf(2);
    final BigInteger three = BigInteger.valueOf(3);
    thisNum = startingNum;
    biggest = BigInteger.valueOf(0);
    count = BigInteger.valueOf(0);

    Thread consoleWatcher = new Thread() {
      @Override
      public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true){// E
          scanner.nextLine();
          System.err.println("Working on " + Hailstones.thisNum + ", iteration #" + Hailstones.count);
        }
      }
    };

    consoleWatcher.start();

    while(!thisNum.equals(one)){
      if(thisNum.compareTo(biggest) == 1) biggest = thisNum;//store the biggest number
      if(args.length > 1 && !args[1].equals("-")){
        if(!args[1].equals("null")){
          try{
            fos.write(thisNum + System.getProperty("line.separator"));
            fos.flush();
          }catch(IOException e){
            e.printStackTrace();
            System.exit(2);
          }
        }
      }else{
        System.out.println(thisNum);
      }

      if(thisNum.remainder(two).equals(zero)){//even
        thisNum = thisNum.divide(two);
      }else{//odd
        thisNum = thisNum.multiply(three).add(one);
      }

      count = count.add(BigInteger.valueOf(1));
    }

    consoleWatcher.interrupt();

    System.err.println("start: " + startingNum);
    System.err.println("term count: " + count);
    System.err.println("biggest: " + biggest);
    // avoid memory leak
    if(args.length <= 0){
      scan.close();
    }

    System.exit(0);
  }
}
