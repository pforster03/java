import java.util.*;
import java.math.*;
import java.io.*;
import java.nio.*;

public class Hailstones{
  public static void main(String[] args) {
    Scanner scan = null;
    String string = null;
    if(args.length > 0 && !args[0].equals("-")){
      System.out.println("Loading number from file " + args[0]);
      File file = new File(args[0]);
      try {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        string = new String(data, "UTF-8").trim();
        System.out.println("Loaded number from file " + args[0]);
      } catch(IOException e) {
        System.out.println("Could not load file " + args[0]);
        System.exit(1);
      }
    }else{
      scan = new Scanner(System.in);
      System.out.print("Enter a positive hailstone starting value > ");
      string = scan.nextLine();
    }

    File fout = null;
    FileOutputStream fos = null;
    BufferedWriter bw = null;


    if(args.length > 1 && !args[1].equals("-")){
      fout = new File(args[1]);
      Files.createNewFile();
      try{
        fos = new FileOutputStream(fout);
      } catch(IOException e) {
        System.out.println("Could not load file " + args[1]);
        System.exit(1);
      }
      bw = new BufferedWriter(new OutputStreamWriter(fos));
    }

    final BigInteger startingNum = new BigInteger(string);
    final BigInteger zero = BigInteger.valueOf(0);
    final BigInteger one = BigInteger.valueOf(1);
    final BigInteger two = BigInteger.valueOf(2);
    final BigInteger three = BigInteger.valueOf(3);
    BigInteger thisNum = startingNum;
    BigInteger biggest = BigInteger.valueOf(0);
    while(!thisNum.equals(one)){
      if(thisNum.compareTo(biggest) == 1) biggest = thisNum;//store the biggest number
      if(args.length > 1 && !args[1].equals("-")){
        bw.write(thisNum + "");
        bw.newLine();
      }else{
        System.out.println(thisNum);
      }

      if(thisNum.remainder(two).equals(zero)){//even
        thisNum = thisNum.divide(two);
      }else{//odd
        thisNum = thisNum.multiply(three).add(one);
      }
    }

    System.out.println("start: " + startingNum);
    System.out.println("term count");
    System.out.println("biggest: " + biggest);
    // avoid memory leak
    if(args.length <= 0){
      scan.close();
    }
  }
}
