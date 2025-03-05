// Abstract class to define the structure
public abstract class PasswordManager {
    public abstract void saveCredentials(String website, String email, String password);

    public abstract String getCredentials(String website);

    public abstract void listAllCredentials();
}
