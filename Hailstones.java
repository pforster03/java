import java.util.*;

public class Hailstones{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Starting value > ");
    final int startingNum = scan.nextInt();
    int thisNum = startingNum;
    while(thisNum != 1){
      if(thisNum % 2 == 0){//even
        thisNum = thisNum / 2;
      }else{//odd
        thisNum = thisNum * 3 + 1;
      }
    }

    // avoid memory leak
    scan.close();
  }
}
