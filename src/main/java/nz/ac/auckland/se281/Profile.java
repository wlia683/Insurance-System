package nz.ac.auckland.se281;

public class Profile {

  private int rank;
  private String userName;
  private int age;
  protected boolean isActive;

  public Profile(int rank, boolean isActive, String userName, String age) {
    this.rank = rank;
    this.userName = userName;
    this.isActive = isActive;
    this.age = Integer.parseInt(age);
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
}
