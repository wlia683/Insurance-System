package nz.ac.auckland.se281;

public class Profile {

    String userName;
    String age;

public Profile(String userName, String age) {
    this.userName = userName;
    this.age = age;
    }

public String getUserName() {
    return userName;
    }

public String getAge() {
    return age;
    }
}
