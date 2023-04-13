package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  protected boolean mechBreak;
  protected String registration;
  protected String model;
  protected String make;

  public CarPolicy(
      int rank,
      int sumInsured,
      String make,
      String model,
      String registration,
      boolean mechBreak,
      int premium) {
    super(rank, sumInsured, premium);

    getSumInsured();
    getPremium();
    getRank();
    this.make = make;
    this.model = model;
    this.registration = registration;
    this.mechBreak = mechBreak;

    if (getProfile().getAge() < 25) {
      premium = (int) (0.15 * sumInsured);
    } else if (getProfile().getAge() >= 25) {
      premium = (int) (0.1 * sumInsured);
    }
    if (mechBreak == true) {
      premium = premium + 80;
    }
  }

  public boolean isMechBreak() {
    return mechBreak;
  }

  public void setMechBreak(boolean mechBreak) {
    this.mechBreak = mechBreak;
  }

  public String getRegistration() {
    return registration;
  }

  public void setRegistration(String registration) {
    this.registration = registration;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }
}
