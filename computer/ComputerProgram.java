package computer;

import java.io.*;
import java.util.*;

public class ComputerProgram{
  public static void main(String[] args) {
    Computer computer = new Computer("Epic PC", 4000, 32000);
    computer.printReport();
  }
}
