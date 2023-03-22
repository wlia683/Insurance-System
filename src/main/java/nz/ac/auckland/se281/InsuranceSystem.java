package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

String userName;
String age;
int rank = 1;
ArrayList<Profile> database = new ArrayList<Profile>();
Profile profile;
  
    public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    
  }

  public void printDatabase() {
    if (database.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0","s",".");
    } else if (database.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1","",":");
    } else {
      int databaseSize = database.size();
      String databaseSizeAsString = Integer.toString(databaseSize);
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(databaseSizeAsString,"s",":");
    } 
    for (Profile profile : database) {
      System.out.println(" " + profile.getRank() + ": " + profile.getUserName() + ", " + profile.getAge()); 
    }
    }

  public void createNewProfile(String userName, String age) {
    Profile profile = new Profile(rank, userName, age);
    database.add(profile);
    MessageCli.PROFILE_CREATED.printMessage(userName, age);
    rank++;
  
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
