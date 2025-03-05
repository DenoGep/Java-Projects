import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    MyFrame(){

        ImageIcon icon = new ImageIcon("file.png");
        ImageIcon icon2 = new ImageIcon("face.png");

        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(200, 250, 150, 150);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(120, 170, 250, 100);
        button.addActionListener(this);
        button.setText("I'm a button");
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(-2);
        button.setForeground(Color.red);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createCompoundBorder());
        // button.setEnabled(false); // disable a button

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Poo");
            // button.setEnabled(false); // click once and then disable
            label.setVisible(true);
        }
    }
}
