package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String registration;
  private boolean mechanicalBreakdown;
  private int basePremium;
  private int discountedPremium;

  public CarPolicy(int ID, int age, int policyCount, PolicyType type, String[] options) {
    super(ID, type, options);

    this.makeAndModel = options[1];
    this.registration = options[2];
    if (options[3].equals("y")) {
      this.mechanicalBreakdown = true;
    } else if (options[3].equals("n")) {
      this.mechanicalBreakdown = false;
    }

    // Determine premium based on age and mechanical breakdown coverage
    if (age < 25) {
      if (this.mechanicalBreakdown) {
        this.basePremium = (int) (this.getSumInsured() * 0.15 + 80);
      } else {
        this.basePremium = (int) (this.getSumInsured() * 0.15);
      }
    } else {
      if (this.mechanicalBreakdown) {
        this.basePremium = (int) (this.getSumInsured() * 0.1 + 80);
      } else {
        this.basePremium = (int) (this.getSumInsured() * 0.1);
      }
    }

    if (policyCount == 2) {
      this.discountedPremium = (int) (this.basePremium - (this.basePremium * 0.1));
    } else if (policyCount >= 3) {
      this.discountedPremium = (int) (this.basePremium - (this.basePremium * 0.15));
    }
  }

  public int getBasePremium() {
    return basePremium;
  }

  public int getDiscountedPremium() {
    return discountedPremium;
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
