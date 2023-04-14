package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  String userName;
  String age;
  boolean isActive = false;
  int ageAsInteger;
  int rank = 1;
  ArrayList<Profile> database = new ArrayList<Profile>();
  ArrayList<Policy> policyDatabase = new ArrayList<Policy>();
  Profile currentProfile;
  Policy currentPolicy;
  HashMap<Integer, ArrayList<Policy>> policyMap;
  int ID = (int) (Math.random() * 1000000);
  int sumInsured;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void profilePolicyManagement(
      ArrayList<Profile> database, ArrayList<Policy> policyDatabase) {
    this.database = database;
    this.policyDatabase = policyDatabase;
    this.policyMap = new HashMap<Integer, ArrayList<Policy>>();

    for (Profile currentProfile : database) {
      ArrayList<Policy> policies = new ArrayList<Policy>();
      for (Policy currentPolicy : policyDatabase) {
        if (currentPolicy.getID() == currentProfile.getID()) {
          policies.add(currentPolicy);
        }
      }
      policyMap.put(currentProfile.getID(), policies);
    }
  }

  public ArrayList<Policy> getPolicies(Profile currentProfile) {
    return policyMap.get(currentProfile.getRank());
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
      int policyCount = 0;
      for (Policy currentPolicy : policyDatabase) {
        if (currentPolicy.getID() == currentProfile.getID()) {
          policyCount++;
        }
      }
      currentProfile.setPolicyCount(policyCount);
      if (currentProfile.isActive == true) {
        if (currentProfile.policyCount == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              "*** ",
              Integer.toString(currentProfile.getRank()),
              currentProfile.getUserName(),
              Integer.toString(currentProfile.getAge()),
              Integer.toString(currentProfile.getPolicyCount()),
              "y");
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              "*** ",
              Integer.toString(currentProfile.getRank()),
              currentProfile.getUserName(),
              Integer.toString(currentProfile.getAge()),
              Integer.toString(currentProfile.getPolicyCount()),
              "ies");
        }
      } else {
        if (currentProfile.policyCount == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              " ",
              Integer.toString(currentProfile.getRank()),
              currentProfile.getUserName(),
              Integer.toString(currentProfile.getAge()),
              Integer.toString(currentProfile.getPolicyCount()),
              "y");
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              " ",
              Integer.toString(currentProfile.getRank()),
              currentProfile.getUserName(),
              Integer.toString(currentProfile.getAge()),
              Integer.toString(currentProfile.getPolicyCount()),
              "ies");
        }
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
    Profile currentProfile = new Profile(rank, ID, isActive, userName, age);
    database.add(currentProfile);
    MessageCli.PROFILE_CREATED.printMessage(userName, age);
    rank++;
    ID = (int) (Math.random() * 1000000);
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

    // Standardise user name entered
    String tidiedUserName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    userName = tidiedUserName;

    // Check if database is empty
    if (database.size() == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
      return;
    }

    // Check the profile is loaded
    for (Profile currentProfile : database) {
      if ((currentProfile.getUserName().equals(userName)) && (currentProfile.isActive == true)) {
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(currentProfile.getUserName());
        return;
      }
    }

    // Delete profile from database and then re-rank the remaining profiles. Or if name is not found
    // in the database, say so.
    for (int i = 0; i < database.size(); i++) {
      if (database.get(i).getUserName().equals(userName)) {
        database.remove(i);
        MessageCli.PROFILE_DELETED.printMessage(userName);
        for (int j = i; j < database.size(); j++) {
          database.get(j).setRank(j + 1);
        }
        return;
      }
      if (i == database.size() - 1) {
        MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
        return;
      }
    }
  }

  public void createPolicy(PolicyType type, String[] options) {

    // check if no loaded profile
    if (currentProfile == null || currentProfile.isActive == false) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      return;
    }
    // if CAR Policytype
    if (type == PolicyType.CAR) {
      Policy currentPolicy = new CarPolicy(type, options);
      policyDatabase.add(currentPolicy);
      MessageCli.NEW_POLICY_CREATED.printMessage(currentProfile.getUserName(), type.toString());
    }
  }
}
