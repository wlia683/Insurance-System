package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String registration;
  private String mechanicalBreakdown;

  public CarPolicy(int ID, PolicyType type, String[] options) {
    super(ID, type, options);

    this.ID = ID;
    this.type = type;
    this.options = options;
    this.makeAndModel = options[1];
    this.registration = options[2];
    this.mechanicalBreakdown = options[3];
  }

  public String getMakeAndModel() {
    return makeAndModel;
  }

  public String getRegistration() {
    return registration;
  }

  public String getMechanicalBreakdown() {
    return mechanicalBreakdown;
  }
}
