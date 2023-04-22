package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;
  private double homePremium;
  private double discountedHomePremium;

  public HomePolicy(
      Profile profile, int identity, int policyCount, PolicyType type, String[] options) {
    super(identity, policyCount, type, options);

    this.address = options[1];
    if (options[2].equalsIgnoreCase("y") || options[2].equalsIgnoreCase("yes")) {
      this.rental = true;
    } else if (options[2].equalsIgnoreCase("n") || options[2].equalsIgnoreCase("no")) {
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

  public void setDiscountedHomePremium(double discountedHomePremium) {
    this.discountedHomePremium = discountedHomePremium;
  }

  public int getDiscountedHomePremium() {
    return (int) discountedHomePremium;
  }
}
