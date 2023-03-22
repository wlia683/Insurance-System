package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

String userName;
String age;
ArrayList<Profile> database = new ArrayList<Profile>();
private Profile Profile;
private nz.ac.auckland.se281.Profile person;
  
    public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    
  }

  public void printDatabase() {
    if (database.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0","s",".");
    } else if (database.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1","",".");
      System.out.println(database.get(0));
    } else {
      int databaseSize = database.size();
      String databaseSizeAsString = Integer.toString(databaseSize);
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(databaseSizeAsString,"s",".");
      for (int i = 0; i < database.size(); i++) {
        System.out.println(database.get(i));
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    this.person = new Profile(userName, age);
    database.add(this.person);
   
  }

  public void loadProfile(String userName) {

  }

  public void unloadProfile() {
  
  }

  public void deleteProfile(String userName) {
 
  }

  public void createPolicy(PolicyType type, String[] options) {

  }
}
