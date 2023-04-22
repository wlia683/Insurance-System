package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  private double lifePremium;
  private double discountedLifePremium;

  public LifePolicy(
      Profile profile, int identity, int age, int policyCount, PolicyType type, String[] options) {
    super(identity, policyCount, type, options);
    this.lifePremium = ((double) age / 100 + 1) / 100 * (double) this.getSumInsured();
  }

  public double getBaseLifePremium() {
    return this.lifePremium;
  }

  public void setDiscountedLifePremium(double discountedLifePremium) {
    this.discountedLifePremium = discountedLifePremium;
  }

  public int getDiscountedLifePremium() {
    return (int) discountedLifePremium;
  }
}
