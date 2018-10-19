package cake;

import java.nio.file.*;
import java.io.*;


public class Cake{
  public boolean isChocolateFlavor;
  public boolean isMapleFrosting;
  static final String chocolate = readFile("chocolate.txt");
  static final String vanilla = readFile("vanilla.txt");

  // vanilla or chocolate cake, chocolate or maple frosting
  public Cake(Boolean isChocolateFlavor, Boolean isMapleFrosting){
    this.isChocolateFlavor = isChocolateFlavor;
    this.isMapleFrosting = isMapleFrosting;
  }

  //toggles canada on this Cake
  public void canada(Boolean isReallyCanada){
    this.isMapleFrosting = true;
  }

  public Boolean isCanada(){
    return this.isMapleFrosting;
  }

  public static void burnCake(Cake cake){
    cake = null;
  }

  public String getRecpie(){
    return (isChocolateFlavor ? chocolate : vanilla);
  }

  private static String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, "utf-8");
  }
}
