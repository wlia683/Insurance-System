package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

String userName;
String age;
  
  ArrayList InsuranceSystem = new ArrayList();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  
  }

  public void printDatabase() {
    if (InsuranceSystem.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0","s",".");
    } else if (InsuranceSystem.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1","",".");
      System.out.println(InsuranceSystem.get(0));
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(MaxProfile,"s",".");
      System.out.println(ArrayList.Insurancesystem());    
    }
  }

  public void createNewProfile(String userName, String age) {
    Profile person = new Profile();
    person.create();
   
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
    this.userName = userName;
  }

  public void unloadProfile() {
  
  }

  public void deleteProfile(String userName) {
   InsuranceSystem.remove(userName);
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
