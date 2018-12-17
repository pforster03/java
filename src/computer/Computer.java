package computer;

public class Computer{
  private String name;
  private int cpuSpeedMHz;
  private int ramMB;

  //main class
  public Computer(String name, int cpuSpeedMHz, int ramMB){
    //Computer uses the SI standard. 1000B = 1MB
    //See https://stackoverflow.com/q/19819763 for more info.
    this.name = name;
    this.cpuSpeedMHz = cpuSpeedMHz;
    this.ramMB = ramMB;
  }

  //self-explanatory
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  public int getRamMB(){
    return ramMB;
  }
  public void setRamMB(int ramMB){
    this.ramMB = ramMB;
  }

  public int getCpuSpeed(){
    return cpuSpeedMHz;
  }
  public void setCpuSpeed(int cpuSpeedMHz){
    this.cpuSpeedMHz = cpuSpeedMHz;
  }

  public void printReport(){
    //String.format is cool.
    System.out.println(String.format("%s\n\nCPU speed: %dMHz\nRAM: %dMHz\nMade with Computer.java\n\nCopyright (C) urmom Inc. All rights reserved.", name, cpuSpeedMHz, ramMB));
  }
}
