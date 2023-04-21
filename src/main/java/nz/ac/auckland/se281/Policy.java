package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class Policy {

  private int ID;
  private String[] options;
  PolicyType type;
  private double sumInsured;
  private int policyCount;

  public Policy(int ID, int policyCount, PolicyType type, String[] options) {

    this.ID = ID;
    this.type = type;
    this.sumInsured = Double.parseDouble(options[0]);
    this.policyCount = policyCount;
    this.options = options;
  }

  public int getPolicyCount() {
    return policyCount;
  }

  public int getID() {
    return ID;
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
