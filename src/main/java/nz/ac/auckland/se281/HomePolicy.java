package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  protected String address;
  protected boolean rental;

  public HomePolicy(int rank, int sumInsured, String address, boolean rental, int premium) {
    super(rank, sumInsured, premium);
    this.address = address;
    this.rental = rental;

    if (getProfile().getAge() < 25) {
      premium = (int) (0.15 * sumInsured);
    } else if (getProfile().getAge() >= 25) {
      premium = (int) (0.1 * sumInsured);
    }
  }
}
