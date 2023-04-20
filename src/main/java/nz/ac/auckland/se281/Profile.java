package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  private int rank;
  private String userName;
  private int age;
  protected boolean isActive;
  private ArrayList<Policy> policies;
  private int ID;
  private int policyCount;
  private int totalPremium;

  public Profile(int rank, int ID, boolean isActive, String userName, String age, int policyCount) {
    this.rank = rank;
    this.ID = ID;
    this.userName = userName;
    this.isActive = isActive;
    this.age = Integer.parseInt(age);
    this.policyCount = policyCount;
  }

  public int getTotalPremium() {
    return totalPremium;
  }

  public void setTotalPremium(int totalPremium) {
    this.totalPremium = totalPremium;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public int getID() {
    return ID;
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

  public ArrayList<Policy> getPolicies() {
    return policies;
  }

  public void setPolicyCount(int policyCount) {
    this.policyCount = policyCount;
  }

  public int getPolicyCount() {
    return policyCount;
  }
}
