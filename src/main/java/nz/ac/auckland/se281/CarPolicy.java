package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  protected boolean mechBreak;
  protected String registration;
  protected String model;
  protected String make;

  public CarPolicy(
      int sumInsured,
      String make,
      String model,
      String registration,
      boolean mechBreak,
      double premium) {
    super(sumInsured, premium);

    this.sumInsured = sumInsured;
    this.make = make;
    this.model = model;
    this.registration = registration;
    this.mechBreak = mechBreak;

    if (Profile.getAge() < 25) {
      premium = 0.15 * sumInsured;
    } else if (Profile.getAge() >= 25) {
      premium = 0.1 * sumInsured;
    }
    if (mechBreak == true) {
      premium = premium + 80;
    }
  }
}
