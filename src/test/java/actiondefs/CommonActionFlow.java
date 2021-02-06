package actiondefs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CommonActionFlow {


    public String OptionPanel() {
        JFrame f;

        f = new JFrame();
        String PhoneNumberValue = JOptionPane.showInputDialog(f, "Enter PhoneNumber");
        return PhoneNumberValue;

    }
    
}
