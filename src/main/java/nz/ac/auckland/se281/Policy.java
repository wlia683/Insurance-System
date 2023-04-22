package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class Policy {

  private int identity;
  private String[] options;
  PolicyType type;
  private double sumInsured;
  private int policyCount;

  public Policy(int identity, int policyCount, PolicyType type, String[] options) {

    this.identity = identity;
    this.type = type;
    this.sumInsured = Double.parseDouble(options[0]);
    this.policyCount = policyCount;
    this.options = options;
  }

  public int getPolicyCount() {
    return policyCount;
  }

  public int getIdentity() {
    return identity;
  }

  public String[] getOptions() {
    return options;
  }

  public PolicyType getType() {
    return type;
  }

  public double getSumInsured() {
    return sumInsured;
  }
}
