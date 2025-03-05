import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {

        this.setTitle("JFrame Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false);
        this.setSize(420, 420); // x and y dimensions of the frame
        this.setVisible(true); // make frame visible

        ImageIcon image = new ImageIcon("beyz.jpg"); // Create an ImageIcon
        this.setIconImage(image.getImage()); // change icon of frame
        this.getContentPane().setBackground(new Color(0x59F1A3)); // change color of background
    }

}
