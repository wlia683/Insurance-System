package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String registration;
  private boolean mechanicalBreakdown;
  private int premium;
  private Profile currentProfile;

  public CarPolicy(int ID, PolicyType type, String[] options) {
    super(ID, type, options);

    this.makeAndModel = options[1];
    this.registration = options[2];
    if (options[3].equals("y")) {
      this.mechanicalBreakdown = true;
    } else if (options[3].equals("n")) {
      this.mechanicalBreakdown = false;
    }

    for (Profile profile : InsuranceSystem.database) {
      for (Policy policy : policyDatabase) {
        if (policy.getID() == profile.getID()) {
          currentProfile = profile;
          break;
        }
      }
    }

    if (currentProfile.getAge() < 25) {
      this.premium = (int) (this.getSumInsured() * 0.15);
    } else {
      this.premium = (int) (this.getSumInsured() * 0.1);
    }
  }

  public int getPremium() {
    return premium;
  }

  public String getMakeAndModel() {
    return makeAndModel;
  }

  public String getRegistration() {
    return registration;
  }

  public boolean getMechanicalBreakdown() {
    return mechanicalBreakdown;
  }
}
