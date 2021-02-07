package actiondefs;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.event.*;

public class RadioButton extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JRadioButton rb1, rb2;
    JButton b;

    public void RadioButtonClick() {
        rb1 = new JRadioButton("Broadcast");
        rb1.setBounds(100, 50, 100, 30);
        rb2 = new JRadioButton("Group");
        rb2.setBounds(100, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        b = new JButton("click");
        b.setBounds(100, 150, 80, 30);
        b.addActionListener(this);
        add(rb1);
        add(rb2);
        add(b);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()) {
            JOptionPane.showMessageDialog(this, "Broadcast");
        }
        if (rb2.isSelected()) {
            JOptionPane.showMessageDialog(this, "Group");
        }
    }
}