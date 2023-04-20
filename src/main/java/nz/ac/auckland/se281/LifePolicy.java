package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  private int lifePremium;
  private int discountedLifePremium;

  public LifePolicy(int ID, int age, int policyCount, PolicyType type, String[] options) {
    super(ID, type, options);

    this.lifePremium = (1 + age / 100) / 100 * this.getSumInsured();

    if (policyCount == 2) {
      this.discountedLifePremium = (int) (this.lifePremium - (this.lifePremium * 0.1));
    } else if (policyCount >= 3) {
      this.discountedLifePremium = (int) (this.lifePremium - (this.lifePremium * 0.15));
    } else {
      this.discountedLifePremium = this.lifePremium;
    }
  }

  public int getDiscountedLifePremium() {
    return discountedLifePremium;
  }

  public int getLifePremium() {
    return lifePremium;
  }
}
