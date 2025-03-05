import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordSaverApp {
    public static void main(String[] args) {
        SecurePasswordManager manager = new SecurePasswordManager();
        StrongPasswordGenerator generator = new StrongPasswordGenerator();

        JFrame frame = new JFrame("Secure Vault");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding a black background color
        JPanel panel = new JPanel();
        panel.setBackground(new Color(58, 56, 56));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adding logo
        JLabel logoLabel = new JLabel(new ImageIcon("logo2.png"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(logoLabel, gbc);

        // Adding Icon
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());

        // Adding fields and labels
        gbc.gridwidth = 1;

        JLabel websiteLabel = new JLabel("Website:");
        websiteLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(websiteLabel, gbc);

        JTextField websiteField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(websiteField, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(passwordLabel, gbc);

        JTextField passwordField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        JButton generatePasswordButton = new JButton("Generate Password");
        generatePasswordButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(generatePasswordButton, gbc);

        generatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String generatedPassword = generator.generatePassword();
                    passwordField.setText(generatedPassword);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error generating password: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(saveButton, gbc);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String website = websiteField.getText();
                    String email = emailField.getText();
                    String password = passwordField.getText();

                    if (website.isEmpty() || email.isEmpty()) {
                        throw new IllegalArgumentException("Website and email must be filled in!");
                    }

                    if (password.isEmpty()) {
                        manager.saveCredentials(website, email); // Call overloaded method
                    } else {
                        manager.saveCredentials(website, email, password);
                    }

                    JOptionPane.showMessageDialog(frame, "Credentials Saved Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    websiteField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton accessButton = new JButton("Access");
        accessButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(accessButton, gbc);

        accessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String website = JOptionPane.showInputDialog(frame, "Enter the website:", "Access Credentials", JOptionPane.QUESTION_MESSAGE);
                    if (website == null || website.isEmpty()) {
                        throw new IllegalArgumentException("Website name cannot be empty.");
                    }

                    String credentials = manager.getCredentials(website); // Call overloaded method
                    if (credentials != null) {
                        String[] parts = credentials.split("\\|");
                        String email = parts[0];
                        String password = parts[1];
                        JOptionPane.showMessageDialog(frame, "Website: " + website + "\nEmail: " + email + "\nPassword: " + password, "Credentials", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No credentials found for the website!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(deleteButton, gbc);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String website = JOptionPane.showInputDialog(frame, "Enter the website to delete:", "Delete Credentials", JOptionPane.QUESTION_MESSAGE);
                    if (website == null || website.isEmpty()) {
                        throw new IllegalArgumentException("Website name cannot be empty.");
                    }

                    boolean success = manager.deleteCredentials(website);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Credentials deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No credentials found for the website!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton listAllButton = new JButton("List All");
        listAllButton.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(listAllButton, gbc);

        listAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.listAllCredentials();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
    }
}
