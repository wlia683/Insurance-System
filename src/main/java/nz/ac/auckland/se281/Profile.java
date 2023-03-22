package nz.ac.auckland.se281;

public class Profile {

    private int rank;
    private String userName;
    private int age;

public Profile(int rank, String userName, String age) {
    this.rank = rank;
    this.userName = userName;
    this.age = Integer.parseInt(age);
    }

public int getRank() {
    return rank;
    }

public String getUserName() {
    return userName;
    }

public int getAge() {
    return age;
    }
}
