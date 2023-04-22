package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;
  private double homePremium;

  public HomePolicy(Profile profile, int ID, int policyCount, PolicyType type, String[] options) {
    super(ID, policyCount, type, options);

    this.address = options[1];
    if (options[2].equals("y")) {
      this.rental = true;
    } else if (options[2].equals("n")) {
      this.rental = false;
    }

    if (rental) {
      this.homePremium = this.getSumInsured() * 0.02;
    } else if (!rental) {
      this.homePremium = this.getSumInsured() * 0.01;
    }
  }

  public double getBaseHomePremium() {
    return homePremium;
  }

  public String getAddress() {
    return address;
  }

  public boolean getRentalStatus() {
    return rental;
  }
}
