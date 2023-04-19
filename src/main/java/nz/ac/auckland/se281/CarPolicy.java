package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String registration;
  private boolean mechanicalBreakdown;
  private int carPremium;
  private int discountedCarPremium;

  public CarPolicy(int ID, int age, int policyCount, PolicyType type, String[] options) {
    super(ID, type, options);

    this.makeAndModel = options[1];
    this.registration = options[2];

    if (options[3].equalsIgnoreCase("y") || options[3].equalsIgnoreCase("yes")) {
      this.mechanicalBreakdown = true;
    } else if (options[3].equalsIgnoreCase("n") || options[3].equalsIgnoreCase("no")) {
      this.mechanicalBreakdown = false;
    }

    // Determine premium based on age and mechanical breakdown coverage
    if (age < 25) {
      if (this.mechanicalBreakdown) {
        this.carPremium = (int) (this.getSumInsured() * 0.15 + 80);
      } else {
        this.carPremium = (int) (this.getSumInsured() * 0.15);
      }
    } else {
      if (this.mechanicalBreakdown) {
        this.carPremium = (int) (this.getSumInsured() * 0.1 + 80);
      } else {
        this.carPremium = (int) (this.getSumInsured() * 0.1);
      }
    }

    if (policyCount == 2) {
      this.discountedCarPremium = (int) (this.carPremium - (this.carPremium * 0.1));
    } else if (policyCount >= 3) {
      this.discountedCarPremium = (int) (this.carPremium - (this.carPremium * 0.15));
    }
  }

  public int getBaseCarPremium() {
    return carPremium;
  }

  public int getDiscountedCarPremium() {
    return discountedCarPremium;
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
