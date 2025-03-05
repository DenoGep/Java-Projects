import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // JLabel = a GUI display for text and image

        ImageIcon imageIcon = new ImageIcon("heart.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        ImageIcon icon = new ImageIcon("bezuk.jpg");
        Border border = BorderFactory.createLineBorder(new Color(117, 2, 221), 3);


        JLabel label = new JLabel(); // create a label
        label.setText("Bezuk benm askm"); // set text of label
        label.setIcon(imageIcon);
        label.setHorizontalTextPosition(JLabel.CENTER); // LEFT, CENTER, RIGHT
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(new Color(0x00FFFF));
        label.setFont(new Font("MV Boli", Font.BOLD, 25));
        label.setIconTextGap(100); // set gap of text to image
        label.setBackground(Color.pink);
        label.setOpaque(true); // display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        // label.setBounds(70, 50, 350, 350);


        JFrame frame = new JFrame();
        frame.setTitle("Sni çk svm aşkm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(500, 500);
        // frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.setIconImage(icon.getImage());
        frame.pack();

    }
}