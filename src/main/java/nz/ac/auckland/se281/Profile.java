package nz.ac.auckland.se281;

public class Profile {

  private int rank;
  private String userName;
  private int age;
  protected boolean isActive;
  private int identity;
  private int policyCount;
  private double totalPremium;

  public Profile(
      int rank, int identity, boolean isActive, String userName, String age, int policyCount) {
    this.rank = rank;
    this.identity = identity;
    this.userName = userName;
    this.isActive = isActive;
    this.age = Integer.parseInt(age);
    this.policyCount = policyCount;
  }

  public int getTotalPremium() {
    return (int) totalPremium;
  }

  public void setTotalPremium(double totalPremium) {
    this.totalPremium = totalPremium;
  }

  public void setIdentity(int identity) {
    this.identity = identity;
  }

  public int getIdentity() {
    return identity;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getRank() {
    return rank;
  }

  public boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getUserName() {
    return userName;
  }

  public int getAge() {
    return age;
  }

  public void setPolicyCount(int policyCount) {
    this.policyCount = policyCount;
  }

  public int getPolicyCount() {
    return policyCount;
  }
}
