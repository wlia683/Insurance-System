package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  private double lifePremium;
  private double discountedLifePremium;

  public LifePolicy(
      Profile profile, int ID, int age, int policyCount, PolicyType type, String[] options) {
    super(ID, policyCount, type, options);
    this.lifePremium = ((double) age / 100 + 1) / 100 * (double) this.getSumInsured();
    if (profile.getPolicyCount() == 2) {
      this.discountedLifePremium = this.lifePremium - (this.lifePremium * 0.1);
    } else if (profile.getPolicyCount() >= 3) {
      this.discountedLifePremium = this.lifePremium - (this.lifePremium * 0.15);
    } else {
      this.discountedLifePremium = this.lifePremium;
    }
  }

  public int getDiscountedLifePremium() {
    return (int) discountedLifePremium;
  }

  public int getLifePremium() {
    return (int) lifePremium;
  }
}
