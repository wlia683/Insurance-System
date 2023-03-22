package nz.ac.auckland.se281;

public class Profile {

    private String userName;
    private int age;

public Profile(String userName, String age) {
    this.userName = userName;
    int ageConverted = Integer.parseInt(age);
    this.age = ageConverted;
    }

public String getUserName() {
    return userName;
    }

public int getAge() {
    return age;
    }
}
