import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button = new JButton("Submit");
    JTextField textField = new JTextField();

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button.addActionListener(this);
        button.setFocusable(false);

        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.BOLD, 35));
        textField.setForeground(new Color(0x92FF1A));
        textField.setBackground(new Color(130, 40, 200));
        textField.setCaretColor(Color.white);
        textField.setText("Username");

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println("Welcome " + textField.getText());
            textField.setEditable(false);
            button.setEnabled(false);
        }
    }
}
