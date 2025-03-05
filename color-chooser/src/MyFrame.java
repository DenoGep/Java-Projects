import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    MyFrame() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Pick a foreground color");
        button.addActionListener(this);

        label = new JLabel("This is some text");
        label.setBackground(Color.white);
        label.setFont(new Font("MV Boli", Font.ITALIC, 100));
        label.setOpaque(true);

        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
            label.setForeground(color);
        }
    }
}
