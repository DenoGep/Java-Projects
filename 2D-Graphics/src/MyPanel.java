import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    Image image;

    MyPanel() {

        image = new ImageIcon("sew - Kopya.png").getImage();
        this.setPreferredSize(new Dimension(500, 500));

    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.blue);
        // g2.setStroke(new BasicStroke(5));
        // g2.drawLine(0, 0, 500, 500);
        g2.setPaint(Color.pink);
        // g2.drawRect(100, 100, 300, 300);
        // g2.fillRect(100, 100, 300, 300);
        g2.setPaint(new Color(115, 229, 10));
        // g2.drawOval(0, 0, 100, 100);
        // g2.fillOval(50, 50, 150, 350);

        /* Drawing a pokemon
        g2.setPaint(new Color(255, 5, 5));
        g2.fillArc(0, 0, 100, 100, 0, 180);
        g2.setPaint(Color.white);
        g2.fillArc(0, 0, 100, 100, 180, 180);
        g2.setStroke(new BasicStroke(10));
        g2.setPaint(Color.black);
        g2.drawLine(0, 50, 94, 50);
        */


        /*
        int[] x_values = {150, 250, 350};
        int[] y_values = {300, 150, 300};

        g2.setBackground(new Color(251, 225, 142));
        g2.setPaint(Color.yellow);
        g2.setStroke(new BasicStroke(3));
        // g2.drawPolygon(x_values, y_values, 3);
        g2.fillPolygon(x_values, y_values, 3);
        */

        /*
        g2.setPaint(Color.magenta);
        g2.setFont(new Font("MV Boli", Font.BOLD, 50));
        g2.drawString("You're a winner", 50, 50);
        */

        g2.drawImage(image, 0, 0, null);
    }

}
