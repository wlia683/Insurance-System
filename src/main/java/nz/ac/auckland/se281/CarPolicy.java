package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String registration;
  private boolean mechanicalBreakdown;
  private double carPremium;
  private double discountedCarPremium;

  public CarPolicy(
      Profile profile, int ID, int age, int policyCount, PolicyType type, String[] options) {
    super(ID, policyCount, type, options);

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
        this.carPremium = this.getSumInsured() * 0.15 + 80;
      } else {
        this.carPremium = this.getSumInsured() * 0.15;
      }
    } else {
      if (this.mechanicalBreakdown) {
        this.carPremium = this.getSumInsured() * 0.1 + 80;
      } else {
        this.carPremium = this.getSumInsured() * 0.1;
      }
    }
  }

  public double getBaseCarPremium() {
    return carPremium;
  }

  public void setDiscountedCarPremium(double discountedCarPremium) {
    this.discountedCarPremium = discountedCarPremium;
  }

  public int getDiscountedCarPremium() {
    return (int) discountedCarPremium;
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
