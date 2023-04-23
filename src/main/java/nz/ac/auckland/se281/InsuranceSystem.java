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
  ArrayList<Policy> policyDatabase = new ArrayList<Policy>();
  Profile currentProfile;
  Policy currentPolicy;
  int identity = 0;

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
    // Calculate variables that may be used in printing the database
    calculatePolicyCount();
    calculateDiscountedPolicies();
    calculateTotalPremium();

    // display all rank, name and age of all entries in the database, active profile will also be
    // marked
    for (Profile profile : database) {
      if (profile.isActive == true) {
        if (profile.getPolicyCount() == 1) {
          // for active profile with only one policy
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              Integer.toString(profile.getRank()),
              profile.getUserName(),
              Integer.toString(profile.getAge()),
              Integer.toString(profile.getPolicyCount()),
              "y",
              Integer.toString(profile.getTotalPremium()));
          // check profile against policies in policy arraylist and if appropriate print the
          // policies found
          for (Policy policy : policyDatabase) {
            if (policy.getIdentity() == profile.getIdentity() && policy instanceof CarPolicy) {
              CarPolicy car = (CarPolicy) policy;
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  car.getMakeAndModel(),
                  Integer.toString((int) car.getSumInsured()),
                  Integer.toString((int) car.getBaseCarPremium()),
                  Integer.toString(car.getDiscountedCarPremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof LifePolicy) {
              LifePolicy life = (LifePolicy) policy;
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  Integer.toString((int) life.getSumInsured()),
                  Integer.toString((int) life.getBaseLifePremium()),
                  Integer.toString(life.getDiscountedLifePremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof HomePolicy) {
              HomePolicy home = (HomePolicy) policy;
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  home.getAddress(),
                  Integer.toString((int) home.getSumInsured()),
                  Integer.toString((int) home.getBaseHomePremium()),
                  Integer.toString(home.getDiscountedHomePremium()));
            }
          }
        } else {
          // for active profile with multiple or zero policies
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              Integer.toString(profile.getRank()),
              profile.getUserName(),
              Integer.toString(profile.getAge()),
              Integer.toString(profile.getPolicyCount()),
              "ies",
              Integer.toString(profile.getTotalPremium()));
          for (Policy policy : policyDatabase) {
            if (policy.getIdentity() == profile.getIdentity() && policy instanceof CarPolicy) {
              CarPolicy car = (CarPolicy) policy;
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  car.getMakeAndModel(),
                  Integer.toString((int) car.getSumInsured()),
                  Integer.toString((int) car.getBaseCarPremium()),
                  Integer.toString(car.getDiscountedCarPremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof LifePolicy) {
              LifePolicy life = (LifePolicy) policy;
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  Integer.toString((int) life.getSumInsured()),
                  Integer.toString((int) life.getBaseLifePremium()),
                  Integer.toString(life.getDiscountedLifePremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof HomePolicy) {
              HomePolicy home = (HomePolicy) policy;
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  home.getAddress(),
                  Integer.toString((int) home.getSumInsured()),
                  Integer.toString((int) home.getBaseHomePremium()),
                  Integer.toString(home.getDiscountedHomePremium()));
            }
          }
        }
      } else {
        if (profile.getPolicyCount() == 1) {
          // for non-active profile with one policy
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              " ",
              Integer.toString(profile.getRank()),
              profile.getUserName(),
              Integer.toString(profile.getAge()),
              Integer.toString(profile.getPolicyCount()),
              "y",
              Integer.toString(profile.getTotalPremium()));
          for (Policy policy : policyDatabase) {
            if (policy.getIdentity() == profile.getIdentity() && policy instanceof CarPolicy) {
              CarPolicy car = (CarPolicy) policy;
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  car.getMakeAndModel(),
                  Integer.toString((int) car.getSumInsured()),
                  Integer.toString((int) car.getBaseCarPremium()),
                  Integer.toString(car.getDiscountedCarPremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof LifePolicy) {
              LifePolicy life = (LifePolicy) policy;
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  Integer.toString((int) life.getSumInsured()),
                  Integer.toString((int) life.getBaseLifePremium()),
                  Integer.toString(life.getDiscountedLifePremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof HomePolicy) {
              HomePolicy home = (HomePolicy) policy;
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  home.getAddress(),
                  Integer.toString((int) home.getSumInsured()),
                  Integer.toString((int) home.getBaseHomePremium()),
                  Integer.toString(home.getDiscountedHomePremium()));
            }
          }
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              // for non-active profile with multiple or zero policies
              " ",
              Integer.toString(profile.getRank()),
              profile.getUserName(),
              Integer.toString(profile.getAge()),
              Integer.toString(profile.getPolicyCount()),
              "ies",
              Integer.toString(profile.getTotalPremium()));
          for (Policy policy : policyDatabase) {
            if (policy.getIdentity() == profile.getIdentity() && policy instanceof CarPolicy) {
              CarPolicy car = (CarPolicy) policy;
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  car.getMakeAndModel(),
                  Integer.toString((int) car.getSumInsured()),
                  Integer.toString((int) car.getBaseCarPremium()),
                  Integer.toString(car.getDiscountedCarPremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof LifePolicy) {
              LifePolicy life = (LifePolicy) policy;
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  Integer.toString((int) life.getSumInsured()),
                  Integer.toString((int) life.getBaseLifePremium()),
                  Integer.toString(life.getDiscountedLifePremium()));
            } else if (policy.getIdentity() == profile.getIdentity()
                && policy instanceof HomePolicy) {
              HomePolicy home = (HomePolicy) policy;
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  home.getAddress(),
                  Integer.toString((int) home.getSumInsured()),
                  Integer.toString((int) home.getBaseHomePremium()),
                  Integer.toString(home.getDiscountedHomePremium()));
            }
          }
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
    int policyCount = 0;
    Profile currentProfile = new Profile(rank, identity, isActive, userName, age, policyCount);
    database.add(currentProfile);
    MessageCli.PROFILE_CREATED.printMessage(userName, age);
    rank++;
    identity++;
  }

  public void loadProfile(String userName) {

    // Standardise user name entered
    String titleCaseName =
        userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    userName = titleCaseName;

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

    // Delete profile from databases and then re-rank the remaining profiles. Or if name is not
    // found
    // in the database, say so.
    for (int i = 0; i < database.size(); i++) {
      if (database.get(i).getUserName().equals(userName)) {
        database.remove(i);
        MessageCli.PROFILE_DELETED.printMessage(userName);
        for (int j = i; j < database.size(); j++) {
          database.get(j).setRank(j + 1);
        }
        for (int k = 0; k < policyDatabase.size(); k++) {
          if (policyDatabase.get(k).getIdentity() == i) {
            policyDatabase.remove(k);
          }
        }
        rank--;
        return;
      }
      if (i == database.size() - 1) {
        MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
        return;
      }
    }
  }

  // Calculate number of policies for each profile
  public void calculatePolicyCount() {
    for (Profile profile : database) {
      int counter = 0;
      for (Policy policy : policyDatabase) {
        if (policy.getIdentity() == profile.getIdentity()) {
          counter++;
        }
      }
      profile.setPolicyCount(counter);
    }
  }

  public void calculateDiscountedPolicies() {
    // before calculating the discounts, we determine the number of policies each profile has
    calculatePolicyCount();
    for (Profile profile : database) {
      for (Policy policy : policyDatabase) {
        // if a policy has an Identity that matches the profile of interest and is a Car Policy
        if (profile.getIdentity() == policy.getIdentity() && policy instanceof CarPolicy) {
          CarPolicy car = (CarPolicy) policy;
          if (profile.getPolicyCount() == 2) {
            car.setDiscountedCarPremium(car.getBaseCarPremium() * 0.9);
          } else if (profile.getPolicyCount() >= 3) {
            car.setDiscountedCarPremium(car.getBaseCarPremium() * 0.8);
          } else {
            car.setDiscountedCarPremium(car.getBaseCarPremium());
          }
          // if a policy has an Identity that matches the profile of interest and is a home policy
        } else if (profile.getIdentity() == policy.getIdentity() && policy instanceof HomePolicy) {
          HomePolicy home = (HomePolicy) policy;
          if (profile.getPolicyCount() == 2) {
            home.setDiscountedHomePremium(home.getBaseHomePremium() * 0.9);
          } else if (profile.getPolicyCount() >= 3) {
            home.setDiscountedHomePremium(home.getBaseHomePremium() * 0.8);
          } else {
            home.setDiscountedHomePremium(home.getBaseHomePremium());
          }
          // if a policy has an Identity that matches the profile of interest and is a life policy
        } else if (profile.getIdentity() == policy.getIdentity() && policy instanceof LifePolicy) {
          LifePolicy life = (LifePolicy) policy;
          if (profile.getPolicyCount() == 2) {
            life.setDiscountedLifePremium(life.getBaseLifePremium() * 0.9);
          } else if (profile.getPolicyCount() >= 3) {
            life.setDiscountedLifePremium(life.getBaseLifePremium() * 0.8);
          } else {
            life.setDiscountedLifePremium(life.getBaseLifePremium());
          }
        }
      }
    }
  }

  // Calculate total premium (with multi-policy discount if appropriate) to pay for each profile
  public void calculateTotalPremium() {
    for (Profile profile : database) {
      double totalPremium = 0;
      for (Policy policy : policyDatabase) {
        if (profile.getIdentity() == policy.getIdentity() && policy instanceof CarPolicy) {
          CarPolicy car = (CarPolicy) policy;
          totalPremium += car.getBaseCarPremium();
        } else if (profile.getIdentity() == policy.getIdentity() && policy instanceof HomePolicy) {
          HomePolicy home = (HomePolicy) policy;
          totalPremium += home.getBaseHomePremium();
        } else if (profile.getIdentity() == policy.getIdentity() && policy instanceof LifePolicy) {
          LifePolicy life = (LifePolicy) policy;
          totalPremium += life.getBaseLifePremium();
        }
      }
      // determine policy count and then based on that apply the appropriate discount and finally,
      // set the total premium to pay
      calculatePolicyCount();
      if (profile.getPolicyCount() == 2) {
        totalPremium = (totalPremium * 0.9);
      } else if (profile.getPolicyCount() >= 3) {
        totalPremium = (totalPremium * 0.8);
      }
      profile.setTotalPremium(totalPremium);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    calculatePolicyCount();
    // check if no loaded profile
    if (currentProfile == null || currentProfile.isActive == false) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      return;
    }

    // check type, then create policy as appropriate
    switch (type) {
      case CAR:
        currentProfile.setPolicyCount(currentProfile.getPolicyCount() + 1);
        Policy carPolicy =
            new CarPolicy(
                currentProfile,
                currentProfile.getIdentity(),
                currentProfile.getAge(),
                currentProfile.getPolicyCount(),
                type,
                options);
        policyDatabase.add(carPolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            (type.toString().toLowerCase()), currentProfile.getUserName());
        break;

      case HOME:
        currentProfile.setPolicyCount(currentProfile.getPolicyCount() + 1);
        Policy homePolicy =
            new HomePolicy(
                currentProfile,
                currentProfile.getIdentity(),
                currentProfile.getPolicyCount(),
                type,
                options);
        policyDatabase.add(homePolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            type.toString().toLowerCase(), currentProfile.getUserName());
        break;

      case LIFE:

        // Check if over age
        if (currentProfile.getAge() >= 100) {
          MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(currentProfile.getUserName());
          return;
        }

        // check for existing life policy
        for (Policy currentPolicy : policyDatabase) {
          if (currentPolicy.getIdentity() == currentProfile.getIdentity()
              && currentPolicy.getType() == PolicyType.LIFE) {
            MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(currentProfile.getUserName());
            return;
          }
        }

        // otherwise create life policy, if no issues
        currentProfile.setPolicyCount(currentProfile.getPolicyCount() + 1);
        Policy lifePolicy =
            new LifePolicy(
                currentProfile,
                currentProfile.getIdentity(),
                currentProfile.getAge(),
                currentProfile.getPolicyCount(),
                type,
                options);
        policyDatabase.add(lifePolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            type.toString().toLowerCase(), currentProfile.getUserName());
        break;
    }
  }
}
