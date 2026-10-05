import java.util.ArrayList;
import java.util.Scanner;

public class UserRegistration {

    static ArrayList<User> users = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    void registerUser() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("       USER REGISTRATION");
        System.out.println("=================================");

        // ---------------- USERNAME ----------------

      System.out.print("Enter Username: ");
	String username = sc.next();

	if (!Character.isLetter(username.charAt(0))) {
    		System.out.println("Username must start with an alphabet.");
    		return;
	}


        // ---------------- MOBILE ----------------

        long mobile;

     	System.out.print("Enter Mobile Number: ");
	mobile = sc.nextLong();

	String mobileStr = String.valueOf(mobile);

	if (mobileStr.length() != 10 ||
    	    !(mobileStr.startsWith("6") ||
      	    mobileStr.startsWith("7") ||
      	    mobileStr.startsWith("8") ||
      	    mobileStr.startsWith("9"))) {

    		System.out.println("Invalid mobile number.");
    		return;
	}


        // ---------------- PASSWORD ----------------

        String password;

        while (true) {

            System.out.print("Enter Password: ");
            password = sc.next();

            if (isValidPassword(password)) {

                break;

            } else {

                System.out.println();
                System.out.println("Invalid Password!");
                System.out.println(
                    "Password must contain:"
                );
                System.out.println(
                    "- Exactly 8 characters"
                );
                System.out.println(
                    "- At least 1 uppercase letter"
                );
                System.out.println(
                    "- At least 1 number"
                );
                System.out.println(
                    "- At least 1 special character"
                );
            }
        }


        // ---------------- CONFIRM PASSWORD ----------------

        while (true) {

            System.out.print("Confirm Password: ");
            String confirmPassword = sc.next();

            if (password.equals(confirmPassword)) {

                break;

            } else {

                System.out.println(
                    "Password and Confirm Password do not match."
                );
            }
        }


        // ---------------- CREATE USER ----------------

        User user = new User(
            username,
            mobile,
            password
        );

        users.add(user);

        System.out.println();
        System.out.println("=================================");
        System.out.println("     Registration Successful!");
        System.out.println("=================================");
    }


    // ==================================================
    // PASSWORD VALIDATION
    // ==================================================

    boolean isValidPassword(String password) {

        // Exactly 8 characters
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }

            else if (Character.isDigit(ch)) {
                hasNumber = true;
            }

            else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasUppercase && hasNumber && hasSpecial;
    }
}