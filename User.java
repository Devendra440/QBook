public class User {

    private String username;
    private long mobile;
    private String password;

    User(String username, long mobile, String password) {

        this.username = username;
       
        this.mobile = mobile;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

  

    long getMobile() {
        return mobile;
    }

    String getPassword() {
        return password;
    }
}