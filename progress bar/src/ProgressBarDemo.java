import javax.swing.*;
import java.awt.*;

public class ProgressBarDemo {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();
    JLabel label = new JLabel("Stamina Bar");



    ProgressBarDemo () {

        bar.setValue(0);
        bar.setBounds(50, 100, 400, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(new Color(9, 204, 235));
        bar.setBackground(Color.black);

        label.setBounds(0, 40, 500, 50);
        label.setVisible(true);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);


        frame.add(bar);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    public void fill() {

        int counter = 100;

        while (counter >= 0) {
            bar.setValue(counter--);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (counter % 4 == 0 && counter <= 20) {
                bar.setBackground(Color.red);
                // bar.setForeground(Color.white);
            }
            else {
                bar.setForeground(new Color(9, 204, 235));
                bar.setBackground(Color.black);
            }
        }
        bar.setBackground(Color.red);
        bar.setForeground(Color.white);
        bar.setString("No Stamina!");
    }

}
