package nz.ac.auckland.se281;

public abstract class Policy {

  protected int sumInsured;
  protected double premium;

  public Policy(int sumInsured, double premium) {
    this.sumInsured = sumInsured;
    this.premium = premium;
  }
}
