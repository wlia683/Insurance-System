package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  protected String address;
  protected boolean rental;

  public HomePolicy(int sumInsured, String address, boolean rental, double premium) {
    super(sumInsured, premium);
    this.address = address;
    this.rental = rental;

    if (rental = true) {
      this.premium = sumInsured * 0.02;
    } else {
      this.premium = sumInsured * 0.01;
    }
    return;
  }
}
