package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

String userName;
String age;
int ageAsInteger;
int rank = 1;
ArrayList<Profile> database = new ArrayList<Profile>();
Profile profile;
  
    public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    
  }

  public void printDatabase() {
    // State the number of entries in the database
    if (database.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0","s",".");
    } else if (database.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1","",":");
    } else {
      int databaseSize = database.size();
      String databaseSizeAsString = Integer.toString(databaseSize);
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(databaseSizeAsString,"s",":");
    } 
    // display all rank, name and age of all entries in the database
    for (Profile profile : database) {
      System.out.println(" " + profile.getRank() + ": " + profile.getUserName() + ", " + profile.getAge()); 
    }
    }

  public void createNewProfile(String userName, String age) {
    //Tidy up user name
    String tidiedUserName = userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase();
    userName = tidiedUserName;

    //Check if user name is less than three letters
    if (userName.length() < 3){
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }

    // Check if valid age
    boolean isNumeric = age.chars().allMatch( Character::isDigit );
    if (isNumeric == false){
    MessageCli.INVALID_AGE.printMessage(age, userName);
      return;}
    ageAsInteger = Integer.parseInt(age);
    if (ageAsInteger < 0){
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    //Check if user name is not unique
    for (Profile profile : database) {
      if (profile.getUserName().equals(userName)) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
        return;
      }
    }
    
     //Otherwise, if all good add profile to database
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
