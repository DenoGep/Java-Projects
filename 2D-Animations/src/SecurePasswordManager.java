// Concrete class implementing the abstract class and encapsulating data

import javax.swing.*;
import java.io.*;

public class SecurePasswordManager extends PasswordManager {
    private final File file = new File("credentials.txt"); // File to store data

    public SecurePasswordManager() {
        try {
            if (!file.exists()) {
                boolean isFileCreated = file.createNewFile();
                if (isFileCreated) {
                    System.out.println("File created successfully: " + file.getAbsolutePath());
                } else {
                    System.out.println("File already exists: " + file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            System.err.println("Error initializing file: " + e.getMessage());
        }
    }


    @Override
    public void saveCredentials(String website, String email, String password) {
        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean updated = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (!parts[0].equals(website)) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    updated = true;
                    writer.write(website + "|" + email + "|" + password);
                    writer.newLine();
                }
            }

            if (!updated) {
                writer.write(website + "|" + email + "|" + password);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error saving credentials: " + e.getMessage());
        }

        if (!file.delete()) {
            System.err.println("Error deleting original file.");
        }

        if (!tempFile.renameTo(file)) {
            System.err.println("Error renaming temp file.");
        }
    }

    public void saveCredentials(String website, String email) { // Method Overloading
        saveCredentials(website, email, "defaultPassword123");
    }

    @Override
    public String getCredentials(String website) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[0].equals(website)) {
                    return parts[1] + "|" + parts[2];
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading credentials: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void listAllCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder allCredentials = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                allCredentials.append(line).append("\n");
            }

            if (!allCredentials.isEmpty()) {
                JOptionPane.showMessageDialog(null, allCredentials.toString(), "Saved Credentials", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No saved credentials found.", "Saved Credentials", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            System.err.println("Error reading credentials: " + e.getMessage());
        }
    }

    public boolean deleteCredentials(String website) { // Delete functionality
        File tempFile = new File("temp.txt");
        boolean deleted = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (!parts[0].equals(website)) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    deleted = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error deleting credentials: " + e.getMessage());
        }

        if (!file.delete()) {
            System.err.println("Error deleting original file.");
        }

        if (!tempFile.renameTo(file)) {
            System.err.println("Error renaming temp file.");
        }

        return deleted;
    }
}

