package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;
  private int homePremium;
  private int discountedHomePremium;

  public HomePolicy(int ID, int policyCount, PolicyType type, String[] options) {
    super(ID, type, options);

    this.address = options[1];
    if (options[2].equals("y")) {
      this.rental = true;
    } else if (options[2].equals("n")) {
      this.rental = false;
    }

    if (rental) {
      this.homePremium = (int) (this.getSumInsured() * 0.02);
    } else if (!rental) {
      this.homePremium = (int) (this.getSumInsured() * 0.01);
    }

    if (policyCount == 2) {
      this.discountedHomePremium = (int) (this.homePremium - (this.homePremium * 0.1));
    } else if (policyCount >= 3) {
      this.discountedHomePremium = (int) (this.homePremium - (this.homePremium * 0.15));
    }
  }

  public int getDiscountedHomePremium() {
    return discountedHomePremium;
  }

  public int getBaseHomePremium() {
    return homePremium;
  }

  public String getAddress() {
    return address;
  }

  public boolean getRentalStatus() {
    return rental;
  }
}
