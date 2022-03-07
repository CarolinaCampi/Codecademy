public class MiniDroidMaker {
  String name;
  int batteryLevel;

  public Droid(String droidName){
    name = droidName;
    batteryLevel = 100;
  }

  public String toString(){
    return "Hello! I'm " + this.name + ", the droid."; 
  }

  public void performTask(String task){
    System.out.println(name + " is performing the following task: " + task + ".");
    this.batteryLevel -= 10;
  }

  public void energyReport(){
    System.out.println(name + "'s battery level is " + batteryLevel + ".");
  }

  public void chargeBattery(){
    batteryLevel = 100;
    System.out.println(name + "'s battery level is back to 100%!");
  }

  public static void main(String[] args){
    Droid codey = new Droid("Codey");
    
    System.out.println(codey.toString());
    codey.performTask("thinking of an algorithm");
    codey.energyReport();
    codey.performTask("dancing");
    codey.energyReport();
    codey.chargeBattery();

  }

}
