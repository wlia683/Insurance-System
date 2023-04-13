package nz.ac.auckland.se281;

public abstract class Policy {

  private int rank;
  private int sumInsured;
  private double premium;

  public Policy(int rank, int sumInsured, int premium) {
    this.rank = rank;
    this.sumInsured = sumInsured;
    this.premium = premium;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public Profile getProfile() {
    return null;
  }

  public int getSumInsured() {
    return sumInsured;
  }

  public void setSumInsured(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  public double getPremium() {
    return premium;
  }

  public void setPremium(double premium) {
    this.premium = premium;
  }

  public Object getRegistration() {
    return null;
  }
}
