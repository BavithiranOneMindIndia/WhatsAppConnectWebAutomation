package actiondefs;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class CommonActionFlow extends JFrame {

    JFrame f;

    public String OptionPanel() {

        f = new JFrame();
        String PhoneNumberValue = JOptionPane.showInputDialog(f, "Enter PhoneNumber");
        return PhoneNumberValue;

    }

    public void OptionPanelCompleted() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Completed");

    }

    public void radioButton() {
        f = new JFrame();
        JRadioButton r1 = new JRadioButton("A) Brodcast");
        JRadioButton r2 = new JRadioButton("B) Group");
        r1.setBounds(75, 50, 100, 30);
        r2.setBounds(75, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        f.add(r1);
        f.add(r2);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

}
