package cake;

import java.io.*;
import java.util.*;

public class CakeProgram{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Would you like a chocolate cake (instead of a vanilla one)? Say true for a chocolate cake, and false for a vanilla cake. > ");
    Boolean isChocolate = scan.nextBoolean();
    System.out.println();
    System.out.print("Would you like maple frosting (instead of chocolate frosting)? Say true for maple frosting, and false for chocolate frosting. > ");
    Boolean isMaple = scan.nextBoolean();
    System.out.println();
    final Cake cake = new Cake(isChocolate, isMaple);
    System.out.println(cake.getRecpie());
  }
}
