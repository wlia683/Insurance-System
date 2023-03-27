package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  String userName;
  String age;
  boolean isActive = false;
  int ageAsInteger;
  int rank = 1;
  ArrayList<Profile> database = new ArrayList<Profile>();
  Profile currentProfile;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {
    // State the number of entries in the database
    if (database.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (database.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
    } else {
      int databaseSize = database.size();
      String databaseSizeAsString = Integer.toString(databaseSize);
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(databaseSizeAsString, "s", ":");
    }
    // display all rank, name and age of all entries in the database, active profile will also be
    // marked
    for (Profile currentProfile : database) {
      if (currentProfile.isActive == true) {
        MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
            "*** ",
            Integer.toString(currentProfile.getRank()),
            currentProfile.getUserName(),
            Integer.toString(currentProfile.getAge()));
      } else {
        MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
            " ",
            Integer.toString(currentProfile.getRank()),
            currentProfile.getUserName(),
            Integer.toString(currentProfile.getAge()));
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // Check if a profile is already loaded and if so, it must be unloaded before creating a new
    // profile
    for (Profile currentProfile : database) {
      if (currentProfile.isActive == true) {
        MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(currentProfile.getUserName());
        return;
      }
    }

    // Standardise user name entered
    String tidiedUserName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    userName = tidiedUserName;

    // Check if user name is less than three letters
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }

    // Check if valid age
    boolean isNumeric = age.chars().allMatch(Character::isDigit);
    if (isNumeric == false) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }
    ageAsInteger = Integer.parseInt(age);
    if (ageAsInteger < 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    // Check if user name is not unique
    for (Profile currentProfile : database) {
      if (currentProfile.getUserName().equals(userName)) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
        return;
      }
    }

    // Otherwise, if all good add profile to database
    Profile currentProfile = new Profile(rank, isActive, userName, age);
    database.add(currentProfile);
    MessageCli.PROFILE_CREATED.printMessage(userName, age);
    rank++;
  }

  public void loadProfile(String userName) {

    // Standardise user name entered
    String tidiedUserName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    userName = tidiedUserName;

    // check for profile already loaded and if so, unload it
    if (database.size() == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
    } else {
      for (Profile currentProfile : database) {
        if (currentProfile.isActive == true) {
          currentProfile.setIsActive(false);
          break;
        }
      }
      // check through database for username entered, loads it and prints message if found
      for (int i = 0; i < database.size(); i++) {
        if (database.get(i).getUserName().equals(userName)) {
          currentProfile = database.get(i);
          currentProfile.isActive = true;
          MessageCli.PROFILE_LOADED.printMessage(userName);
          break;
        } else if (i == database.size() - 1) {
          MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
        }
      }
    }
  }

  public void unloadProfile() {

    // If there is nothing in the database
    if (database.size() == 0) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
      return;
    }
    // If there is something, check through for a loaded profile and if there is, unload it
    for (Profile currentProfile : database) {
      if (currentProfile.isActive == true) {
        currentProfile.setIsActive(false);
        MessageCli.PROFILE_UNLOADED.printMessage(currentProfile.getUserName());
        return;
      }
      if (currentProfile.getRank() == database.size() && currentProfile.isActive == false) {
        MessageCli.NO_PROFILE_LOADED.printMessage();
        return;
      }
    }
  }

  public void deleteProfile(String userName) {

//for (int i = 0; i < database.size(); i++) {
  //if (database.get(i).getUserName().equals(userName)) {
    //continue;
  //} else if (i == database.size() - 1) {
    //MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
    //return;
  //}
//}

  // Check if profile is loaded
  for (Profile currentProfile : database) {
    if (currentProfile.isActive == true) {
      MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(currentProfile.getUserName());
    return;
    }
  }

    // Standardise user name entered
    String tidiedUserName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    userName = tidiedUserName;

    // Check for if entered profile actually exist. If it exists, then delete profile from database and then re-rank the profiles
    for (int i = 0; i < database.size(); i++) {
      if (i == database.size() - 1) {
        MessageCli. NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
        return;
      }
      if (database.get(i).getUserName().equals(userName)) {
        database.remove(i);
        MessageCli.PROFILE_DELETED.printMessage(userName);
        for (int j = i; j < database.size(); j++) {
          database.get(j).setRank(j + 1);
        }
        return;
      }
    }
  }




  public void createPolicy(PolicyType type, String[] options) {}
}
