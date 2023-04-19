package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;
  private int basePremium;
  private int discountedPremium;

  public HomePolicy(int ID, PolicyType type, String[] options) {
    super(ID, type, options);

    this.address = options[1];
    if (options[2].equals("y")) {
      this.rental = true;
    } else if (options[2].equals("n")) {
      this.rental = false;
    }

    if (rental) {
      this.basePremium = (int) (this.getSumInsured() * 0.02);
    } else if (!rental) {
      this.basePremium = (int) (this.getSumInsured() * 0.01);
    }
  }

  public int getDiscountedPremium() {
    return discountedPremium;
  }

  public int getBasePremium() {
    return basePremium;
  }

  public String getAddress() {
    return address;
  }

  public boolean getRentalStatus() {
    return rental;
  }
}
