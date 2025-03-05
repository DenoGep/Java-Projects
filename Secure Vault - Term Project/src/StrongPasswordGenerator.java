// Class implementing the PasswordGenerator interface

public class StrongPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        try {
            @SuppressWarnings("SpellCheckingInspection")
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                int randomIndex = (int) (Math.random() * characters.length());
                password.append(characters.charAt(randomIndex));
            }
            return password.toString();
        } catch (Exception e) {
            System.err.println("Error generating password: " + e.getMessage());
            return "defaultPassword123";
        }
    }
}
