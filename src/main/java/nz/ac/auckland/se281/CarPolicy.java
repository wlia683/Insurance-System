package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  public CarPolicy(int ID, PolicyType type, String[] options) {
    super(ID, type, options);

    this.ID = ID;
    this.type = type;
    this.options = options;
  }
}
