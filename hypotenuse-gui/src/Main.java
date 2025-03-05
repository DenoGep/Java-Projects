import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        double x = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter x: "));
        double y = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter y: "));

        double z = Math.sqrt((x * x) + (y * y));

        JOptionPane.showMessageDialog(null, "The hypotenuse is " + z);
    }
}