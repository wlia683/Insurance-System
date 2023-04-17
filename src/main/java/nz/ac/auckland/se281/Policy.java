package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class Policy {

  protected int ID;
  protected String[] options;
  PolicyType type;
  private int sumInsured;

  public Policy(int ID, PolicyType type, String[] options) {

    this.ID = ID;
    this.type = type;
    this.options = options;
    this.sumInsured = Integer.parseInt(options[0]);
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

  public int getSumInsured() {
    return sumInsured;
  }
}
