import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {

    JLabel label;
    ImageIcon smile;
    ImageIcon nervous;
    ImageIcon angry;
    ImageIcon dizzy;

    MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 550);
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.addMouseListener(this);

        smile = new ImageIcon("smile.png");
        nervous = new ImageIcon("nervous.png");
        angry = new ImageIcon("angry.png");
        dizzy = new ImageIcon("dizzy.png");

        label.setIcon(smile);

        this.setMinimumSize(new Dimension(550, 550));
        this.pack();
        this.setLocationRelativeTo(null);
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setIcon(angry);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setIcon(dizzy);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setIcon(nervous);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setIcon(smile);
    }
}

