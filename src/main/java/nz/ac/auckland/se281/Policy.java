package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class Policy {

  protected String[] options;
  PolicyType type;

  public Policy(PolicyType type, String[] options) {

    this.type = type;
    this.options = options;
  }

  public String[] getOptions() {
    return options;
  }

  public PolicyType getType() {
    return type;
  }
}
