import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // JOptionPane.showMessageDialog(null, "This is some useless info", "Title", JOptionPane.PLAIN_MESSAGE);
        // JOptionPane.showMessageDialog(null, "This is some useless info", "Title", JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "This is some useless info", "Title", JOptionPane.QUESTION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "You're computer has A VIRUS!!!", "Title", JOptionPane.WARNING_MESSAGE);
        // JOptionPane.showMessageDialog(null, "This is some useless info", "Title", JOptionPane.ERROR_MESSAGE);

        // System.out.println(JOptionPane.showConfirmDialog(null, "Do you like pizza", "choose", JOptionPane.YES_NO_OPTION));

        // String name = JOptionPane.showInputDialog("What is your name: ");
        // System.out.println("Hello " + name);

        String[] responses = {"No, you're awesome", "Thank you", "*blush*"};

        ImageIcon icon = new ImageIcon("beyz.jpg");

        JOptionPane.showOptionDialog(
                null,
                "You are awesome", "secret message",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icon,
                responses,
                0);

    }
}