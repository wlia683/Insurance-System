package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  private double lifePremium;

  public LifePolicy(
      Profile profile, int ID, int age, int policyCount, PolicyType type, String[] options) {
    super(ID, policyCount, type, options);
    this.lifePremium = ((double) age / 100 + 1) / 100 * (double) this.getSumInsured();
  }

  public double getBaseLifePremium() {
    return this.lifePremium;
  }
}
