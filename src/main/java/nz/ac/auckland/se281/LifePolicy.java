package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  private double lifePremium;
  private double discountedLifePremium;

  public LifePolicy(
      Profile profile, int ID, int age, int policyCount, PolicyType type, String[] options) {
    super(ID, policyCount, type, options);
    this.lifePremium = ((double) age / 100 + 1) / 100 * (double) this.getSumInsured();
  }

  public double getBaseLifePremium() {
    return this.lifePremium;
  }

  public int getDiscountedLifePremium() {
    if (this.getPolicyCount() == 2) {
      discountedLifePremium = lifePremium * 0.9;
    } else if (this.getPolicyCount() >= 3) {
      discountedLifePremium = lifePremium * 0.8;
    } else {
      discountedLifePremium = lifePremium;
    }
    return (int) discountedLifePremium;
  }
}
